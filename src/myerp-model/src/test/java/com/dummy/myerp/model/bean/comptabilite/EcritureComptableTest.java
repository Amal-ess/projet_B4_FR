package com.dummy.myerp.model.bean.comptabilite;

import org.apache.commons.lang3.ObjectUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;


public class EcritureComptableTest {

    private LigneEcritureComptable createLigne(Integer pCompteComptableNumero, String pDebit, String pCredit) {
        BigDecimal vDebit = pDebit == null ? null : new BigDecimal(pDebit);
        BigDecimal vCredit = pCredit == null ? null : new BigDecimal(pCredit);
        String vLibelle = ObjectUtils.defaultIfNull(vDebit, BigDecimal.ZERO)
                .subtract(ObjectUtils.defaultIfNull(vCredit, BigDecimal.ZERO)).toPlainString();
        LigneEcritureComptable vRetour = new LigneEcritureComptable(new CompteComptable(pCompteComptableNumero),
                vLibelle,
                vDebit, vCredit);
        return vRetour;
    }


    @Test
    public void shouldGetTotalDebit() {
        //GIVEN
        EcritureComptable ecritureComptable = new EcritureComptable();
        ecritureComptable.getListLigneEcriture().add(this.createLigne(1, "10", null));
        ecritureComptable.getListLigneEcriture().add(this.createLigne(1, "20", "1"));
        ecritureComptable.getListLigneEcriture().add(this.createLigne(2, null, "30"));
        ecritureComptable.getListLigneEcriture().add(this.createLigne(2, "1", "2"));
        //WHEN
        BigDecimal totalDebit = ecritureComptable.getTotalDebit();
        //THEN
        Assertions.assertThat(totalDebit).isEqualTo(new BigDecimal(31));
    }

    @Test
    public void shouldGetTotalCredit() {
        //GIVEN
        EcritureComptable ecritureComptable = new EcritureComptable();
        ecritureComptable.getListLigneEcriture().add(this.createLigne(1, "10", null));
        ecritureComptable.getListLigneEcriture().add(this.createLigne(1, "20", "1"));
        ecritureComptable.getListLigneEcriture().add(this.createLigne(2, null, "30"));
        ecritureComptable.getListLigneEcriture().add(this.createLigne(2, "1", "2"));
        //WHEN
        BigDecimal totalCredit = ecritureComptable.getTotalCredit();
        //THEN
        Assertions.assertThat(totalCredit).isEqualTo(new BigDecimal(33));
    }


    @Test
    public void isEquilibree() {
        EcritureComptable vEcriture;
        vEcriture = new EcritureComptable();

        vEcriture.setLibelle("Equilibrée");
        vEcriture.getListLigneEcriture().add(this.createLigne(1, "200.50", null));
        vEcriture.getListLigneEcriture().add(this.createLigne(1, "100.50", "33"));
        vEcriture.getListLigneEcriture().add(this.createLigne(2, null, "301"));
        vEcriture.getListLigneEcriture().add(this.createLigne(2, "40", "7"));
        Assertions.assertThat(vEcriture.isEquilibree()).isTrue().as(vEcriture.toString());

        vEcriture.getListLigneEcriture().clear();
        vEcriture.setLibelle("Non équilibrée");
        vEcriture.getListLigneEcriture().add(this.createLigne(1, "10", null));
        vEcriture.getListLigneEcriture().add(this.createLigne(1, "20", "1"));
        vEcriture.getListLigneEcriture().add(this.createLigne(2, null, "30"));
        vEcriture.getListLigneEcriture().add(this.createLigne(2, "1", "2"));
        Assertions.assertThat(vEcriture.isEquilibree()).isFalse().as(vEcriture.toString());

    }


}

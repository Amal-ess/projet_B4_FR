package com.dummy.myerp.business.impl.manager;

import com.dummy.myerp.consumer.dao.contrat.ComptabiliteDao;
import com.dummy.myerp.model.bean.comptabilite.CompteComptable;
import com.dummy.myerp.model.bean.comptabilite.EcritureComptable;
import com.dummy.myerp.model.bean.comptabilite.JournalComptable;
import com.dummy.myerp.model.bean.comptabilite.LigneEcritureComptable;
import com.dummy.myerp.technical.exception.FunctionalException;
import com.dummy.myerp.technical.exception.NotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.math.BigDecimal;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ComptabiliteManagerImplTest {

    @Mock
    private ComptabiliteDao mockComptabiliteDao;

    @InjectMocks
    private ComptabiliteManagerImpl manager;


    @Test
    public void checkEcritureComptableUnit() throws Exception {
        EcritureComptable vEcritureComptable;
        vEcritureComptable = new EcritureComptable();
        vEcritureComptable.setJournal(new JournalComptable("AC", "Achat"));
        vEcritureComptable.setDate(new Date());
        vEcritureComptable.setLibelle("Libelle");
        vEcritureComptable.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(1),
                null, new BigDecimal(123),
                null));
        vEcritureComptable.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(2),
                null, null,
                new BigDecimal(123)));
        manager.checkEcritureComptableUnit(vEcritureComptable);
    }

    @Test
    public void checkEcritureComptableUnitViolation() {
        EcritureComptable vEcritureComptable;
        vEcritureComptable = new EcritureComptable();

        assertThatExceptionOfType(FunctionalException.class).isThrownBy(() -> {
            manager.checkEcritureComptableUnit(vEcritureComptable);
        });
    }

    @Test
    public void checkEcritureComptableUnitRG2() {
        EcritureComptable vEcritureComptable;
        vEcritureComptable = new EcritureComptable();
        vEcritureComptable.setJournal(new JournalComptable("AC", "Achat"));
        vEcritureComptable.setDate(new Date());
        vEcritureComptable.setLibelle("Libelle");
        vEcritureComptable.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(1),
                null, new BigDecimal(123),
                null));
        vEcritureComptable.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(2),
                null, null,
                new BigDecimal(1234)));
        assertThatExceptionOfType(FunctionalException.class).isThrownBy(() -> {
            manager.checkEcritureComptableUnit(vEcritureComptable);
        });
    }

    @Test
    public void checkEcritureComptableUnitRG3() {
        EcritureComptable vEcritureComptable;
        vEcritureComptable = new EcritureComptable();
        vEcritureComptable.setJournal(new JournalComptable("AC", "Achat"));
        vEcritureComptable.setDate(new Date());
        vEcritureComptable.setLibelle("Libelle");
        vEcritureComptable.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(1),
                null, new BigDecimal(123),
                null));
        vEcritureComptable.getListLigneEcriture().add(new LigneEcritureComptable(new CompteComptable(1),
                null, new BigDecimal(123),
                null));
        assertThatExceptionOfType(FunctionalException.class).isThrownBy(() -> {
            manager.checkEcritureComptableUnit(vEcritureComptable);
        });
    }


    @Test
    public void shouldCheckEcritureComptableDoesNotExist() throws FunctionalException, NotFoundException {
        // Given
        String reference = "12345-1234/12345";
        EcritureComptable vEcritureComptable = new EcritureComptable();
        vEcritureComptable.setId(10);
        vEcritureComptable.setJournal(new JournalComptable("AC", "Achat"));
        vEcritureComptable.setDate(new Date());
        vEcritureComptable.setLibelle("Libelle");
        vEcritureComptable.setReference(reference);
        vEcritureComptable.getListLigneEcriture().add(
                new LigneEcritureComptable(new CompteComptable(1), null, new BigDecimal(123), null)
        );
        vEcritureComptable.getListLigneEcriture().add(
                new LigneEcritureComptable(new CompteComptable(1), null, null, new BigDecimal(123))
        );

        EcritureComptable daoEcritureComptable = new EcritureComptable();
        daoEcritureComptable.setId(11);

        // When
        when(mockComptabiliteDao.getEcritureComptableByRef(eq(reference))).thenReturn(daoEcritureComptable);
        assertThatExceptionOfType(FunctionalException.class)
                .isThrownBy(() -> {
                    manager.checkEcritureComptable(vEcritureComptable);
                })
				.withMessage("Une autre écriture comptable existe déjà avec la même référence.");
    }
}

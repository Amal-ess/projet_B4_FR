package com.dummy.myerp.model.bean.comptabilite;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class SequenceEcritureComptableTest {


    @Test
    void getAnnee() {
        SequenceEcritureComptable sequenceEcritureComptable = new SequenceEcritureComptable();
        sequenceEcritureComptable.setAnnee(2000);
        Assertions.assertThat(sequenceEcritureComptable.getAnnee()).isEqualTo(2000);

    }

    @Test
    void getDerniereValeur() {
        SequenceEcritureComptable sequenceEcritureComptable = new SequenceEcritureComptable();
        sequenceEcritureComptable.setDerniereValeur(20);
        Assertions.assertThat(sequenceEcritureComptable.getDerniereValeur()).isEqualTo(20);

    }


    @Test
    public void testToString() {
        SequenceEcritureComptable sequenceEcritureComptable = new SequenceEcritureComptable();
        sequenceEcritureComptable.setDerniereValeur(20);
        sequenceEcritureComptable.setAnnee(2000);
        String tostring = "SequenceEcritureComptable(annee=2000, derniereValeur=20)";
        Assertions.assertThat(sequenceEcritureComptable.toString()).isEqualTo(tostring);
    }


}
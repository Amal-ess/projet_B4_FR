package com.dummy.myerp.model.bean.comptabilite;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


class JournalComptableTest {


    @Test
    public void getNumero() {
        JournalComptable journalComptable = new JournalComptable();
        journalComptable.setCode("hello");
        Assertions.assertThat(journalComptable.getCode()).isEqualTo("hello");
    }

    @Test
    public void getLibelle() {
        JournalComptable journalComptable = new JournalComptable();
        journalComptable.setLibelle("libelle");
        Assertions.assertThat(journalComptable.getLibelle()).isEqualTo("libelle");

    }

//1
    @Test
    public void shouldConstructWithCode() {
        String code = "Test";
        JournalComptable journalComptable = new JournalComptable(code,"Test");

        Assertions.assertThat(journalComptable).isNotNull();
        Assertions.assertThat(journalComptable.getCode()).isEqualTo(code);


    }
//2
    @Test
    public void shouldConstructWithLibelle(){
        String libelle ="Test";
        JournalComptable journalComptable = new JournalComptable(libelle, "Test");
        Assertions.assertThat(journalComptable).isNotNull();
        Assertions.assertThat(journalComptable.getLibelle()).isEqualTo(libelle);

    }


    @Test
    public void shouldCodeWithgetByCode(){
        //GIVEN
        JournalComptable compte = new JournalComptable("10", "Libelle");
        List<JournalComptable> journalComptables = new ArrayList<>();

        journalComptables.add(compte);

        //WHEN
        JournalComptable compteByCode = JournalComptable.getByCode(journalComptables,"10");
        //THEN
        Assertions.assertThat(compteByCode).isEqualTo(compte);
        Assertions.assertThat(compteByCode.getCode()).isEqualTo("10");

    }


}
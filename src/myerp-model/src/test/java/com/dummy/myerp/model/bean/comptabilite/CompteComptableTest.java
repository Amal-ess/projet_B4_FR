package com.dummy.myerp.model.bean.comptabilite;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;


class CompteComptableTest {

    @Test
    public void getNumero() {
        CompteComptable compteComptable = new CompteComptable();
        compteComptable.setNumero(1);
        Assertions.assertThat(compteComptable.getNumero()).isEqualTo(1);
        ///hello
    }

    @Test
    public void getLibelle() {
        CompteComptable compteComptable = new CompteComptable();
        compteComptable.setLibelle("libelle");
        Assertions.assertThat(compteComptable.getLibelle()).isEqualTo("libelle");
    }

    @Test
    public void shouldConstructWithNumero() {
        // Given
        int numero = 10;

        // When
        CompteComptable compteComptable = new CompteComptable(numero);

        // Then
        Assertions.assertThat(compteComptable).isNotNull();
        Assertions.assertThat(compteComptable.getNumero()).isEqualTo(numero);
        Assertions.assertThat(compteComptable.getLibelle()).isNullOrEmpty();
    }

    @Test
    public void shouldConstructWithNumeroAndLibelle() {
        int numero = 10;
        String libelle = "Test";

        CompteComptable compteComptable = new CompteComptable(numero, libelle);
        Assertions.assertThat(compteComptable.getLibelle()).isEqualTo(libelle);
        Assertions.assertThat(compteComptable.getNumero()).isEqualTo(numero);
    }

    @Test
    public void shouldNumeroWithgetByNumero(){
        //GIVEN
        List<CompteComptable> compteComptables = new ArrayList<>();
        CompteComptable compte10 = new CompteComptable(10);
        compteComptables.add(compte10);
        CompteComptable compte14 = new CompteComptable(14);
        compteComptables.add(compte14);
        CompteComptable compte15 = new CompteComptable(15);
        compteComptables.add(compte15);

        //WHEN
        CompteComptable compteByNumero = CompteComptable.getByNumero(compteComptables, 10);

        //THEN
        Assertions.assertThat(compteByNumero).isEqualTo(compte10);
        Assertions.assertThat(compteByNumero.getNumero()).isEqualTo(10);

    }

    @Test
    public void shouldNotFindWithgetByNumero(){
        //GIVEN
        List<CompteComptable> compteComptables = new ArrayList<>();
        CompteComptable compte10 = new CompteComptable(10);
        compteComptables.add(compte10);

        //WHEN
        CompteComptable compteByNumero = CompteComptable.getByNumero(compteComptables, 40);

        //THEN
        Assertions.assertThat(compteByNumero).isNull();

    }


}
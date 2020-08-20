package com.dummy.myerp.model.bean.comptabilite;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class CompteComptableTest {

    @Test
    public void getNumero() {
        CompteComptable compteComptable = new CompteComptable();
        compteComptable.setNumero(1);
        assertThat(compteComptable.getNumero()).isEqualTo(1);
    }

    @Test
    public void setNumero(){
        CompteComptable compteComptable = new CompteComptable();
        assertDoesNotThrow(()-> compteComptable.setNumero(1));
    }


    @Test
    public void getLibelle() {
        CompteComptable compteComptable = new CompteComptable();
        compteComptable.setLibelle("libelle");
        assertThat(compteComptable.getLibelle()).isEqualTo("libelle");
    }

    @Test
    public void shouldConstructWithNumero() {
        // Given
        int numero = 10;

        // When
        CompteComptable compteComptable = new CompteComptable(numero);

        // Then
        assertThat(compteComptable).isNotNull();
        assertThat(compteComptable.getNumero()).isEqualTo(numero);
        assertThat(compteComptable.getLibelle()).isNullOrEmpty();
    }

    @Test
    public void shouldConstructWithNumeroAndLibelle() {
        int numero = 10;
        String libelle = "Test";

        CompteComptable compteComptable = new CompteComptable(numero, libelle);
        assertThat(compteComptable.getLibelle()).isEqualTo(libelle);
        assertThat(compteComptable.getNumero()).isEqualTo(numero);
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
        assertThat(compteByNumero).isEqualTo(compte10);
        assertThat(compteByNumero.getNumero()).isEqualTo(10);

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
        assertThat(compteByNumero).isNull();

    }

    @Test
    public void Given_beanEcritureComptable_When_getByNumeroIsUsed_Then_shouldBeEqual() {

        CompteComptable compte1 = new CompteComptable(1,"Libelle1");
        CompteComptable compte2 = new CompteComptable(20,"Libelle2");
        List<CompteComptable> compteList = new ArrayList<>();
        compteList.add(compte1);
        compteList.add(compte2);
        final CompteComptable result = CompteComptable.getByNumero(compteList,20);
        assertThat(result).isEqualTo(compte2);
    }

}
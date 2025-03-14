package com.ipi.jva350.model;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.LinkedHashSet;

class SalarieAideADomicileTest {

    @Test
    void aLegalementDroitADesCongesPayesIsWrong(){
        //Given
        SalarieAideADomicile salarie = new SalarieAideADomicile();

        //when
        boolean result = salarie.aLegalementDroitADesCongesPayes();

        //Then
        // avec 0 jour travaillé, il est peu probable que le salarié n'ait pas droit à des jours de congés

        Assertions.assertFalse(result);
    }

    @Test
    void aLegalementDroitADesCongesPayesIsTrue(){
        //given
        SalarieAideADomicile salarie = new SalarieAideADomicile("Nouveau",
                LocalDate.now(), LocalDate.now(), 0, 0,
                11, 0, 0);

        //when
        boolean result = salarie.aLegalementDroitADesCongesPayes();

        //then
        // avec 11 jours travaillés, il est fort probable que le salarié ait droit à des jours de congés
        Assertions.assertTrue(result);
    }

    @Test
    void aLegalementDroitADesCongesPayesAuxLimites(){
        //given
        SalarieAideADomicile salarie = new SalarieAideADomicile();
        salarie.setJoursTravaillesAnneeNMoins1(10);

        //when
        boolean result = salarie.aLegalementDroitADesCongesPayes();

        //then
        // avec 10 jours travaillés
        Assertions.assertTrue(result);
    }

    @Test
    void calculeJoursDeCongeDecomptesPourPlageTest() {
        //given
        SalarieAideADomicile salarie = new SalarieAideADomicile();

        //when
        LinkedHashSet<LocalDate> result = salarie.calculeJoursDeCongeDecomptesPourPlage(LocalDate.now(), LocalDate.now().plusDays(10));

        //then
        Assertions.assertEquals(9, result.size());
    }
}

package com.ipi.jva350.model;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class SalarieAideADomicileTest {

    @Test
    void aLegalementDroitADesCongesPayesIsWrong(){
        //Given
        SalarieAideADomicile salarie = new SalarieAideADomicile();

        //when
        boolean result = salarie.aLegalementDroitADesCongesPayes();

        //Then
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
        Assertions.assertTrue(result);
    }
}

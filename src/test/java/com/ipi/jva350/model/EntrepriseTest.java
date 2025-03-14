package com.ipi.jva350.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class EntrepriseTest {

    @ParameterizedTest
    @CsvSource({
            "2024-01-01, true",   // Jour de l'An
            "2024-05-01, true",   // Fête du Travail
            "2024-07-14, true",   // Fête nationale
            "2024-12-25, true",   // Noël
            "2024-06-15, false"    // Jour non férié
    })
    @DisplayName("Test de la méthode estJourFerie avec différentes dates")
    void testEstJourFerie(String date, boolean expected) {
        LocalDate jour = LocalDate.parse(date);
        assertEquals(expected, Entreprise.estJourFerie(jour), "Erreur sur la date " + date);
    }
}

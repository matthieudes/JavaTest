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


    @ParameterizedTest
    @CsvSource({
            "2024-01-01, 2024-01-01, 2024-12-31, true",  // Date au début de la plage
            "2024-12-31, 2024-01-01, 2024-12-31, true",  // Date à la fin de la plage
            "2024-06-15, 2024-01-01, 2024-12-31, true",  // Date dans la plage
            "2024-01-01, 2024-02-01, 2024-12-31, false",  // Date avant la plage
            "2024-12-31, 2024-01-01, 2024-11-30, false",  // Date après la plage
            "2024-06-15, null, 2024-12-31, false",  // Date de début nulle
            "2024-06-15, 2024-01-01, null, false",  // Date de fin nulle
            "null, 2024-01-01, 2024-12-31, false",  // Date d'input nulle
            "null, null, null, false"  // Toutes les dates nulles
    })
    @DisplayName("Test de la méthode estDansPlage avec différentes dates")
    void testEstDansPlage(String dateStr, String debutStr, String finStr, boolean expected) {
        LocalDate date = "null".equals(dateStr) ? null : LocalDate.parse(dateStr);
        LocalDate debut = "null".equals(debutStr) ? null : LocalDate.parse(debutStr);
        LocalDate fin = "null".equals(finStr) ? null : LocalDate.parse(finStr);

        assertEquals(expected, Entreprise.estDansPlage(date, debut, fin),
                "Erreur pour la date " + dateStr + " dans la plage " + debutStr + " à " + finStr);
    }


}
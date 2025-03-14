package com.ipi.jva350.model;

import com.ipi.jva350.repository.SalarieAideADomicileRepository;
import com.ipi.jva350.service.SalarieAideADomicileService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
public class SalarieAideADomicileServiceTest {
    @Mock
    private SalarieAideADomicileRepository salarieAideADomicileRepository;

    @InjectMocks
    private SalarieAideADomicileService salarieService;

    @Test
    public void CalculeLimiteEntrepriseCongesPermisTest() {
        // Given
        LocalDate moisEnCours = LocalDate.of(2023, 11, 1);
        double congesPayesAcquisAnneeNMoins1 = 20;
        LocalDate moisDebutContrat = LocalDate.of(2022, 6, 28);
        LocalDate premierJourDeConge = LocalDate.of(2023, 12, 17);
        LocalDate dernierJourDeConge = LocalDate.of(2023, 12, 18);

        // On vient simuler le comportement de la méthode partCongesPrisTotauxAnneeNMoins1 pour qu'elle retourne 0
        Mockito.when(salarieAideADomicileRepository.partCongesPrisTotauxAnneeNMoins1()).thenReturn(0.0);

        // When
        long limiteEntreprise = salarieService.calculeLimiteEntrepriseCongesPermis(
                moisEnCours, congesPayesAcquisAnneeNMoins1, moisDebutContrat, premierJourDeConge, dernierJourDeConge);

        // Then
        Assertions.assertEquals(16, limiteEntreprise); // Adjust the expected value based on your business logic
    }
}

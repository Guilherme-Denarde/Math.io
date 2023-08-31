package com.uniamerida.estadistica.Service;

import com.uniamerida.estadistica.Entity.NumeroEntity;
import com.uniamerida.estadistica.Repository.NumeroRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class NumeroServiceTest {

    @InjectMocks
    private NumeroService numeroService;

    @Mock
    private NumeroRepository numeroRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSalvarNumero() {
        Double valor = 10.0;
        NumeroEntity entity = new NumeroEntity(null, valor);
        when(numeroRepository.save(any(NumeroEntity.class))).thenReturn(entity);

        NumeroEntity result = numeroService.salvarNumero(valor);
        assertEquals(valor, result.getValor());
    }

    @Test
    public void testCalcularMedia() {
        double media = numeroService.calcularMedia(Arrays.asList(2.0, 4.0, 6.0));
        assertEquals(4.0, media);
    }

    @Test
    public void testCalcularDesvioPadrao() {
        // Given
        NumeroService service = new NumeroService();
        List<Double> numeros = Arrays.asList(1.0, 2.0, 3.0, 4.0, 5.0);

        // When
        double result = service.calcularDesvioPadrão(numeros);

        // Then
        // The expected standard deviation of [1.0, 2.0, 3.0, 4.0, 5.0] is approximately 1.5811
        assertEquals(1.5811, result, 0.001);
    }

}

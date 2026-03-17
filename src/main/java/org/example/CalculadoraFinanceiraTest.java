package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

public class CalculadoraFinanceiraTest {

    CalculadoraFinanceira calc = new CalculadoraFinanceira();

    @BeforeEach
    void iniciar() {
        calc = new CalculadoraFinanceira();
    }

    @Test
    void testeDesconto() {
        assertEquals(90, calc.calcularDesconto(100, 10));
    }

    @Test
    void testeDescontoErro() {
        assertThrows(IllegalArgumentException.class, () -> {
            calc.calcularDesconto(-100, 10);
        });
    }

    @Test
    void testeDescontoZero() {
        assertEquals(100, calc.calcularDesconto(100, 0));
    }

    @Test
    void testeJuros() {
        assertEquals(200, calc.calcularJurosSimples(1000, 0.1, 2));
    }

    @Test
    void testeJurosErro() {
        assertThrows(IllegalArgumentException.class, () -> {
            calc.calcularJurosSimples(0, 0.1, 2);
        });
    }

    @Test
    void testeMedia() {
        double[] valores = {6.0, 8.0};
        assertEquals(7, calc.calcularMedia(valores));
    }

    @Test
    void testeMediaErro() {
        assertThrows(IllegalArgumentException.class, () -> {
            calc.calcularMedia(null);
        });
    }

    @Test
    void testeMediaVazia() {
        assertThrows(IllegalArgumentException.class, () -> {
            calc.calcularMedia(new double[]{});
        });
    }

    @Test
    void testeAprovado() {
        assertTrue(calc.ehAprovado(6));
        assertFalse(calc.ehAprovado(5));
    }

    @ParameterizedTest
    @ValueSource(doubles = {6, 7, 10})
    void testeAprovadoVarios(double nota) {
        assertTrue(calc.ehAprovado(nota));
    }
}
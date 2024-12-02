package br.edu.univille.poo.libetravel;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class IntegracaoBancoServiceTest {

    @Test
    void deveRegistrarDespesaAutomaticaComSucesso() {
        IntegracaoBancoService service = new IntegracaoBancoService();

        Despesa despesa = service.registrarDespesaAutomatica("Compra Transporte", 50.0);

        assertNotNull(despesa);
        assertEquals("Transporte", despesa.getCategoria());
        assertEquals(50.0, despesa.getValor());
    }

    @Test
    void deveLancarExcecaoParaDadosInvalidos() {
        IntegracaoBancoService service = new IntegracaoBancoService();

        assertThrows(IllegalArgumentException.class, () ->
                service.registrarDespesaAutomatica("", 50.0)
        );
    }
}

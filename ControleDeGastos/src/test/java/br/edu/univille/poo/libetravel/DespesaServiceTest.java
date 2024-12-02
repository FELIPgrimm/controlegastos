package br.edu.univille.poo.libetravel;

import org.junit.jupiter.api.Test;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

class DespesaServiceTest {

    // Testa se a despesa é registrada com sucesso
    @Test
    void deveRegistrarDespesaComSucesso() {
        DespesaService despesaService = new DespesaService();

        Despesa despesa = despesaService.registrarDespesa(100.0, "Alimentação");

        assertNotNull(despesa);
        assertEquals("Alimentação", despesa.getCategoria());
        assertEquals(100.0, despesa.getValor());
        assertNotNull(despesa.getData());  // Verifica se a data foi regitrada corretamente
    }

    // Testa se uma categoria inválida gera exceção
    @Test
    void deveLancarExcecaoParaCategoriaInvalida() {
        DespesaService despesaService = new DespesaService();

        // Teste de categoria vazia
        assertThrows(IllegalArgumentException.class, () ->
                despesaService.registrarDespesa(100.0, "")
        );

        // Teste de categoria nula
        assertThrows(IllegalArgumentException.class, () ->
                despesaService.registrarDespesa(100.0, null)
        );

        // Teste de categoria apenas com espaços
        assertThrows(IllegalArgumentException.class, () ->
                despesaService.registrarDespesa(100.0, "   ")
        );
    }

    // Testa se um valor inválido (menor ou igual a zero) gera exceção
    @Test
    void deveLancarExcecaoParaValorInvalido() {
        DespesaService despesaService = new DespesaService();

        // Teste de valor negativo
        assertThrows(IllegalArgumentException.class, () ->
                despesaService.registrarDespesa(-50.0, "Alimentação")
        );

        // Teste de valor zero
        assertThrows(IllegalArgumentException.class, () ->
                despesaService.registrarDespesa(0.0, "Alimentação")
        );
    }

    // Testa a criação de uma despesa com valor muito pequeno (mas válido)

    @Test
    void deveRegistrarDespesaComValorPequeno() {
        DespesaService despesaService = new DespesaService();

        Despesa despesa = despesaService.registrarDespesa(0.01, "Transporte");

        assertNotNull(despesa);
        assertEquals(0.01, despesa.getValor());
    }

}

package br.edu.univille.poo.libetravel;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;



class CategorizacaoServiceTest {

    @Test
    void deveCategorizarDespesaCorretamente() {
        CategorizacaoService service = new CategorizacaoService();

        // Testes de categorização
        assertEquals("Alimentação", service.categorizarDespesa("Jantar no restaurante"));
        assertEquals("Transporte", service.categorizarDespesa("Taxi para casa"));
        assertEquals("Outros", service.categorizarDespesa("Compra de livros"));
    }

    @Test
    void deveLancarExcecaoParaDescricaoInvalida() {
        CategorizacaoService service = new CategorizacaoService();

        // Testa se uma descrição vazia lança exceção
        assertThrows(IllegalArgumentException.class, () -> service.categorizarDespesa(""));
    }
}

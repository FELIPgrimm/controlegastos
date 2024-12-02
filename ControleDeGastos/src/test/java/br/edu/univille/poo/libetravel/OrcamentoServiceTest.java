package br.edu.univille.poo.libetravel;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class OrcamentoServiceTest {

    @Test
    void deveCriarOrcamentoComSucesso() {
        OrcamentoService service = new OrcamentoService();

        service.criarOrcamento("Alimentação", 500.0);

        assertEquals(500.0, service.obterOrcamento("Alimentação"));
    }

    @Test
    void deveEditarOrcamentoComSucesso() {
        OrcamentoService service = new OrcamentoService();
        service.criarOrcamento("Transporte", 300.0);

        service.editarOrcamento("Transporte", 400.0);

        assertEquals(400.0, service.obterOrcamento("Transporte"));
    }

    @Test
    void deveLancarExcecaoParaCategoriaNaoEncontrada() {
        OrcamentoService service = new OrcamentoService();

        assertThrows(IllegalArgumentException.class, () ->
                service.editarOrcamento("Saúde", 500.0)
        );
    }
}

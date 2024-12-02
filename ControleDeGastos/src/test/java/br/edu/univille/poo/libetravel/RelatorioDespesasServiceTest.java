package br.edu.univille.poo.libetravel;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

class RelatorioDespesasServiceTest {

    @Test
    void deveListarDespesasPorCategoriaComSucesso() {
        RelatorioDespesasService service = new RelatorioDespesasService();
        service.adicionarDespesa("Alimentação", 100.0);
        service.adicionarDespesa("Alimentação", 50.0);
        service.adicionarDespesa("Transporte", 30.0);

        List<Despesa> despesas = service.listarDespesasPorCategoria("Alimentação");

        assertEquals(2, despesas.size());
        assertEquals(100.0, despesas.get(0).getValor());
        assertEquals(50.0, despesas.get(1).getValor());
    }

    @Test
    void deveRetornarListaVaziaParaCategoriaSemDespesas() {
        RelatorioDespesasService service = new RelatorioDespesasService();

        List<Despesa> despesas = service.listarDespesasPorCategoria("Saúde");

        assertTrue(despesas.isEmpty());
    }

    @Test
    void deveLancarExcecaoParaAdicionarDespesaComDadosInvalidos() {
        RelatorioDespesasService service = new RelatorioDespesasService();

        assertThrows(IllegalArgumentException.class, () ->
                service.adicionarDespesa("", 50.0)
        );
    }
}

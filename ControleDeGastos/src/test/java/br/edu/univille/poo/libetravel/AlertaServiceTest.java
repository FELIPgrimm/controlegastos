package br.edu.univille.poo.libetravel;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AlertaServiceTest {

    @Test
    void deveEnviarAlertaAoUltrapassarOrcamento() {
        OrcamentoService orcamentoService = new OrcamentoService();
        orcamentoService.criarOrcamento("Alimentação", 200.0);

        AlertaService alertaService = new AlertaService(orcamentoService);

        String alerta = alertaService.verificarOrcamento("Alimentação", 250.0);

        assertEquals("Alerta: Orçamento para Alimentação ultrapassado!", alerta);
    }

    @Test
    void naoDeveEnviarAlertaSeDentroDoOrcamento() {
        OrcamentoService orcamentoService = new OrcamentoService();
        orcamentoService.criarOrcamento("Transporte", 300.0);

        AlertaService alertaService = new AlertaService(orcamentoService);

        String alerta = alertaService.verificarOrcamento("Transporte", 250.0);

        assertEquals("Orçamento dentro do limite.", alerta);
    }
}

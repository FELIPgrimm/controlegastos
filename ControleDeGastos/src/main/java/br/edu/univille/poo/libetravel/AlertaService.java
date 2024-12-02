package br.edu.univille.poo.libetravel;

public class AlertaService {

    private final OrcamentoService orcamentoService;

    public AlertaService(OrcamentoService orcamentoService) {
        this.orcamentoService = orcamentoService;
    }

    public String verificarOrcamento(String categoria, double valorAtual) {
        double limite = orcamentoService.obterOrcamento(categoria);
        if (valorAtual > limite) {
            return "Alerta: Orçamento para " + categoria + " ultrapassado!";
        }
        return "Orçamento dentro do limite.";
    }
}

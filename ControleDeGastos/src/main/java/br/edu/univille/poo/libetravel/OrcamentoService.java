package br.edu.univille.poo.libetravel;

import java.util.HashMap;
import java.util.Map;

public class OrcamentoService {

    private final Map<String, Double> orcamentos = new HashMap<>();

    public void criarOrcamento(String categoria, double valor) {
        if (categoria == null || categoria.isEmpty() || valor <= 0) {
            throw new IllegalArgumentException("Dados inválidos para orçamento");
        }
        orcamentos.put(categoria, valor);
    }

    public void editarOrcamento(String categoria, double novoValor) {
        if (!orcamentos.containsKey(categoria)) {
            throw new IllegalArgumentException("Categoria não encontrada");
        }
        if (novoValor <= 0) {
            throw new IllegalArgumentException("Valor inválido para orçamento");
        }
        orcamentos.put(categoria, novoValor);
    }

    public double obterOrcamento(String categoria) {
        return orcamentos.getOrDefault(categoria, 0.0);
    }
}

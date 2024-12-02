package br.edu.univille.poo.libetravel;

import java.util.*;

public class RelatorioDespesasService {

    private final Map<String, List<Despesa>> despesasPorCategoria = new HashMap<>();

    public void adicionarDespesa(String categoria, double valor) {
        if (categoria == null || categoria.isEmpty() || valor <= 0) {
            throw new IllegalArgumentException("Dados inválidos");
        }
        despesasPorCategoria.putIfAbsent(categoria, new ArrayList<>());
        despesasPorCategoria.get(categoria).add(new Despesa(valor, categoria));
    }

    public List<Despesa> listarDespesasPorCategoria(String categoria) {
        return despesasPorCategoria.getOrDefault(categoria, Collections.emptyList());
    }
}

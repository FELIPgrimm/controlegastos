package br.edu.univille.poo.libetravel;

import java.util.*;

public class RelatorioMensalService {

    private final Map<String, List<Despesa>> despesasPorCategoria = new HashMap<>();

    public void adicionarDespesa(String categoria, double valor, Date data) {
        if (categoria == null || categoria.isEmpty() || valor <= 0 || data == null) {
            throw new IllegalArgumentException("Dados inválidos");
        }
        despesasPorCategoria.putIfAbsent(categoria, new ArrayList<>());
        despesasPorCategoria.get(categoria).add(new Despesa(categoria, valor, data));
    }

    public Map<String, Double> gerarRelatorioMensal(int mes, int ano) {
        Map<String, Double> relatorioMensal = new HashMap<>();

        for (Map.Entry<String, List<Despesa>> entry : despesasPorCategoria.entrySet()) {
            for (Despesa despesa : entry.getValue()) {
                Calendar cal = Calendar.getInstance();
                cal.setTime(despesa.getData());
                if (cal.get(Calendar.MONTH) + 1 == mes && cal.get(Calendar.YEAR) == ano) {
                    relatorioMensal.merge(entry.getKey(), despesa.getValor(), Double::sum);
                }
            }
        }
        return relatorioMensal;
    }
}

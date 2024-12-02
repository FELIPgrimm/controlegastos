package br.edu.univille.poo.libetravel;
import java.util.*;


public class RelatorioHistoricoService {

    private final Map<String, List<Despesa>> despesasPorCategoria = new HashMap<>();

    public void adicionarDespesa(String categoria, double valor, Date data) {
        if (categoria == null || categoria.isEmpty() || valor <= 0 || data == null) {
            throw new IllegalArgumentException("Dados inválidos");
        }
        despesasPorCategoria.putIfAbsent(categoria, new ArrayList<>());
        despesasPorCategoria.get(categoria).add(new Despesa(categoria, valor, data));
    }

    public Map<String, Map<String, Double>> gerarRelatoriosHistoricos() {
        Map<String, Map<String, Double>> historico = new TreeMap<>(); // Ordenado por data

        for (Map.Entry<String, List<Despesa>> entry : despesasPorCategoria.entrySet()) {
            for (Despesa despesa : entry.getValue()) {
                Calendar cal = Calendar.getInstance();
                cal.setTime(despesa.getData());
                String mesAno = String.format("%02d-%d", cal.get(Calendar.MONTH) + 1, cal.get(Calendar.YEAR));

                historico.putIfAbsent(mesAno, new HashMap<>());
                historico.get(mesAno).merge(entry.getKey(), despesa.getValor(), Double::sum);
            }
        }
        return historico;
    }
}

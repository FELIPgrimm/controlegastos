package br.edu.univille.poo.libetravel;

public class CategorizacaoService {

    public String categorizarDespesa(String descricao) {
        if (descricao == null || descricao.isEmpty()) {
            throw new IllegalArgumentException("Descrição inválida");
        }

        // Depuração: Verificando a descrição recebida
        System.out.println("Descrição recebida: " + descricao);

        // Verificando a lógica de categorização
        if (descricao.toLowerCase().contains("alimentação") || descricao.toLowerCase().contains("restaurante")) {
            return "Alimentação";
        }
        if (descricao.toLowerCase().contains("transporte") || descricao.toLowerCase().contains("taxi")) {
            return "Transporte";
        }
        return "Outros";
    }
}

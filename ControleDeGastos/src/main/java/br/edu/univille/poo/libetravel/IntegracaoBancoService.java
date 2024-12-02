package br.edu.univille.poo.libetravel;

public class IntegracaoBancoService {

    public Despesa registrarDespesaAutomatica(String descricao, double valor) {
        if (descricao == null || descricao.isEmpty() || valor <= 0) {
            throw new IllegalArgumentException("Dados inválidos para despesa automática");
        }
        // Supondo que a descrição ajuda na categorização
        String categoria = descricao.contains("Transporte") ? "Transporte" : "Outros";
        return new Despesa(valor, categoria);
    }
}

package br.edu.univille.poo.libetravel;

public class DespesaService {

    public Despesa registrarDespesa(double valor, String categoria) {
        // Validação para categoria inválida
        if (categoria == null || categoria.trim().isEmpty()) {
            throw new IllegalArgumentException("Categoria inválida.");
        }

        // Validação para valor menor ou igual a zero
        if (valor <= 0) {
            throw new IllegalArgumentException("O valor deve ser maior que zero.");
        }

        // Criação da despesa
        return new Despesa(valor, categoria);  // Certifique-se de que a categoria está sendo corretamente passada para o construtor de Despesa
    }
}

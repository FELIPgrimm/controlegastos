package br.edu.univille.poo.libetravel;

import java.util.Date;

public class Despesa {
    private double valor;
    private String categoria;
    private Date data;

    // Construtor que recebe valor e categoria
    public Despesa(double valor, String categoria) {
        this.valor = valor;
        this.categoria = categoria;
        this.data = new Date();  // Inicializa a data com a data atual
    }

    // Construtor com data explícita
    public Despesa(String categoria, double valor, Date data) {
        this.valor = valor;
        this.categoria = categoria;
        this.data = data;
    }

    // Getters
    public double getValor() {
        return valor;
    }

    public String getCategoria() {
        return categoria;
    }

    public Date getData() {
        return data;
    }
}

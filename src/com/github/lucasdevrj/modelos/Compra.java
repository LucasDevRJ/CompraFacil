package com.github.lucasdevrj.modelos;

public class Compra implements Comparable<Compra> {

    private String descricao;
    private double preco;

    public Compra(String descricao, double preco) {
        this.descricao = descricao;
        this.preco = preco;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public int compareTo(Compra outraCompra) {
        return Double.compare(preco, outraCompra.preco);
    }

    @Override
    public String toString() {
        return "%s - R$%.2f".formatted(descricao, preco);
    }
}

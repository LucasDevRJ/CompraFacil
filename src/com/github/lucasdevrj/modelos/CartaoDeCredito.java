package com.github.lucasdevrj.modelos;

import java.util.ArrayList;

public class CartaoDeCredito {

    private double limite;
    private ArrayList<Compra> extrato;

    public CartaoDeCredito(double limite) {
        this.limite = limite;
    }

    public double getLimite() {
        return limite;
    }
}

package com.github.lucasdevrj.modelos;

import java.util.ArrayList;

public class CartaoDeCredito {

    private double limite;
    private ArrayList<Compra> extrato;

    public CartaoDeCredito(double limite, ArrayList<Compra> extrato) {
        this.limite = limite;
        this.extrato = extrato;
    }

    public double getLimite() {
        return limite;
    }

    public ArrayList<Compra> getExtrato() {
        return extrato;
    }
}

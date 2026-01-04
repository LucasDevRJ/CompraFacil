package com.github.lucasdevrj.principal;

import com.github.lucasdevrj.modelos.CartaoDeCredito;
import com.github.lucasdevrj.modelos.Compra;

import java.util.ArrayList;
import java.util.Scanner;

public class MenuPrincipal {

    public void exibeMenu() {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite o limite do cartão: ");
        double limite = entrada.nextDouble();

        ArrayList<Compra> listaDeCompras = new ArrayList<>();

        int resposta = 1;
        do {

            System.out.println("Digite a descrição da compra: ");
            String descricao = entrada.nextLine();

            System.out.print("Digite o valor da compra: ");
            double preco = entrada.nextDouble();

            if (preco > limite) {
                System.out.println("Saldo insuficiente!");
                break;
            }

            Compra compra = new Compra(descricao, preco);
            listaDeCompras.add(compra);
            limite -= preco;

            System.out.print("Digite 0 para sair ou 1 para continuar: ");
            resposta = entrada.nextInt();
        } while(resposta == 1);

        CartaoDeCredito cartaoDeCredito = new CartaoDeCredito(limite, listaDeCompras);
        exibeComprasRealizadas(cartaoDeCredito);

        entrada.close();
    }

    public void exibeComprasRealizadas(CartaoDeCredito cartaoDeCredito) {
        for (Compra compra : cartaoDeCredito.getExtrato()) {
            String produto = compra.getDescricao();
            double preco = compra.getPreco();
            double limite = cartaoDeCredito.getLimite();
            String extrato = """
                **********************************
                COMPRAS REALIZADAS:
                %s - R$%2.f
                
                **********************************
                
                Saldo do cartão: R$%2.f
                """.formatted(produto, preco, limite);
            System.out.println(extrato);
        }
    }
}

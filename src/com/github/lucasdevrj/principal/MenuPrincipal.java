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

        CartaoDeCredito cartaoDeCredito = new CartaoDeCredito(limite);
        ArrayList<Compra> listaDeCompras = new ArrayList<>();

        int resposta = 1;
        do {

            System.out.println("Digite a descrição da compra: ");
            String descricao = entrada.nextLine();

            System.out.print("Digite o valor da compra: ");
            double preco = entrada.nextDouble();

            if (preco > cartaoDeCredito.getLimite()) {
                System.out.println("Saldo insuficiente!");
                break;
            }

            Compra compra = new Compra(descricao, preco);
            listaDeCompras.add(compra);

            System.out.print("Digite 0 para sair ou 1 para continuar: ");
            resposta = entrada.nextInt();
        } while(resposta == 1);

        exibeComprasRealizadas(listaDeCompras);

        entrada.close();
    }

    public void exibeComprasRealizadas(ArrayList<Compra> listaDeCompras) {
        String extrato = """
                **********************************
                COMPRAS REALIZADAS:
                %s - R$%2.f
                
                **********************************
                
                Saldo do cartão: R$%2.f
                """.formatted(listaDeCompras);
        System.out.println(extrato);
    }
}

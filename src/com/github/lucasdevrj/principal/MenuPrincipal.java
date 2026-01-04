package com.github.lucasdevrj.principal;

import com.github.lucasdevrj.modelos.CartaoDeCredito;
import com.github.lucasdevrj.modelos.Compra;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class MenuPrincipal {

    public void exibeMenu() {
        Scanner entrada = new Scanner(System.in);

        System.out.print("Digite o limite do cartão: ");
        double limite = entrada.nextDouble();
        entrada.nextLine();

        ArrayList<Compra> listaDeCompras = new ArrayList<>();

        int resposta = 1;
        do {

            System.out.print("Digite a descrição da compra: ");
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
            entrada.nextLine();
        } while(resposta == 1);

        CartaoDeCredito cartaoDeCredito = new CartaoDeCredito(limite, listaDeCompras);
        exibeComprasRealizadas(cartaoDeCredito);

        entrada.close();
    }

    private void exibeComprasRealizadas(CartaoDeCredito cartaoDeCredito) {
        System.out.println("**********************************");
        System.out.println("COMPRAS REALIZADAS: ");
        ArrayList<Compra> listaDeCompras = cartaoDeCredito.getExtrato();
        listaDeCompras.sort(Comparator.comparing(Compra::getPreco));
        for (Compra compra : listaDeCompras) {
            System.out.println(compra);
        }
        System.out.println("**********************************");
        System.out.printf("Saldo do cartão: R$%.2f", cartaoDeCredito.getLimite());
    }
}

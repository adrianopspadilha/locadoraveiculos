package br.com.fundatec.locadoraveiculos.menu;

import br.com.fundatec.locadoraveiculos.util.Teclado;

import java.util.Scanner;

public class MenuPrincipal {
    private Teclado teclado;
    private MenuCliente menuCliente;
    private MenuVeiculos menuVeiculos;
    private MenuLocacao menuLocacao;

    public MenuPrincipal() {
        teclado = new Teclado();
        menuCliente = new MenuCliente(teclado);
        menuVeiculos = new MenuVeiculos(teclado);
        menuLocacao = new MenuLocacao(teclado);
    }

    public void mostrarMenu() {
        int opcao;

        do {
            imprimirMenu();
            opcao = teclado.lerInt("Qual a opção desejada ?");

            switch (opcao) {
                case 1:
                    System.out.println("Navegando para menu de clientes...");
                    System.out.println();
                    menuCliente.menuCliente();
                    break;
                case 2:
                    System.out.println("Navegando para menu de veiculos...");
                    System.out.println();
                    menuVeiculos.menuVeiculos();
                    break;
                case 3:
                    System.out.println("Navegando para menu de locacoes...");
                    System.out.println();
                    menuLocacao.menuLocacao();
                    break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    return;
                default:
                    System.out.println("Opção invalida!");
            }
        } while (true);
    }

    public void imprimirMenu() {
        System.out.println("Bem vindo ao Menu Principal: \n Escolha umas das opções abaixo:");
        System.out.println("   1 - Menu de clientes \n   2 - Menu de veiculos \n   3 - Menu de locações \n   0 - Encerrar o progama");


    }
}

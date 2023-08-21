package br.com.fundatec.locadoraveiculos;

import br.com.fundatec.locadoraveiculos.bancodedados.TabelaCliente;
import br.com.fundatec.locadoraveiculos.bancodedados.TabelaVeiculos;
import br.com.fundatec.locadoraveiculos.menu.MenuPrincipal;

public class LocadoraVeiculos {

    public static void main(String[] args) {
        TabelaVeiculos tabelaVeiculos = TabelaVeiculos.obterTabela();
        tabelaVeiculos.inicializar();

        TabelaCliente tabelaCliente = TabelaCliente.obterTabela();
        tabelaCliente.inicializar();

        MenuPrincipal menu = new MenuPrincipal();
        menu.mostrarMenu();

        System.out.println("Programa finalizado!");

    }
}

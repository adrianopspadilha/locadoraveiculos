package br.com.fundatec.locadoraveiculos.bancodedados;

import br.com.fundatec.locadoraveiculos.modelo.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TabelaCliente {

    private static TabelaCliente instancia;
    private List<Cliente> clientes;

    private TabelaCliente() {
        this.clientes = new ArrayList<>();
    }

    public void adicionar(Cliente cliente) {
        this.clientes.add(cliente);
    }

    public static TabelaCliente obterTabela() {
        if (instancia == null) {
            instancia = new TabelaCliente();
        }
        return instancia;
    }

    public List<Cliente> getClientes() {
        return Collections.unmodifiableList(clientes);
    }

    public void inicializar(){
        this.adicionar(new Cliente("Adriano Padilha",40427730015l, TipoDocumento.CPF, new Endereco("Lucas de Oliveira",2704,"Apt 101", "Petropolis","POA","RS",90630084)));



    }
}
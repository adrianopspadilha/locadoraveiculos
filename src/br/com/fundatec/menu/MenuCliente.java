package br.com.fundatec.locadoraveiculos.menu;

import br.com.fundatec.locadoraveiculos.bancodedados.TabelaCliente;
import br.com.fundatec.locadoraveiculos.modelo.Cliente;
import br.com.fundatec.locadoraveiculos.modelo.Endereco;
import br.com.fundatec.locadoraveiculos.modelo.TipoDocumento;
import br.com.fundatec.locadoraveiculos.modelo.TipoPessoa;
import br.com.fundatec.locadoraveiculos.util.Teclado;

import java.util.List;
import java.util.Scanner;

public class MenuCliente {

    private Teclado teclado;

    private TabelaCliente tabelaCliente;

    public MenuCliente(Teclado teclado) {
        this.teclado = teclado;
        this.tabelaCliente = TabelaCliente.obterTabela();
    }

    public void menuCliente() {
        int opcao;

        do {

            System.out.println(" Escolha uma das opções: \n  1 - Cadastrar cliente \n  2 - Listar clientes \n  0 - Voltar para o menu principal");
            System.out.println(" ");
            opcao = teclado.lerInt("Qual a opção desejada ?");

            switch (opcao) {
                case 1:
                    System.out.println("Navegando para cadastrar clientes...");
                    incluirCliente();
                    break;
                case 2:
                    System.out.println("Navegando para listar clientes...");
                    System.out.println(" ");
                    listarClientes();
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal...");
                    return;
                default:
                    System.out.println("Opção invalida!");
            }
        } while (true);
    }

    private void incluirCliente() {
        System.out.println();
        System.out.println("Cadastro De Cliente:");
        TipoPessoa tipoPessoa = teclado.lerTipoPessoa("Informe o tipo de pessoa (PESSOA_FISICA ou PESSOA_JURIDICA): ");
        Cliente cliente;
        if (tipoPessoa.PESSOA_FISICA == tipoPessoa) {
          cliente = incluirClientePessoaFisica();
        } else {
          cliente = incluirClientePessoaJuridica();
        }
        tabelaCliente.adicionar(cliente);

        System.out.println("  >>> Cliente cadastrado com sucesso! <<<");
    }

    private Cliente incluirClientePessoaFisica() {
        String nome = teclado.lerString("Digite o nome:");
        TipoDocumento tipoDocumento = teclado.lerTipoDocumento("Informe o tipo de documento (CNH, CPF ou RG): ");
        Long numeroDocumento = teclado.lerLong("Informe o numero do documento: ");
        Endereco endereco = incluirEndereco();

        return new Cliente(nome, numeroDocumento, tipoDocumento,endereco);
    }

    private Cliente incluirClientePessoaJuridica() {
        String razaoSocial = teclado.lerString("Informe a razão social: ");
        Long cnpj = teclado.lerLong("Digite o CNPJ: ");
        Endereco endereco = incluirEndereco();

        return new Cliente(razaoSocial, cnpj, endereco);
    }

    private Endereco incluirEndereco() {
        String logradouro = teclado.lerString("Informe o logradouro: ");
        Integer numero = teclado.lerInt("Informe o numero: ");
        String complemento = teclado.lerString("Digite o complemento: ");
        String bairro = teclado.lerString("Informe o bairro: ");
        String cidade = teclado.lerString("Informe a cidade: ");
        String uf = teclado.lerString("Informe a UF: ");
        Integer cep = teclado.lerInt("Digite o CEP: ");

        return new Endereco(logradouro, numero, complemento, bairro, cidade, uf, cep);
    }

    private void listarClientes() {
        List<Cliente> listaClientes = tabelaCliente.getClientes();

        if (listaClientes.isEmpty()) {
            System.out.println("Ainda não ha clientes cadastrados");
        } else {
            for (Cliente cliente : listaClientes) {
                System.out.println((listaClientes.indexOf(cliente) + 1)
                        + " " + cliente.getTipoPessoa()
                        + " " + imprimirNomeOuRazaosocial(cliente)
                        + " " + imprimirTipoDocumento(cliente)
                        + " " + imprimirNumeroDocumento(cliente)
                        + " " + imprimirEndereco(cliente.getEndereco()));
            }
        }
    }

    private Long imprimirNumeroDocumento(Cliente cliente) {
        if (TipoPessoa.PESSOA_FISICA == cliente.getTipoPessoa()) {
            return cliente.getNumeroDocumento();
        }
        return cliente.getCnpj();
    }

    private String imprimirTipoDocumento(Cliente cliente) {
        if (TipoPessoa.PESSOA_FISICA == cliente.getTipoPessoa()) {
            return cliente.getTipoDocumento().toString();
        }

        return "CNPJ";
    }

    private String imprimirNomeOuRazaosocial(Cliente cliente) {
        if (TipoPessoa.PESSOA_FISICA == cliente.getTipoPessoa()) {
            return cliente.getNome();
        }
        return cliente.getRazaoSocial();
    }

    private String imprimirEndereco(Endereco endereco) {
        return endereco.getLogradouro()
                + ", " + endereco.getNumero()
                + ", " + endereco.getComplemento()
                + " - " + endereco.getBairro()
                + ". " + endereco.getCidade()
                + "/" + endereco.getUf()
                + ". CEP: " + endereco.getCep();
    }
}

package br.com.fundatec.locadoraveiculos.menu;

import br.com.fundatec.locadoraveiculos.bancodedados.TabelaCliente;
import br.com.fundatec.locadoraveiculos.bancodedados.TabelaLocacao;
import br.com.fundatec.locadoraveiculos.bancodedados.TabelaVeiculos;
import br.com.fundatec.locadoraveiculos.modelo.*;
import br.com.fundatec.locadoraveiculos.util.Teclado;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MenuLocacao {
    private Teclado teclado;

    private TabelaLocacao tabelaLocacao;

    private TabelaCliente tabelaCliente;

    private TabelaVeiculos tabelaVeiculos;

    public MenuLocacao(Teclado teclado) {
        this.teclado = teclado;
        this.tabelaLocacao = TabelaLocacao.obterTabela();
        this.tabelaCliente = TabelaCliente.obterTabela();
        this.tabelaVeiculos = TabelaVeiculos.obterTabela();
    }

    public void menuLocacao() {
        int opcao;

        do {
            System.out.println(" Escolha uma das opções: " +
                    "\n  1 - Cadastrar locação " +
                    "\n  2 - Listar locação " +
                    "\n  3 - Encerrar locações " +
                    "\n  0 - Voltar para o menu principal");
            opcao = teclado.lerInt("Qual a opção desejada ?");

            switch (opcao) {
                case 1:
                    System.out.println("Navegando para cadastrar locação...");
                    System.out.println(" ");
                    cadastrarLocacao();
                    break;
                case 2:
                    System.out.println("Navegando para listar locação...");
                    System.out.println(" ");
                    listarLocacoes();
                    break;
                case 3:
                    System.out.println("Navegando para encerrar locação...");
                    System.out.println(" ");
                    encerrarLocacao();
                    return;
                case 0:
                    System.out.println("Voltando ao menu principal...");
                    return;
                default:
                    System.out.println("Opção invalida!");
            }
        } while (true);
    }

    private void cadastrarLocacao() {

        if (tabelaVeiculos.getVeiculos().isEmpty()) {
            System.out.println("Lista de veiculos vazia");
        } else if (tabelaCliente.getClientes().isEmpty()) {
            System.out.println("Lista de clientes vazia");
        } else {
            listarVeiculos();

            int idVeiculo = teclado.lerInt("Digite o ID do veiculo: ");

            listarClientes();

            int idCliente = teclado.lerInt("Digite o ID do cliente: ");

            LocalDate dataLocacao = informarDataLocacao();

            Veiculo veiculoSelecionado = tabelaVeiculos.getVeiculos().get(idVeiculo - 1);
            Cliente clienteSelecionado = tabelaCliente.getClientes().get(idCliente - 1);
            Locacao novaLocacao = new Locacao(clienteSelecionado, veiculoSelecionado, dataLocacao, null, 0.0, SituacaoLocacao.ATIVA);

            tabelaLocacao.adicionar(novaLocacao);

            System.out.println("Locação cadastrada com sucesso!");
        }
    }

    private void listarVeiculos() {
        List<Veiculo> listaVeiculos = tabelaVeiculos.getVeiculos();

        if (listaVeiculos.isEmpty()) {
            System.out.println("Ainda não há veículos cadastrados.");
        } else {
            System.out.println("Lista de Veículos Disponíveis:");
            System.out.println("ID | Placa | Marca | Modelo | Tipo | Km | Valor Km Rodado | Valor Diária");

            for (Veiculo veiculo : listaVeiculos) {
                System.out.printf("%2d | %-7s | %-5s | %-6s | %-4s | %.1f | R$ %.2f | R$ %.2f%n",
                        (listaVeiculos.indexOf(veiculo) + 1),
                        veiculo.getPlaca(),
                        veiculo.getMarca(),
                        veiculo.getModelo(),
                        veiculo.getTipoVeiculo(),
                        veiculo.getKilometragem(),
                        veiculo.getValorKmRodados(),
                        veiculo.getValorDiaria());
            }
        }
    }

    private void listarClientes() {
        List<Cliente> listaClientes = tabelaCliente.getClientes();

        if (listaClientes.isEmpty()) {
            System.out.println("Ainda não há clientes cadastrados.");
        } else {
            System.out.println("Lista de Clientes Disponíveis:");
            System.out.println("ID | Tipo | Nome/Razão Social | Documento");

            for (Cliente cliente : listaClientes) {
                System.out.printf("%2d | %-4s | %-20s | %s%n",
                        (listaClientes.indexOf(cliente) + 1),
                        cliente.getTipoPessoa(),
                        imprimirNomeOuRazaosocial(cliente),
                        imprimirNumeroDocumento(cliente));
            }
        }
    }

    private String imprimirNumeroDocumento(Cliente cliente) {
        if (TipoPessoa.PESSOA_FISICA == cliente.getTipoPessoa()) {
            return String.valueOf(cliente.getNumeroDocumento());
        }
        return String.valueOf(cliente.getCnpj());
    }

    private String imprimirNomeOuRazaosocial(Cliente cliente) {
        if (TipoPessoa.PESSOA_FISICA == cliente.getTipoPessoa()) {
            return String.valueOf(cliente.getNome());
        }
        return String.valueOf(cliente.getRazaoSocial());
    }

    private LocalDate informarDataLocacao() {
        while (true) {
            try {
                int dia = teclado.lerInt("Digite o dia da locação: ");
                int mes = teclado.lerInt("Digite o mês da locação: ");
                int ano = teclado.lerInt("Digite o ano da locação: ");

                return LocalDate.of(ano, mes, dia);
            } catch (DateTimeException excecao) {
                System.out.println("Data inválida. Por favor, digite novamente.");
            }
        }
    }

    private void encerrarLocacao() {
        List<Locacao> locacoesAtivas = obterLocacoesAtivas();

        if (locacoesAtivas.isEmpty()) {
            System.out.println("Não há locações ativas para encerrar.");
            return;
        }

        System.out.println("Locações Ativas:");
        listarLocacoes();

        int opcao = teclado.lerInt("Digite o ID da locação que deseja encerrar: ");
        if (opcao < 1 || opcao > locacoesAtivas.size()) {
            System.out.println("ID de locação inválido.");
            return;
        }

        Locacao locacaoSelecionada = locacoesAtivas.get(opcao - 1);
        LocalDate dataEntrega = informarDataEntrega();
        float kilometragemAtual = informarKilometragemAtual(locacaoSelecionada.getVeiculo().getKilometragem());

        double valorLocacao = calcularValorLocacao(locacaoSelecionada, dataEntrega, kilometragemAtual);
        locacaoSelecionada.setValor(valorLocacao);
        locacaoSelecionada.setDataEntrega(dataEntrega);
        locacaoSelecionada.setSituacao(SituacaoLocacao.ENCERRADA);
        locacaoSelecionada.getVeiculo().setKilometragem(kilometragemAtual);

        System.out.println("Locação encerrada com sucesso!");
        System.out.println("Valor da Locação: R$" + valorLocacao);
    }

    private List<Locacao> obterLocacoesAtivas() {
        List<Locacao> locacoes = tabelaLocacao.getLocacao();
        return locacoes.stream()
                .filter(locacao -> locacao.getSituacao() == SituacaoLocacao.ATIVA)
                .collect(Collectors.toList());
    }

    private LocalDate informarDataEntrega() {
        while (true) {
            try {
                int dia = teclado.lerInt("Digite o dia de entrega: ");
                int mes = teclado.lerInt("Digite o mês de entrega: ");
                int ano = teclado.lerInt("Digite o ano de entrega: ");

                return LocalDate.of(ano, mes, dia);
            } catch (DateTimeException excecao) {
                System.out.println("Data inválida. Por favor, digite novamente.");
            }
        }
    }

    private float informarKilometragemAtual(float kilometragemAnterior) {
        while (true) {
            float kilometragemAtual = teclado.lerfloat("Digite a kilometragem atual do veículo: ");
            if (kilometragemAtual < kilometragemAnterior) {
                System.out.println("Kilometragem inválida. Deve ser maior que a anterior (" + kilometragemAnterior + ").");
            } else {
                return kilometragemAtual;
            }
        }
    }

    private double calcularValorLocacao(Locacao locacao, LocalDate dataEntrega, float kilometragemAtual) {
        long diasLocados = ChronoUnit.DAYS.between(locacao.getDataLocacao(), dataEntrega);
        double valorDiaria = locacao.getVeiculo().getValorDiaria();
        double valorKmRodado = locacao.getVeiculo().getValorKmRodados() * (kilometragemAtual - locacao.getVeiculo().getKilometragem());

        return valorDiaria * diasLocados + valorKmRodado;
    }

    private void listarLocacoes() {
        List<Locacao> locacoes = tabelaLocacao.getLocacao();

        if (locacoes.isEmpty()) {
            System.out.println("Ainda não há locações cadastradas!");
        } else {
            System.out.println("Listagem de Locações:");
            System.out.println("ID | Veículo | Cliente | Data Locação | Data Entrega | Valor | Situação");
            System.out.println("-------------------------------------------------------------");

            for (Locacao locacao : locacoes) {
                if (locacao.getSituacao().equals(SituacaoLocacao.ATIVA)) {
                    System.out.println((locacoes.indexOf(locacao) + 1)
                            + " | "
                            + locacao.getVeiculo().getPlaca()
                            + " | "
                            + formatarCliente(locacao.getCliente())
                            + " | "
                            + locacao.getDataLocacao()
                            + " | "
                            + locacao.getDataEntrega()
                            + " | "
                            + "R$" + locacao.getValor()
                            + " | "
                            + locacao.getSituacao());
                }
            }
        }
    }

    private String formatarCliente(Cliente cliente) {
        if (cliente.getTipoPessoa() == TipoPessoa.PESSOA_FISICA) {
            return cliente.getTipoDocumento() + " " + cliente.getNumeroDocumento();
        } else {
            return "CNPJ " + cliente.getCnpj();
        }
    }
}


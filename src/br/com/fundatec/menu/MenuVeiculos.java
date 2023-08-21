package br.com.fundatec.locadoraveiculos.menu;

import br.com.fundatec.locadoraveiculos.bancodedados.TabelaVeiculos;
import br.com.fundatec.locadoraveiculos.modelo.Cliente;
import br.com.fundatec.locadoraveiculos.modelo.TipoVeiculo;
import br.com.fundatec.locadoraveiculos.modelo.Veiculo;
import br.com.fundatec.locadoraveiculos.util.Teclado;

import java.util.List;
import java.util.Scanner;

public class MenuVeiculos {
    private Teclado teclado;

    private TabelaVeiculos tabelaVeiculos;

    public MenuVeiculos(Teclado teclado) {
        this.teclado = teclado;
        this.tabelaVeiculos = TabelaVeiculos.obterTabela();
    }

    public void menuVeiculos() {
        int opcao;

        do {
            System.out.println(" Escolha uma das opções: \n  1 - Cadastrar veiculos \n  2 - Listar veiculos \n  0 - Voltar para o menu principal");
            opcao = teclado.lerInt("Qual a opção desejada ?");

            switch (opcao) {
                case 1:
                    System.out.println("Navegando para cadastrar veiculos...");
                    cadastrarVeiculos();
                    break;
                case 2:
                    System.out.println("Navegando para listar veiculos...");
                    listarVeiculos();
                    break;
                case 0:
                    System.out.println("Voltando ao menu principal...");
                    return;
                default:
                    System.out.println("Opção invalida!");
            }
        } while (true);
    }

    private void cadastrarVeiculos() {
        System.out.println("  Cadastrar Veiculo:  ");
        System.out.println();
        TipoVeiculo tipoVeiculo = teclado.lerTipoVeiculo("Informe o tipo de veiculo (Hatch, Sedan, SUV, Pickup): ");
        String marcaVeiculo = teclado.lerString("Digite a marca do veiculo: ");
        String modeloVeiculo = teclado.lerString("Digite o modelo do veiculo: ");
        String placaVeiculo = teclado.lerString("Digite a placa do veiculo: ");

        Double valorKmRodado = 0.0;
        double valorDiaria = 0.0;
        float kilometragem = 0.0f;

        switch (tipoVeiculo) {

            case HATCH:
                valorKmRodado = 0.50;
                valorDiaria = 35.0;
                kilometragem = 0;
                System.out.println("Preço Km Rodado: R$" + valorKmRodado);
                System.out.println("Valor da diaria: R$" + valorDiaria);
                break;
            case SEDAN:
                valorKmRodado = 0.75;
                valorDiaria = 45.0;
                kilometragem = 0;
                System.out.println("Preço Km Rodado: R$" + valorKmRodado);
                System.out.println("Valor da diaria: R$" + valorDiaria);
                break;
            case SUV:
                valorKmRodado = 1.10;
                valorDiaria = 52.0;
                kilometragem = 0;
                System.out.println("Preço Km Rodado: R$" + valorKmRodado);
                System.out.println("Valor da diaria: R$" + valorDiaria);
                break;
            case PICKUP:
                valorKmRodado = 1.25;
                valorDiaria = 61.75;
                kilometragem = 0;
                System.out.println("Preço Km Rodado: R$" + valorKmRodado);
                System.out.println("Valor da diaria: R$" + valorDiaria);
                break;
        }
        Veiculo veiculo = new Veiculo(placaVeiculo, marcaVeiculo, modeloVeiculo, tipoVeiculo, valorKmRodado, valorDiaria);

        tabelaVeiculos.adicionar(veiculo);
        System.out.println();
        System.out.println("  >>> Veiculo cadastrado com sucesso! <<<");
        System.out.println();
    }

    private void listarVeiculos() {

        List<Veiculo> listaVeiculos = tabelaVeiculos.getVeiculos();

        if (listaVeiculos.isEmpty()) {
            System.out.println("Ainda não ha veiculos cadastrados");
        } else {
            System.out.println(" PLACA | MODELO | TIPO | KM | VALOR KM RODADO | VALOR DIARIA |");
            for (Veiculo veiculo : listaVeiculos) {
                System.out.println((listaVeiculos.indexOf(veiculo) + 1)
                        + "   " + veiculo.getPlaca()
                        + "   " + veiculo.getModelo()
                        + "   " + veiculo.getTipoVeiculo()
                        + "   " + veiculo.getKilometragem()
                        + "   " + veiculo.getValorKmRodados()
                        + "   " + veiculo.getValorDiaria());
            }
        }
    }
}

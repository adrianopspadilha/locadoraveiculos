package br.com.fundatec.locadoraveiculos.util;

import br.com.fundatec.locadoraveiculos.modelo.SituacaoLocacao;
import br.com.fundatec.locadoraveiculos.modelo.TipoDocumento;
import br.com.fundatec.locadoraveiculos.modelo.TipoPessoa;
import br.com.fundatec.locadoraveiculos.modelo.TipoVeiculo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Teclado {

    private Scanner scanner;

    public Teclado() {
        scanner = new Scanner(System.in);
    }

    public int lerOpcao(String mensagem) {
        System.out.println(mensagem);
        int inteiro;
        try {
            inteiro = scanner.nextInt();
        } catch (InputMismatchException excecao) {
            inteiro = -1;
        }
        scanner.nextLine();
        return inteiro;
    }

    public TipoPessoa lerTipoPessoa(String mensagem) {
        while (true) {
            System.out.println(mensagem);
            try {
                String tipoPessoa = scanner.nextLine();
                return TipoPessoa.valueOf(tipoPessoa.toUpperCase());
            } catch (IllegalArgumentException excecao) {
                System.out.println("Tipo de Pessoa invalido!");
            }
        }
    }

    public String lerString(String mensagem) {
        System.out.println(mensagem);
        return scanner.nextLine();
    }

    public TipoDocumento lerTipoDocumento(String mensagem) {
        while (true) {
            System.out.println(mensagem);
            try {
                String tipoDocumento = scanner.nextLine();
                return TipoDocumento.valueOf(tipoDocumento.toUpperCase());
            } catch (IllegalArgumentException excecao) {
                System.out.println("Tipo de Pessoa invalido!");
            }
        }
    }

    public Long lerLong(String mensagem) {
        while (true) {
            System.out.println(mensagem);
            long numero;
            try {
                numero = scanner.nextLong();
                scanner.nextLine();
                return numero;
            } catch (InputMismatchException excecao) {
                System.out.println(" >>> Digite apenas numeros! <<< ");
            }
        }
    }

    public Integer lerInt(String mensagem) {
        while (true) {
            System.out.println(mensagem);
            int numero;
            try {
                numero = scanner.nextInt();
                scanner.nextLine();
                return numero;
            } catch (InputMismatchException excecao) {
                System.out.println(" >>> Digite apenas numeros! <<< ");
            }
        }
    }

    public TipoVeiculo lerTipoVeiculo(String mensagem) {
        while (true) {
            System.out.println(mensagem);
            try {
                String tipoVeiculo = scanner.nextLine();
                return TipoVeiculo.valueOf(tipoVeiculo.toUpperCase());
            } catch (IllegalArgumentException excecao) {
                System.out.println("Tipo de veiculo invalido!");
            }
        }
    }

    public SituacaoLocacao lerTipoLocacao(String mensagem) {
        while (true) {
            System.out.println(mensagem);
            try {
                String situacaoLocacao = scanner.nextLine();
                return SituacaoLocacao.valueOf(situacaoLocacao.toUpperCase());
            } catch (IllegalArgumentException excecao) {
                System.out.println("Tipo de veiculo invalido!");
            }
        }
    }

    public float lerfloat(String mensagem) {
        while (true) {
            System.out.println(mensagem);
            int numero;
            try {
                numero = scanner.nextInt();
                scanner.nextLine();
                return numero;
            } catch (InputMismatchException excecao) {
                System.out.println(" >>> Digite apenas numeros! <<< ");
            }
        }
    }
}

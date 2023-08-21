package br.com.fundatec.locadoraveiculos.modelo;

import java.time.LocalDate;

public class Locacao {

    private Cliente cliente;

    private Veiculo veiculo;

    private LocalDate dataLocacao;

    private LocalDate dataEntrega;

    private double valor;

    private SituacaoLocacao situacao;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public LocalDate getDataLocacao() {
        return dataLocacao;
    }

    public void setDataLocacao(LocalDate dataLocacao) {
        this.dataLocacao = dataLocacao;
    }

    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(LocalDate dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public SituacaoLocacao getSituacao() {
        return situacao;
    }

    public void setSituacao(SituacaoLocacao situacao) {
        this.situacao = situacao;
    }

    public Locacao(Cliente cliente, Veiculo veiculo, LocalDate dataLocacao, LocalDate dataEntrega, Double valor, SituacaoLocacao situacao) {
        this.cliente = cliente;
        this.veiculo = veiculo;
        this.dataLocacao = dataLocacao;
        this.dataEntrega = dataEntrega;
        this.valor = valor;
        this.situacao = situacao;
    }
}

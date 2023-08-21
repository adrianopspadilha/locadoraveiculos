package br.com.fundatec.locadoraveiculos.modelo;

public class Veiculo {

    private String placa;

    private String marca;

    private String modelo;

    private TipoVeiculo tipoVeiculo;

    private float kilometragem;

    private double valorKmRodados;

    private double valorDiaria;

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public TipoVeiculo getTipoVeiculo() {
        return tipoVeiculo;
    }

    public void setTipoVeiculo(TipoVeiculo tipoVeiculo) {
        this.tipoVeiculo = tipoVeiculo;
    }

    public float getKilometragem() {
        return kilometragem;
    }

    public void setKilometragem(float kilometragem) {
        this.kilometragem = kilometragem;
    }

    public double getValorKmRodados() {
        return valorKmRodados;
    }

    public void setValorKmRodados(double valorKmRodados) {
        this.valorKmRodados = valorKmRodados;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }

    public void setValorDiaria(double valorDiaria) {
        this.valorDiaria = valorDiaria;
    }

    public Veiculo(String placa, String marca, String modelo, TipoVeiculo tipoVeiculo, Double valorKmRodado, Double valorDiaria) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.tipoVeiculo = tipoVeiculo;
        this.kilometragem = 0;
        this.valorKmRodados = valorKmRodado;
        this.valorDiaria = valorDiaria;
    }
}

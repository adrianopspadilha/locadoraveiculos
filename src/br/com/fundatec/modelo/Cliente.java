package br.com.fundatec.locadoraveiculos.modelo;

public class Cliente {

    private TipoPessoa tipoPessoa;

    private String nome;

    private long numeroDocumento;

    private TipoDocumento tipoDocumento;

    private String razaoSocial;

    private long cnpj;

    private Endereco endereco;

    public TipoPessoa getTipoPessoa() {
        return tipoPessoa;
    }

    public String getNome() {
        return nome;
    }

    public long getNumeroDocumento() {
        return numeroDocumento;
    }

    public TipoDocumento getTipoDocumento() {
        return tipoDocumento;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public long getCnpj() {
        return cnpj;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public Cliente(String nome, Long numeroDocumento, TipoDocumento tipoDocumento, Endereco endereco) {
        this.tipoPessoa = TipoPessoa.PESSOA_FISICA;
        this.nome = nome;
        this.numeroDocumento = numeroDocumento;
        this.tipoDocumento = tipoDocumento;
        this.endereco = endereco;
    }

    public Cliente(String razaoSocial, Long cnpj, Endereco endereco) {
        this.tipoPessoa = TipoPessoa.PESSOA_JURIDICA;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.endereco = endereco;
    }


}

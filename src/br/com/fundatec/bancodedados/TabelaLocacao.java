package br.com.fundatec.locadoraveiculos.bancodedados;

import br.com.fundatec.locadoraveiculos.modelo.Locacao;
import br.com.fundatec.locadoraveiculos.modelo.Veiculo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TabelaLocacao {
    private static TabelaLocacao instancia;
    private List<Locacao> locacao;

    private TabelaLocacao() {
        this.locacao = new ArrayList<>();
    }

    public void adicionar(Locacao locacao) {
        this.locacao.add(locacao);
    }

    public static TabelaLocacao obterTabela() {
        if (instancia == null) {
            instancia = new TabelaLocacao();
        }
        return instancia;
    }

    public List<Locacao> getLocacao() {
        return Collections.unmodifiableList(locacao);
    }
}

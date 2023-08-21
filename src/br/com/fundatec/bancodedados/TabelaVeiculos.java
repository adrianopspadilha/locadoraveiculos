package br.com.fundatec.locadoraveiculos.bancodedados;

import br.com.fundatec.locadoraveiculos.modelo.Cliente;
import br.com.fundatec.locadoraveiculos.modelo.TipoVeiculo;
import br.com.fundatec.locadoraveiculos.modelo.Veiculo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TabelaVeiculos {

    private static TabelaVeiculos instancia;
    private List<Veiculo> veiculos;

    private TabelaVeiculos() {
        this.veiculos = new ArrayList<>();
    }

    public void adicionar(Veiculo veiculo) {
        this.veiculos.add(veiculo);
    }

    public static TabelaVeiculos obterTabela() {
        if (instancia == null) {
            instancia = new TabelaVeiculos();
        }
        return instancia;
    }

    public List<Veiculo> getVeiculos() {
        return Collections.unmodifiableList(veiculos);
    }

    public void inicializar(){
        this.adicionar(new Veiculo("ABC123", "Gurgel","XEF",TipoVeiculo.HATCH,0.5,35.0));
        this.adicionar(new Veiculo("DEF456", "Ford","Kaa",TipoVeiculo.SEDAN,0.75,45.0));
        this.adicionar(new Veiculo("GHI789", "Hyundai","Tucson",TipoVeiculo.SUV,1.1,52.0));
        this.adicionar(new Veiculo("JKL101", "Volkswagen","Amarok",TipoVeiculo.PICKUP,1.25,61.75));

    }
}

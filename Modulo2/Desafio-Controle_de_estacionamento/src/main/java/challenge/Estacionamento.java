package challenge;

import java.util.ArrayList;
import java.util.List;

public class Estacionamento {
    int limiteVagas = 10;
    int maximoPontosHabilitacao = 20;
    List<Carro> carrosEstacionados = new ArrayList<>();

    public boolean todosOsMotoristasComMaisDe55Anos(Carro carro) {
        for (Carro veiculos : carrosEstacionados) {
            if (veiculos.getMotorista().getIdade() < 55) {
                return false;
            }
        }
        return true;
    }

    public void estacionar(Carro carro) {
        if (carro.getMotorista() == null) {
            throw new EstacionamentoException("É necessário que exista um motorista");
        }

        if (carro.getMotorista().getIdade() < 18) {
            throw new EstacionamentoException("Idade insuficiente para dirigir");
        }

        if (carro.getMotorista().getPontos() >= maximoPontosHabilitacao) {
            throw new EstacionamentoException("A pontuação da carteira não deve ser superior a vinte pontos");
        }

        if (carrosEstacionados.size() < limiteVagas) {
            carrosEstacionados.add(carro);
        }

        if (todosOsMotoristasComMaisDe55Anos(carro)) {
            throw new EstacionamentoException("Estacionamento Lotado");
        }
    }

    public int carrosEstacionados() {
        return carrosEstacionados.size();
    }

    public boolean carroEstacionado(Carro carro) {
        return true;
    }
}

package br.com.procode.api.service;

import br.com.procode.api.entity.Veiculos;
import br.com.procode.api.repository.VeiculosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculosService {

    @Autowired
    private VeiculosRepository veiculosRepository;

    public List<Veiculos> listarTodosVeiculos() {
        return veiculosRepository.findAll();
    }

    public Veiculos buscarVeiculoPorId(Long id) {
        return veiculosRepository.findById(id).orElse(null);
    }

    public Veiculos inserirVeiculo(Veiculos veiculo) {
        if (veiculosRepository.findByPlaca(veiculo.getPlaca()) != null) {
            throw new IllegalArgumentException("Já existe um veículo com a mesma placa.");
        }
        return veiculosRepository.save(veiculo);
    }

    public Veiculos atualizarVeiculo(Veiculos veiculo) {
        return veiculosRepository.save(veiculo);
    }

    public void deletarVeiculo(Long id) {
        veiculosRepository.deleteById(id);
    }
}

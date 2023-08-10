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

    public List<Veiculos> listarTodos() {
        return veiculosRepository.findAll();
    }

    public Veiculos buscarPorId(Long id) {
        return veiculosRepository.findById(id).orElse(null);
    }

    public Veiculos inserir(Veiculos veiculo) {
        if (veiculosRepository.findByPlaca(veiculo.getPlaca()) != null) {
            throw new IllegalArgumentException("Já existe um veículo com a mesma placa.");
        }
        return veiculosRepository.save(veiculo);
    }

    public Veiculos atualizar(Veiculos veiculo) {
        return veiculosRepository.save(veiculo);
    }

    public void deletar(Long id) {
        veiculosRepository.deleteById(id);
    }
}

package br.com.procode.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.procode.api.entity.Cliente;
import br.com.procode.api.repository.ClienteRepository;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Cliente inserir(Cliente cliente) {
        if (isIdadePermitida(cliente.getDataNascimento())) {
            return clienteRepository.save(cliente);
        }
        // Você pode lançar uma exceção ou retornar um valor indicando que a idade não é permitida
        throw new IllegalArgumentException("A idade do cliente não está dentro do intervalo permitido.");
    }

    private boolean isIdadePermitida(LocalDate dataNascimento) {
        LocalDate dataAtual = LocalDate.now();
        Period idade = Period.between(dataNascimento, dataAtual);
        return idade.getYears() >= 18 && idade.getYears() <= 65;
    }
    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> buscar(Long id) {
        return clienteRepository.findById(id);
    }

    public Cliente atualizar(Long id, Cliente clienteAtualizado) {
        if (clienteRepository.existsById(id)) {
            clienteAtualizado.setId(id);
            return clienteRepository.save(clienteAtualizado);
        }
        return null; // Ou lance uma exceção informando que o cliente não foi encontrado
    }

    public boolean deletar(Long id) {
        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
            return true;
        }
        return false; // Ou lance uma exceção informando que o cliente não foi encontrado
    }
}


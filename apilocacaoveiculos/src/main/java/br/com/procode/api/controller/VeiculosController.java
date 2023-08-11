package br.com.procode.api.controller;

import br.com.procode.api.entity.Veiculos;
import br.com.procode.api.service.VeiculosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veiculos")
public class VeiculosController {

    @Autowired
    private VeiculosService veiculosService;

    @GetMapping
    public List<Veiculos> listarTodos() {
        return veiculosService.listarTodos();
    }

    @GetMapping("/{id}")
    public Veiculos buscarPorId(@PathVariable Long id) {
        return veiculosService.buscarPorId(id);
    }

    @PostMapping
    public Veiculos inserir(@RequestBody Veiculos veiculo) {
        return veiculosService.inserir(veiculo);
    }

    @PutMapping("/{id}")
    public Veiculos atualizar(@PathVariable Long id, @RequestBody Veiculos veiculo) {
        veiculo.setId(id);
        return veiculosService.atualizar(veiculo);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        veiculosService.deletar(id);
    }
}

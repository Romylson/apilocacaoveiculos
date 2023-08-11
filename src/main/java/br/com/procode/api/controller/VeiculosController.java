package br.com.procode.api.controller;
import br.com.procode.api.entity.Veiculos;
import br.com.procode.api.service.VeiculosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/veiculos")
public class VeiculosController {

    @Autowired
    private VeiculosService veiculosService;
    @PostMapping
    public void inserirVeiculo(@RequestBody Veiculos veiculo) {
        veiculosService.inserirVeiculo(veiculo);
    }
    @GetMapping
    public List<Veiculos> listarTodosVeiculos() {
        return veiculosService.listarTodosVeiculos();
    }

    @GetMapping("/{veiculoId}")
    public Veiculos buscarVeiculoPorId(@PathVariable Long veiculoId) {
        return veiculosService.buscarVeiculoPorId(veiculoId);
    }
    @PutMapping("/{veiculoId}")
    public void atualizarVeiculo(@PathVariable Long veiculoId, @RequestBody Veiculos veiculoAtualizado) {
        veiculosService.atualizarVeiculo(veiculoAtualizado);
    }

    @DeleteMapping("/{veiculoId}")
    public void deletarVeiculo(@PathVariable Long veiculoId) {
        veiculosService.deletarVeiculo(veiculoId);
    }
 }


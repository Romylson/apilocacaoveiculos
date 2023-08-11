package br.com.procode.api.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import br.com.procode.api.entity.Cliente;
import br.com.procode.api.service.ClienteService;

import java.util.List;
import java.util.Optional;

	@RestController
	@RequestMapping("/api/v1/clientes")
	public class ClienteController {

	    private final ClienteService clienteService;

	    @Autowired
	    public ClienteController(ClienteService clienteService) {
	        this.clienteService = clienteService;
	    }

	    @PostMapping(value="/inserir")
	    public Cliente inserir(@RequestBody Cliente cliente) {
	        Cliente novoCliente = clienteService.inserir(cliente);
	        return novoCliente;
	    }

	    @GetMapping(value="/listar")
	    public List<Cliente> listar() {
	        List<Cliente> clientes = clienteService.listar();
	        return clientes;
	    }

	    @GetMapping(value="/buscar/{id}")
	    public Optional<Cliente> buscar(@PathVariable Long id) {
	        Optional<Cliente> cliente = clienteService.buscar(id);
	        if(cliente!=null) {
	        return cliente;
	        }
	        return null;
	    }

	    @PutMapping(value="/atualizar/{id}")
	    public Cliente atualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
	    	   cliente.setId(id);
	           return clienteService.atualizar(id,cliente);
	    }

	    @DeleteMapping(value="/deletar/{id}")
	    public void deletar(@PathVariable Long id) {
	        clienteService.deletar(id);
	    }
	}


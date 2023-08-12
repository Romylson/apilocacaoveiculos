package br.com.procode.api.controller;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.procode.api.entity.Locacao;
import br.com.procode.api.exception.LocacaoAlreadyReturnedException;
import br.com.procode.api.exception.LocacaoNotFoundException;
import br.com.procode.api.request.DevolucaoRequest;
import br.com.procode.api.service.LocacaoService;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/v1/locacoes")
public class LocacaoController {

    @Autowired
    private LocacaoService locacaoService;

    @PostMapping(value="/inserir")
    public void inserirLocacao(@RequestBody Locacao locacao) {
        locacaoService.inserirLocacao(locacao);
    }

    @GetMapping(value="/listar")
    public List<Locacao> listarLocacoes() {
        return locacaoService.listarTodasLocacoes();
    }

    @GetMapping(value="/cliente/{clienteId}")
    public List<Locacao> listarLocacoesPorCliente(@PathVariable Long clienteId) {
        return locacaoService.listarLocacoesPorCliente(clienteId);
    }

    @DeleteMapping(value="/deletar/{locacaoId}")
    public void cancelarLocacao(@PathVariable Long locacaoId) {
        locacaoService.cancelarLocacao(locacaoId);
    }
    @PutMapping("/devolucao/{idLocacao}")
    @ResponseStatus(HttpStatus.OK)
    public Locacao realizarDevolucao(@PathVariable Long idLocacao, @RequestBody DevolucaoRequest request) throws LocacaoNotFoundException, LocacaoAlreadyReturnedException {
        return locacaoService.realizarDevolucao(idLocacao, request.getDataDevolucaoReal());
    }
    //@PostMapping("/devolucao/{idLocacao]")
    //public void realizarDevolucao(@RequestParam Long idLocacao,@RequestParam LocalDate dataDevolucaoReal) {
    //    locacaoService.realizarDevolucao(idLocacao, dataDevolucaoReal);
    //}
}

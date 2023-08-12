package br.com.procode.api.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.procode.api.entity.Cliente;
import br.com.procode.api.entity.Locacao;
import br.com.procode.api.entity.Veiculo;
import br.com.procode.api.repository.ClienteRepository;
import br.com.procode.api.repository.LocacaoRepository;
import br.com.procode.api.repository.VeiculoRepository;

@Service
public class LocacaoService {

    @Autowired
    private LocacaoRepository locacaoRepository;

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private ClienteRepository clienteRepository;
        // Calcula valor da locação e demais valores
        public void inserirLocacao(Locacao locacao) {
        	Veiculo veiculo = veiculoRepository.findById(locacao.getVeiculo().getId())
        			.orElseThrow(() -> new IllegalArgumentException("Veículo não encontrado"));
            
            if (!veiculo.isDisponivel()) {
                throw new IllegalArgumentException("O veículo não está disponível para locação");
            }
            // Verificar se o cliente possui locação em aberto
            Cliente cliente = clienteRepository.findById(locacao.getCliente().getId())
            		.orElseThrow(()-> new IllegalArgumentException("Cliente não encontrado"));
            
            List<Locacao> locacoesEmAberto = locacaoRepository.findByClienteAndDataPrevistaDevolucaoIsNull(cliente);
            if (!locacoesEmAberto.isEmpty()) {
                throw new IllegalArgumentException("O cliente possui locação em aberto");
            }
            
            // Calcular valor da locação
            long diasLocacao = ChronoUnit.DAYS.between(locacao.getDataLocacao(), locacao.getDataPrevistaDevolucao());
            BigDecimal valorDiaria = veiculo.getValorDiariaPorTipo();//getValorDiariaPorTipo();
            BigDecimal valorLocacao = valorDiaria.multiply(BigDecimal.valueOf(diasLocacao));
            locacao.setValorLocacao(valorLocacao);
            
            // Atualizar disponibilidade do veículo
            veiculo.setDisponivel(false);
            veiculoRepository.save(veiculo);
            
            // Inserir a locação no banco de dados
            locacaoRepository.save(locacao);
        }
        

    public List<Locacao> listarTodasLocacoes() {
        return locacaoRepository.findAll();
    }

    public List<Locacao> listarLocacoesPorCliente(Long clienteId) {
        Cliente cliente = clienteRepository.findById(clienteId).orElseThrow(() -> new IllegalArgumentException("Cliente não encontrado"));
        return locacaoRepository.findByCliente(cliente);
    }

    public void cancelarLocacao(Long locacaoId) {
        Locacao locacao = locacaoRepository.findById(locacaoId).orElseThrow(() -> new IllegalArgumentException("Locação não encontrada"));

        // Realizar operações para cancelar a locação

        locacaoRepository.delete(locacao);
    }

    @SuppressWarnings("unused")
	private boolean clientePossuiLocacaoEmAberto(Cliente cliente) {
        List<Locacao> locacoesEmAberto = locacaoRepository.findByClienteAndDataPrevistaDevolucaoIsNull(cliente);
        return !locacoesEmAberto.isEmpty();
    }

    public Locacao realizarDevolucao(Long idLocacao, LocalDate dataDevolucaoReal) {
        // Buscar a locação pelo ID
        Locacao locacao = locacaoRepository.findById(idLocacao)
                .orElseThrow(() -> new  IllegalArgumentException("Locação não encontrada"));

        // Verificar se a locação já foi devolvida
        if (locacao.getDataPrevistaDevolucao() != null) {
            throw new  IllegalArgumentException("Locação já foi devolvida");
        }

        // Calcular atraso e multa se houver
        long diasAtraso = ChronoUnit.DAYS.between(locacao.getDataPrevistaDevolucao(), dataDevolucaoReal);
        BigDecimal multa = BigDecimal.ZERO;

        if (diasAtraso > 0) {
            BigDecimal valorDiaria = locacao.getVeiculo().getValorDiariaPorTipo();
            multa = valorDiaria.multiply(BigDecimal.valueOf(diasAtraso)).multiply(new BigDecimal("0.10"));
        }

        // Calcular valor total da locação
        BigDecimal valorTotalLocacao = locacao.getValorLocacao().add(multa);

        // Atualizar informações da locação
        locacao.setDataPrevistaDevolucao(dataDevolucaoReal);
        locacao.setValorMulta(multa);
        locacao.setValorTotal(valorTotalLocacao);

        // Atualizar disponibilidade do veículo
        Veiculo veiculo = locacao.getVeiculo();
        veiculo.setDisponivel(true);

        // Salvar as alterações
        locacaoRepository.save(locacao);
        veiculoRepository.save(veiculo);

        return locacao;
    }
}



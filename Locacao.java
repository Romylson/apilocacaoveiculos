package br.com.procode.api.entity;
import java.math.BigDecimal;
import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import jakarta.persistence.Table;
	@Entity
    @Data
    @Table(name="TB_LOCACAO")
    public class Locacao {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        @JoinColumn(name = "veiculo_id")
        private Veiculo veiculo;

        @ManyToOne
        @JoinColumn(name = "cliente_id")
        private Cliente cliente;
        private BigDecimal valorLocacao;
        private BigDecimal valorMulta;
        private BigDecimal valorTotal;
        private LocalDate dataLocacao;
        private LocalDate dataPrevistaDevolucao;
    

    // Construtores, getters e setters...
    public Veiculo getVeiculo() {
		return veiculo;
	}

	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
    public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public LocalDate getDataLocacao() {
		return dataLocacao;
	}

	public void setDataLocacao(LocalDate dataLocacao) {
		this.dataLocacao = dataLocacao;
	}

	public BigDecimal getValorLocacao() {
		return valorLocacao;
	}

	public void setValorLocacao(BigDecimal valorLocacao) {
		this.valorLocacao = valorLocacao;
	}

	public BigDecimal getValorMulta() {
		return valorMulta;
	}

	public void setValorMulta(BigDecimal valorMulta) {
		this.valorMulta = valorMulta;
	}

	/**
	 * @return the dataPrevistaDevolucao
	 */
	public LocalDate getDataPrevistaDevolucao() {
		return dataPrevistaDevolucao;
	}

	/**
	 * @param dataPrevistaDevolucao the dataPrevistaDevolucao to set
	 */
	public void setDataPrevistaDevolucao(LocalDate dataPrevistaDevolucao) {
		this.dataPrevistaDevolucao = dataPrevistaDevolucao;
	}
}

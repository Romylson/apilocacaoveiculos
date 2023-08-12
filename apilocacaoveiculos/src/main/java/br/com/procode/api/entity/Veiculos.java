package br.com.procode.api.entity;

import lombok.Data;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Data
@Table(name="TB_VEICULOS")
public class Veiculos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String marca;
    private String modelo;
    private int ano;
    private TipoVeiculo tipo;
    private String placa;
    private boolean disponivel = true;

    public TipoVeiculo getTipo() {
		return tipo;
	}

	public void setTipo(TipoVeiculo tipo) {
		this.tipo = tipo;
	}

	public BigDecimal getValorDiariaPorTipo() {
        switch (tipo) {
            case PASSEIO:
                return new BigDecimal("70.00");
            case SUV:
                return new BigDecimal("120.00");
            case PICAPE:
                return new BigDecimal("150.00");
            case VAN:
                return new BigDecimal("180.00");
            case CAMINHAO:
                return new BigDecimal("300.00");
            default:
                throw new IllegalArgumentException("Tipo de veículo inválido");
        }
    }

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public boolean isDisponivel() {
		return disponivel;
	}

	public void setDisponivel(boolean disponivel) {
		this.disponivel = disponivel;
	}

	public Long getId() {
		return id;                                                                                
	}

	public void setId(Long id) {
		this.id = id;
	}
}


package br.com.procode.api.entity;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

	@Entity
	@Data
	@Table(name="TB_CLIENTE")
	public class Cliente {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    @Column(nullable=false,length=255)
	    private String nome;
	    @Column(nullable=false,length=11)
	    private String cpf;
	    @Column(nullable=false,length=50)
	    private String rg;
	    @Column(nullable=false,length=15)
	    private String telefone;
	    @Column(nullable=false,length=255)
	    private String endereco;
	    @Column(nullable=false)
	    private boolean ativo;
	    private LocalDate dataNascimento;
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public LocalDate getDataNascimento() {
			return dataNascimento;
		}
		public void setDataNascimento(LocalDate dataNascimento) {
			this.dataNascimento = dataNascimento;
		}
		public String getNome() {
			return nome;
		}
		public void setNome(String nome) {
			this.nome = nome;
		}
		public String getCpf() {
			return cpf;
		}
		public void setCpf(String cpf) {
			this.cpf = cpf;
		}
		public String getRg() {
			return rg;
		}
		public void setRg(String rg) {
			this.rg = rg;
		}
		public String getTelefone() {
			return telefone;
		}
		public void setTelefone(String telefone) {
			this.telefone = telefone;
		}
		public String getEndereco() {
			return endereco;
		}
		public void setEndereco(String endereco) {
			this.endereco = endereco;
		}
		public boolean isAtivo() {
			return ativo;
		}
		public void setAtivo(boolean ativo) {
			this.ativo = ativo;
		}

	}




package br.com.serratec.psychedelicus.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "produto")
public class Produto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "prod_cd_id")
	private Long id;
	
	//@NotBlank(message = "Não é permitido espaços nulos ou vazios.")
	@Column(name = "prod_tx_nome")
	private String nome;
	
	//@NotBlank(message = "Não é permitido espaços nulos ou vazios.")
	@Column(name = "prod_tx_descricao")
	private String descricao;
	
	//@NotBlank(message = "Não é permitido espaços nulos ou vazios.")
	@Column(name = "prod_nm_preco")
	private Double preco;
	
	@Column(name = "prod_dt_vencimento")
	//@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate vencimento;
	
	//@NotBlank(message = "Não é permitido espaços nulos ou vazios.")
	@Column(name = "prod_tx_categoria")
	private String categoria;
	
	@Column(name = "prod_int_quantidade")
	private Integer quantidade;
	
	@ManyToMany(mappedBy = "produtos")
	private List<Pedido> pedidos;
	
	public Produto() {

	}

	public Produto(Long id, String nome, String descricao, Double preco, LocalDate vencimento, String categoria,
			Integer quantidade) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.vencimento = vencimento;
		this.categoria = categoria;
		this.quantidade = quantidade;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public LocalDate getVencimento() {
		return vencimento;
	}

	public void setVencimento(LocalDate vencimento) {
		this.vencimento = vencimento;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
}

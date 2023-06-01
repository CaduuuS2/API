package br.com.serratec.psychedelicus.domain;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "usu_cd_usuarioId")
	private Long clienteId;

	// @NotBlank(message = "Não é permitido espaços nulos ou vazios.")
	@Column(name = "usu_tx_nome")
	private String nome;

	// @NotBlank(message = "Não é permitido espaços nulos ou vazios.")
	// @Size(min = 11, max = 11, message = "O número de telefone deve conter 11
	// dígitos!")
	@Column(name = "usu_tx_telefone")
	private String telefone;

	// @NotBlank(message = "Não é permitido espaços nulos ou vazios.")
	// @Email(message = "O campo 'email' deve ser um endereço de e-mail válido!")
	@Column(name = "usu_tx_email")
	private String email;

	// @NotBlank(message = "Não é permitido espaços nulos ou vazios.")
	// @CPF(message = "O campo 'cpf' deve ser um número de CPF válido!")
	@Column(name = "usu_tx_cpf")
	private String cpf;

	@Column(name = "usu_dt_dataNascimento")
	// @JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataNascimento;

	@OneToMany(mappedBy = "clienteRelacionamento")
	private List<Pedido> pedidos;

	public Cliente() {

	}

	public Cliente(Long clienteId, String nome, String telefone, String email, String cpf, LocalDate dataNascimento) {
		this.clienteId = clienteId;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
	}

	public Long getClienteId() {
		return clienteId;
	}

	public void setClienteId(Long clienteId) {
		this.clienteId = clienteId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
}

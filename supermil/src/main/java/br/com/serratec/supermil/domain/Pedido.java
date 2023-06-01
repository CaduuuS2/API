package br.com.serratec.supermil.domain;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "pedido")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ped_cd_pedidoId")
	private Long pedidoId;

	@Column(name = "ped_dt_HrPedido")
	//@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime dtHrPedido;

	@ManyToOne
	@JoinColumn(name = "fk_usu_cd_usuarioId")
	private Usuario usuarioRelacionamento;

	@ManyToMany
	@JoinTable(name = "item_pedido",
	joinColumns = @JoinColumn(name = "fk_ped_cd_pedidoId"),
	inverseJoinColumns = @JoinColumn(name = "fk_prod_cd_produtoId"))
	private List<Produto> produtos;

	public Pedido() {

	}

	public Pedido(Long pedidoId, LocalDateTime dtHrPedido) {
		this.pedidoId = pedidoId;
		this.dtHrPedido = dtHrPedido;
	}

	public Long getPedidoId() {
		return pedidoId;
	}

	public void setPedidoId(Long pedidoId) {
		this.pedidoId = pedidoId;
	}

	public LocalDateTime getDtHrPedido() {
		return dtHrPedido;
	}

	public void setDtHrPedido(LocalDateTime dtHrPedido) {
		this.dtHrPedido = dtHrPedido;
	}
}

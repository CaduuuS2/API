package br.com.serratec.supermil.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.supermil.domain.Pedido;
import br.com.serratec.supermil.services.EmailService;
import br.com.serratec.supermil.services.PedidoService;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {

	@Autowired
	private PedidoService pedidoService;

	@Autowired
	EmailService emailService;

	// Buscar todos os pedido do banco de dados
	@GetMapping("/listarPedidos")
	public ResponseEntity<List<Pedido>> listarPedidos() {
		return ResponseEntity.ok(pedidoService.ListarPedidos());
	}

	// Buscar pedido no banco de dados utilizando o id para referenciar
	@GetMapping("/{pedidoId}/buscarPedido")
	public ResponseEntity<Pedido> buscarPedidoPorId(@PathVariable Long pedidoId) {
		return ResponseEntity.ok(pedidoService.buscarPedidoPorId(pedidoId));
	}

	// Adicionar um pedido ao banco de dados
	@PostMapping("/salvarPedido")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Pedido> salvarPedido(@Valid @RequestParam String email, @RequestBody Pedido pedido)
			throws MessagingException {
		emailService.confirmacaoCadastroPedido(email, pedido);
		return ResponseEntity.status(HttpStatus.CREATED).body(pedidoService.salvarPedido(pedido));
	}

	// Excluir um pedido do banco de dados utilizando o id para referenciar
	@DeleteMapping("/{pedidoId}/excluirPedido")
	public ResponseEntity<Void> excluirPedido(@Valid @PathVariable Long pedidoId) {
		pedidoService.excluirPedido(pedidoId);
		return ResponseEntity.noContent().build();
	}

	// Atualizar um pedido do banco de dados utilizando o id para referenciar
	@PutMapping("/{pedidoId}/atualizarPedido")
	public ResponseEntity<Pedido> atualizarPedido(@Valid @PathVariable Long pedidoId, Pedido pedidoAtualizado) {
		return ResponseEntity.ok(pedidoService.atualizarPedido(pedidoId, pedidoAtualizado));
	}
}

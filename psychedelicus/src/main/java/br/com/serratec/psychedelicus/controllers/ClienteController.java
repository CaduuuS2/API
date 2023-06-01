package br.com.serratec.psychedelicus.controllers;

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

import br.com.serratec.psychedelicus.domain.Cliente;
import br.com.serratec.psychedelicus.services.ClienteService;
import br.com.serratec.psychedelicus.services.EmailService;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	ClienteService clienteService;

	@Autowired
	EmailService emailService;

	// Buscar todos os clientes do banco de dados
	@GetMapping("/listarClientes")
	public ResponseEntity<List<Cliente>> listarClientes() {
		return ResponseEntity.ok(clienteService.listarCliente());
	}

	// Buscar cliente no banco de dados utilizando o id para referenciar
	@GetMapping("/{clienteId}/buscarCliente")
	public ResponseEntity<Cliente> buscarClientePorId(@PathVariable Long clienteId) {
		return ResponseEntity.ok(clienteService.buscarClientePorId(clienteId));
	}

	// Adicionar um cliente ao banco de dados
	@PostMapping("/salvarCliente")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Cliente> salvarCliente(@Valid @RequestParam String email, @RequestBody Cliente cliente)
			throws MessagingException {
		emailService.confirmacaoCadastroCliente(email, cliente);
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.salvarCliente(cliente));
	}

	// Excluir um cliente do banco de dados utilizando o id para referenciar
	@DeleteMapping("/{clienteId}/excluirCliente")
	public ResponseEntity<Void> excluirCliente(@Valid @PathVariable Long clienteId) {
		clienteService.excluirCliente(clienteId);
		return ResponseEntity.noContent().build();
	}

	// Atualizar um cliente do banco de dados utilizando o id para referenciar
	@PutMapping("/{clienteId}/atualizarCliente")
	public ResponseEntity<Cliente> atualizarCliente(@Valid @PathVariable Long clienteId, Cliente clienteAtualizado) {
		return ResponseEntity.ok(clienteService.atualizarCliente(clienteId, clienteAtualizado));
	}
}

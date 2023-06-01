package br.com.serratec.scarletRoses.controllers;

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

import br.com.serratec.scarletRoses.domain.Usuario;
import br.com.serratec.scarletRoses.services.EmailService;
import br.com.serratec.scarletRoses.services.UsuarioService;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;

	@Autowired
	EmailService emailService;

	// Buscar todos os usuarios do banco de dados
	@GetMapping("/listarUsuarios")
	public ResponseEntity<List<Usuario>> listarUsuarios() {
		return ResponseEntity.ok(usuarioService.listarUsuario());
	}

	// Buscar usuario no banco de dados utilizando o id para referenciar
	@GetMapping("/{usuarioId}/buscarUsuario")
	public ResponseEntity<Usuario> buscarUsuarioPorId(@PathVariable Long usuarioId) {
		return ResponseEntity.ok(usuarioService.buscarUsuarioPorId(usuarioId));
	}

	// Adicionar um usuario ao banco de dados
	@PostMapping("/salvarUsuario")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Usuario> salvarUsuario(@Valid @RequestParam String email, @RequestBody Usuario usuario)
			throws MessagingException {
		emailService.confirmacaoCadastroUsuario(email, usuario);
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.salvarUsuario(usuario));
	}

	// Excluir um usuario do banco de dados utilizando o id para referenciar
	@DeleteMapping("/{usuarioId}/excluirUsuario")
	public ResponseEntity<Void> excluirUsuario(@Valid @PathVariable Long usuarioId) {
		usuarioService.excluirUsuario(usuarioId);
		return ResponseEntity.noContent().build();
	}

	// Atualizar um usuario do banco de dados utilizando o id para referenciar
	@PutMapping("/{usuarioId}/atualizarUsuario")
	public ResponseEntity<Usuario> atualizarUsuario(@Valid @PathVariable Long usuarioId, Usuario usuarioAtualizado) {
		return ResponseEntity.ok(usuarioService.atualizarUsuario(usuarioId, usuarioAtualizado));
	}
}

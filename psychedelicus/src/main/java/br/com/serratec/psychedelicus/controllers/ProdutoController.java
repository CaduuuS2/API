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

import br.com.serratec.psychedelicus.domain.Produto;
import br.com.serratec.psychedelicus.services.EmailService;
import br.com.serratec.psychedelicus.services.ProdutoService;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	ProdutoService produtoService;

	@Autowired
	EmailService emailService;

	// Buscar produto no banco de dados utilizando o id para referenciar
	@GetMapping("/listarProdutos")
	public ResponseEntity<List<Produto>> listarProdutos() {
		return ResponseEntity.ok(produtoService.listarProdutos());
	}

	// Buscar todos os produtos do banco de dados
	@GetMapping("/{produtoId}/buscarProduto")
	public ResponseEntity<Produto> buscarProdutoPorId(@PathVariable Long produtoId) {
		return ResponseEntity.ok(produtoService.buscarProdutoPorId(produtoId));
	}

	// Adicionar um produto ao banco de dados
	@PostMapping("/salvarProduto")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<Produto> salvarProduto(@Valid @RequestParam String email, @Valid @RequestBody Produto produto)
			throws MessagingException {
		emailService.confirmacaoCadastroProduto(email, produto);
		return ResponseEntity.status(HttpStatus.CREATED).body(produtoService.salvarProduto(produto));
	}

	// Excluir um produto do banco de dados utilizando o id para referenciar
	@DeleteMapping("/{produtoId}/excluirProduto")
	public ResponseEntity<Void> excluirProduto(@Valid @PathVariable Long produtoId) {
		produtoService.excluirProduto(produtoId);
		return ResponseEntity.noContent().build();
	}

	// Atualizar um produto do banco de dados utilizando o id para referenciar
	@PutMapping("/{produtoId}/atualizarProduto")
	public ResponseEntity<Produto> atualizarProduto(@Valid @PathVariable Long produtoId, Produto produtoAtualizado) {
		return ResponseEntity.ok(produtoService.atualizarProduto(produtoId, produtoAtualizado));
	}
}

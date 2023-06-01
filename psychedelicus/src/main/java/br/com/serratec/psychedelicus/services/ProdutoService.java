package br.com.serratec.psychedelicus.services;

import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.serratec.psychedelicus.domain.Produto;
import br.com.serratec.psychedelicus.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	ProdutoRepository produtoRepository;

	public List<Produto> listarProdutos() {
		return produtoRepository.findAll();
	}

	public Produto buscarProdutoPorId(Long id) {
		return produtoRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Produto não encontrado"));
	}

	public Produto salvarProduto(Produto produto) {
		return produtoRepository.save(produto);
	}

	public void excluirProduto(Long id) {
		produtoRepository.deleteById(id);
	}

	public Produto atualizarProduto(Long id, Produto produtoAtualizado) {
		produtoRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Produto não encontrado"));
		produtoAtualizado.setId(id);
		return produtoRepository.save(produtoAtualizado);
	}
}

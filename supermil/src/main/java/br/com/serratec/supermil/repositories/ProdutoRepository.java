package br.com.serratec.supermil.repositories;

import org.springframework.stereotype.Repository;

import br.com.serratec.supermil.domain.Produto;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository("produto")
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
}


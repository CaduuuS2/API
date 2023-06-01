package br.com.serratec.psychedelicus.repositories;

import org.springframework.stereotype.Repository;

import br.com.serratec.psychedelicus.domain.Produto;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository("produto")
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
}


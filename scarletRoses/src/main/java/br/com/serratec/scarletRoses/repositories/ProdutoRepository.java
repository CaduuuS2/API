package br.com.serratec.scarletRoses.repositories;

import org.springframework.stereotype.Repository;

import br.com.serratec.scarletRoses.domain.Produto;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository("produto")
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
}


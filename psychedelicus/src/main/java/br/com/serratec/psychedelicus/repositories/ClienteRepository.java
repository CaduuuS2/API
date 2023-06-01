package br.com.serratec.psychedelicus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.serratec.psychedelicus.domain.Cliente;


@Repository("cliente")
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
}
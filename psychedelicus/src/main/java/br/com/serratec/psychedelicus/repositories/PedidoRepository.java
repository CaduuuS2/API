package br.com.serratec.psychedelicus.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.serratec.psychedelicus.domain.Pedido;

@Repository("pedido")
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
	
}
package br.com.serratec.scarletRoses.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.serratec.scarletRoses.domain.Pedido;

@Repository("pedido")
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
	
}
package br.com.serratec.supermil.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.serratec.supermil.domain.Pedido;

@Repository("pedido")
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
	
}
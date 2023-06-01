package br.com.serratec.psychedelicus.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.serratec.psychedelicus.domain.Pedido;
import br.com.serratec.psychedelicus.repositories.PedidoRepository;


@Service
public class PedidoService {

	@Autowired
	PedidoRepository pedidoRepository;

	public List<Pedido> ListarPedidos() {
		return pedidoRepository.findAll();
	}

	public Pedido buscarPedidoPorId(Long pedidoId) {
		return pedidoRepository.findById(pedidoId)
				.orElseThrow(() -> new NoSuchElementException("Pedido não encontrado."));
	}

	public Pedido salvarPedido(Pedido pedido) {
		return pedidoRepository.save(pedido);
	}

	public void excluirPedido(Long pedidoId) {
		pedidoRepository.deleteById(pedidoId);
	}

	public Pedido atualizarPedido(Long pedidoId, Pedido pedidoAtualizado) {
		pedidoRepository.findById(pedidoId);
		pedidoAtualizado.setPedidoId(pedidoId);
		return pedidoRepository.save(pedidoAtualizado);

	}
}
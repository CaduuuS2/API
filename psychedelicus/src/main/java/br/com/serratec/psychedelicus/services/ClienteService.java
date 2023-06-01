package br.com.serratec.psychedelicus.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.serratec.psychedelicus.domain.Cliente;
import br.com.serratec.psychedelicus.repositories.ClienteRepository;


@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository clienteRepository;

	public List<Cliente> listarCliente() {
		return clienteRepository.findAll();
	}

	public Cliente buscarClientePorId(Long id) {
		return clienteRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Cliente não encontrado"));
	}

	public Cliente salvarCliente(Cliente Cliente) {
		return clienteRepository.save(Cliente);
	}

	public void excluirCliente(Long id) {
		clienteRepository.deleteById(id);
	}

	public Cliente atualizarCliente(Long id, Cliente clienteAtualizado) {
		clienteRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Cliente não encontrado"));
		clienteAtualizado.setClienteId(id);
		return clienteRepository.save(clienteAtualizado);
	}
}

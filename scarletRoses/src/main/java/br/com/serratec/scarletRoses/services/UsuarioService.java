package br.com.serratec.scarletRoses.services;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.serratec.scarletRoses.domain.Usuario;
import br.com.serratec.scarletRoses.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	UsuarioRepository usuarioRepository;

	public List<Usuario> listarUsuario() {
		return usuarioRepository.findAll();
	}

	public Usuario buscarUsuarioPorId(Long id) {
		return usuarioRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Usuario não encontrado"));
	}

	public Usuario salvarUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	public void excluirUsuario(Long id) {
		usuarioRepository.deleteById(id);
	}

	public Usuario atualizarUsuario(Long id, Usuario usuarioAtualizado) {
		usuarioRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Usuario não encontrado"));
		usuarioAtualizado.setUsuarioId(id);
		return usuarioRepository.save(usuarioAtualizado);
	}
}

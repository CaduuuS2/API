package br.com.serratec.supermil.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.serratec.supermil.domain.Usuario;

@Repository("usuario")
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
}
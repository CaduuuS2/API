package br.com.serratec.scarletRoses.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.serratec.scarletRoses.domain.Usuario;

@Repository("usuario")
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
}
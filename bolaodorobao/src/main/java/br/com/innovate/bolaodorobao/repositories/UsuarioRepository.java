package br.com.innovate.bolaodorobao.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.innovate.bolaodorobao.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}

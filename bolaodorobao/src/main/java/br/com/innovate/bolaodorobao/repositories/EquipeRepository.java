package br.com.innovate.bolaodorobao.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.innovate.bolaodorobao.modelo.Equipe;

public interface EquipeRepository extends JpaRepository<Equipe, Long> {

	Optional<Equipe> findByNome(String nome);

}

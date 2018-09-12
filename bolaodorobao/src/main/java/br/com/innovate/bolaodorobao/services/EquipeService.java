package br.com.innovate.bolaodorobao.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.innovate.bolaodorobao.modelo.Equipe;
import br.com.innovate.bolaodorobao.repositories.EquipeRepository;

@Service
public class EquipeService {
	
	@Autowired
	private EquipeRepository equipeRepository;
	
	public Optional<Equipe> findAll(){
		return equipeRepository.findAll().stream().findAny();
	}

	public Optional<Equipe> findByNome(String nome) {
		
		return equipeRepository.findByNome(nome);
	}

	public Optional<Equipe> findById(Long id) {
		return equipeRepository.findById(id);
	}

	public void deletar(Equipe equipe) {
		equipeRepository.delete(equipe);
		
	}

}

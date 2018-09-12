package br.com.innovate.bolaodorobao.controllers;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.innovate.bolaodorobao.dto.EquipeDto;
import br.com.innovate.bolaodorobao.modelo.Equipe;
import br.com.innovate.bolaodorobao.response.Response;
import br.com.innovate.bolaodorobao.services.EquipeService;

@RestController
@RequestMapping("/api/equipes")
@CrossOrigin("*")
public class EquipeController {

	@Autowired
	private EquipeService equipeService;
	
	private static final Logger log = LoggerFactory.getLogger(EquipeController.class);
	
	@GetMapping
	public ResponseEntity<Response<List<EquipeDto>>>listar(){
		log.info("Iniciando pesquisa de equipes");
		Response<List<EquipeDto>> response = new Response<>();
		
		Optional<Equipe> equipes = equipeService.findAll();
		
		if(!equipes.isPresent()) {
			log.error("Não foram encontradas equipes cadastradas");
			response.getErrors().add("Não foram encontradas equipes cadastradas");
			return ResponseEntity.badRequest().body(response);
		}
		
		equipes.stream().forEach(equipe -> response.getData().add(new EquipeDto(equipe)));
		return ResponseEntity.ok(response);
	}
	
	@PostMapping
	public ResponseEntity<Response<EquipeDto>> cadastrar(@RequestBody @Valid EquipeDto equipeDto, BindingResult result){
		log.info("Iniciando cadastro de uma Equipe");			
		Response<EquipeDto> response = new Response<>();
		
		validateEquipeDto(equipeDto, result);
		if(result.hasErrors()) {
			result.getAllErrors().forEach(error-> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		return ResponseEntity.ok(response);
	}
	
	public ResponseEntity<Response<String>> deletar(@PathVariable("id")Long id){
		log.info("Iniciando exclusão de Equipe");
		Response<String> response = new Response<>();
		
		Optional<Equipe> equipe = equipeService.findById(id);
		if(!equipe.isPresent()) {
			log.error("Equipe não encontrada");
			response.getErrors().add("Equipe não encontrada");
			return ResponseEntity.badRequest().body(response);
		}
		
		equipeService.deletar(equipe.get());
		return ResponseEntity.ok(response);
	}

	private void validateEquipeDto(@Valid EquipeDto equipeDto, BindingResult result) {
		Optional<Equipe> equipe = equipeService.findByNome(equipeDto.getNome());
		
		if(equipe.isPresent()) {
			result.addError(new ObjectError("Equipe","Equipe já cadastrada!"));
		}
	}
}

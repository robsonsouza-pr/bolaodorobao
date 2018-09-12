package br.com.innovate.bolaodorobao.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.innovate.bolaodorobao.modelo.Equipe;

public class EquipeDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	@NotNull(message="O nome da equipe não pode ser vazio")
	@Length(min = 1, max = 100,
	message = "O nome da equipe deve conter entre 1 e 100 caracteres.")
	private String nome;
	
	@NotNull(message="O nome da equipe não pode ser vazio")
	private String src;
	
	public EquipeDto() {}
	
	public EquipeDto(Equipe equipe) {
		this.id = equipe.getId();
		this.nome = equipe.getNome();
		this.src = equipe.getSrc();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSrc() {
		return src;
	}

	public void setSrc(String src) {
		this.src = src;
	}
}

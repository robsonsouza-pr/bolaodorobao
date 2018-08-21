package br.com.innovate.bolaodorobao.modelo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.innovate.bolaodorobao.enums.ResultadoEnum;

@Entity
public class Partida implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id; 
	
	private Equipe mandante;
	private Integer placarMandante;
	
	private Equipe visitante;
	private Integer placarVisitante;
	
	private ResultadoEnum resultadoEnum;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Equipe getMandante() {
		return mandante;
	}

	public void setMandante(Equipe mandante) {
		this.mandante = mandante;
	}

	public Integer getPlacarMandante() {
		return placarMandante;
	}

	public void setPlacarMandante(Integer placarMandante) {
		this.placarMandante = placarMandante;
	}

	public Equipe getVisitante() {
		return visitante;
	}

	public void setVisitante(Equipe visitante) {
		this.visitante = visitante;
	}

	public Integer getPlacarVisitante() {
		return placarVisitante;
	}

	public void setPlacarVisitante(Integer placarVisitante) {
		this.placarVisitante = placarVisitante;
	}

	public ResultadoEnum getResultadoEnum() {
		return resultadoEnum;
	}

	public void setResultadoEnum(ResultadoEnum resultadoEnum) {
		this.resultadoEnum = resultadoEnum;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Partida other = (Partida) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}

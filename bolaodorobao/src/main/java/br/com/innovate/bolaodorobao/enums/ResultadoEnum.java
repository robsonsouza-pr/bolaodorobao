package br.com.innovate.bolaodorobao.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

public enum ResultadoEnum {
	
	VITORIA (1L),
	EMPÁTE (2L),
	DERROTA(3L);
	
	private static final Map<Long, ResultadoEnum> LOOKUP = new HashMap<>();

	static {
		for (ResultadoEnum e : EnumSet.allOf(ResultadoEnum.class)) {
			LOOKUP.put(e.getId(), e);
		}
	}

	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private ResultadoEnum(Long id) {
		this.id = id;
	}

	public static ResultadoEnum valueOf(Long id) {
		return LOOKUP.get(id);
	}

}

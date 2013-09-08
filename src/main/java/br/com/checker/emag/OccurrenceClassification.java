package br.com.checker.emag;

import lombok.Getter;

public enum OccurrenceClassification {

	MARK("2.1","Marca��o"),
	BEHAVIOR("2.2","Comportamento (DOM)"),
	CONTENT_INFORMATION("2.3","Conte�do / Informa��o"),
	PRESENTATION_DESIGN("2.4","Apresenta��o / Design"),
	MULTIMEDIA("2.5","Multim�dia"),
	FORM("2.6","Formul�rios");
	
	OccurrenceClassification(String code,String description) {
		this.code = code;
		this.description = description;
	}
	
	@Getter private final String code;
	@Getter private final String description;
}


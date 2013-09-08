package br.com.checker.emag;

import lombok.Getter;
import lombok.ToString;

@ToString
public @Getter class Occurrence {
	
	private Integer line;
	private Integer column;
	private String code;
	private boolean error;
	private String tag;
	
	public Occurrence(int line, int column, String code, boolean error,
			String tag) {
		this.line = line;
		this.column = column;
		this.code = code;
		this.error = error;
		this.tag = tag;
	}
	
	public Occurrence(String code, boolean error,
			String tag) {
		this.code = code;
		this.error = error;
		this.tag = tag;
	}
	
	
}

package br.com.code.domain;

public enum TipoSexo {
	FEMININO('F'),MASCULINO('M');
	
	private TipoSexo(char desc) {
		this.desc = desc;
	}
	
	public char getDesc() {
		return desc;
	}

	private char desc;
	
}

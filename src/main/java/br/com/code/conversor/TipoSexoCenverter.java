package br.com.code.conversor;


import org.springframework.core.convert.converter.Converter;

import br.com.code.domain.TipoSexo;


public class TipoSexoCenverter implements Converter<String, TipoSexo> {

	@Override
	public TipoSexo convert(String texto) {

		char tipo = texto.charAt(0);
		
		return tipo == TipoSexo.FEMININO.getDesc()? TipoSexo.FEMININO : TipoSexo.MASCULINO;
	}

}

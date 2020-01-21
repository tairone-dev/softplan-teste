package com.br.softplan.teste.domain.sienge.utils;

import java.util.List;
import java.util.stream.Collectors;

import com.br.softplan.teste.domain.sienge.Composicao;

public class ListaDeComposicoes {

	public List<Integer> buscarCodigosUnicos(List<Composicao> composicoes) {
		return composicoes.stream().map(composicao -> composicao.getCodigoComposicao()).distinct()
				.collect(Collectors.toList());
	}
	
	public List<Composicao> buscarComposicoesComCodigoDaComposicao(Integer codigo, List<Composicao> composicoes) {
		return composicoes.stream().filter(composicao -> composicao.getCodigoComposicao().equals(codigo))
				.collect(Collectors.toList());
	}
}

package com.br.softplan.teste.domain.sienge.utils;

import java.util.List;

import com.br.softplan.teste.domain.sienge.Composicao;

public class CalculadoraDeComposicao {

	public Double calcularValorTotalDa(Composicao composicao) {
		Double total = composicao.getValorUnitario() * composicao.getQuantidadeComposicao();

		return formatarValorParaDuasCasasDecimais(total);
	}

	private Double formatarValorParaDuasCasasDecimais(Double valor) {
		return Math.floor(valor * 100.0) / 100.0;
	}

	public Double calcularValorTotalDas(List<Composicao> composicoes) {
		return composicoes.stream().map(composicao -> calcularValorTotalDa(composicao)).reduce(0.0, Double::sum);
	}

}

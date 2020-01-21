package com.br.softplan.teste.domain.sienge;

import java.util.ArrayList;
import java.util.List;

import com.br.softplan.teste.domain.sienge.utils.CalculadoraDeComposicao;
import com.br.softplan.teste.domain.sienge.utils.ListaDeComposicoes;
import com.br.softplan.teste.domain.sienge.utils.ManipuladorDeString;

public class GeradorOrcamento {
	
	private ListaDeComposicoes listaDeComposicoes = new ListaDeComposicoes();
	private CalculadoraDeComposicao calculadoraDeComposicao = new CalculadoraDeComposicao();
	private ManipuladorDeString manipulador = new ManipuladorDeString();

	public List<String> gerarOrcamentoDas(List<Composicao> composicoes) {
		List<Integer> codigosUnicos = listaDeComposicoes.buscarCodigosUnicos(composicoes);
		List<String> orcamentos = new ArrayList<String>();
		
		for (Integer codigo : codigosUnicos) {
			List<Composicao> composicoesComCodigoDaComposicao = listaDeComposicoes.buscarComposicoesComCodigoDaComposicao(codigo, composicoes);
			
			Double valorTotal = calculadoraDeComposicao.calcularValorTotalDas(composicoesComCodigoDaComposicao);
			
			Composicao composicao = composicoesComCodigoDaComposicao.get(0);
			
			orcamentos.add(gerarOrcamentoDa(composicao, valorTotal));
		}
		
		return orcamentos;
	}
	
	private String gerarOrcamentoDa(Composicao composicao, Double valorTotal) {
		StringBuilder orcamento = new StringBuilder();
		orcamento.append(composicao.getCodigoComposicao()).append(" ");
		orcamento.append(composicao.getDescricaoComposicao()).append(" ");
		orcamento.append(composicao.getUnidadeComposicao()).append(" ");
		orcamento.append(manipulador.formatarValorDecimalPadraoPtBr(valorTotal, "#,##0.00"));
		
		return orcamento.toString();
	}
}

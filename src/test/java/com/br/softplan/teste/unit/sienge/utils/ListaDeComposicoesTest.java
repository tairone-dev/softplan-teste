package com.br.softplan.teste.unit.sienge.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.br.softplan.teste.domain.sienge.Composicao;
import com.br.softplan.teste.domain.sienge.utils.ListaDeComposicoes;

class ListaDeComposicoesTest {
	
	private ListaDeComposicoes listaDeComposicoes;
	private Composicao composicao;
	private Composicao composicao2;
	private List<Composicao> composicoes;
	private List<Integer> codigosUnicos;

	@BeforeEach
	void setUp() throws Exception {
		listaDeComposicoes = new ListaDeComposicoes();
		composicao = new Composicao();
		composicao2 = new Composicao();
		composicoes = Arrays.asList();
		codigosUnicos = Arrays.asList();
	}
	
	@Test
	void testBuscarCodigosUnicosComDuasComposicoesComCodigosRepetidosDeveRetornarApenasUmCodigo() {
		composicao = new Composicao();
		composicao.setCodigoComposicao(94793);
		composicao2 = new Composicao();
		composicao2.setCodigoComposicao(94793);
		
		composicoes = Arrays.asList(composicao, composicao2);
		
		codigosUnicos = Arrays.asList(94793);
		
		assertEquals(codigosUnicos, listaDeComposicoes.buscarCodigosUnicos(composicoes));
	}
	
	@Test
	void testBuscarCodigosUnicosPassandoSeisComposicoesECincoComCodigosUnicosDeveRetornarCincoCodigos() {
		composicao = new Composicao();
		composicao.setCodigoComposicao(94793);
		composicao2 = new Composicao();
		composicao2.setCodigoComposicao(98561);
		Composicao composicao3 = new Composicao();
		composicao3.setCodigoComposicao(87286);
		Composicao composicao4 = new Composicao();
		composicao4.setCodigoComposicao(88830);
		Composicao composicao5 = new Composicao();
		composicao5.setCodigoComposicao(88831);
		Composicao composicao6 = new Composicao();
		composicao6.setCodigoComposicao(88831);
		
		composicoes = Arrays.asList(composicao, composicao2, composicao3, composicao4, composicao5, composicao6);
		
		codigosUnicos = Arrays.asList(94793, 98561, 87286, 88830, 88831);
		
		assertEquals(codigosUnicos, listaDeComposicoes.buscarCodigosUnicos(composicoes));
	}
	
}

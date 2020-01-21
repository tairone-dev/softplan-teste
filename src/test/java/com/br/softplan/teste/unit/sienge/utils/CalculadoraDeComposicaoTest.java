package com.br.softplan.teste.unit.sienge.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.br.softplan.teste.domain.sienge.Composicao;
import com.br.softplan.teste.domain.sienge.utils.CalculadoraDeComposicao;

class CalculadoraDeComposicaoTest {
	
	private CalculadoraDeComposicao calculadora;
	private Composicao composicao;
	private Composicao composicao2;
	private Composicao composicao3;
	private Composicao composicao4;
	private List<Composicao> composicoes;

	
	@BeforeEach
	void setUp() throws Exception {
		calculadora = new CalculadoraDeComposicao();
		composicao = new Composicao();
		composicao2 = new Composicao();
		composicao3 = new Composicao();
		composicao4 = new Composicao();
		composicoes = Arrays.asList();
	}
	
	@Test
	void testCalcularValorTotalDeUmaComposicaoComQuantidadeUmRecebendoValorComDuasCasasDecimais() {
		composicao.setValorUnitario(16.0);
		composicao.setQuantidadeComposicao(1.0);
		
		assertEquals(16.00, calculadora.calcularValorTotalDa(composicao));
	}
	
	@Test
	void testCalcularValorTotalDeUmaComposicaoComQuantidadeMenorQueUmRecebendoValorComDuasCasasDecimais() {
		composicao.setValorUnitario(9.4);
		composicao.setQuantidadeComposicao(0.019);
		
		assertEquals(0.17, calculadora.calcularValorTotalDa(composicao));
	}
	
	@Test
	void testCalcularValorTotalDeUmaComposicaoComQuantidadeMaiorQueUmRecebendoValorComDuasCasasDecimais() {
		composicao.setValorUnitario(130.49);
		composicao.setQuantidadeComposicao(0.47);
		
		assertEquals(61.33, calculadora.calcularValorTotalDa(composicao));
	}
	
	@Test
	void testCalcularValorTotalDeDuasComposicoesRecebendoValorComDuasCasasDecimais() {
		composicao.setValorUnitario(9.4);
		composicao.setQuantidadeComposicao(0.019);
		composicao2.setValorUnitario(100.41);
		composicao2.setQuantidadeComposicao(1.0);
		
		composicoes = Arrays.asList(composicao, composicao2);
		
		assertEquals(100.58, calculadora.calcularValorTotalDas(composicoes));
	}
	
	@Test
	void testCalcularValorTotalDasComposicoesDoRegistroDeGavetaBrutoRecebendoValorComDuasCasasDecimais() {
		composicao.setValorUnitario(9.4);
		composicao.setQuantidadeComposicao(0.019);
		composicao2.setValorUnitario(100.41);
		composicao2.setQuantidadeComposicao(1.0);
		composicao3.setValorUnitario(15.19);
		composicao3.setQuantidadeComposicao(0.789);
		composicao4.setValorUnitario(20.33);
		composicao4.setQuantidadeComposicao(0.789);
		
		composicoes = Arrays.asList(composicao, composicao2, composicao3, composicao4);
		
		assertEquals(128.60, calculadora.calcularValorTotalDas(composicoes));
	}
	
	@Test
	void testCalcularValorTotalDasComposicoesDeImpermeabilizacaoDeParedeRecebendoValorComDuasCasasDecimais() {
		composicao.setValorUnitario(4.44);
		composicao.setQuantidadeComposicao(0.387);
		composicao2.setValorUnitario(289.97);
		composicao2.setQuantidadeComposicao(0.025);
		composicao3.setValorUnitario(19.82);
		composicao3.setQuantidadeComposicao(0.867);
		composicao4.setValorUnitario(14.78);
		composicao4.setQuantidadeComposicao(0.176);
		
		composicoes = Arrays.asList(composicao, composicao2, composicao3, composicao4);
		
		assertEquals(28.73, calculadora.calcularValorTotalDas(composicoes));
	}
	
	@Test
	void testCalcularValorTotalDasComposicoesDeArgamassaTracoRecebendoValorComDuasCasasDecimais() {
		composicao.setValorUnitario(67.50);
		composicao.setQuantidadeComposicao(1.3);
		composicao2.setValorUnitario(0.47);
		composicao2.setQuantidadeComposicao(130.49);
		composicao3.setValorUnitario(0.49);
		composicao3.setQuantidadeComposicao(250.11);
		composicao4.setValorUnitario(16.0);
		composicao4.setQuantidadeComposicao(1.0);
		Composicao composicao5 = new Composicao();
		composicao5.setValorUnitario(1.25);
		composicao5.setQuantidadeComposicao(1.19);
		Composicao composicao6 = new Composicao();
		composicao6.setValorUnitario(0.22);
		composicao6.setQuantidadeComposicao(3.91);
		
		composicoes = Arrays.asList(composicao, composicao2, composicao3, composicao4, composicao5, composicao6);
		
		assertEquals(289.97, calculadora.calcularValorTotalDas(composicoes));
	}
	
	@Test
	void testCalcularValorTotalDasComposicoesDeBetoneiraCHPRecebendoValorComDuasCasasDecimais() {
		composicao.setValorUnitario(0.18);
		composicao.setQuantidadeComposicao(1.0);
		composicao2.setValorUnitario(0.04);
		composicao2.setQuantidadeComposicao(1.0);
		composicao3.setValorUnitario(0.17);
		composicao3.setQuantidadeComposicao(1.0);
		composicao4.setValorUnitario(0.86);
		composicao4.setQuantidadeComposicao(1.0);
		
		composicoes = Arrays.asList(composicao, composicao2, composicao3, composicao4);
		
		assertEquals(1.25, calculadora.calcularValorTotalDas(composicoes));
	}
	
	@Test
	void testCalcularValorTotalDasComposicoesDeBetoneiraCHIRecebendoValorComDuasCasasDecimais() {
		composicao.setValorUnitario(0.18);
		composicao.setQuantidadeComposicao(1.0);
		composicao2.setValorUnitario(0.04);
		composicao2.setQuantidadeComposicao(1.0);
		
		composicoes = Arrays.asList(composicao, composicao2);
		
		assertEquals(0.22, calculadora.calcularValorTotalDas(composicoes));
	}
}

package com.br.softplan.teste.unit.sienge;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.br.softplan.teste.domain.sienge.Composicao;
import com.br.softplan.teste.domain.sienge.GeradorOrcamento;

class GeradorOrcamentoTest {

	GeradorOrcamento gerador;
	Composicao fitaVedaRosca;
	List<String> orcamentos;
	List<Composicao> composicoes;
	
	@BeforeEach
	void setUp() throws Exception {
		gerador = new GeradorOrcamento();
		
		fitaVedaRosca = new Composicao();
		fitaVedaRosca.setCodigoComposicao(94793);
		fitaVedaRosca.setDescricaoComposicao("REGISTRO DE GAVETA BRUTO");
		fitaVedaRosca.setUnidadeComposicao("UN");
		fitaVedaRosca.setQuantidadeComposicao(0.019);
		fitaVedaRosca.setValorUnitario(9.4);
	}
	
	@Test
	void testGerarOrcamentoComUmaComposicao() {
		composicoes = Arrays.asList(fitaVedaRosca);
		
		orcamentos = Arrays.asList("94793 REGISTRO DE GAVETA BRUTO UN 0,17");
		
		assertEquals(orcamentos, gerador.gerarOrcamentoDas(composicoes));
	}
	
	@Test
	void testGerarOrcamentoDeComposicaoDeRegistroDeGavetaBruto() {
		Composicao registroGaveta = new Composicao();
		registroGaveta.setCodigoComposicao(94793);
		registroGaveta.setDescricaoComposicao("REGISTRO DE GAVETA BRUTO");
		registroGaveta.setUnidadeComposicao("UN");
		registroGaveta.setQuantidadeComposicao(1.0);
		registroGaveta.setValorUnitario(100.41);
		
		Composicao auxiliarDeEncanador = new Composicao();
		auxiliarDeEncanador.setCodigoComposicao(94793);
		auxiliarDeEncanador.setDescricaoComposicao("REGISTRO DE GAVETA BRUTO");
		auxiliarDeEncanador.setUnidadeComposicao("UN");
		auxiliarDeEncanador.setQuantidadeComposicao(0.789);
		auxiliarDeEncanador.setValorUnitario(15.19);
		
		Composicao encanadorOuBombeiro = new Composicao();
		encanadorOuBombeiro.setCodigoComposicao(94793);
		encanadorOuBombeiro.setDescricaoComposicao("REGISTRO DE GAVETA BRUTO");
		encanadorOuBombeiro.setUnidadeComposicao("UN");
		encanadorOuBombeiro.setQuantidadeComposicao(0.789);
		encanadorOuBombeiro.setValorUnitario(20.33);
		
		composicoes = Arrays.asList(fitaVedaRosca, registroGaveta, auxiliarDeEncanador, encanadorOuBombeiro);
		
		orcamentos = Arrays.asList("94793 REGISTRO DE GAVETA BRUTO UN 128,60");
		
		assertEquals(orcamentos, gerador.gerarOrcamentoDas(composicoes));
	}

}

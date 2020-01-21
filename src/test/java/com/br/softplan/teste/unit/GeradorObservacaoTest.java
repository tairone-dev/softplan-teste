package com.br.softplan.teste.unit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.br.softplan.teste.domain.GeradorObservacao;
import com.br.softplan.teste.domain.Nota;

class GeradorObservacaoTest {

	private GeradorObservacao gerador;
	private List<Object> numeros;
	private List<Nota> notas;
	Nota nota;
	Nota nota2;

	@BeforeEach
	void setUp() throws Exception {
		gerador = new GeradorObservacao();
		nota = new Nota(1, 34565.45);
		nota2 = new Nota(2, 34.4);
	}

	@Test
	void testGerarObservacaoSemNumeroDevolveStringVazia() {
		numeros = Arrays.asList();
		assertEquals("", gerador.geraObservacao(numeros));
	}

	@Test
	void testGerarObservacaoComUmNumeroDevolveStringCompleta() {
		numeros = Arrays.asList(1);
		assertEquals("Fatura da nota fiscal de simples remessa: 1.", gerador.geraObservacao(numeros));
	}

	@Test
	void testGerarObservacaoComDoisNumerosDevolveStringCompleta() {
		numeros = Arrays.asList(1, 2);
		assertEquals("Fatura das notas fiscais de simples remessa: 1 e 2.", gerador.geraObservacao(numeros));
	}

	@Test
	void testGerarObservacaoComTresNumerosDevolveStringCompleta() {
		numeros = Arrays.asList(1, 2, 3);
		assertEquals("Fatura das notas fiscais de simples remessa: 1, 2 e 3.", gerador.geraObservacao(numeros));
	}

	@Test
	void testGerarObservacaoSemNotaDevolveStringVazia() {
		notas = Arrays.asList();
		assertEquals("", gerador.geraObservacao(notas));
	}

	@Test
	void testGerarObservacaoComUmaNotaDevolveStringCompleta() {
		notas = Arrays.asList(nota);
		assertEquals("Fatura da nota fiscal de simples remessa: 1 cujo valor é R$ 34.565,45.",
				gerador.geraObservacao(notas));
	}

	@Test
	void testGerarObservacaoComDuasNotasDevolveStringCompleta() {
		notas = Arrays.asList(nota, nota2);
		assertEquals("Fatura das notas fiscais de simples remessa: 1 cujo valor é R$ 34.565,45 e 2 cujo valor é R$ 34,40.",
				gerador.geraObservacao(notas));
	}

	@Test
	void testGerarObservacaoComTresNotasDevolveStringCompleta() {
		Nota nota3 = new Nota(3, 1.5);
		notas = Arrays.asList(nota, nota2, nota3);
		assertEquals("Fatura das notas fiscais de simples remessa: 1 cujo valor é R$ 34.565,45, 2 cujo valor é R$ 34,40 e 3 cujo valor é R$ 1,50.",
				gerador.geraObservacao(notas));
	}
	
	@Test
	void testGerarObservacaoComUmaNotaComUmaCasaDecimalDevolveStringCompletaComDuasCasasDecimais() {
		Nota notaComUmaCasaDecimal = new Nota(1, 1.1);
		notas = Arrays.asList(notaComUmaCasaDecimal);
		assertEquals("Fatura da nota fiscal de simples remessa: 1 cujo valor é R$ 1,10.",
				gerador.geraObservacao(notas));
	}

	@Test
	void testGerarObservacaoComUmaNotaComTresCasasDecimaisDevolveStringCompletaComDuasCasasDecimais() {
		Nota notaComTresCasasDecimais = new Nota(1, 1.111);
		notas = Arrays.asList(notaComTresCasasDecimais);
		assertEquals("Fatura da nota fiscal de simples remessa: 1 cujo valor é R$ 1,11.",
				gerador.geraObservacao(notas));
	}

}

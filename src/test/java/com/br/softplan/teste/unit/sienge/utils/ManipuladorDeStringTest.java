package com.br.softplan.teste.unit.sienge.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.br.softplan.teste.domain.sienge.utils.ManipuladorDeString;

class ManipuladorDeStringTest {
	
	private ManipuladorDeString manipulador;
	private String formato = "#,###.00";
	private double valor;
	
	@BeforeEach
	void setUp() throws Exception {
		manipulador = new ManipuladorDeString();
	}

	@Test
	void testFormatarDoubleDeMilharComTresCasasDecimais() {
		valor = 1000.2222;
		assertEquals("1.000,22", manipulador.formatarValorDecimalPadraoPtBr(valor, formato));
	}
	
	@Test
	void testFormatarDoubleCentenaComQuatroCasasDecimais() {		
		valor = 100.2222;
		assertEquals("100,22", manipulador.formatarValorDecimalPadraoPtBr(valor, formato));
	}

}

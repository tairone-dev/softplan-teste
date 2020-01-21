package com.br.softplan.teste.unit;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.br.softplan.teste.domain.Nota;

class NotaTest {

	Nota nota;
	
	@BeforeEach
	void setUp() throws Exception {
		
	}

	@Test
	void testToStringComValorDeDuasCasasDecimaisDeveGerarStringCompletaComValorDeDuasCasasDecimais() {
		nota = new Nota(1, 1.10);
		assertEquals("1 cujo valor é R$ 1,10", nota.toString());
	}

	@Test
	void testToStringComValorDeUmaCasaDecimalDeveGerarStringCompletaComValorDeDuasCasasDecimais() {
		nota = new Nota(1, 1.1);
		assertEquals("1 cujo valor é R$ 1,10", nota.toString());
	}
	
	@Test
	void testToStringComValorDeTresCasasDecimaisDeveGerarStringCompletaComValorDeDuasCasasDecimais() {
		nota = new Nota(1, 1.101);
		assertEquals("1 cujo valor é R$ 1,10", nota.toString());
	}
	
	
	@Test
	void testToStringComValorDeMilharDeveGerarStringCompletaComValorSeparadoPorPontoFinalNaCasaDeMilhar() {
		nota = new Nota(1, 1000.10);
		assertEquals("1 cujo valor é R$ 1.000,10", nota.toString());
	}
	
	@Test
	void testToStringComValorDeUmMilhaoDeveGerarStringCompletaComValorSeparadoPorPontoFinalNasCasasDeMilhares() {
		nota = new Nota(1, 1000000.10);
		assertEquals("1 cujo valor é R$ 1.000.000,10", nota.toString());
	}
}

package com.br.softplan.teste.domain.sienge.utils;

import java.text.DecimalFormat;
import java.util.Currency;
import java.util.Locale;

public class ManipuladorDeString {
	
	private static final Locale ptBr = new Locale("pt", "BR");

	public String formatarValorDecimalPadraoPtBr(Double valor, String formato) {
		DecimalFormat decimalFormat = new DecimalFormat(formato);
		
		decimalFormat.setCurrency(Currency.getInstance(ptBr));
		
		return decimalFormat.format(valor);
	}
}

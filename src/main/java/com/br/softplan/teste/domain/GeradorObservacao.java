package com.br.softplan.teste.domain;

import java.util.Iterator;
import java.util.List;

public class GeradorObservacao {

	// Textos pré-definidos
	private static final String fraseSingular = "Fatura da nota fiscal de simples remessa: ";
	private static final String frasePlural = "Fatura das notas fiscais de simples remessa: ";

	// Gera observações, com texto pre-definido, incluindo os números, das notas
	// fiscais, recebidos no parâmetro
	public String geraObservacao(List<?> lista) {
		if (!lista.isEmpty()) {
			return retornaCodigos(lista);
		}
		return "";
	}

	// Cria observação
	private String retornaCodigos(List<?> lista) {
		String texto = lista.size() >= 2 ? frasePlural : fraseSingular;

		// Acha separador
		StringBuilder cod = new StringBuilder();		
		for (Iterator<?> iterator = lista.iterator(); iterator.hasNext();) {
			Object c = iterator.next();
			String s = "";
			if (cod.toString() == null || cod.toString().length() <= 0)
				s = "";
			else if (iterator.hasNext())
				s = ", ";
			else
				s = " e ";

			cod.append(s).append(c);
		}

		return cod.insert(0, texto).append(".").toString();
	}
}

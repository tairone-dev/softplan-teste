package com.br.softplan.teste.domain;

import java.text.NumberFormat;
import java.util.Locale;

public class Nota {

	private int numero;
	private Double valor;

	public Nota() {
	}

	public Nota(int numero, Double valor) {
		this.numero = numero;
		this.valor = valor;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		Locale ptBr = new Locale("pt", "BR");

		String valorEmString = NumberFormat.getCurrencyInstance(ptBr).format(valor);

		return String.format("%d cujo valor é %s", numero, valorEmString);
	}
}

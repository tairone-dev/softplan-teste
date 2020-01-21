package com.br.softplan.teste.deserializer;

import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import com.br.softplan.teste.domain.sienge.Composicao;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class ComposicaoDeserializer extends StdDeserializer<Composicao> {

	public ComposicaoDeserializer() {
		this(null);
	}
	
	protected ComposicaoDeserializer(Class<?> vc) {
		super(vc);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -2542192247186989555L;

	@Override
	public Composicao deserialize(JsonParser jp, DeserializationContext ctxt)
			throws IOException, JsonProcessingException {
		
		
		JsonNode node = jp.getCodec().readTree(jp);
		
		int codigoComposicao = node.get("codigoComposicao").asInt();
		String descricaoComposicao = node.get("descricaoComposicao").asText();
		String unidadeComposicao = node.get("unidadeComposicao").asText();
		String tipoItem = node.get("tipoItem").asText();
		int codigoItem = node.get("codigoItem").asInt();
		String descricaoItemComposicao = node.get("descricaoItemComposicao").asText();
		String unidadeItem = node.get("unidadeItem").asText();		
		
		
		Locale ptBr = new Locale("pt", "BR");
		
		NumberFormat nf_in = NumberFormat.getNumberInstance(ptBr);
		double quantidadeComposicao = 0.0;
		double valorUnitario = 0.0;
		try {
			quantidadeComposicao = nf_in.parse(node.get("quantidadeComposicao").asText()).doubleValue();
			valorUnitario = nf_in.parse(node.get("valorUnitario").asText()).doubleValue();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return new Composicao(codigoComposicao, descricaoComposicao, unidadeComposicao, tipoItem, codigoItem, descricaoItemComposicao, unidadeItem, quantidadeComposicao, valorUnitario);
	}

}

package com.br.softplan.teste.domain.sienge;

import com.br.softplan.teste.deserializer.ComposicaoDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(using = ComposicaoDeserializer.class)
public class Composicao {

	private Integer codigoComposicao;
	private String descricaoComposicao;
	private String unidadeComposicao;
	private String tipoItem;
	private Integer codigoItem;
	private String descricaoItemComposicao;
	private String unidadeItem;
	private Double quantidadeComposicao;
	private Double valorUnitario;
	private Double valorTotal;

	public Composicao() {
	}

	public Composicao(Integer codigoComposicao, String descricaoComposicao, String unidadeComposicao, String tipoItem,
			Integer codigoItem, String descricaoItemComposicao, String unidadeItem, Double quantidadeComposicao,
			Double valorUnitario) {
		this.codigoComposicao = codigoComposicao;
		this.descricaoComposicao = descricaoComposicao;
		this.unidadeComposicao = unidadeComposicao;
		this.tipoItem = tipoItem;
		this.codigoItem = codigoItem;
		this.descricaoItemComposicao = descricaoItemComposicao;
		this.unidadeItem = unidadeItem;
		this.quantidadeComposicao = quantidadeComposicao;
		this.valorUnitario = valorUnitario;
	}

	public Integer getCodigoComposicao() {
		return codigoComposicao;
	}

	public void setCodigoComposicao(Integer codigoComposicao) {
		this.codigoComposicao = codigoComposicao;
	}

	public String getDescricaoComposicao() {
		return descricaoComposicao;
	}

	public void setDescricaoComposicao(String descricaoComposicao) {
		this.descricaoComposicao = descricaoComposicao;
	}

	public String getUnidadeComposicao() {
		return unidadeComposicao;
	}

	public void setUnidadeComposicao(String unidadeComposicao) {
		this.unidadeComposicao = unidadeComposicao;
	}

	public String getTipoItem() {
		return tipoItem;
	}

	public void setTipoItem(String tipoItem) {
		this.tipoItem = tipoItem;
	}

	public Integer getCodigoItem() {
		return codigoItem;
	}

	public void setCodigoItem(Integer codigoItem) {
		this.codigoItem = codigoItem;
	}

	public String getDescricaoItemComposicao() {
		return descricaoItemComposicao;
	}

	public void setDescricaoItemComposicao(String descricaoItemComposicao) {
		this.descricaoItemComposicao = descricaoItemComposicao;
	}

	public String getUnidadeItem() {
		return unidadeItem;
	}

	public void setUnidadeItem(String unidadeItem) {
		this.unidadeItem = unidadeItem;
	}

	public Double getQuantidadeComposicao() {
		return quantidadeComposicao;
	}

	public void setQuantidadeComposicao(Double quantidadeComposicao) {
		this.quantidadeComposicao = quantidadeComposicao;
	}

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}
	
	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}
}

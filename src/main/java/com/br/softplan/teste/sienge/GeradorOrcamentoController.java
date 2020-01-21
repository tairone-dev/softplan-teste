package com.br.softplan.teste.sienge;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.br.softplan.teste.domain.sienge.Composicao;
import com.br.softplan.teste.domain.sienge.GeradorOrcamento;

@Path("/orcamento")
public class GeradorOrcamentoController {
	
	GeradorOrcamento gerador = new GeradorOrcamento();
	
	@POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> gerarObservacaoComValor(List<Composicao> composicoes) {
        return gerador.gerarOrcamentoDas(composicoes);
    }
}

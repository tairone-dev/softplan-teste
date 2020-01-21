package com.br.softplan.teste;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.br.softplan.teste.domain.GeradorObservacao;
import com.br.softplan.teste.domain.Nota;

@Path("/gerador-observacao")
public class GeradorObservacaoController {
	
	private GeradorObservacao gerador = new GeradorObservacao();

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String gerarObservacao(@QueryParam("valores") List<Integer> valores) {
        return gerador.geraObservacao(valores);
    }
    
    @POST
    @Path("/com-valor")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String gerarObservacaoComValor(List<Nota> notas) {
        return gerador.geraObservacao(notas);
    }
}
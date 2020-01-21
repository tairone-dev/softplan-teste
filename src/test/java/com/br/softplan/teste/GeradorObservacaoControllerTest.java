package com.br.softplan.teste;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.br.softplan.teste.domain.Nota;

import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class GeradorObservacaoControllerTest {

	@Test
	public void testEndpointGeradorObservacaoSemEnviarParametros() {
		given()
			.when().get("/gerador-observacao")
			.then()
				.statusCode(200)
				.body(is(""));
	}

	@Test
	public void testEndpointGeradorObservacaoEnviandoUmNumeroDeNota() {
		given()
			.when().get("/gerador-observacao?valores=1")
			.then()
				.statusCode(200)
				.body(is("Fatura da nota fiscal de simples remessa: 1."));
	}
	
	@Test
	public void testEndpointGeradorObservacaoEnviandoDoisNumerosDeNota() {
		given()
			.when().get("/gerador-observacao?valores=1&valores=2")
			.then()
				.statusCode(200)
				.body(is("Fatura das notas fiscais de simples remessa: 1 e 2."));
	}

	@Test
	public void testEndpointGeradorObservacaoEnviandoTresNumerosDeNota() {
		given()
			.when().get("/gerador-observacao?valores=1&valores=2&valores=3")
			.then()
				.statusCode(200)
				.body(is("Fatura das notas fiscais de simples remessa: 1, 2 e 3."));
	}

	@Test
	public void testEndpointGeradorObservacaoComValorSemEnviarParametros() {		
		given()
			.when().post("/gerador-observacao/com-valor")
			.then()
				.statusCode(415)
				.body(is(""));
	}
	
	@Test
	public void testEndpointGeradorObservacaoComValorEnviandoUmaNota() {
		Nota nota = new Nota(1, 34565.45);
		List<Nota> notas = Arrays.asList(nota, nota);
		
		given()
			.when().post("/gerador-observacao/com-valor", notas)
			.then()
				.statusCode(200)
				.body(is("Fatura da nota fiscal de simples remessa: 1 cujo valor é R$ 34.565,45."));
	}
}
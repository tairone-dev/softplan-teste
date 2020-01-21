# softplan-teste project

O projeto foi desenvolvido utilizando o framework Quarkus: https://quarkus.io/ .

## Rodando a aplicação no modo desenvolvimento

Basta rodar este comando maven dentro do root do projeto:
```
./mvnw quarkus:dev
```

## Exercício 1

Ponto 1 - Renomear variável "umoNota":
    Aparentemente esta variável possui um nome que foi gerado a partir de um "typo". A alteração do 
nome foi para "fraseSingular" na tentativa de deixar o nome da variável mais claro sobre o seu conteúdo.

Ponto 2 - Remover a variável "texto" como propriedade da classe:
    Esta ação foi tomada pois nem sempre a variável é utilizada e somente faz sentido ser instanciada 
dentro do método "retornaCodigos" pois é somente ali que existe alguma interação com a mesma.

Ponto 3 - Movida inicialização da variável "texto" no método "geraObservação":
    Pelo motivo da variável ser efetivamente usada dentro do método "retornaCodigos", desta forma não
será inicializada em vão.

Ponto 4 - Alterado "If - Else" para "If ternário"
    Neste ponto acabei optando pelo código ficar um pouco mais sucinto e mais explícito sobre seu
comportamento.

Ponto 5 - Removito as string + "" :
    Para não instanciar uma nova string para cada concatenação, alterei para o método "append" do 
"StringBuilder".

Ponto 6 - Alterada declaração de tipo da lista para lista genérica:
    Foi alterado este ponto do código para permitir que o mesmo recebesse um novo tipo de lista ("Nota")
onde através de um "@Override" no método "toString()" da classe foi possível adicionar o novo comportamento
sem alterar a lógica já existente no sistema.

Ponto 7 - Movidos os textos fixo da classe para propriedade da mesma:
    Essa alteração é devida a facilidade que pode ocorrer "typos" no código, como provavelmente aconteceu no
antigo nome "umoNota" existente na propriedade da classe.

## Acessos da api

# Antigo comportamento

    Basta enviar uma requisição *GET* para o endpoint:

    `http://localhost:8080/gerador-observacao`

    Passando por parametro o array de inteiros, como exemplo abaixo:

    `http://localhost:8080/gerador-observacao?valores=1&valores=2&valores=3`

# Novo comportamento

    Enviar uma requisição *POST* para o endpoint:

    `/gerador-observacao/com-valor`

    Passando por parâmetro um objeto JSON, segue exemplo abaixo:

    `[
	    {
		    "numero": 1,
    		"valor": 34565.45
	    },
	    {
		    "numero": 2,
    		"valor": 35842.2
	    },
	    {
		    "numero": 3,
    		"valor": 1.5
	    }
    ]`

## Exercício 2

Ponto 1 - Deserializer Composicao
    Foi necessária a implementação de um deserializer pois como o endpoint recebe uma lista de composições
e a classe "Composicao" possui as propriedades "quantidadeComposicao" e "valorUnitario" declaradas como "Double".
No momento de conversão do JSON a tipagem dava erro, pois os valores no JSON estão com separação decimal utilizando
o símbolo "," sendo que o Java esperava a separação por ".".
    Desta forma foi possível customizar a desserialização do objeto fazendo o tratamento diretamente na entrada do mesmo.

Ponto 2 - Diferença nos valores do JSON para Planilha Excel
    Após alguns testes na solução implementada foi possível observar que ocorria uma diferença de valor nas composições
de código "98561" e "87286", pois alguns itens estão sem a propriedade "valorUnitario" preenchidas.
    Por esta razão segue link com o JSON atualizado com base no Excel para geração de um relatório correto:

JSON: https://drive.google.com/file/d/1C_6Eb-L3eaNYE6ZxMVL0aQrpMttq0LRl/view?usp=sharing


## Acessos da api

    Enviar uma requisição *POST* para o endpoint:

    `http://localhost:8080/orcamento`

    Passando por parâmetro o objeto json proporcionado para resolução do exercício.
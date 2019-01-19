# PROVA 3 - ROTEIRO DE IMPLEMENTAÇÃO

**Laboratório de Programação 2 - 2018.2**

[PROVA 3](https://docs.google.com/document/d/e/2PACX-1vQSNOjX2hO9e2i5-go3olzeQug1vwOqUaMSuTEgBvQCwuIPmcOMdC5D1qDION4ULXRW6qmSkAek0lLB/pub "PROVA 3")

<p align="center">
    <img src= "https://rest.unifacisa.edu.br/wp-content/uploads/2015/05/imagem-mat%C3%A9ria-Club-ludi.jpg">
</p>

O Clube LuLi é uma alternativa de entretenimento para a crianças e jovens nas férias escolares. O clube oferece aos seus associados oficinas educativas e uma diversificada loja de livros e jogos de tabuleiro.

Sua tarefa hoje é ajudar a implementar o back-end de um sistema para automatizar a loja virtual do Clube LuLi. Você deve fornecer uma **Façade**, que atenda aos requisitos listados a seguir, para que outra equipe implemente a interface com o usuário.

### Parte 1 - Gerência de Produtos

Os associados do clube podem se inscrever para participar de oficinas (musicais, gastronômicas, esportivas, etc), comprar livros (novos e usados) ou adquirir jogos de tabuleiro. Todos esses produtos devem ser cadastrados no sistema para posterior compra e consulta. Em comum, os produtos tem:

    - Nome (String): Identificador único do produto. Em uma tentativa de cadastro de um produto com mesmo nome, uma exceção deve ser lançada.
    - Categoria (String): Refere-se ao público alvo, pode ser Infantil ou Juvenil.
    - Valor (double): Usado para o cálculo do preço do produto.

O sistema, além do cadastro dos produtos, deve permitir, obter preço e exibir as informações de um produto específico. Considere que o nome do produto é o seu identificador único no sistema e deve ser passado como parâmetro para essas operações. Caso o Produto passado não exista no cadastro, uma exceção à sua escolha deve ser lançada.

A representação textual de um produto deve seguir o formato exemplo: "`[Oficina de Cupcake, Infantil, 100.0]`” Outro exemplo “`[Survive, Juvenil, 279.0]`”. Os valores são, respectivamente, _[nome, categoria, preço]_.

Métodos do sistema:
* String exibirProduto(String nome)
* double obterPreco(String nome)

Há especificidades entre os diferentes tipos de produtos que impactam no cálculo do seu preço. O preço a ser pago pelas oficinas depende de sua carga horária. Os livros vendidos no clube podem ser novos ou usados. Os livros usados tem um bom desconto. Todos os jogos infantis tem um desconto especial. A tabela que segue, mostra como deve ser feito o cálculo do preço dos produtos com base no seu valor e outros atributos:  

| Produto |        Atributos      | Cálculo do **preço** com base no atributo **valor** |
| :-----: | :------------------:  | :-------------------------------------------------: |
| Oficina | (double) cargahoraria |           preço = cargahoraria * **valor**          |
| Livro   | (String) estado, só pode ser  {"Novo", "Usado"} | Se estado é "Usado": preço = **valor** - 50% de **valor**; caso contrário, **preço = valor** |
| Jogo    | (String) categoria<sup>[1](#footnote-1)</sup>, só pode ser {"Infantil", "Juvenil"} | Se categoria "Infantil", preço = **valor** - 5% de **valor**; caso contrário, **preço = valor** |

Por este motivo, a adição de produtos deve ser distinta:
* void adicionaOficina(String nome, String categoria, double valor, double cargahoraria)
* void adicionaLivro(String nome, String categoria, double valor, String estado)
* void adicionaJogo(String nome, String categoria, double valor)

### Parte 2 - Carrinho de Compras

O sistema deve permitir a criação de carrinhos de compra, para representar as compras dos associados no Clube LuLi. Por hora, é suficiente que você crie um carrinho com um identificador único numérico. O sistema deve permitir a adição de Produtos em um carrinho de compras específico e posterior totalização do preço a ser pago. Os carrinhos tem um identificador único (id) que deve ser passado como parâmetro para as operações que o referenciam. Caso o Carrinho não exista ou o Produto a ser adicionado não esteja previamente cadastrado no sistema, exceções distintas devem ser lançadas.

Métodos do sistema:
* void criaCarrinho(int id)
* void adicionaProdutoAoCarrinho(int id, String nomeProduto)
* double totalizaCarrinho(int id)

### Parte 3 - Listagem de Produtos

O sistema permite que sejam emitidas listagens de todos os produtos já cadastrados, seguindo alguns critérios de ordenação: (1) ordem alfabética do nome do Produto, (2) ordem alfabética da categoria do Produto e (3) ordem crescente de Preço. Por padrão, a ordenação é feita da forma (1). Este critério pode ser alterado através de uma operação oferecida pelo sistema, com os parâmetros: "PRECO", para a forma (3) e "CATEGORIA", para a forma (2)  e "NOME", para a forma (1).  

Métodos do sistema:

* void configuraOrdenacao(String ord)
* String listar()

obs: Pode haver empates e não definimos aqui o critério de desempate.

A representação textual da listagem de Produtos deve ser em uma só linha e seguir o formato exemplo: "`[[Bang, Infantil, 47.5], [Harry Potter, Juvenil, 10.0], [Jogo do Contente, Infantil, 34.5], [Origami, Infantil, 80.0]]`".

### Parte 4 - Teste de Unidade

Faça testes de unidade para a(s) entidade(s) responsáveis pelo Carrinho e compras de produtos.

___________________________________

1. <a name="footnote-1"></a> categoria é um atributo válido para todos os Produtos, mas é relevante apenas para o cálculo do preço de Jogos.

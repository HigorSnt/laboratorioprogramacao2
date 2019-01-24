# SIMULADO - ROTEIRO DE IMPLEMENTAÇÃO

**Laboratório de Programação 2 - 2018.2**

[SIMULADO](https://docs.google.com/document/d/e/2PACX-1vTITS2LP7b7akegjffSWoaAVnIc7YtTYZVK_HeBqE6Cs2cVjDTQtFNwl7f-oyYjUZBjXDwzQ0ouy-qF/pub "SIMULADO")

Os quiosques de refeição self service da UFCG resolveram investir em tecnologia e oferecer o cardápio de refeições virtual. O cardápio será usado para informar aos clientes os itens para o almoço ou jantar disponíveis a cada dia. Você deve fazer parte da equipe de desenvolvedores desse programa e sua responsabilidade é:
1. Criar uma **classe que representa um item do cardápio**, com nome (arroz branco, feijão, frango assado, verdura na maionese, etc.) e calorias por porção (20, 100, 50, 0). Nesse caso, considera-se que é uma porção padrão pequena. Escreva o construtor e todos os métodos que você achar que devem ser escritos. Dois itens são iguais se tem o mesmo nome. A representação textual de um item deve mostrar seu nome e calorias por porção.
2. Criar uma **classe que representa o cardápio virtual**. O cardápio deve guardar o nome do estabelecimento e um array de itens. Ao criar um cardápio deve ser informado quantos itens aquele cardápio irá conter ou optar por criar um cardápio padrão com 5 itens. Escreva os métodos que achar que devem existir nesta classe. Não esqueça dos métodos:  
    a. adicionaItem(Item item) que adiciona um item no cardápio.  
    b. listaCardapio() retorna uma representação textual dos itens no cardápio numerados pela ordem de inserção no mesmo.  
    c. calcularCaloriasRefeicao(String[] refeicao, String tamanhoRefeicao) retorna a quantidade de calorias para a refeição especificada considerando que a refeição pode ser padrão (1 porção padrão de cada item), grande (2 porções de cada item) e mega (3 porções de cada item). Por exemplo,  
Digamos que o cardápio possui os seguintes itens:  
1 - arroz branco - 100 calorias/porção  
2 - arroz a grega - 200 calorias/porção  
3 - macarrao - 200 calorias/porção  
4 - feijoada - 150 calorias/porção  
5 - feijao verde - 90 calorias/porção  
6 - frango assado - 90 calorias/porção  
7 - bife - 100 calorias/porção  
8 - vinagrete - 0 calorias/porção  

String[] refeicao = {“arroz branco”, “feijoada”, “vinagrete”}

cardapio.calcularCaloriasRefeicao(refeicao, “grande”) irá retornar 250*2, ou seja, 500 calorias

3. **Lançar uma IllegalArgumentException** para o caso de ser passado um array de refeições inválido (com itens desconhecidos do cardápio) no cálculo de calorias por refeição.

4. Fazer os **testes de unidade com JUnit para a classe que representa o cardápio virtual.**

_Observação: você está livre para decidir que métodos e que atributos (além dos mencionados) devem estar presentes em suas classes.Decida que métodos acessadores e modificadores são necessários._
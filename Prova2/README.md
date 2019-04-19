# PROVA 2

**Laboratório de Programação 2 - 2018.2**

[PROVA 2](https://docs.google.com/document/d/e/2PACX-1vRGCz5GQ-_ZeyS8d0WSNOvvbmN42mgKZuovEZ6beU33cPZJ3pVlxX9tGkea5ffzPlHR2MAXWRdTiUtp/pub "PROVA 2")

<p align="center">
    <img src= "https://lh6.googleusercontent.com/BlL3RqF3e43ll0Ve3gpia7qUcy9_A9BjjKl23uAi_QpFKosIaI2R3nrTL-9kw0y9WQZHrHTqQ9wOxMyMRHlo9adoDcTTe9kDxI9oJYgDxeLuELgqv7f9YJqImvZlwmUikwc7koVa">
</p>

Sua tia é uma artista e confecciona **caixas decorativas personalizadas**. Para ajudar sua tia, você resolveu criar uma aplicação que gerencia o **estoque de caixas** já decoradas e personalizados. Não se preocupe com a interface com o usuário, seu primo vai fazer isso. Vocês vão apenas combinar sobre a classe fachada.  
Funcionalidades do sistema a ser criado:


1. **Cadastrar caixas decorativas no estoque**. Toda caixa decorativa tem uma descrição única (que sua tia usa para localizar a caixa), a personalização da caixa (que pode ser "arte em tecido", "colagem" ou "pintura à mão"), formato (que pode ser pentagonal, circular ou retangular) e as dimensões da tampa da caixa (importantes para calcular o preço). Essas dimensões mudam dependendo do formato da caixa:  
>> a. Pentagonal: lado (e altura calculada com base no lado);  
>> b. Retangular: lado1, lado2;  
>> c. Circular: raio do círculo;

Mais informações úteis sobre as caixas a serem cadastradas no estoque:

* Deve ser possível informar durante o cadastro a descrição única da caixa, a personalização da caixa, as dimensões da tampa da caixa, e deve ser possível redefinir a personalização da caixa.
* Caixas de mesmo formato, área de tampa e/ou personalização podem ser adicionadas, desde que tenham descrições únicas diferentes;
* Ao criar uma caixa de formato específico devem ser informadas as dimensões da tampa da caixa de acordo com o seu formato. São elas:
    * Pentagonal: lado;
    * Retangular: lado1, lado2;
    * Circular: raio do círculo;
* No caso do pentágono deve-se calcular a altura com base em seu lado, como sendo `(lado / 2 * √ 5 + 2 * √5 )/2`
* A representação em string de uma caixa decorativa é: `Caixa com <personalizacao> custa R$ <preco>. Formato <formato>.`
* Além do formato em si, a principal diferença entre as caixas de diferentes formatos é a forma de calcular o preço. O preço de cada formato é definido pela área necessária para personalizar a tampa da caixa, de forma que para as três formas é cobrado R$ 0,10 por centímetro quadrado (cm²) personalizado. As fórmulas são: **precoTotal = (0.1 * areaDaTampa)**. Veja abaixo como calcular essas áreas:
    * Pentagonal: `areaTotal = 5.0 * ( base * altura ) / 2.0`;
    * Retângular: `areaTotal = lado1 * lado2`;
    * Circular: `areaTotal = pi * raio² //pi = 3.14`;
* Você pode fazer uso de exceções para lidar com situações em que dimensões negativas ou zero forem passadas.


2. O estoque vai manter uma coleção de caixas personalizadas independente do seu formato e decoração específica. Além de cadastrar caixas no estoque, deve ser possível:  
>>a. **Modificar o tipo de personalização de uma caixa** específica identificada pela sua descrição única.  
>>b. **Remover (retornando boolean) uma caixa do estoque** (identificando essa caixa pela sua descrição única);  
>>c. **Obter o número de caixas no estoque**;  
>>d. **Consultar** se o estoque possui uma determinada caixa com uma personalização e formato específicos;  
>>e. **Retornar as caixas com uma personalização de interesse**, ordenadas pela descrição única da caixa;  
>>f. **Retornar as caixas com um formato de interesse**, ordenadas pela descrição única da caixa;  
>>g. **Calcular o total de rendimentos** que sua tia pode obter se ela vender todas as caixas do estoque.


3. Escreva **testes de unidade** para a classe mais alta da sua hierarquia de caixas decorativas.


4. Escreva uma **classe de fachada** a ser passada para o pessoal da interface gráfica.
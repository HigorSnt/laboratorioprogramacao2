# PROVA 1 - ROTEIRO DE IMPLEMENTAÇÃO

**Laboratório de Programação 2 - 2018.2**

A rede de estacionamentos LitaPark abriu uma filial em frente a UFCG e irá disponibilizar um amplo espaço, segurança, eficiência e comodidade para seus clientes. Nesse caso, O Sr. Lita julgou essencial informatizar a gerência do estacionamento e encomendou um protótipo aos estudantes de P2 e LP2 2018.2. A gerência do estacionamento inclui estacionar os carros nas vagas disponíveis, liberar uma vaga, informar sobre disponibilidade de vagas e calcular o valor devido pelo cliente ao liberar uma vaga. Para implementar esse sistema você deve seguir as orientações abaixo:

**Observações:**
* Iremos usar a classe LocalTime da api de Java para representar tempo, atente para o exemplo de uso dessa classe fornecido na prova;
* Você só precisa tratar as situações de erro definidas na parte 3.

### Parte 1

Você precisa criar **uma entidade para representar uma vaga do estacionamento**, com placa do carro ocupando a vaga, hora em que o carro foi estacionado, código do setor (ex. A, B, C) e posição (valor numérico, ex. 1, 2, 3,...). Ao criar uma vaga deve ser informado seu setor e posição. Deve ser possível acessar todas as informações sobre a vaga incluindo sua localização (combinação do setor e posição) e, o status da vaga, ou seja, se a vaga está ocupada (tem um carro estacionado nela) ou não. Quando um carro estacionar na vaga, será preciso atualizar a informação da vaga (placa do carro e hora de entrada), o mesmo ocorrerá quando o carro sair da vaga. Além disso, duas vagas são iguais se tiverem a mesma localização. A representação textual da vaga deve mostrar sua localização e status. Para representar a hora você pode usar a api de Java da seguinte forma:

```java
public class Main {
    public static void main (String[] args){
        //captura o tempo agora (hora, minuto, segundo...)
        LocalTime inicio = LocalTime.now();
        //retorna a hora associada a este objeto de tempo
        int hora = inicio.getHour();
        //retorna o minuto associado a este objeto de tempo
        int minuto = inicio.getMinute();
        //cria uma representação de tempo a partir de hora e minuto fornecidos como parametro
        LocalTime fim = LocalTime.of(hora+1, minuto+1);
        int intervaloDeTempo = fim.getHour() - inicio.getHour();
        System.out.println("Intervalo de tempo: " + intervaloDeTempo);
    }
}
```
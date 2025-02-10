package atividades.aula5_ex5.Cenario3;
/**
 *
 * @author Marcio de Arruda Fonseca
 */
public class Main {

    public static void main(String[] args) {
        // Criação do armazenamento de eventos
        EventStorage storage = new EventStorage();

        // Criando e iniciando múltiplos produtores
        for (int i = 0; i < 3; i++) {
            Producer producer = new Producer(storage);
            Thread thread = new Thread(producer);
            thread.start();
        }

        // Criando e iniciando múltiplos consumidores
        for (int i = 0; i < 3; i++) {
            Consumer consumer = new Consumer(storage);
            Thread thread = new Thread(consumer);
            thread.start();
        }
    }
}
/**
Cenário 3: Aumentando o Número de Produtores e Consumidores
Neste cenário, múltiplos produtores e consumidores operam simultaneamente, mas a sincronização garante que o comportamento seja correto.

Saída Esperada (Correta)

Set: 1
Set: 2
Set: 3
Get: 3: Wed Oct 25 10:00:00 GMT 2023
Set: 3
Get: 3: Wed Oct 25 10:00:01 GMT 2023
Set: 3
Set: 4
Get: 4: Wed Oct 25 10:00:02 GMT 2023
...
Set: 10
Get: 10: Wed Oct 25 10:00:50 GMT 2023
Set: 10
Get: 10: Wed Oct 25 10:00:51 GMT 2023
...
Get: 1: Wed Oct 25 10:01:00 GMT 2023

Explicação:
Mesmo com múltiplos produtores e consumidores, o tamanho do armazenamento nunca excede maxSize (10) e nunca fica negativo.
As threads são coordenadas corretamente usando wait() e notify().
A saída é consistente e previsível, sem erros.
*/

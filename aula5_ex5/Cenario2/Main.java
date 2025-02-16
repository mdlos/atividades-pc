package atividades.aula5_ex5.Cenario2;
/**
 *
 * @author Marcio de Arruda Fonseca
 */
public class Main {

    public static void main(String[] args) {
        // Criação do armazenamento de eventos
        EventStorage storage = new EventStorage();

        // Criando e iniciando a thread do produtor
        Producer producer = new Producer(storage);  // Instancia o produtor com o armazenamento
        Thread thread1 = new Thread(producer);  // Cria a thread para o produtor
        thread1.start();  // Inicia a thread do produtor

        // Criando e iniciando a thread do consumidor
        Consumer consumer = new Consumer(storage);  // Instancia o consumidor com o armazenamento
        Thread thread2 = new Thread(consumer);  // Cria a thread para o consumidor
        thread2.start();  // Inicia a thread do consumidor
    }
}

/**
Cenário 2: Com Uso de Condições Sincronizadas
Neste cenário, a sincronização garante que o produtor e o consumidor operem de forma coordenada. A saída será consistente e sem erros.

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
O tamanho do armazenamento nunca excede maxSize (10) e nunca fica negativo.
O produtor espera quando o armazenamento está cheio, e o consumidor espera quando o armazenamento está vazio.
A saída é consistente e previsível.
*/

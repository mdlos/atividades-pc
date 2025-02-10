package atividades.aula5_ex5.Cenario1;
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
Cenário 1: Sem Uso de Condições Sincronizadas
Neste cenário, como não há controle de concorrência, a saída será inconsistente e pode incluir erros. Abaixo estão exemplos de saídas possíveis:

Saída Esperada (Com Problemas)
Set: 1
Set: 2
Set: 3
Get: 3: Wed Oct 25 10:00:00 GMT 2023
Get: 2: Wed Oct 25 10:00:01 GMT 2023
Set: 3
Set: 4
Set: 11  // Erro: Tamanho excedeu maxSize (10)
Get: 10: Wed Oct 25 10:00:02 GMT 2023
Get: -1: null  // Erro: Tentativa de consumir de uma lista vazia
Set: 0
Set: 1
...
Exception in thread "Thread-1" java.lang.NullPointerException  // Erro devido à inconsistência

Explicação:
O produtor pode adicionar eventos mesmo quando o armazenamento está cheio, causando um tamanho maior que maxSize.
O consumidor pode tentar consumir eventos de uma lista vazia, resultando em null ou exceções.
A saída é imprevisível e inconsistente
*/

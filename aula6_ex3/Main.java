package atividades.aula6_ex3;

/**
 *
 * @author Marcio de Arruda Fonseca
 */

public class Main {
    public static void main(String[] args) {
        FileMock mock = new FileMock(101, 10);
        Buffer buffer = new Buffer(20);

        Producer producer = new Producer(mock, buffer);
        Thread threadProducer = new Thread(producer, "Producer");

        Consumer consumers[] = new Consumer[3];
        Thread threadConsumers[] = new Thread[3];
        for (int i = 0; i < 3; i++) {
            consumers[i] = new Consumer(buffer);
            threadConsumers[i] = new Thread(consumers[i], "Consumer " + i);
        }

        threadProducer.start();
        for (int i = 0; i < 3; i++) {
            threadConsumers[i].start();
        }
    }
}

        /*
         * Saídas durante a execução:
         *
         * 1. O produtor começa a inserir linhas no buffer.
         *    - Saída esperada:
         *      Producer: Linha inserida: 1
         *      Producer: Linha inserida: 2
         *      ...
         *
         * 2. Os consumidores começam a ler e processar as linhas do buffer.
         *    - Saída esperada:
         *      Consumer 0: Linha lida: 1
         *      Consumer 1: Linha lida: 2
         *      ...
         *
         * 3. Quando o buffer está cheio, o produtor aguarda até que haja espaço.
         *    - Saída esperada:
         *      (Nenhuma inserção ocorre até que os consumidores liberem espaço)
         *
         * 4. Quando o buffer está vazio, os consumidores aguardam até que haja novas linhas.
         *    - Saída esperada:
         *      (Nenhuma leitura ocorre até que o produtor insira novas linhas)
         *
         * 5. O processo continua até que todas as linhas sejam processadas.
         *    - Saída esperada:
         *      Mock: 0 (indica que todas as linhas foram lidas)
         *      (As threads dos consumidores terminam após processar todas as linhas)
         */

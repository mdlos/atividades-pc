package atividades.aula6_ex5;

/**
 *
 * @author Marcio de Arruda Fonseca
 */

/**
 * Classe principal que inicia o sistema de fila de impressão.
 */
public class Main {
    public static void main(String[] args) {
        PrintQueue printQueue = new PrintQueue(); // Cria uma fila de impressão

        // Cria 12 threads para simular trabalhos de impressão
        Thread thread[] = new Thread[12];
        for (int i = 0; i < 12; i++) {
            thread[i] = new Thread(new Job(printQueue), "Thread " + i);
        }

        // Inicia todas as threads
        for (int i = 0; i < 12; i++) {
            thread[i].start();
        }

        /*
         * Saídas durante a execução:
         *
         * 1. Apenas 3 threads podem acessar as impressoras simultaneamente.
         *    - Exemplo de saída:
         *      Thread 0 :: Início da impressão em: 12:34.567
         *      Thread 1 :: Início da impressão em: 12:34.567
         *      Thread 2 :: Início da impressão em: 12:34.567
         *      Thread 0: PrintQueue: Imprimindo um trabalho na impressora 0 durante 5 segundos
         *      Thread 1: PrintQueue: Imprimindo um trabalho na impressora 1 durante 3 segundos
         *      Thread 2: PrintQueue: Imprimindo um trabalho na impressora 2 durante 7 segundos
         *
         * 2. Quando uma thread termina a impressão, outra thread é liberada para acessar uma impressora.
         *    - Exemplo de saída:
         *      Thread 1 :: Término da impressão em: 12:37.567
         *      Thread 3 :: Início da impressão em: 12:37.567
         *      Thread 3: PrintQueue: Imprimindo um trabalho na impressora 1 durante 4 segundos
         *
         * 3. O processo continua até que todas as threads tenham terminado de imprimir.
         *    - Exemplo de saída final:
         *      Thread 11 :: Término da impressão em: 12:50.123
         */
    }
}

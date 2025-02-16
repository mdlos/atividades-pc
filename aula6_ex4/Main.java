package atividades.aula6_ex4;

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

        // Cria 10 threads para simular trabalhos de impressão
        Thread thread[] = new Thread[10];
        for (int i = 0; i < 10; i++) {
            thread[i] = new Thread(new Job(printQueue), "Thread " + i);
        }

        // Inicia todas as threads
        for (int i = 0; i < 10; i++) {
            thread[i].start();
        }

        /*
         * Saídas durante a execução:
         *
         * 1. Apenas 2 threads podem acessar o recurso de impressão simultaneamente.
         *    - Exemplo de saída:
         *      Thread 0 :: Início da impressão em: 12:34.567
         *      Thread 1 :: Início da impressão em: 12:34.567
         *      Thread 0: PrintQueue: Imprimindo um trabalho durante 5 segundos
         *      Thread 1: PrintQueue: Imprimindo um trabalho durante 3 segundos
         *
         * 2. Quando uma thread termina a impressão, outra thread é liberada para acessar o recurso.
         *    - Exemplo de saída:
         *      Thread 1 :: Término da impressão em: 12:37.567
         *      Thread 2 :: Início da impressão em: 12:37.567
         *      Thread 2: PrintQueue: Imprimindo um trabalho durante 7 segundos
         *
         * 3. O processo continua até que todas as threads tenham terminado de imprimir.
         *    - Exemplo de saída final:
         *      Thread 9 :: Término da impressão em: 12:50.123
         */
    }
}
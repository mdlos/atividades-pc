package atividades.aula6_ex2;

/**
 *
 * @author Marcio de Arruda Fonseca
 */


public class Main {
    public static void main(String[] args) {
        // Cria uma instância da fila de impressão (recurso compartilhado)
        PrintQueue printQueue = new PrintQueue();

        // Cria um array de 10 threads para simular trabalhos de impressão
        Thread thread[] = new Thread[10];
        for (int i = 0; i < 10; i++) {
            // Cria uma thread com um trabalho (Job) e atribui um nome à thread
            thread[i] = new Thread(new Job(printQueue), "Thread " + i);
        }

        // Inicia as threads
        for (int i = 0; i < 10; i++) {
            thread[i].start(); // Inicia a thread
            try {
                Thread.sleep(100); // Pausa entre o início das threads para simular concorrência
            } catch (InterruptedException e) {
                e.printStackTrace(); // Trata a exceção caso a thread seja interrompida
            }
        }

        /*
         * Saídas durante a execução:
         *
         * 1. As threads tentam acessar a fila de impressão em ordem (FIFO).
         *    - Saída esperada:
         *      Thread 0: Going to print a job
         *      Thread 1: Going to print a job
         *      Thread 2: Going to print a job
         *      ...
         *
         * 2. O lock justo (fair = true) garante que as threads sejam atendidas na ordem de chegada.
         *    - Saída esperada:
         *      Thread 0: PrintQueue: Printing a Job during X seconds in first code block
         *      Thread 0: PrintQueue: Printing a Job during Y seconds in second code block
         *      Thread 0: The document has been printed
         *      Thread 1: PrintQueue: Printing a Job during Z seconds in first code block
         *      ...
         *
         * 3. Nenhuma thread fica bloqueada por longos períodos devido à política FIFO.
         *    - Saída esperada:
         *      Todas as threads conseguem imprimir seus trabalhos sem bloqueios excessivos.
         *
         * 4. Comparação com lock não justo (fair = false):
         *    - Com lock não justo, as threads podem ser atendidas em uma ordem diferente da chegada.
         *    - Isso pode resultar em algumas threads sendo privilegiadas, enquanto outras ficam bloqueadas por mais tempo.
         *
         * 5. Cenários de teste:
         *    - Teste com 10 threads e lock justo: Verifique se a ordem de execução segue FIFO.
         *    - Teste com 10 threads e lock não justo: Observe se algumas threads são privilegiadas.
         *    - Aumente o número de threads para testar o impacto da contenção no desempenho.
         *
         * Observações:
         * - O lock justo garante que as threads sejam atendidas na ordem de chegada, mas pode reduzir o desempenho devido à sobrecarga de gerenciamento.
         * - O lock não justo pode ser mais eficiente, mas pode resultar em starvation (threads bloqueadas por longos períodos).
         */
    }
}

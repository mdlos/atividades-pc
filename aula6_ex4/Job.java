package atividades.aula6_ex4;

/**
 *
 * @author Marcio de Arruda Fonseca
 */

/**
 * Classe que representa uma tarefa de impressão.
 * Cada instância desta classe é executada em uma thread separada.
 */
public class Job implements Runnable {
    private PrintQueue printQueue; // Fila de impressão compartilhada

    public Job(PrintQueue printQueue) {
        this.printQueue = printQueue;
    }

    @Override
    public void run() {
        // Simula a execução de um trabalho de impressão
        printQueue.printJob(new Object()); // Passa um objeto fictício para impressão
    }
}
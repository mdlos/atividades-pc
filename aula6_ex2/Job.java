package atividades.aula6_ex2;

/**
 *
 * @author Marcio de Arruda Fonseca
 */


public class Job implements Runnable {

    private PrintQueue printQueue; // Recurso compartilhado (fila de impressão)

    // Construtor que recebe a fila de impressão
    public Job(PrintQueue printQueue) {
        this.printQueue = printQueue;
    }

    @Override
    public void run() {
        // Mensagem indicando que a thread está tentando imprimir um trabalho
        System.out.printf("%s: Going to print a job\n", Thread.currentThread().getName());
        
        // Chama o método de impressão na fila compartilhada
        printQueue.printJob(new Object());
        
        // Mensagem indicando que o trabalho foi impresso
        System.out.printf("%s: The document has been printed\n", Thread.currentThread().getName());
    }
}

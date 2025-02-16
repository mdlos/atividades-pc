package atividades.aula5_ex6.Cenario2;
/**
 *
 * @author Marcio de Arruda Fonseca
 */
public class Job implements Runnable {  // Declara uma classe chamada Job que implementa a interface Runnable
    private PrintQueue printQueue;  // Atributo privado que referencia uma fila de impressão

    public Job(PrintQueue printQueue) {  // Construtor que recebe uma fila de impressão como parâmetro
        this.printQueue = printQueue;  // Inicializa o atributo printQueue
    }

    @Override
    public void run() {  // Método que será executado quando a thread iniciar
        //System.out.printf("%s: Indo imprimir um documento\n", Thread.currentThread().getName());
        printQueue.printJob(new Object());  // Chama o método printJob da fila de impressão, passando um objeto genérico
        //System.out.printf("%s: O documento foi impresso\n", Thread.currentThread().getName());
    }
}


package atividades.aula6_ex2;

/**
 *
 * @author Marcio de Arruda Fonseca
 */


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintQueue {

    // Lock com justeza ativada (fair = true)
    private final Lock queueLock = new ReentrantLock(true);

    // Método para imprimir um trabalho
    public void printJob(Object document) {
        // Bloqueia o lock para garantir exclusividade
        queueLock.lock();

        try {
            // Simula o tempo de impressão com um valor aleatório
            Long duration = (long) (Math.random() * 10000);
            System.out.printf("%s: PrintQueue: Printing a Job during %d seconds in first code block\n",
                    Thread.currentThread().getName(), (duration / 1000));
            
            // Pausa a thread para simular o tempo de impressão
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace(); // Trata a exceção caso a thread seja interrompida
        } finally {
            queueLock.unlock(); // Libera o lock após a conclusão
        }

        // Segundo bloco de impressão (simula uma segunda etapa de processamento)
        queueLock.lock();
        try {
            Long duration = (long) (Math.random() * 10000);
            System.out.printf("%s: PrintQueue: Printing a Job during %d seconds in second code block\n",
                    Thread.currentThread().getName(), (duration / 1000));
            
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            queueLock.unlock(); // Libera o lock após a conclusão
        }
    }
}

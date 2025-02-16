package atividades.aula6_ex4;

/**
 *
 * @author Marcio de Arruda Fonseca
 */

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Classe que representa uma fila de impressão com controle de acesso usando Semaphore.
 */
public class PrintQueue {
    private final Semaphore semaphore; // Semáforo para controlar o acesso ao recurso
    private final SimpleDateFormat sdf = new SimpleDateFormat("mm:ss.SSS"); // Formato de data para logs

    public PrintQueue() {
        // Inicializa o semáforo com 2 permissões, permitindo que 2 threads acessem o recurso simultaneamente
        semaphore = new Semaphore(2);
    }

    /**
     * Método que simula a impressão de um documento.
     * @param document Documento a ser impresso (não utilizado no exemplo).
     */
    public void printJob(Object document) {
        String name = Thread.currentThread().getName(); // Nome da thread atual
        try {
            semaphore.acquire(); // Adquire uma permissão do semáforo (bloqueia se não houver permissões disponíveis)
            
            // Registra o horário de início da impressão
            System.out.println(name + " :: Início da impressão em: " + sdf.format(new Date()));

            // Simula o tempo de impressão (entre 0 e 9 segundos)
            long duration = (long) (Math.random() * 10);
            System.out.printf("%s: PrintQueue: Imprimindo um trabalho durante %d segundos\n", name, duration);

            TimeUnit.SECONDS.sleep(duration); // Simula o tempo de impressão
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Registra o horário de término da impressão
            System.out.println(name + " :: Término da impressão em: " + sdf.format(new Date()) + "\r\n");
            semaphore.release(); // Libera a permissão do semáforo
        }
    }
}
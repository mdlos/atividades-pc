package atividades.aula6_ex5;

/**
 *
 * @author Marcio de Arruda Fonseca
 */


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Classe que representa uma fila de impressão com controle de acesso a múltiplas impressoras.
 */
public class PrintQueue {
    private Semaphore semaphore; // Semáforo para controlar o acesso às impressoras
    private boolean freePrinters[]; // Array para rastrear a disponibilidade das impressoras
    private Lock lockPrinters; // Lock para garantir acesso seguro ao array de impressoras
    private final SimpleDateFormat sdf = new SimpleDateFormat("mm:ss.SSS"); // Formato de data para logs

    public PrintQueue() {
        semaphore = new Semaphore(3); // Permite que até 3 threads acessem as impressoras simultaneamente
        freePrinters = new boolean[3]; // 3 impressoras disponíveis
        for (int i = 0; i < 3; i++) {
            freePrinters[i] = true; // Inicializa todas as impressoras como disponíveis
        }
        lockPrinters = new ReentrantLock(); // Lock para sincronizar o acesso ao array de impressoras
    }

    /**
     * Método que simula a impressão de um documento.
     * Documento a ser impresso (não utilizado no exemplo).
     */
    public void printJob(Object document) {
        String name = Thread.currentThread().getName(); // Nome da thread atual
        try {
            semaphore.acquire(); // Adquire uma permissão do semáforo (bloqueia se não houver permissões disponíveis)
            
            // Registra o horário de início da impressão
            System.out.println(name + " :: Início da impressão em: " + sdf.format(new Date()));

            // Obtém uma impressora disponível
            int assignedPrinter = getPrinter();

            // Simula o tempo de impressão (entre 0 e 9 segundos)
            Long duration = (long) (Math.random() * 10);
            System.out.printf("%s: PrintQueue: Imprimindo um trabalho na impressora %d durante %d segundos\n",
                    name, assignedPrinter, duration);
            TimeUnit.SECONDS.sleep(duration);

            // Libera a impressora após o uso
            freePrinters[assignedPrinter] = true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Registra o horário de término da impressão
            System.out.println(name + " :: Término da impressão em: " + sdf.format(new Date()) + "\r\n");

            semaphore.release(); // Libera a permissão do semáforo
        }
    }

    /**
     * Método para obter uma impressora disponível.
     */
    private int getPrinter() {
        int ret = -1; // Valor padrão para indicar que nenhuma impressora está disponível

        try {
            lockPrinters.lock(); // Bloqueia o acesso ao array de impressoras

            // Procura por uma impressora disponível
            for (int i = 0; i < freePrinters.length; i++) {
                if (freePrinters[i]) {
                    ret = i; // Atribui a impressora disponível
                    freePrinters[i] = false; // Marca a impressora como ocupada
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lockPrinters.unlock(); // Libera o acesso ao array de impressoras
        }

        return ret; // Retorna o índice da impressora disponível
    }
}

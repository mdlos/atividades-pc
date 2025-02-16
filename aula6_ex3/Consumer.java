package atividades.aula6_ex3;

import java.util.Random;

/**
 *
 * @author Marcio de Arruda Fonseca
 */
/**
 * Classe que representa um consumidor de linhas do buffer.
 */
public class Consumer implements Runnable {
    private Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (buffer.hasPendingLines()) {
            String line = buffer.remove();
            if (line != null) {
                processLine(line);
            }
        }
    }

    /**
     * Simula o processamento de uma linha.
     */
    private void processLine(String line) {
        try {
            Random random = new Random();
            Thread.sleep(random.nextInt(100)); // Simula um tempo de processamento
            System.out.println("Linha processada: " + line);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


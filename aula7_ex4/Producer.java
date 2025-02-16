package atividades.aula7_ex4;

/**
 *
 * @author Marcio de Arruda Fonseca
 */

import java.util.List;
import java.util.concurrent.Exchanger;

/**
 * Classe Producer que implementa Runnable para produzir dados e trocá-los com o Consumer.
 */
public class Producer implements Runnable {
    private List<String> buffer; // Buffer para armazenar os dados
    private final Exchanger<List<String>> exchanger; // Exchanger para troca de dados

    public Producer(List<String> buffer, Exchanger<List<String>> exchanger) {
        this.buffer = buffer;
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        int cycle = 1;

        for (int i = 0; i < 10; i++) {
            System.out.printf("Producer: Ciclo %d\n", cycle);

            // Produz 10 mensagens e as adiciona ao buffer
            for (int j = 0; j < 10; j++) {
                String message = "Evento " + ((i * 10) + j);
                System.out.printf("Producer: Produziu %s\n", message);
                buffer.add(message);
            }

            try {
                // Troca o buffer com o Consumer
                buffer = exchanger.exchange(buffer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.printf("Producer: %d mensagens trocadas\n", buffer.size());
            cycle++;
        }
    }
}

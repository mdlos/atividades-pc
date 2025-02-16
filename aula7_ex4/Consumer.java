package atividades.aula7_ex4;

/**
 *
 * @author Marcio de Arruda Fonseca
 */

import java.util.List;
import java.util.concurrent.Exchanger;

/**
 * Classe Consumer que implementa Runnable para consumir dados trocados com o Producer.
 */
public class Consumer implements Runnable {
    private List<String> buffer; // Buffer para armazenar os dados
    private final Exchanger<List<String>> exchanger; // Exchanger para troca de dados

    public Consumer(List<String> buffer, Exchanger<List<String>> exchanger) {
        this.buffer = buffer;
        this.exchanger = exchanger;
    }

    @Override
    public void run() {
        int cycle = 1;

        for (int i = 0; i < 10; i++) {
            System.out.printf("Consumer: Ciclo %d\n", cycle);

            try {
                // Troca o buffer com o Producer
                buffer = exchanger.exchange(buffer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.printf("Consumer: %d mensagens recebidas\n", buffer.size());

            // Processa as mensagens no buffer
            for (int j = 0; j < 10; j++) {
                String message = buffer.get(0);
                System.out.printf("Consumer: Consumiu %s\n", message);
                buffer.remove(0); // Remove a mensagem do buffer
            }

            cycle++;
        }
    }
}

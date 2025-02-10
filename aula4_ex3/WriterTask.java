package atividades.aula4_ex3;

import java.util.Date;
import java.util.Deque;
import java.util.concurrent.TimeUnit;

/**
 * Classe responsável por gerar eventos e adicioná-los a uma fila compartilhada.
 * Cada evento contém a data e uma mensagem identificando a thread que o criou.
  * @author Márcio de Arruda Fonseca
 * @version 1.0
 */
public class WriterTask implements Runnable {
    private Deque<Event> deque; // Fila onde os eventos serão armazenados

    /**
     * Construtor da classe WriterTask.
     * @param deque {@link Deque} que armazenará os eventos gerados.
     */
    public WriterTask(Deque<Event> deque) {
        this.deque = deque;
    }

    /**
     * Método executado pela thread para gerar eventos periodicamente.
     * Cada evento é criado e adicionado à frente da fila a cada segundo.
     */
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            Event event = new Event();
            event.setDate(new Date()); // Define a data atual no evento
            event.setEvent(String.format("A thread %s gerou um evento => %s",
                    Thread.currentThread().getId(), String.valueOf(event.getDate())));

            deque.addFirst(event); // Adiciona o evento no início da fila

            try {
                // Aguarda 1 segundo antes de gerar o próximo evento
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


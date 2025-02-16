package atividades.aula4_ex3;

import java.util.Date;
import java.util.Deque;

/**
 * Classe CleanerTask
 * Responsável por limpar eventos antigos da fila de eventos.
 * Esta classe estende Thread e executa periodicamente a remoção de eventos
 * que ultrapassam um determinado tempo limite.
  * @author Márcio de Arruda Fonseca
 * @version 1.0
 */
public class CleanerTask extends Thread {
    private Deque<Event> deque; // Fila de eventos

    /**
     * Construtor da classe CleanerTask.
     *
     * @param deque Fila de eventos compartilhada entre as threads
     */
    public CleanerTask(Deque<Event> deque) {
        this.deque = deque;
        // Define esta thread como um daemon, para que ela não impeça a JVM de terminar
        setDaemon(true);
    }

    /**
     * Método run() executado quando a thread é iniciada.
     * Ele verifica e remove eventos antigos da fila a cada segundo.
     */
    @Override
    public void run() {
        while (true) {
            Date date = new Date(); // Captura a data e hora atual
            clean(date); // Executa a limpeza dos eventos
            try {
                // Intervalo de verificação de 1 segundo
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Método responsável por remover eventos com mais de 10 segundos na fila.
     *
     * @param date Data e hora atuais para comparar com os eventos na fila.
     */
    private void clean(Date date) {
        long difference;
        boolean delete;

        // Verifica se a fila está vazia
        if (deque.size() == 0) {
            return;
        }

        delete = false;
        do {
            Event e = deque.getLast(); // Obtém o evento mais antigo da fila
            difference = date.getTime() - e.getDate().getTime(); // Calcula a diferença de tempo
            
            // Se o evento tiver mais de 10 segundos, remove-o da fila
            if (difference > 10000) {
                System.out.printf("%s Limpador: %s\n", String.valueOf(new Date()), e.getEvent());
                deque.removeLast(); // Remove o evento da fila
                delete = true;
            }
        } while (difference > 10000); // Continua removendo enquanto houver eventos antigos

        // Exibe o tamanho atualizado da fila se houve remoção de eventos
        if (delete) {
            System.out.printf("Limpador: Tamanho da fila: %d\n", deque.size());
        }
    }
}


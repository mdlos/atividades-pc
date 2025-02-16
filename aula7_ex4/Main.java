package atividades.aula7_ex4;

/**
 *
 * @author Marcio de Arruda Fonseca
 */

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

public class Main {
    public static void main(String[] args) {
        // Cria dois buffers para troca de dados
        List<String> buffer1 = new ArrayList<>();
        List<String> buffer2 = new ArrayList<>();

        // Cria um Exchanger para troca de buffers entre Producer e Consumer
        Exchanger<List<String>> exchanger = new Exchanger<>();

        // Cria as tarefas Producer e Consumer
        Producer producer = new Producer(buffer1, exchanger);
        Consumer consumer = new Consumer(buffer2, exchanger);

        // Cria e inicia as threads
        Thread threadProducer = new Thread(producer);
        Thread threadConsumer = new Thread(consumer);

        threadProducer.start();
        threadConsumer.start();

        /*
         * Saída esperada (exemplo):
         * Producer: Ciclo 1
         * Producer: Produziu Evento 0
         * Producer: Produziu Evento 1
         * ...
         * Producer: Produziu Evento 9
         * Consumer: Ciclo 1
         * Producer: 0 mensagens trocadas
         * Consumer: 10 mensagens recebidas
         * Consumer: Consumiu Evento 0
         * Consumer: Consumiu Evento 1
         * ...
         * Consumer: Consumiu Evento 9
         *
         * Producer: Ciclo 2
         * Producer: Produziu Evento 10
         * Producer: Produziu Evento 11
         * ...
         * Producer: Produziu Evento 19
         * Consumer: Ciclo 2
         * Producer: 0 mensagens trocadas
         * Consumer: 10 mensagens recebidas
         * Consumer: Consumiu Evento 10
         * Consumer: Consumiu Evento 11
         * ...
         * Consumer: Consumiu Evento 19
         *
         * ...
         *
         * (Repete até o ciclo 10)
         */
    }
}

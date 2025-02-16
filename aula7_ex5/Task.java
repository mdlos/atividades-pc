package atividades.aula7_ex5;

/**
 *
 * @author Marcio de Arruda Fonseca
 */

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Classe Task que implementa Runnable para simular uma tarefa.
 */
public class Task implements Runnable {
    private Date initDate; // Data de criação da tarefa
    private String name;   // Nome da tarefa

    public Task(String name) {
        this.initDate = new Date();
        this.name = name;
    }

    @Override
    public void run() {
        // Exibe informações sobre a tarefa
        System.out.printf("%s: Tarefa %s: Criada em: %s\n", Thread.currentThread().getName(), name, initDate);
        System.out.printf("%s: Tarefa %s: Iniciada em: %s\n", Thread.currentThread().getName(), name, new Date());

        // Simula o processamento da tarefa
        try {
            Long duration = (long) (Math.random() * 10); // Duração aleatória entre 0 e 10 segundos
            System.out.printf("%s: Tarefa %s: Executando por %d segundos\n", Thread.currentThread().getName(), name, duration);
            TimeUnit.SECONDS.sleep(duration); // Pausa a thread para simular o processamento
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Exibe a conclusão da tarefa
        System.out.printf("%s: Tarefa %s: Concluída em: %s\n", Thread.currentThread().getName(), name, new Date());
    }
}

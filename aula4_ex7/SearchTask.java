package atividades.aula4_ex7;

/**
 * 
 * Autor: Márcio de Arruda Fonseca
 */

import java.util.Date;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class SearchTask implements Runnable {
    // Objeto Result que será atualizado com o nome da thread que executou a tarefa
    private Result result;

    public SearchTask(Result result) {
        this.result = result;
    }

    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.printf("Thread %s: Start\n", name);
        try {
            doTask();
            // Atualiza o resultado com o nome da thread
            result.setName(name);
        } catch (InterruptedException e) {
            System.out.printf("Thread %s: Interrupted\n", name);
            return;
        }
        System.out.printf("Thread %s: End\n", name);
    }

    /**
     * Simula uma tarefa que leva um tempo aleatório para ser executada
     */
    private void doTask() throws InterruptedException {
        Random random = new Random(new Date().getTime());
        int value = (int) (random.nextDouble() * 100);
        System.out.printf("Thread %s: %d\n", Thread.currentThread().getName(), value);
        TimeUnit.SECONDS.sleep(value); // Simula o tempo de processamento
    }
}

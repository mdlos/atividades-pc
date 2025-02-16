package atividades.aula6_ex6;

/**
 *
 * @author Marcio de Arruda Fonseca
 */

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Videoconference implements Runnable {
    private final CountDownLatch controller;
    private final CyclicBarrier barrier; // Adicionado para sincronização adicional

    public Videoconference(int number) {
        // Inicializa o CountDownLatch com o número de participantes
        this.controller = new CountDownLatch(number);
        // Inicializa o CyclicBarrier com o número de participantes e uma ação de finalização
        this.barrier = new CyclicBarrier(number, () -> {
            System.out.println("\nAll participants are ready. Starting the main event...");
        });
    }

    /**
     * Método chamado quando um participante chega.
     */
    public void arrive(String name) {
        System.out.printf("%s has arrived.\n", name);
        // Decrementa o CountDownLatch
        controller.countDown();
        System.out.printf("VideoConference: Waiting for %d participants.\n", controller.getCount());

        try {
            // Usa o CyclicBarrier para sincronizar os participantes
            barrier.await();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        System.out.printf("VideoConference: Initialization: %d participants.\n\n", controller.getCount());

        try {
            // Aguarda até que todos os participantes cheguem (CountDownLatch)
            controller.await();

            // Mensagem de início da videoconferência
            System.out.printf("\nVideoConference: All the participants have come\n");
            System.out.printf("VideoConference: Let's start...\n");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
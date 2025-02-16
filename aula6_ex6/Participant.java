package atividades.aula6_ex6;

/**
 *
 * @author Marcio de Arruda Fonseca
 */

import java.util.concurrent.TimeUnit;

public class Participant implements Runnable {
    private Videoconference conference;
    private String name;

    public Participant(Videoconference conference, String name) {
        this.conference = conference;
        this.name = name;
    }

    @Override
    public void run() {
        // Simula um tempo aleatório de chegada do participante
        Long duration = (long) (Math.random() * 10);
        try {
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Notifica a videoconferência que o participante chegou
        conference.arrive(name);
    }
}
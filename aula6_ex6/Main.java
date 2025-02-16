package atividades.aula6_ex6;

/**
 *
 * @author Marcio de Arruda Fonseca
 */

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        // Cria uma videoconferência com 10 participantes
        Videoconference conference = new Videoconference(10);

        // Inicia a thread da videoconferência
        Thread threadConference = new Thread(conference);
        threadConference.start();

        // Cria e inicia 10 threads de participantes
        for (int i = 0; i < 10; i++) {
            Participant p = new Participant(conference, "Participant " + i);
            Thread t = new Thread(p);
            t.start();
        }
    }
}

/**

Saidas: 

Cenário 1: Execução Básica
Descrição: Execução do código com 10 participantes.

Resultado Esperado: Todos os participantes chegam, a barreira é alcançada, e a conferência começa.

Saída Esperada:

VideoConference: Initialization: 10 participants.

Participant 0 has arrived.
VideoConference: Waiting for 9 participants.
Participant 1 has arrived.
VideoConference: Waiting for 8 participants.
...
Participant 9 has arrived.
VideoConference: Waiting for 0 participants.

VideoConference: All the participants have come
VideoConference: Let's start...
All participants have reached the barrier. Starting the conference...
Participant 0 has passed the barrier and is ready to start.
Participant 1 has passed the barrier and is ready to start.
...
Participant 9 has passed the barrier and is ready to start.

----

Cenário 2: Atraso na Chegada dos Participantes
Descrição: Um participante chega com um atraso significativo.

Resultado Esperado: A conferência só começa após todos os participantes chegarem, incluindo o atrasado.

Saída Esperada:

VideoConference: Initialization: 10 participants.

Participant 0 has arrived.
VideoConference: Waiting for 9 participants.
...
Participant 8 has arrived.
VideoConference: Waiting for 1 participants.
Participant 9 has arrived. (Atrasado)
VideoConference: Waiting for 0 participants.

VideoConference: All the participants have come
VideoConference: Let's start...
All participants have reached the barrier. Starting the conference...
Participant 0 has passed the barrier and is ready to start.
...
Participant 9 has passed the barrier and is ready to start.

------

Cenário 3: Menos Participantes que o Esperado
Descrição: Menos participantes são criados do que o número esperado.

Resultado Esperado: A conferência nunca começa, pois o CountDownLatch não chega a zero.

Saída Esperada:

VideoConference: Initialization: 10 participants.

Participant 0 has arrived.
VideoConference: Waiting for 9 participants.
...
(A execução fica parada esperando mais participantes)

*/

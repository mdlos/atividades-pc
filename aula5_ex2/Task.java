package atividades.aula5_ex2;

/**
 *
 * @author Marcio de Arruda Fonseca
 */
import java.util.concurrent.TimeUnit;

public class Task implements Runnable {

    @Override
    public void run() {
        try {
            // Faz a thread dormir por 1 segundo
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            // Captura e imprime a exceção caso a thread seja interrompida durante o sono
            e.printStackTrace();
        }
    }
}

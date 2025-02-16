package Atividades.aula4_ex1;

import java.util.Date; // Importa a classe Date para trabalhar com datas e horas
import java.util.concurrent.TimeUnit; // Importa a classe TimeUnit para manipular unidades de tempo

/**
 * Classe RelogioArquivo que implementa a interface Runnable.
 * Esta classe é projetada para ser executada em uma thread separada e imprime
 * a data e hora atuais em intervalos de 1 segundo.
  *
 * @author Márcio de Arruda Fonseca
 * @version 1.0
 */
public class RelogioArquivo implements Runnable {

    /**
     * Método run() sobrescrito da interface Runnable.
     * Este método é executado quando a thread é iniciada.
     * Ele imprime a data e hora atuais 10 vezes, com um intervalo de 1 segundo entre cada impressão.
     * Se a thread for interrompida, uma mensagem é exibida e a execução é finalizada.
     */
    @Override
    public void run() {
        // Loop que executa 10 iterações
        for (int i = 0; i < 10; i++) {
            // Imprime a data e hora atuais no console
            System.out.printf("%s\n", new Date());
            try {
                // Pausa a execução da thread por 1 segundo
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                // Exibe uma mensagem se a thread for interrompida
                System.out.printf("O RelogioArquivo foi interrompido\n");
                // Finaliza a execução da thread
                return;
            }
        }
    }
}

package atividades.aula8_ex6;


/**
 *
 * @author Marcio de Arruda Fonseca
 */

import java.util.concurrent.Callable;

public class Task implements Callable<String> {

    @Override
    public String call() throws Exception {
        // Executa um loop infinito, imprimindo uma mensagem a cada 100ms
        while (true) {
            System.out.printf("Task: Test\n");
            Thread.sleep(100); // Simula um processamento
        }
    }
}

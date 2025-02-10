package atividades.aula5_ex2;
/**
 *
 * @author Marcio de Arruda Fonseca
 */

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        // Cria uma instância da tarefa que será executada pelas threads
        Task task = new Task();

        System.out.printf("Iniciando as Threads\n");

        // Cria e inicia 5 threads manualmente
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(task, "Thread_" + i);
            thread.start();
        }

        System.out.printf("Todas as threads foram criadas e iniciadas.\n");
    }
}
    /**
      Cenário 1: Sem Uso de ThreadFactory
      Saída esperada:
      Iniciando as Threads
      Todas as threads foram criadas e iniciadas.
     */

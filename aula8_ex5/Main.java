package atividades.aula8_ex5;


/**
 *
 * @author Marcio de Arruda Fonseca
 */

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        // Cria um ScheduledExecutorService com um pool de 1 thread
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        // Exibe o horário de início da execução
        System.out.printf("Main: Iniciando em: %s\n", new Date());

        // Cria uma tarefa
        Task task = new Task("Task");

        // Agenda a tarefa para ser executada repetidamente com um atraso inicial de 1 segundo e um intervalo de 2 segundos
        ScheduledFuture<?> result = executor.scheduleAtFixedRate(task, 1, 2, TimeUnit.SECONDS);

        // Monitora o atraso restante para a próxima execução da tarefa
        for (int i = 0; i < 10; i++) {
            System.out.printf("Main: Atraso: %d ms\n", result.getDelay(TimeUnit.MILLISECONDS));
            try {
                // Aguarda 500ms antes de verificar novamente
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Encerra o executor
        executor.shutdown();
        System.out.printf("Main: Sem mais tarefas em: %s\n", new Date());

        try {
            // Aguarda 5 segundos para garantir que todas as tarefas sejam concluídas
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Exibe o horário de término da execução
        System.out.printf("Main: Finalizado em: %s\n", new Date());

        /*
        Saídas esperadas para diferentes cenários:

        Cenário 1: Execução com intervalo de 2 segundos
        Main: Iniciando em: Wed May 15 15:32:42 CST 2013
        Main: Atraso: 999 ms
        Main: Atraso: 499 ms
        Main: Atraso: 0 ms
        Task: Executado em: Wed May 15 15:32:45 CST 2013
        Main: Atraso: 1498 ms
        Main: Atraso: 998 ms
        Main: Atraso: 498 ms
        Main: Atraso: -1 ms
        Task: Executado em: Wed May 15 15:32:47 CST 2013
        Main: Atraso: 1498 ms
        Main: Atraso: 998 ms
        Main: Atraso: 498 ms
        Task: Executado em: Wed May 15 15:32:49 CST 2013
        Main: Sem mais tarefas em: Wed May 15 15:32:49 CST 2013
        Main: Finalizado em: Wed May 15 15:32:54 CST 2013

        Cenário 2: Execução com intervalo de 3 segundos
        Main: Iniciando em: Wed May 15 15:40:00 CST 2013
        Main: Atraso: 999 ms
        Main: Atraso: 499 ms
        Main: Atraso: 0 ms
        Task: Executado em: Wed May 15 15:40:03 CST 2013
        Main: Atraso: 2998 ms
        Main: Atraso: 2498 ms
        Main: Atraso: 1998 ms
        Main: Atraso: 1498 ms
        Main: Atraso: 998 ms
        Main: Atraso: 498 ms
        Task: Executado em: Wed May 15 15:40:06 CST 2013
        Main: Sem mais tarefas em: Wed May 15 15:40:06 CST 2013
        Main: Finalizado em: Wed May 15 15:40:11 CST 2013

        Cenário 3: Execução com intervalo de 1 segundo
        Main: Iniciando em: Wed May 15 15:45:00 CST 2013
        Main: Atraso: 999 ms
        Main: Atraso: 499 ms
        Main: Atraso: 0 ms
        Task: Executado em: Wed May 15 15:45:01 CST 2013
        Main: Atraso: 998 ms
        Main: Atraso: 498 ms
        Main: Atraso: -1 ms
        Task: Executado em: Wed May 15 15:45:02 CST 2013
        Main: Atraso: 998 ms
        Main: Atraso: 498 ms
        Main: Atraso: -1 ms
        Task: Executado em: Wed May 15 15:45:03 CST 2013
        Main: Sem mais tarefas em: Wed May 15 15:45:03 CST 2013
        Main: Finalizado em: Wed May 15 15:45:08 CST 2013
        */
    }
}

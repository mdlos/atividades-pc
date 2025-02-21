package atividades.aula8_ex4;

/**
 *
 * @author Marcio de Arruda Fonseca
 */

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        // Cria um ScheduledExecutorService com um pool de 1 thread
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);

        // Exibe o horário de início da execução
        System.out.printf("Main: Iniciando em: %s\n", new Date());

        // Agenda 5 tarefas com atrasos crescentes (1, 2, 3, 4 e 5 segundos)
        for (int i = 0; i < 5; i++) {
            Task task = new Task("Task-" + i);
            executor.schedule(task, i + 1, TimeUnit.SECONDS); // Agenda a tarefa com um atraso de i+1 segundos
        }

        // Encerra o executor após a conclusão de todas as tarefas
        executor.shutdown();

        try {
            // Aguarda até que todas as tarefas sejam concluídas (ou até 1 dia, o que ocorrer primeiro)
            executor.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Exibe o horário de término da execução
        System.out.printf("Core: Terminando em: %s\n", new Date());

        /*
        Saídas para diferentes cenários:

        Cenário 1: Execução com 5 tarefas agendadas com atrasos de 1 a 5 segundos
        Main: Iniciando em: Wed May 15 14:00:00 CST 2023
        Task-0: Iniciando em: 00:01.000
        Task-1: Iniciando em: 00:02.000
        Task-2: Iniciando em: 00:03.000
        Task-3: Iniciando em: 00:04.000
        Task-4: Iniciando em: 00:05.000
        Core: Terminando em: Wed May 15 14:00:05 CST 2023

        Cenário 2: Execução com 3 tarefas agendadas com atrasos de 2, 4 e 6 segundos
        Main: Iniciando em: Wed May 15 14:10:00 CST 2023
        Task-0: Iniciando em: 00:02.000
        Task-1: Iniciando em: 00:04.000
        Task-2: Iniciando em: 00:06.000
        Core: Terminando em: Wed May 15 14:10:06 CST 2023

        Cenário 3: Execução com 1 tarefa agendada com atraso de 3 segundos
        Main: Iniciando em: Wed May 15 14:20:00 CST 2023
        Task-0: Iniciando em: 00:03.000
        Core: Terminando em: Wed May 15 14:20:03 CST 2023
        */
    }
}

package atividades.aula8_ex3;

/**
 *
 * @author Marcio de Arruda Fonseca
 */

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
    public static void main(String[] args) {
        // Cria um ExecutorService com um pool de threads dinâmico
        ExecutorService executor = Executors.newCachedThreadPool();

        // Lista de tarefas a serem submetidas ao executor
        List<Task> taskList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            Task task = new Task("Task-" + i);
            taskList.add(task);
        }

        // Lista para armazenar os objetos Future retornados pela submissão das tarefas
        List<Future<Result>> resultList = null;

        // Exibe a data e hora de início da execução
        System.out.println(new Date());

        try {
            // Submete todas as tarefas ao executor e aguarda a conclusão de todas
            resultList = executor.invokeAll(taskList);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Encerra o executor
        executor.shutdown();

        // Exibe a data e hora de término da execução
        System.out.println(new Date());

        // Exibe os resultados das tarefas
        System.out.printf("Core: Exibindo os resultados\n");
        for (int i = 0; i < resultList.size(); i++) {
            Future<Result> future = resultList.get(i);

            try {
                // Obtém o resultado da tarefa (bloqueia até que a tarefa seja concluída)
                Result result = future.get();
                System.out.printf("%s: %d\n", result.getName(), result.getValue());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        /*
        Saídas para diferentes cenários:

        Cenário 1: Execução com 3 tarefas
        Wed May 15 13:20:39 CST 2013
        Task-0: Iniciando
        Task-1: Iniciando
        Task-2: Iniciando
        Task-0: Aguardando 6 segundos para resultados.
        Task-1: Aguardando 7 segundos para resultados.
        Task-2: Aguardando 5 segundos para resultados.
        Task-2: Finalizando
        Task-0: Finalizando
        Task-1: Finalizando
        Wed May 15 13:20:47 CST 2013
        Core: Exibindo os resultados
        Task-0: 202
        Task-1: 302
        Task-2: 159

        Cenário 2: Execução com 5 tarefas
        Wed May 15 13:25:00 CST 2013
        Task-0: Iniciando
        Task-1: Iniciando
        Task-2: Iniciando
        Task-3: Iniciando
        Task-4: Iniciando
        Task-0: Aguardando 4 segundos para resultados.
        Task-1: Aguardando 8 segundos para resultados.
        Task-2: Aguardando 3 segundos para resultados.
        Task-3: Aguardando 6 segundos para resultados.
        Task-4: Aguardando 2 segundos para resultados.
        Task-4: Finalizando
        Task-2: Finalizando
        Task-0: Finalizando
        Task-3: Finalizando
        Task-1: Finalizando
        Wed May 15 13:25:08 CST 2013
        Core: Exibindo os resultados
        Task-0: 150
        Task-1: 280
        Task-2: 90
        Task-3: 320
        Task-4: 200

        Cenário 3: Execução com 1 tarefa
        Wed May 15 13:30:00 CST 2013
        Task-0: Iniciando
        Task-0: Aguardando 5 segundos para resultados.
        Task-0: Finalizando
        Wed May 15 13:30:05 CST 2013
        Core: Exibindo os resultados
        Task-0: 180
        */
    }
}

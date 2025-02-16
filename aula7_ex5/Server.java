package atividades.aula7_ex5;

/**
 *
 * @author Marcio de Arruda Fonseca
 */

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Classe Server que gerencia um pool de threads para executar tarefas.
 */
public class Server {
    private ThreadPoolExecutor executor;

    public Server() {
        // Cria um pool de threads com tamanho fixo (10 threads)
        executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
    }

    /**
     * Submete uma tarefa ao pool de threads.
     */
    public void executeTask(Task task) {
        System.out.printf("Server: Uma nova tarefa chegou\n");
        executor.execute(task); // Submete a tarefa ao executor
        System.out.printf("Server: Tamanho do Pool: %d\n", executor.getPoolSize());
        System.out.printf("Server: Contagem de Threads Ativas: %d\n", executor.getActiveCount());
        System.out.printf("Server: Tarefas Concluídas: %d\n", executor.getCompletedTaskCount());
    }

    /**
     * Encerra o executor após a conclusão de todas as tarefas.
     */
    public void endServer() {
        executor.shutdown(); // Encerra o executor
    }
}

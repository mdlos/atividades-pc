package atividades.aula7_ex6;

/**
 *
 * @author Marcio de Arruda Fonseca
 */


public class Main {
    public static void main(String[] args) {
        // Cria um servidor com um pool de threads de tamanho fixo (5 threads)
        Server server = new Server();

        // Submete 100 tarefas ao servidor
        for (int i = 0; i < 100; i++) {
            Task task = new Task("Tarefa " + i);
            server.executeTask(task);
        }

        // Encerra o servidor após a submissão de todas as tarefas
        server.endServer();

        /*
         * Saída:
         * Server: Uma nova tarefa chegou
         * Server: Tamanho do Pool: 1
         * Server: Contagem de Threads Ativas: 1
         * Server: Total de Tarefas Submetidas: 1
         * Server: Tarefas Concluídas: 0
         * pool-1-thread-1: Tarefa Tarefa 0: Criada em: [data/hora]
         * pool-1-thread-1: Tarefa Tarefa 0: Iniciada em: [data/hora]
         * pool-1-thread-1: Tarefa Tarefa 0: Executando por X segundos
         * ...
         * pool-1-thread-1: Tarefa Tarefa 0: Concluída em: [data/hora]
         *
         * Server: Uma nova tarefa chegou
         * Server: Tamanho do Pool: 2
         * Server: Contagem de Threads Ativas: 2
         * Server: Total de Tarefas Submetidas: 2
         * Server: Tarefas Concluídas: 1
         * pool-1-thread-2: Tarefa Tarefa 1: Criada em: [data/hora]
         * pool-1-thread-2: Tarefa Tarefa 1: Iniciada em: [data/hora]
         * pool-1-thread-2: Tarefa Tarefa 1: Executando por Y segundos
         * ...
         * pool-1-thread-2: Tarefa Tarefa 1: Concluída em: [data/hora]
         *
         * (Repete para todas as 100 tarefas)
         */
    }
}

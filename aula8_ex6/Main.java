package atividades.aula8_ex6;


/**
 *
 * @author Marcio de Arruda Fonseca
 */

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        // Cria um ExecutorService com um pool de threads dinâmico
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newCachedThreadPool();

        // Cria uma instância da tarefa
        Task task = new Task();

        System.out.printf("Main: Executando a tarefa\n");

        // Submete a tarefa ao executor e armazena o objeto Future retornado
        Future<String> result = executor.submit(task);

        try {
            // Aguarda 2 segundos antes de cancelar a tarefa
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Cancela a tarefa (interrompe sua execução)
        System.out.printf("Main: Cancelando a tarefa\n");
        result.cancel(true); // true indica que a tarefa deve ser interrompida se estiver em execução

        // Verifica se a tarefa foi cancelada e se está concluída
        System.out.printf("Main: Cancelada: %s\n", result.isCancelled());
        System.out.printf("Main: Concluída: %s\n", result.isDone());

        // Encerra o executor
        executor.shutdown();
        System.out.printf("Main: O executor foi finalizado\n");

        /*
        Saídas esperadas para diferentes cenários:

        Cenário 1: Tarefa cancelada após 2 segundos
        Main: Executando a tarefa
        Task: Test
        Task: Test
        Task: Test
        ... (repetido várias vezes por 2 segundos)
        Main: Cancelando a tarefa
        Main: Cancelada: true
        Main: Concluída: true
        Main: O executor foi finalizado

        Cenário 2: Tarefa não cancelada (comente o cancelamento para testar)
        Main: Executando a tarefa
        Task: Test
        Task: Test
        Task: Test
        ... (repetido indefinidamente)
        Main: O executor foi finalizado

        Cenário 3: Tarefa cancelada imediatamente (sem esperar 2 segundos)
        Main: Executando a tarefa
        Main: Cancelando a tarefa
        Main: Cancelada: true
        Main: Concluída: true
        Main: O executor foi finalizado
        */
    }
}

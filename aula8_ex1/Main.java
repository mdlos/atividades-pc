package atividades.aula8_ex1;

/**
 *
 * @author Marcio de Arruda Fonseca
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class Main {
    public static void main(String[] args) {
        // Cria um ExecutorService com um pool fixo de 2 threads
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(2);
        // Lista para armazenar os objetos Future retornados pela submissão das tarefas
        List<Future<Integer>> resultList = new ArrayList<>();

        Random random = new Random();
        // Submete 10 tarefas ao executor
        for (int i = 0; i < 10; i++) {
            // Gera um número aleatório entre 0 e 9
            Integer number = random.nextInt(10);
            // Cria uma instância de FactorialCalculator com o número gerado
            FactorialCalculator calculator = new FactorialCalculator(number);
            // Submete a tarefa ao executor e armazena o Future retornado
            Future<Integer> result = executor.submit(calculator);
            resultList.add(result);
        }

        // Monitora o progresso das tarefas
        do {
            System.out.printf("Main: Número de tarefas concluídas: %d\n", executor.getCompletedTaskCount());
            for (int i = 0; i < resultList.size(); i++) {
                Future<Integer> result = resultList.get(i);
                // Verifica se a tarefa foi concluída
                System.out.printf("Main: Tarefa %d: %s\n", i, result.isDone() ? "Concluída" : "Em andamento");
            }
            try {
                // Aguarda 50ms antes de verificar novamente
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (executor.getCompletedTaskCount() < resultList.size()); // Continua até que todas as tarefas sejam concluídas

        // Exibe os resultados das tarefas
        System.out.printf("Main: Resultados\n");
        for (int i = 0; i < resultList.size(); i++) {
            Future<Integer> result = resultList.get(i);
            Integer number = null;
            try {
                // Obtém o resultado da tarefa (bloqueia até que a tarefa seja concluída)
                number = result.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            System.out.printf("Main: Tarefa %d: %d\n", i, number);
        }

        // Finaliza o executor
        executor.shutdown();
    }
}

/*
Saida:

/*
Saida: Número de tarefas concluídas: 0
Main: Tarefa 0: Em andamento
Main: Tarefa 1: Em andamento
Main: Tarefa 2: Em andamento
...
pool-1-thread-1: 120   // Fatorial de 5
pool-1-thread-2: 720   // Fatorial de 6
...
Main: Número de tarefas concluídas: 10
Main: Resultados
Main: Tarefa 0: 120
Main: Tarefa 1: 720
...

Número de tarefas concluídas: 0
Main: Tarefa 0: Em andamento
Main: Tarefa 1: Em andamento
...
pool-1-thread-1: 120   // Fatorial de 5
pool-1-thread-2: 720   // Fatorial de 6
pool-1-thread-3: 24    // Fatorial de 4
pool-1-thread-4: 5040  // Fatorial de 7
...
Main: Número de tarefas concluídas: 10
Main: Resultados
Main: Tarefa 0: 120
Main: Tarefa 1: 720
*/ 

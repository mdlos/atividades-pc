package atividades.aula4_ex7;

/**
 * 
 * Autor: Márcio de Arruda Fonseca
 */

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        // Cria um grupo de threads chamado "Searcher"
        ThreadGroup threadGroup = new ThreadGroup("Searcher");
        Result result = new Result();

        // Cria uma tarefa de busca
        SearchTask searchTask = new SearchTask(result);
        for (int i = 0; i < 5; i++) {
            // Cria e inicia uma nova thread no grupo
            Thread thread = new Thread(threadGroup, searchTask);
            thread.start();

            try {
                // Espera 1 segundo antes de criar a próxima thread
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Exibe o número de threads ativas no grupo
        System.out.printf("Number of Threads: %d\n", threadGroup.activeCount());
        System.out.printf("Information about the Thread Group\n");
        // Lista todas as threads no grupo
        threadGroup.list();

        // Obtém uma lista de todas as threads ativas no grupo
        Thread[] threads = new Thread[threadGroup.activeCount()];
        threadGroup.enumerate(threads);
        for (int i = 0; i < threadGroup.activeCount(); i++) {
            System.out.printf("Thread %s: %s\n", threads[i].getName(), threads[i].getState());
        }

        // Espera que as threads terminem
        waitFinish(threadGroup);

        // Interrompe todas as threads no grupo
        threadGroup.interrupt();
    }

    /**
     * Espera que o número de threads ativas no grupo seja reduzido a 4
     */
    private static void waitFinish(ThreadGroup threadGroup) {
        while (threadGroup.activeCount() > 4) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

/**
Saida Cenario 1:
Configuração: 5 threads, tempo de espera de 1 segundo entre a criação de cada thread.

Thread Thread-0: Start
Thread Thread-0: 76
Thread Thread-1: Start
Thread Thread-1: 74
Thread Thread-2: Start
Thread Thread-2: 2
Thread Thread-2: End
Thread Thread-3: Start
Thread Thread-3: 93
Thread Thread-4: Start
Thread Thread-4: 74
Number of Threads: 4
Information about the Thread Group
java.lang.ThreadGroup[name=Searcher,maxpri=10]
    Thread[Thread-0,5,Searcher]
    Thread[Thread-1,5,Searcher]
    Thread[Thread-3,5,Searcher]
    Thread[Thread-4,5,Searcher]
Thread Thread-0: TIMED_WAITING
Thread Thread-1: TIMED_WAITING
Thread Thread-3: TIMED_WAITING
Thread Thread-4: TIMED_WAITING
Thread Thread-1: Interrupted
Thread Thread-0: Interrupted
Thread Thread-3: Interrupted
Thread Thread-4: Interrupted

Saida Cenari 2:
Configuração: 10 threads, tempo de espera de 1 segundo entre a criação de cada thread.
Thread Thread-0: Start
Thread Thread-0: 45
Thread Thread-1: Start
Thread Thread-1: 67
Thread Thread-2: Start
Thread Thread-2: 23
Thread Thread-2: End
Thread Thread-3: Start
Thread Thread-3: 89
Thread Thread-4: Start
Thread Thread-4: 12
Thread Thread-4: End
Thread Thread-5: Start
Thread Thread-5: 56
Thread Thread-6: Start
Thread Thread-6: 34
Thread Thread-6: End
Thread Thread-7: Start
Thread Thread-7: 78
Thread Thread-8: Start
*/

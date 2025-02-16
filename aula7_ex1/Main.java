package atividades.aula7_ex1;

/**
 *
 * @author Marcio de Arruda Fonseca
 */

import java.util.concurrent.CyclicBarrier;

/**
 * Classe Main que inicia o programa e configura o CyclicBarrier.
 */
public class Main {

    public static void main(String[] args) {

        final int ROWS = 10000; // Número de linhas na matriz
        final int NUMBERS = 1000; // Número de colunas na matriz
        final int SEARCH = 5; // Número a ser buscado
        final int LINES_PARTICIPANT = 2000; // Número de linhas que cada thread processará

        MatrixMock mock = new MatrixMock(ROWS, NUMBERS, SEARCH);
        Results results = new Results(ROWS);
        Grouper grouper = new Grouper(results);

        final int PARTICIPANTS = 5; // Número de threads participantes
        CyclicBarrier barrier = new CyclicBarrier(PARTICIPANTS, grouper);

        Searcher searchers[] = new Searcher[PARTICIPANTS];
        for (int i = 0; i < PARTICIPANTS; i++) {
            searchers[i] = new Searcher(i * LINES_PARTICIPANT, (i * LINES_PARTICIPANT) + LINES_PARTICIPANT, mock,
                    results, SEARCH, barrier);
            Thread thread = new Thread(searchers[i]);
            thread.start();
        }

        System.out.printf("Main: A thread principal terminou.\n");

        /*
         * Saída:
         * Mock: Existem X ocorrências do número 5 nos dados gerados.
         * Thread-0: Processando linhas de 0 a 2000.
         * Thread-1: Processando linhas de 2000 a 4000.
         * Thread-2: Processando linhas de 4000 a 6000.
         * Thread-3: Processando linhas de 6000 a 8000.
         * Thread-4: Processando linhas de 8000 a 10000.
         * Thread-0: Linhas processadas.
         * Thread-1: Linhas processadas.
         * Thread-2: Linhas processadas.
         * Thread-3: Linhas processadas.
         * Thread-4: Linhas processadas.
         * Grouper: Processando resultados...
         * Grouper: Resultado total: X.
         * Main: A thread principal terminou.
         */
    }
}

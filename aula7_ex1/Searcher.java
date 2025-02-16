package atividades.aula7_ex1;

/**
 *
 * @author Marcio de Arruda Fonseca
 */

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Classe Searcher que implementa Runnable para buscar um número específico em uma parte da matriz.
 */
public class Searcher implements Runnable {

    private int firstRow;
    private int lastRow;
    private MatrixMock mock;
    private Results results;
    private int number;
    private final CyclicBarrier barrier;

    public Searcher(int firstRow, int lastRow, MatrixMock mock, Results results, int number, CyclicBarrier barrier) {
        this.firstRow = firstRow;
        this.lastRow = lastRow;
        this.mock = mock;
        this.results = results;
        this.number = number;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        int counter;
        System.out.printf("%s: Processando linhas de %d a %d.\n", Thread.currentThread().getName(), firstRow, lastRow);

        for (int i = firstRow; i < lastRow; i++) {
            int row[] = mock.getRow(i);
            counter = 0;
            for (int j = 0; j < row.length; j++) {
                if (row[j] == number) {
                    counter++;
                }
            }
            results.setData(i, counter);
        }

        System.out.printf("%s: Linhas processadas.\n", Thread.currentThread().getName());

        try {
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}

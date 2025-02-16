package atividades.aula7_ex1;

/**
 *
 * @author Marcio de Arruda Fonseca
 */

import java.util.Random;

/**
 * Classe MatrixMock que gera uma matriz de números aleatórios e conta as ocorrências de um número específico.
 */
public class MatrixMock {

    private int data[][];

    public MatrixMock(int size, int length, int number) {
        int counter = 0;
        data = new int[size][length];

        Random random = new Random();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < length; j++) {
                data[i][j] = random.nextInt(10);
                if (data[i][j] == number) {
                    counter++;
                }
            }
        }

        System.out.printf("Mock: Existem %d ocorrências do número %d nos dados gerados.\n", counter, number);
    }

    public int[] getRow(int row) {
        if ((row >= 0) && (row < data.length)) {
            return data[row];
        }
        return null;
    }
}


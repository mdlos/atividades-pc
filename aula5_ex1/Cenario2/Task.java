package atividades.aula5_ex1.Cenario2;

/**
 * 
 * Autor: Márcio de Arruda Fonseca
 */
import java.util.Random;

public class Task implements Runnable {

    @Override
    public void run() {
        int result;
        Random random = new Random(Thread.currentThread().getId());

        while (true) {
            // Gera um número aleatório entre 0 e 1000 e tenta dividir 1000 por ele
            int divisor = (int) (random.nextDouble() * 1000);
            if (divisor == 0) {
                // Lança uma exceção se o divisor for zero
                throw new ArithmeticException("Divisão por zero");
            }
            result = 1000 / divisor;
            System.out.printf("%s : %d\n", Thread.currentThread().getId(), result);

            // Verifica se a thread foi interrompida
            if (Thread.currentThread().isInterrupted()) {
                System.out.printf("%d : Interrompida\n", Thread.currentThread().getId());
                return; // Encerra a execução da thread
            }
        }
    }
}

/**
Cenário 2: Com Manipulação Global de Exceções

*/

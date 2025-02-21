package atividades.aula8_ex1;

/**
 *
 * @author Marcio de Arruda Fonseca
 */

import java.util.concurrent.Callable;

public class FactorialCalculator implements Callable<Integer> {
    private Integer number;

    // Construtor que recebe o número para calcular o fatorial
    public FactorialCalculator(Integer number) {
        this.number = number;
    }

    @Override
    public Integer call() throws Exception {
        int num, result;

        num = number.intValue();
        result = 1;

        // Calcula o fatorial do número
        if (num == 0 || num == 1) {
            result = 1;
        } else {
            for (int i = 2; i <= number; i++) {
                result *= i;
                // Simula um atraso para fins de teste
                Thread.sleep(20);
            }
        }

        // Exibe o resultado no console
        System.out.printf("%s: %d\n", Thread.currentThread().getName(), result);

        return result;
    }
}

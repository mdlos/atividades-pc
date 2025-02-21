package atividades.aula8_ex3;

/**
 *
 * @author Marcio de Arruda Fonseca
 */

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class Task implements Callable<Result> {
    private String name; // Nome da tarefa

    // Construtor que recebe o nome da tarefa
    public Task(String name) {
        this.name = name;
    }

    @Override
    public Result call() throws Exception {
        System.out.printf("%s: Iniciando\n", this.name);

        try {
            // Simula um tempo aleatório de processamento (entre 0 e 10 segundos)
            Long duration = (long) (Math.random() * 10);
            System.out.printf("%s: Aguardando %d segundos para resultados.\n", this.name, duration);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Calcula um valor aleatório para simular o resultado da tarefa
        int value = 0;
        for (int i = 0; i < 5; i++) {
            value += (int) (Math.random() * 100);
        }

        // Cria um objeto Result com o nome da tarefa e o valor calculado
        Result result = new Result();
        result.setName(this.name);
        result.setValue(value);
        System.out.printf("%s: Finalizando\n", this.name);

        return result;
    }
}

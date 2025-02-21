package atividades.aula8_ex5;

/**
 *
 * @author Marcio de Arruda Fonseca
 */

import java.util.Date;

public class Task implements Runnable {
    private String name; // Nome da tarefa

    // Construtor que recebe o nome da tarefa
    public Task(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        // Exibe o horário de execução da tarefa
        System.out.printf("%s: Executado em: %s\n", name, new Date());
    }
}

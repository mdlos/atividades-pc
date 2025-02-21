package atividades.aula8_ex4;

/**
 *
 * @author Marcio de Arruda Fonseca
 */

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Callable;

public class Task implements Callable<String> {
    private final SimpleDateFormat sdf = new SimpleDateFormat("mm:ss.SSS"); // Formato de data para exibição
    private String name; // Nome da tarefa

    // Construtor que recebe o nome da tarefa
    public Task(String name) {
        this.name = name;
    }

    @Override
    public String call() throws Exception {
        // Exibe o horário de início da execução da tarefa
        System.out.printf("%s: Iniciando em: %s\n", name, sdf.format(new Date()));
        return "Hello, world"; // Retorna uma mensagem de exemplo
    }
}

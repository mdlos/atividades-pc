package atividades.aula4_ex4;

import java.lang.Thread.UncaughtExceptionHandler;

/**
 * Classe ExceptionHandler
 * 
 * Implementa a interface UncaughtExceptionHandler para capturar e tratar 
 * exceções não tratadas lançadas por threads. Essa classe exibe detalhes da 
 * exceção e da thread que a gerou.
 * 
 * Autor: Márcio de Arruda Fonseca
 */
public class ExceptionHandler implements UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        // Exibe informações sobre a exceção capturada e a thread que a gerou
        System.out.printf("Uma exceção foi capturada\n");

        // Exibe o ID da thread que lançou a exceção
        System.out.printf("Thread: %s\n", t.getId());

        // Exibe o nome da exceção e a mensagem associada
        System.out.printf("Exceção: %s: %s\n", e.getClass().getName(), e.getMessage());

        // Exibe o stack trace completo da exceção no console
        System.out.printf("Stack Trace: \n");
        e.printStackTrace(System.out);

        // Exibe o status atual da thread no momento da exceção
        System.out.printf("Status da thread: %s\n", t.getState());
    }
}


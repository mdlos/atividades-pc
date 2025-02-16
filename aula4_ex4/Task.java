package atividades.aula4_ex4;

/**
 * Classe que representa uma tarefa a ser executada em uma thread.
 * <p>
 * A classe implementa a interface {@link Runnable} e, ao ser executada, 
 * simula uma operação que pode lançar uma exceção. Caso ocorra uma exceção, ela é capturada 
 * e re-lançada para testar o comportamento do manipulador de exceções não capturadas.
 * </p>
 * 
 * @author Márcio de Arruda Fonseca
 */
public class Task implements Runnable {

    /**
     * Método que contém a lógica da tarefa a ser executada na thread.
     * Simula uma operação que pode gerar uma exceção, e caso isso aconteça,
     * a exceção é capturada e re-lançada.
     */
    @Override
    public void run() {
        try {
            // Simula uma operação que pode lançar uma exceção
            Integer.parseInt("TTT"); // Isso lançará uma NumberFormatException
        } catch (NumberFormatException e) {
            // Exibe uma mensagem de erro com a exceção capturada
            System.out.println("Exceção capturada dentro da thread: " + e.getMessage());
            throw e; // Re-lança a exceção para testar o UncaughtExceptionHandler
        }

        // Exibe uma mensagem indicando o fim da execução do método run
        System.out.println("=====run end=====");
    }
}


package atividades.aula4_ex4;

/**
 * Classe principal que executa o teste das threads com e sem exceção.
 * <p>
 * Esta classe cria e executa duas threads: uma que lança uma exceção para testar o 
 * {@link UncaughtExceptionHandler}, e outra que executa normalmente sem exceção.
 * O manipulador de exceções é configurado para ambas as threads.
 * </p>
 * 
 * @author Márcio de Arruda Fonseca
 */
public class Main {
    public static void main(String[] args) {
        // Cria uma tarefa que lançará uma exceção
        Task task = new Task();
        Thread thread = new Thread(task);

        // Configura o manipulador de exceções não capturadas para a thread
        thread.setUncaughtExceptionHandler(new ExceptionHandler());
        thread.start(); // Inicia a execução da thread

        try {
            thread.join(); // Espera a thread terminar
        } catch (InterruptedException e) {
            e.printStackTrace(); // Trata a interrupção da thread
        }

        // Exibe uma mensagem quando a thread de exceção for finalizada
        System.out.printf("A thread foi finalizada\n");

        // Testando outra thread sem exceção
        Thread safeThread = new Thread(() -> {
            System.out.println("Thread segura executando...");
            System.out.println("=====run end=====");
        });

        // Configura o manipulador de exceções não capturadas para a thread segura
        safeThread.setUncaughtExceptionHandler(new ExceptionHandler());
        safeThread.start(); // Inicia a execução da thread segura

        try {
            safeThread.join(); // Espera a thread segura terminar
        } catch (InterruptedException e) {
            e.printStackTrace(); // Trata a interrupção da thread
        }

        // Exibe uma mensagem quando a thread segura for finalizada
        System.out.printf("A thread segura foi finalizada\n");
    }
}

/**
Uma exceção foi capturada
Thread: 9
Exceção: java.lang.NumberFormatException: For input string: "TTT"
Stack Trace: 
java.lang.NumberFormatException: For input string: "TTT"
    at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
    at java.lang.Integer.parseInt(Integer.java:492)
    at java.lang.Integer.parseInt(Integer.java:527)
    at aula4_ex4.Task.run(Task.java:8)
    at java.lang.Thread.run(Thread.java:722)
Status da thread: RUNNABLE
A thread foi finalizada
*/


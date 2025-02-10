package atividades.aula5_ex1.Cenario2;

/**
 * 
 * Autor: Márcio de Arruda Fonseca
 */
public class MyThreadGroup extends ThreadGroup {

    // Construtor que recebe o nome do grupo de threads e o passa para a superclasse
    public MyThreadGroup(String name) {
        super(name);
    }

    // Sobrescreve o método que lida com exceções não tratadas nas threads do grupo
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        // Exibe uma mensagem indicando qual thread gerou uma exceção
        System.out.printf("A thread %s lançou uma exceção\n", t.getId());

        // Imprime o rastreamento da pilha da exceção
        e.printStackTrace(System.out);

        // Exibe uma mensagem informando que as demais threads serão interrompidas
        System.out.printf("Terminando o restante das threads\n");

        // Interrompe todas as threads do grupo
        interrupt();
    }
}

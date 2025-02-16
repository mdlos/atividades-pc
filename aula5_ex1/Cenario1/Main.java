package atividades.aula5_ex1.Cenario1;

/**
 * 
 * Autor: Márcio de Arruda Fonseca
 */
public class Main {

    public static void main(String[] args) {
        // Cria um grupo de threads personalizado
        MyThreadGroup threadGroup = new MyThreadGroup("MyThreadGroup");

        // Cria uma instância da tarefa que será executada pelas threads
        Task task = new Task();

        // Cria e inicia 5 threads, associando-as ao grupo de threads criado
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(threadGroup, task);
            t.start();
        }
    }
}

/**
Cenário 1: Sem Manipulação Global de Exceções

15 : 50
16 : 20
17 : 10
18 : 25
19 : 100
A thread 15 lançou uma exceção
java.lang.ArithmeticException: Divisão por zero
    at Task.run(Task.java:14)
    at java.lang.Thread.run(Thread.java:748)
Terminando o restante das threads
16 : Interrompida
17 : Interrompida
18 : Interrompida
19 : Interrompida


*/

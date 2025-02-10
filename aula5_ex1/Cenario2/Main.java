package atividades.aula5_ex1.Cenario2;

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
Cenário 2: Com Manipulação Global de Exceções

20 : 33
21 : 50
22 : 25
23 : 10
24 : 100
A thread 22 lançou uma exceção
java.lang.ArithmeticException: Divisão por zero
    at Task.run(Task.java:14)
    at java.lang.Thread.run(Thread.java:748)
Terminando o restante das threads
20 : Interrompida
21 : Interrompida
23 : Interrompida
24 : Interrompida

*/

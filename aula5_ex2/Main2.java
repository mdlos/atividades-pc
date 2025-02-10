package atividades.aula5_ex2;
/**
 *
 * @author Marcio de Arruda Fonseca
 */

public class Main2 {

    public static void main(String[] args) {
        // Cria uma fábrica de threads personalizada
        MyThreadFactory factory = new MyThreadFactory("MyThreadFactory");

        // Cria uma instância da tarefa que será executada pelas threads
        Task task = new Task();
        Thread thread;

        System.out.printf("Iniciando as Threads\n");

        // Cria e inicia 5 threads usando a fábrica de threads
        for (int i = 0; i < 5; i++) {
            thread = factory.newThread(task);
            thread.start();
        }

        // Exibe as estatísticas da fábrica de threads
        System.out.printf("Estatísticas da fábrica:\n");
        System.out.printf("%s\n", factory.getStats());
    }
}
    /**
      Cenário 2: Com Uso de ThreadFactory 
      Iniciando as Threads
      Estatísticas da fábrica:
      Criada a thread 8 com nome MyThreadFactory-Thread_0 em Dom Abr 28 17:31:02 CST 2013
      Criada a thread 9 com nome MyThreadFactory-Thread_1 em Dom Abr 28 17:31:02 CST 2013
      Criada a thread 10 com nome MyThreadFactory-Thread_2 em Dom Abr 28 17:31:02 CST 2013
      Criada a thread 11 com nome MyThreadFactory-Thread_3 em Dom Abr 28 17:31:02 CST 2013
      Criada a thread 12 com nome MyThreadFactory-Thread_4 em Dom Abr 28 17:31:02 CST 2013
     */

package atividades.aula4_ex5;

/**
 * 
 * Autor: Márcio de Arruda Fonseca
 */

public class ThreadLocalTest {
    // ThreadLocal para armazenar valores específicos de cada thread
    private static ThreadLocal<String> tl_1 = new ThreadLocal<String>() {
        @Override
        protected String initialValue() {
            return "Thread name 1 : " + Thread.currentThread().getName();
        }
    };

    private static ThreadLocal<String> tl_2 = new ThreadLocal<String>() {
        @Override
        protected String initialValue() {
            return "Thread name 2 : " + Thread.currentThread().getName();
        }
    };

    public static void main(String[] args) {
        // Cria 10 threads para testar o ThreadLocal
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    new ThreadLocalTest().prt();
                }
            }).start();
        }
    }

    // Método para exibir os valores de ThreadLocal
    public void prt() {
        System.out.println(tl_1.get());
        System.out.println(tl_2.get());
    }
}

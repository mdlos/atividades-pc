package atividades.aula4_ex5;

/**
 * 
 * Autor: Márcio de Arruda Fonseca
 */

public class Main {
    static final ThreadLocal<String> t1 = new ThreadLocal<String>();

    public static void main(String[] args) {
        // Testando ThreadLocal
        t1.set("ThreadLocal-VAL");
        System.out.println("Main-1:" + t1.get()); // ThreadLocal-VAL

        new Thread() {
            @Override
            public void run() {
                System.out.println("Child-1:" + t1.get()); // null (ThreadLocal não é herdado)
            }
        }.start();

        // Testando InheritableThreadLocal
        final ThreadLocal<String> itl = new InheritableThreadLocal<String>();
        itl.set("InheritableThreadLocal-VAL");
        System.out.println("Main-2:" + itl.get()); // InheritableThreadLocal-VAL

        new Thread() {
            @Override
            public void run() {
                System.out.println("Child-2:" + itl.get()); // InheritableThreadLocal-VAL (herdado)
            }
        }.start();
    }
}

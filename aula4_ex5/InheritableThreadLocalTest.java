package atividades.aula4_ex5;

/**
 * 
 * Autor: Márcio de Arruda Fonseca
 */

public class InheritableThreadLocalTest {
    // Usando InheritableThreadLocal para herdar valores entre threads
    private static InheritableThreadLocal<StringBuffer> ITL = new InheritableThreadLocal<StringBuffer>() {
        @Override
        protected StringBuffer initialValue() {
            return new StringBuffer("hello"); // Valor inicial para a thread principal
        }
    };

    public static void main(String[] args) {
        // Exibe o valor inicial na thread principal
        System.out.println(Thread.currentThread().getName() + " : " + ITL.get()); // hello

        // Cria uma thread filha
        new Thread(new Runnable() {
            @Override
            public void run() {
                // Exibe o valor herdado da thread pai
                System.out.println(Thread.currentThread().getName() + " : " + ITL.get()); // hello

                // Cria uma thread neta
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        // Exibe o valor herdado da thread pai
                        System.out.println(Thread.currentThread().getName() + " : " + ITL.get()); // hello

                        // Modifica o valor na thread neta
                        ITL.get().append(", wqf");
                        System.out.println(Thread.currentThread().getName() + " : " + ITL.get()); // hello, wqf
                    }
                }, "inner-inner").start();

                try {
                    Thread.sleep(1000); // Espera a thread neta terminar
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }

                // Exibe o valor após a modificação na thread neta
                System.out.println(Thread.currentThread().getName() + " : " + ITL.get()); // hello, wqf
            }
        }, "inner").start();

        try {
            Thread.sleep(1000); // Espera a thread filha terminar
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }

        // Exibe o valor na thread principal após todas as modificações
        System.out.println(Thread.currentThread().getName() + " : " + ITL.get()); // hello
    }
}

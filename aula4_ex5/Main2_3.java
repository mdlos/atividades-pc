package atividades.aula4_ex5;

/**
 * 
 * Autor: Márcio de Arruda Fonseca
 */

public class Main2_3 {
    private final static InheritableThreadLocal<String> holder = new InheritableThreadLocal<String>() {
        @Override
        protected String childValue(String value) {
            return "Child created from " + value; // Personaliza o valor herdado
        }
    };

    public static void main(String[] args) {
        holder.set("Lily");
        System.out.println("main begin=" + holder.get()); // Lily

        Thread a = new Thread() {
            @Override
            public void run() {
                System.out.println("thread-begin=" + holder.get()); // Child created from Lily
                holder.set("Lucy");
                System.out.println("thread-end=" + holder.get()); // Lucy
            }
        };
        a.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("main end=" + holder.get()); // Lily
    }
}

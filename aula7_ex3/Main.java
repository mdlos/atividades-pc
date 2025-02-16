package atividades.aula7_ex3;

/**
 *
 * @author Marcio de Arruda Fonseca
 */


public class Main {
    public static void main(String[] args) {
        // Cria um Phaser personalizado
        MyPhaser phaser = new MyPhaser();

        // Cria um array de estudantes
        Student[] students = new Student[5];
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student(phaser);
            phaser.register(); // Registra cada estudante no Phaser
        }

        // Cria e inicia as threads dos estudantes
        Thread[] threads = new Thread[students.length];
        for (int i = 0; i < students.length; i++) {
            threads[i] = new Thread(students[i], "Estudante " + i);
            threads[i].start();
        }

        // Aguarda todas as threads terminarem
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Verifica se o Phaser terminou
        System.out.printf("Main: O Phaser terminou: %s.\n", phaser.isTerminated());

        /*
         * Saída esperada (exemplo):
         * Estudante 0: Chegou para fazer o exame. [data/hora]
         * Estudante 1: Chegou para fazer o exame. [data/hora]
         * Estudante 2: Chegou para fazer o exame. [data/hora]
         * Estudante 3: Chegou para fazer o exame. [data/hora]
         * Estudante 4: Chegou para fazer o exame. [data/hora]
         * Phaser: O exame vai começar. Os estudantes estão prontos.
         * Phaser: Temos 5 estudantes.
         *
         * Estudante 0: Vai fazer o primeiro exercício. [data/hora]
         * Estudante 1: Vai fazer o primeiro exercício. [data/hora]
         * ...
         * Phaser: Todos os estudantes terminaram o primeiro exercício.
         * Phaser: É hora do segundo exercício.
         *
         * Estudante 0: Vai fazer o segundo exercício. [data/hora]
         * Estudante 1: Vai fazer o segundo exercício. [data/hora]
         * ...
         * Phaser: Todos os estudantes terminaram o segundo exercício.
         * Phaser: É hora do terceiro exercício.
         *
         * Estudante 0: Vai fazer o terceiro exercício. [data/hora]
         * Estudante 1: Vai fazer o terceiro exercício. [data/hora]
         * ...
         * Phaser: Todos os estudantes terminaram o exame.
         * Phaser: Obrigado pelo seu tempo.
         *
         * Main: O Phaser terminou: true.
         */
    }
}

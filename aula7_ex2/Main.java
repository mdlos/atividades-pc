package atividades.aula7_ex2;

/**
 *
 * @author Marcio de Arruda Fonseca
 */

import java.util.concurrent.Phaser;

public class Main {
    public static void main(String[] args) {
        // Cria um Phaser com 3 threads registradas
        Phaser phaser = new Phaser(3);

        // Cria as tarefas de busca de arquivos
        FileSearch system = new FileSearch("C:\\Windows", "log", phaser);
        FileSearch apps = new FileSearch("C:\\Program Files", "log", phaser);
        FileSearch documents = new FileSearch("C:\\Documents And Settings", "log", phaser);

        // Cria e inicia as threads
        Thread systemThread = new Thread(system, "System");
        Thread appsThread = new Thread(apps, "Apps");
        Thread documentsThread = new Thread(documents, "Documents");

        systemThread.start();
        appsThread.start();
        documentsThread.start();

        // Aguarda as threads terminarem
        try {
            systemThread.join();
            appsThread.join();
            documentsThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Verifica se o Phaser terminou
        System.out.printf("Terminated: %s\n", phaser.isTerminated());

        /*
         * Saída esperada (exemplo):
         * System: Starting.
         * Apps: Starting.
         * Documents: Starting.
         *
         * System: Phase 1: X results.
         * Apps: Phase 1: Y results.
         * Documents: Phase 1: Z results.
         *
         * System: Phase 2: X results.
         * Apps: Phase 2: Y results.
         * Documents: Phase 2: Z results.
         *
         * System: /caminho/arquivo1.log
         * Apps: /caminho/arquivo2.log
         * Documents: /caminho/arquivo3.log
         *
         * System: Work completed.
         * Apps: Work completed.
         * Documents: Work completed.
         *
         * Terminated: true
         */
    }
}

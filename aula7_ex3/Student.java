package atividades.aula7_ex3;
/**
 *
 * @author Marcio de Arruda Fonseca
 */

import java.util.Date;
import java.util.concurrent.Phaser;
import java.util.concurrent.TimeUnit;

/**
 * Classe Student que implementa Runnable para simular a execução de um exame em fases.
 */
public class Student implements Runnable {
    private Phaser phaser;

    public Student(Phaser phaser) {
        this.phaser = phaser;
    }

    @Override
    public void run() {
        // Fase 0: Chegada do estudante
        System.out.printf("%s: Chegou para fazer o exame. %s\n", Thread.currentThread().getName(), new Date());
        phaser.arriveAndAwaitAdvance();

        // Fase 1: Primeiro exercício
        System.out.printf("%s: Vai fazer o primeiro exercício. %s\n", Thread.currentThread().getName(), new Date());
        doExercise1();
        System.out.printf("%s: Terminou o primeiro exercício. %s\n", Thread.currentThread().getName(), new Date());
        phaser.arriveAndAwaitAdvance();

        // Fase 2: Segundo exercício
        System.out.printf("%s: Vai fazer o segundo exercício. %s\n", Thread.currentThread().getName(), new Date());
        doExercise2();
        System.out.printf("%s: Terminou o segundo exercício. %s\n", Thread.currentThread().getName(), new Date());
        phaser.arriveAndAwaitAdvance();

        // Fase 3: Terceiro exercício
        System.out.printf("%s: Vai fazer o terceiro exercício. %s\n", Thread.currentThread().getName(), new Date());
        doExercise3();
        System.out.printf("%s: Terminou o exame. %s\n", Thread.currentThread().getName(), new Date());
        phaser.arriveAndAwaitAdvance();
    }

    /**
     * Simula a execução do primeiro exercício.
     */
    private void doExercise1() {
        try {
            Long duration = (long) (Math.random() * 10);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Simula a execução do segundo exercício.
     */
    private void doExercise2() {
        try {
            Long duration = (long) (Math.random() * 10);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Simula a execução do terceiro exercício.
     */
    private void doExercise3() {
        try {
            Long duration = (long) (Math.random() * 10);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

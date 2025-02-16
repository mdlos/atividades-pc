package atividades.aula7_ex3;
/**
 *
 * @author Marcio de Arruda Fonseca
 */


import java.util.concurrent.Phaser;

/**
 * Classe MyPhaser que estende Phaser para personalizar o comportamento em cada fase.
 */
public class MyPhaser extends Phaser {

    @Override
    protected boolean onAdvance(int phase, int registeredParties) {
        // Personaliza o comportamento do Phaser em cada fase
        switch (phase) {
            case 0:
                return estudantesChegaram(); // Fase 0: Chegada dos estudantes
            case 1:
                return terminarPrimeiroExercicio(); // Fase 1: Término do primeiro exercício
            case 2:
                return terminarSegundoExercicio(); // Fase 2: Término do segundo exercício
            case 3:
                return terminarExame(); // Fase 3: Término do exame
            default:
                return true; // Fases adicionais terminam o Phaser
        }
    }

    /**
     * Método chamado na fase 0 (chegada dos estudantes).
     */
    private boolean estudantesChegaram() {
        System.out.printf("Phaser: O exame vai começar. Os estudantes estão prontos.\n");
        System.out.printf("Phaser: Temos %d estudantes.\n", getRegisteredParties());
        return false; // Continua para a próxima fase
    }

    /**
     * Método chamado na fase 1 (término do primeiro exercício).
     */
    private boolean terminarPrimeiroExercicio() {
        System.out.printf("Phaser: Todos os estudantes terminaram o primeiro exercício.\n");
        System.out.printf("Phaser: É hora do segundo exercício.\n");
        return false; // Continua para a próxima fase
    }

    /**
     * Método chamado na fase 2 (término do segundo exercício).
     */
    private boolean terminarSegundoExercicio() {
        System.out.printf("Phaser: Todos os estudantes terminaram o segundo exercício.\n");
        System.out.printf("Phaser: É hora do terceiro exercício.\n");
        return false; // Continua para a próxima fase
    }

    /**
     * Método chamado na fase 3 (término do exame).
     */
    private boolean terminarExame() {
        System.out.printf("Phaser: Todos os estudantes terminaram o exame.\n");
        System.out.printf("Phaser: Obrigado pelo seu tempo.\n");
        return true; // Termina o Phaser
    }
}


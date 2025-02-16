package atividades.aula7_ex1;

/**
 *
 * @author Marcio de Arruda Fonseca
 */

/**
 * Classe Grouper que implementa Runnable para processar os resultados finais.
 */
public class Grouper implements Runnable {

    private Results results;

    public Grouper(Results results) {
        this.results = results;
    }

    @Override
    public void run() {
        int finalResult = 0;
        System.out.printf("Grouper: Processando resultados...\n");
        int data[] = results.getData();
        for (int number : data) {
            finalResult += number;
        }
        System.out.printf("Grouper: Resultado total: %d.\n", finalResult);
    }
}


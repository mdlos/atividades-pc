package atividades.aula6_ex1;
/**
 *
 * @author Marcio de Arruda Fonseca
 */

public class Reader implements Runnable {

    // Referência para o objeto PricesInfo, que contém os preços compartilhados
    private PricesInfo pricesInfo;

    // Construtor que recebe a instância de PricesInfo
    public Reader(PricesInfo pricesInfo) {
        this.pricesInfo = pricesInfo;
    }

    @Override
    public void run() {
        // Loop para simular 10 leituras dos preços
        for (int i = 0; i < 10; i++) {
            // Obtém o preço 1 e imprime o valor
            System.out.printf("%s: Preço 1: %f\n", Thread.currentThread().getName(), pricesInfo.getPrice1());
            // Obtém o preço 2 e imprime o valor
            System.out.printf("%s: Preço 2: %f\n", Thread.currentThread().getName(), pricesInfo.getPrice2());
        }
    }
}

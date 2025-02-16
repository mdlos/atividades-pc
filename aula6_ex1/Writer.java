package atividades.aula6_ex1;
/**
 *
 * @author Marcio de Arruda Fonseca
 */


public class Writer implements Runnable {

    // Referência para o objeto PricesInfo, que contém os preços compartilhados
    private PricesInfo pricesInfo;

    // Construtor que recebe a instância de PricesInfo
    public Writer(PricesInfo pricesInfo) {
        this.pricesInfo = pricesInfo;
    }

    @Override
    public void run() {
        // Loop para simular 3 escritas nos preços
        for (int i = 0; i < 3; i++) {
            // Mensagem indicando que o escritor está tentando modificar os preços
            System.out.printf("Escritor: Tentativa de modificar os preços.\n");
            // Modifica os preços com valores aleatórios
            pricesInfo.setPrices(Math.random() * 10, Math.random() * 8);
            // Mensagem indicando que os preços foram modificados
            System.out.printf("Escritor: Os preços foram modificados.\n");
            try {
                // Pausa a thread por 2 milissegundos para simular um intervalo entre escritas
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace(); // Trata a exceção caso a thread seja interrompida
            }
        }
    }
}

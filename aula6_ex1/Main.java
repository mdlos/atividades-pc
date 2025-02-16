package atividades.aula6_ex1;

/**
 *
 * @author Marcio de Arruda Fonseca
 */

public class Main {

    public static void main(String[] args) {
        // Cria uma instância de PricesInfo, que contém os preços compartilhados
        PricesInfo pricesInfo = new PricesInfo();

        // Cria um array de 5 leitores (Readers)
        Reader readers[] = new Reader[5];
        // Cria um array de 5 threads para os leitores
        Thread threadsReader[] = new Thread[5];

        // Inicializa os leitores e suas threads
        for (int i = 0; i < 5; i++) {
            readers[i] = new Reader(pricesInfo); // Passa a instância de PricesInfo para o leitor
            threadsReader[i] = new Thread(readers[i]); // Cria uma thread para o leitor
        }

        // Cria um escritor (Writer) e sua thread
        Writer writer = new Writer(pricesInfo); // Passa a instância de PricesInfo para o escritor
        Thread threadWriter = new Thread(writer); // Cria uma thread para o escritor

        // Inicia as threads dos leitores
        for (int i = 0; i < 5; i++) {
            threadsReader[i].start();
        }

        // Inicia a thread do escritor
        threadWriter.start();

        /*
         * Saídas durante a execução:
         *
         * 1. As threads leitoras começam a ler os preços simultaneamente.
         *    - Saída esperada:
         *      Thread-0: Preço 1: 1.0
         *      Thread-0: Preço 2: 2.0
         *      Thread-1: Preço 1: 1.0
         *      Thread-1: Preço 2: 2.0
         *      ...
         *
         * 2. Quando a thread escritora tenta modificar os preços, ela adquire o bloqueio de escrita.
         *    - Saída esperada:
         *      Escritor: Tentativa de modificar os preços.
         *      at [data/hora]
         *
         * 3. Durante a escrita, as threads leitoras são bloqueadas e não podem ler os preços.
         *    - Saída esperada:
         *      (Nenhuma leitura ocorre durante a escrita)
         *
         * 4. Após a escrita ser concluída, a thread escritora libera o bloqueio de escrita.
         *    - Saída esperada:
         *      Escritor: Os preços foram modificados.
         *      at [data/hora]
         *
         * 5. As threads leitoras retomam a leitura dos preços atualizados.
         *    - Saída esperada:
         *      Thread-2: Preço 1: [novo valor]
         *      Thread-2: Preço 2: [novo valor]
         *      ...
         *
         * 6. O processo se repete até que todas as leituras e escritas sejam concluídas.
         *
         * Observações:
         * - As leituras ocorrem simultaneamente, exceto durante a escrita.
         * - A escrita bloqueia todas as leituras até ser concluída.
         * - Os preços são atualizados com valores aleatórios a cada escrita.
         */
    }
}

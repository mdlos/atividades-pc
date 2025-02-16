package atividades.aula5_ex5.Cenario3;

/**
 *
 * @author Marcio de Arruda Fonseca
 */

public class Consumer implements Runnable {
    private EventStorage storage;  // Instância do armazenamento de eventos

    public Consumer(EventStorage storage) {
        this.storage = storage;  // Inicializa o armazenamento de eventos
    }

    @Override
    public void run() {
        // Consome eventos 100 vezes
        for (int i = 0; i < 100; i++) {
            storage.get();  // Chama o método 'get' do armazenamento de eventos
        }
    }
}

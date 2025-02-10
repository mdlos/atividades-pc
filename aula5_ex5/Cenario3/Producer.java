package atividades.aula5_ex5.Cenario3;

/**
 *
 * @author Marcio de Arruda Fonseca
 */

public class Producer implements Runnable {
    private EventStorage storage;  // Armazenamento de eventos onde o produtor vai adicionar eventos

    public Producer(EventStorage storage) {
        this.storage = storage;  // Inicializa o armazenamento de eventos
    }

    @Override
    public void run() {
        // O produtor irá adicionar 100 eventos ao armazenamento
        for (int i = 0; i < 100; i++) {
            storage.set();  // Chama o método 'set' para adicionar um evento
        }
    }
}

package atividades.aula5_ex5.Cenario2;

/**
 *
 * @author Marcio de Arruda Fonseca
 */
 
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class EventStorage {

    private int maxSize;  // Máximo de eventos que o armazenamento pode conter
    private List<Date> storage;  // Lista para armazenar os eventos

    public EventStorage() {
        maxSize = 10;  // Define o tamanho máximo do armazenamento como 10
        storage = new LinkedList<>();  // Inicializa a lista de armazenamento de eventos
    }

    // Método para adicionar eventos ao armazenamento (sincronizado)
    public synchronized void set() {
        // Enquanto o armazenamento estiver cheio, aguarda a remoção de eventos
        while (storage.size() == maxSize) {
            try {
                wait();  // A thread que chama 'set' aguarda até que haja espaço
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Adiciona um novo evento (data atual) ao armazenamento
        storage.add(new Date());
        System.out.printf("Set: %d \n", storage.size());  // Exibe o número de eventos no armazenamento

        // Notifica a thread consumidora que pode retirar um evento
        notify();
    }

    // Método para consumir (retirar) eventos do armazenamento (sincronizado)
    public synchronized void get() {
        // Enquanto o armazenamento estiver vazio, aguarda a adição de eventos
        while (storage.size() == 0) {
            try {
                wait();  // A thread que chama 'get' aguarda até que um evento seja adicionado
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // Retira o primeiro evento do armazenamento e exibe
        System.out.printf("Get: %d: %s \n", storage.size(), ((LinkedList<?>) storage).poll());
        // Notifica a thread produtora que pode adicionar um evento
        notify();
    }
}

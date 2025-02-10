package atividades.aula5_ex5.Cenario1;

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

    // Método para adicionar eventos ao armazenamento (sem sincronização)
    public void set() {
        // Adiciona um novo evento (data atual) ao armazenamento
        storage.add(new Date());
        System.out.printf("Set: %d \n", storage.size());  // Exibe o número de eventos no armazenamento
    }

    // Método para consumir (retirar) eventos do armazenamento (sem sincronização)
    public void get() {
        // Retira o primeiro evento do armazenamento e exibe
        System.out.printf("Get: %d: %s \n", storage.size(), ((LinkedList<?>) storage).poll());
    }
}

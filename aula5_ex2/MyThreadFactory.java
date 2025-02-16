package atividades.aula5_ex2;

/**
 *
 * @author Marcio de Arruda Fonseca
 */
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ThreadFactory;

// Implementação personalizada da fábrica de threads
public class MyThreadFactory implements ThreadFactory {

    // Contador para rastrear o número de threads criadas
    private int counter;
    
    // Nome base para as threads criadas
    private String name;
    
    // Lista para armazenar estatísticas das threads criadas
    private List<String> stats;

    // Construtor que recebe um nome base para as threads e inicializa os atributos
    public MyThreadFactory(String name) {
        counter = 0;
        this.name = name;
        stats = new ArrayList<String>();
    }

    // Implementação do método da interface ThreadFactory
    @Override
    public Thread newThread(Runnable r) {
        // Cria uma nova thread com um nome único baseado no contador
        Thread t = new Thread(r, name + "-Thread_" + counter);
        counter++;

        // Registra a criação da thread na lista de estatísticas
        stats.add(String.format("Criada a thread %d com nome %s em %s\n", 
                t.getId(), t.getName(), new Date()));
        
        return t;
    }

    // Método para obter as estatísticas das threads criadas
    public String getStats() {
        StringBuffer buffer = new StringBuffer();
        Iterator<String> it = stats.iterator();

        // Percorre a lista de estatísticas e concatena as informações
        while (it.hasNext()) {
            buffer.append(it.next());
        }

        return buffer.toString();
    }
}

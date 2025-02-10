/**
 * Classe Main que contém o método principal (main) para executar o programa.
 * Esta classe cria uma thread para executar a classe RelogioArquivo e a interrompe após 5 segundos.
  *
 * @author Márcio de Arruda Fonseca
 * @version 1.0
 */
 
package Atividades.aula4_ex1;
 
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        // Cria uma instância da classe RelogioArquivo
        RelogioArquivo clock = new RelogioArquivo();
        
        // Cria uma nova thread, passando a instância de RelogioArquivo como argumento
        Thread thread = new Thread(clock);
        
        // Inicia a thread, que começa a executar o método run() de RelogioArquivo
        thread.start();
        
        try {
            // A thread principal (main) dorme por 5 segundos
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            // Exibe o stack trace caso a thread principal seja interrompida
            e.printStackTrace();
        }
        
        // Interrompe a thread que está executando o RelogioArquivo
        thread.interrupt();
        
        // Espera a thread terminar sua execução (opcional, para sincronização)
        try {
            thread.join();
        } catch (InterruptedException e) {
            // Exibe o stack trace caso a thread principal seja interrompida durante o join
            e.printStackTrace();
        }
        
        // Mensagem indicando que o programa principal terminou
        System.out.println("Programa principal terminou.");
    }
}

/**
Sat Oct 28 10:15:30 UTC 2023
Sat Oct 28 10:15:31 UTC 2023
Sat Oct 28 10:15:32 UTC 2023
Sat Oct 28 10:15:33 UTC 2023
Sat Oct 28 10:15:34 UTC 2023
O RelogioArquivo foi interrompido Programa principal terminou.
*/

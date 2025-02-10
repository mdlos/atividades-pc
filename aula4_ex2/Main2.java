package atividades.aula4_ex2;
import aula4_ex2.CarregadorFontesDados;

import java.util.Date; // Importa a classe Date para manipulação de data e hora

/**
 * Classe principal que inicia as threads para carregar fontes de dados e conexões de rede.
 * Aguarda até 1 segundo pela conclusão da thread de fontes de dados e indefinidamente pela thread de conexões de rede.
 * @author Márcio de Arruda Fonseca
 * @version 1.0
 */
public class Main2 {

    public static void main(String[] args) {
        // Cria uma instância de CarregadorFontesDados
        CarregadorFontesDados dsLoader = new CarregadorFontesDados();
        // Cria uma thread para executar o CarregadorFontesDados
        Thread thread1 = new Thread(dsLoader, "ThreadFonteDados");
        thread1.start(); // Inicia a thread

        // Cria uma instância de CarregadorConexoesRede
        CarregadorConexoesRede ncLoader = new CarregadorConexoesRede();
        // Cria uma thread para executar o CarregadorConexoesRede
        Thread thread2 = new Thread(ncLoader, "ThreadConexaoRede");
        thread2.start(); // Inicia a thread

        try {
            // Aguarda até 1 segundo pela conclusão da thread de fontes de dados
            thread1.join(1000);
            // Aguarda indefinidamente pela conclusão da thread de conexões de rede
            thread2.join();
        } catch (InterruptedException e) {
            // Exibe o rastreamento do erro caso a thread seja interrompida
            e.printStackTrace();
        }

        // Exibe mensagem indicando que toda a configuração foi carregada com sucesso
        System.out.printf("Main: Configuração carregada: %s\n", new Date());
    }
}
/**
Iniciando o carregamento das fontes de dados: Sat Oct 28 10:25:00 UTC 2023
Iniciando o carregamento das conexões de rede: Sat Oct 28 10:25:00 UTC 2023
java.lang.InterruptedException: sleep interrupted
    at java.base/java.lang.Thread.sleep(Native Method)
    at aula4_ex2.CarregadorFontesDados.run(CarregadorFontesDados.java:20)
O carregamento das conexões de rede foi concluído: Sat Oct 28 10:25:04 UTC 2023
Main: Configuração carregada: Sat Oct 28 10:25:04 UTC 2023
*/

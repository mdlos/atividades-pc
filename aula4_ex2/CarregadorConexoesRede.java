package atividades.aula4_ex2;

import java.util.Date; // Importa a classe Date para manipulação de data e hora
import java.util.concurrent.TimeUnit; // Importa a classe TimeUnit para manipular unidades de tempo

/**
 * Classe que implementa a interface Runnable para carregar conexões de rede.
 * Simula um processo de carregamento que leva 4 segundos para ser concluído.
 * @author Márcio de Arruda Fonseca
 * @version 1.0
 */
public class CarregadorConexoesRede implements Runnable {

    /**
     * Método run() sobrescrito da interface Runnable.
     * Este método é executado quando a thread é iniciada.
     * Ele simula o carregamento de conexões de rede, exibindo mensagens no início e no fim do processo.
     */
    @Override
    public void run() {
        // Exibe mensagem indicando o início do carregamento das conexões de rede
        System.out.printf("Iniciando o carregamento das conexões de rede: %s\n", new Date());
        try {
            // Pausa a execução da thread por 4 segundos (simulando o carregamento)
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            // Exibe o rastreamento do erro caso a thread seja interrompida
            e.printStackTrace();
        }
        // Exibe mensagem indicando o término do carregamento das conexões de rede
        System.out.printf("O carregamento das conexões de rede foi concluído: %s\n", new Date());
    }
}

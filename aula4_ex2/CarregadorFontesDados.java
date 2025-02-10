package aula4_ex2;

import java.util.Date; // Importa a classe Date para manipulação de data e hora
import java.util.concurrent.TimeUnit; // Importa a classe TimeUnit para manipular unidades de tempo

/**
 * Classe que implementa a interface Runnable para carregar fontes de dados.
 * Simula um processo de carregamento que leva 6 segundos para ser concluído.
 * @author Márcio de Arruda Fonseca
 * @version 1.0
 */
public class CarregadorFontesDados implements Runnable {

    /**
     * Método run() sobrescrito da interface Runnable.
     * Este método é executado quando a thread é iniciada.
     * Ele simula o carregamento de fontes de dados, exibindo mensagens no início e no fim do processo.
     */
    @Override
    public void run() {
        // Exibe mensagem indicando o início do carregamento das fontes de dados
        System.out.printf("Iniciando o carregamento das fontes de dados: %s\n", new Date());
        try {
            // Pausa a execução da thread por 6 segundos (simulando o carregamento)
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            // Exibe o rastreamento do erro caso a thread seja interrompida
            e.printStackTrace();
        }
        // Exibe mensagem indicando o término do carregamento das fontes de dados
        System.out.printf("O carregamento das fontes de dados foi concluído: %s\n", new Date());
    }
}

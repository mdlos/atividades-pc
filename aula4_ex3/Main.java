package atividades.aula4_ex3;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Classe principal que inicia as threads responsáveis pela escrita e limpeza de eventos.
 * 
 * O programa cria múltiplas threads para gerar eventos e uma thread separada para limpar
 * eventos antigos da fila.
  * @author Márcio de Arruda Fonseca
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {
        // Criação de uma fila compartilhada para armazenar os eventos
        Deque<Event> deque = new ArrayDeque<>();

        // Inicia 3 threads para gerar eventos
        WriterTask writer = new WriterTask(deque);
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(writer);
            thread.start();
        }

        // Inicia a thread responsável por limpar eventos antigos
        CleanerTask cleaner = new CleanerTask(deque);
        cleaner.start();
    }
}

/**
 * Exemplo de saída esperada do programa:
 * 
 * Wed Oct 25 14:30:00 GMT 2023 Limpador: A thread 15 gerou um evento => Wed Oct 25 14:29:50 GMT 2023
 * Limpador: Tamanho da fila: 10
 * Wed Oct 25 14:30:01 GMT 2023 Limpador: A thread 16 gerou um evento => Wed Oct 25 14:29:51 GMT 2023
 * Limpador: Tamanho da fila: 10
 */


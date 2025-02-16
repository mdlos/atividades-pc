package atividades.aula6_ex3;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author Marcio de Arruda Fonseca
 */

/**
 * Classe que representa um buffer compartilhado entre produtores e consumidores.
 */
public class Buffer {
    private LinkedList<String> buffer = new LinkedList<>();
    private int maxSize;
    private ReentrantLock lock;
    private Condition lines;
    private Condition space;
    private boolean pendingLines;

    public Buffer(int maxSize) {
        this.maxSize = maxSize;
        lock = new ReentrantLock();
        lines = lock.newCondition();
        space = lock.newCondition();
        pendingLines = false;
    }

    /**
     * Insere uma linha no buffer.
     */
    public void insert(String line) {
        lock.lock();
        try {
            while (buffer.size() == maxSize && pendingLines) {
                space.await(); // Aguarda até que haja espaço no buffer
            }
            buffer.offer(line);
            System.out.println("Linha adicionada ao buffer: " + line);
            lines.signalAll(); // Notifica os consumidores que há novas linhas
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    /**
     * Remove uma linha do buffer.
     */
    public String remove() {
        lock.lock();
        try {
            while (buffer.size() == 0 && pendingLines) {
                lines.await(); // Aguarda até que haja linhas no buffer
            }
            if (buffer.size() > 0) {
                String line = buffer.removeFirst();
                System.out.println("Linha removida do buffer: " + line);
                space.signalAll(); // Notifica os produtores que há espaço no buffer
                return line;
            } else {
                return null;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        } finally {
            lock.unlock();
        }
    }

    /**
     * Define se há linhas pendentes.
     *  pendingLines true se há linhas pendentes, false caso contrário.
     */
    public void setPendingLines(boolean pendingLines) {
        lock.lock();
        try {
            this.pendingLines = pendingLines;
            if (!pendingLines) {
                lines.signalAll(); // Notifica todos os consumidores que não há mais linhas
            }
        } finally {
            lock.unlock();
        }
    }

    /**
     * Verifica se há linhas pendentes.
     * return true se há linhas pendentes, false caso contrário.
     */
    public boolean hasPendingLines() {
        lock.lock();
        try {
            return pendingLines || buffer.size() > 0;
        } finally {
            lock.unlock();
        }
    }
}

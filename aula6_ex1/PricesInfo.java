package atividades.aula6_ex1;
/**
 *
 * @author Marcio de Arruda Fonseca
 */

import java.util.Date;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class PricesInfo {

    // Variáveis para armazenar os preços
    private double price1;
    private double price2;

    // Lock para controle de leitura e escrita
    private ReadWriteLock lock;

    public PricesInfo() {
        price1 = 1.0;
        price2 = 2.0;
        
        // Inicializa o ReadWriteLock
        lock = new ReentrantReadWriteLock();
    }
    
    // Método para obter o preço 1
    public double getPrice1() {
        // Bloqueia para leitura
        lock.readLock().lock();
        
        System.out.println("price1 reading =====>");    
        try {
            Thread.sleep(100); // Simula um tempo de leitura
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        double value = price1;
        System.out.println("price1 reading <=====");
        
        // Libera o bloqueio de leitura
        lock.readLock().unlock();
        
        return value;
    }
    
    // Método para obter o preço 2
    public double getPrice2() {
        // Bloqueia para leitura
        lock.readLock().lock();
        
        System.out.println("price2 reading =====>");
        try {
            Thread.sleep(100); // Simula um tempo de leitura
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        double value = price2;
        System.out.println("price2 reading <=====");
        
        // Libera o bloqueio de leitura
        lock.readLock().unlock();
        
        return value;
    }
    
    // Método para definir os preços
    public void setPrices(double price1, double price2) {
        // Bloqueia para escrita
        lock.writeLock().lock();
        System.out.println(" at " + new Date());
        try {
            Thread.sleep(2 * 1000); // Simula um tempo de escrita
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        this.price1 = price1;
        this.price2 = price2;
        
        System.out.println("     at " + new Date());
        // Libera o bloqueio de escrita
        lock.writeLock().unlock();
    }
}

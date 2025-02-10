package atividades.aula5_ex3.Cenario2;

/**
 *
 * @author Marcio de Arruda Fonseca
 */

public class Account {

    private double balance;

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Método sincronizado para adicionar um valor ao saldo da conta
    public synchronized void addAmount(double amount) {
        double tmp = balance;
        try {
            Thread.sleep(10); // Simula uma pausa
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tmp += amount;
        balance = tmp;
    }

    // Método sincronizado para subtrair um valor do saldo da conta
    public synchronized void subtractAmount(double amount) {
        double tmp = balance;
        try {
            Thread.sleep(10); // Simula uma pausa
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tmp -= amount;
        balance = tmp;
    }
}

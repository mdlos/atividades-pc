package atividades.aula5_ex3.Cenario1;

/**
 *
 * @author Marcio de Arruda Fonseca
 */

public class Main {

    public static void main(String[] args) {
        Account account = new Account();
        account.setBalance(1000);

        Company company = new Company(account);
        Thread companyThread = new Thread(company);

        Bank bank = new Bank(account);
        Thread bankThread = new Thread(bank);

        System.out.printf("Conta : Balanço inicial: %f\n", account.getBalance());

        companyThread.start();
        bankThread.start();

        try {
            companyThread.join();
            bankThread.join();
            System.out.printf("Conta : Balanço Final: %f\n", account.getBalance());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

/**
Cenário 1: Sem Sincronização
Saida:
Conta : Balanço inicial: 1000.000000
Conta : Balanço Final: 850.000000
*/

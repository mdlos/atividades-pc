package atividades.aula5_ex3.Cenario1;

/**
 *
 * @author Marcio de Arruda Fonseca
 */
 
public class Bank implements Runnable {

    // Atributo privado para representar a conta bancária
    private Account account;

    // Construtor que recebe a conta bancária como parâmetro
    public Bank(Account account) {
        this.account = account;
    }

    // Método que executa a lógica da thread
    @Override
    public void run() {
        // Realiza 100 saques de 1000 cada
        for (int i = 0; i < 100; i++) {
            account.subtractAmount(1000); // Subtrai 1000 da conta
        }
    }
}

package atividades.aula5_ex3.Cenario1;

/**
 *
 * @author Marcio de Arruda Fonseca
 */
 
public class Company implements Runnable {

    // Atributo que representa a conta bancária compartilhada
    
        // Construtor que recebe uma instância de Conta
    	private Account account;

	public Company(Account account) {
		this.account = account; // Atribui a conta recebida ao atributo da classe
	}

    @Override
    // Método que será executado quando a thread for iniciada
    public void run() {
        // Laço que executa 100 vezes, depositando 1000 na conta a cada iteração
        for (int i = 0; i < 100; i++) {
            account.addAmount(1000); // Chama o método de adicionar valor à conta
        }
    }
}


package atividades.aula8_ex2;

/**
 *
 * @author Marcio de Arruda Fonseca
 */


import java.util.Random;
import java.util.concurrent.TimeUnit;

public class UserValidator {
    private String name; // Nome do validador

    // Construtor que recebe o nome do validador
    public UserValidator(String name) {
        this.name = name;
    }

    // Método para validar o usuário e senha
    public boolean validate(String name, String password) {
        Random random = new Random();

        try {
            // Simula um tempo aleatório de validação (entre 0 e 10 segundos)
            Long duration = (long) (Math.random() * 10);
            System.out.printf("Validador %s: Validando usuário por %d segundos\n", this.name, duration);
            TimeUnit.SECONDS.sleep(duration);
        } catch (InterruptedException e) {
            return false; // Retorna false em caso de interrupção
        }

        // Retorna um valor booleano aleatório para simular sucesso ou falha na validação
        return random.nextBoolean();
    }

    // Retorna o nome do validador
    public String getName() {
        return name;
    }
}

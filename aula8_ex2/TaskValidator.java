package atividades.aula8_ex2;

/**
 *
 * @author Marcio de Arruda Fonseca
 */


import java.util.concurrent.Callable;

public class TaskValidator implements Callable<String> {

    private UserValidator validator; // Validador de usuário
    private String user; // Nome do usuário
    private String password; // Senha do usuário

    // Construtor que recebe o validador, usuário e senha
    public TaskValidator(UserValidator validator, String user, String password) {
        this.validator = validator;
        this.user = user;
        this.password = password;
    }

    @Override
    public String call() throws Exception {
        // Valida o usuário e senha
        if (!validator.validate(user, password)) {
            System.out.printf("%s: O usuário não foi encontrado\n", validator.getName());
            throw new Exception("Erro ao validar usuário");
        }

        // Se a validação for bem-sucedida, exibe uma mensagem e retorna o nome do validador
        System.out.printf("%s: O usuário foi encontrado\n", validator.getName());
        return validator.getName();
    }
}

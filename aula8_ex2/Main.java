package atividades.aula8_ex2;

/**
 *
 * @author Marcio de Arruda Fonseca
 */


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        // Dados do usuário para validação
        String username = "test";
        String password = "test";

        // Cria dois validadores: LDAP e Database
        UserValidator ldapValidator = new UserValidator("LDAP");
        UserValidator dbValidator = new UserValidator("Database");

        // Cria tarefas de validação para cada validador
        TaskValidator ldapTask = new TaskValidator(ldapValidator, username, password);
        TaskValidator dbTask = new TaskValidator(dbValidator, username, password);

        // Lista de tarefas a serem submetidas ao executor
        List<TaskValidator> taskList = new ArrayList<>();
        taskList.add(ldapTask);
        taskList.add(dbTask);

        // Cria um ExecutorService com um pool de threads dinâmico
        ExecutorService executor = Executors.newCachedThreadPool();
        String result;
        try {
            // Submete as tarefas e retorna o resultado da primeira tarefa bem-sucedida
            result = executor.invokeAny(taskList);
            System.out.printf("Main: Resultado: %s\n", result);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace(); // Trata exceções
        }

        // Encerra o executor
        executor.shutdown();
        System.out.printf("Main: Fim da execução\n");
    }
}

/*
Saida: 
/*
Validador LDAP: Validando usuário por 3 segundos
Validador Database: Validando usuário por 7 segundos
LDAP: O usuário foi encontrado
Main: Resultado: LDAP
Database: O usuário não foi encontrado
Main: Fim da execução
*/

/*
Validador Database: Validando usuário por 2 segundos
Validador LDAP: Validando usuário por 5 segundos
Database: O usuário foi encontrado
Main: Resultado: Database
LDAP: O usuário não foi encontrado
Main: Fim da execução
*/

/*
Validador LDAP: Validando usuário por 4 segundos
Validador Database: Validando usuário por 6 segundos
LDAP: O usuário não foi encontrado
Database: O usuário não foi encontrado
java.util.concurrent.ExecutionException: java.lang.Exception: Erro ao validar usuário
Main: Fim da execução
*/
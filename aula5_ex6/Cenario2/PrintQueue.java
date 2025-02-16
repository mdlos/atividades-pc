package atividades.aula5_ex6.Cenario2;
/**
 *
 * @author Marcio de Arruda Fonseca
 */
 
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintQueue {

    // Declaração de um objeto Lock para controlar o acesso ao recurso compartilhado (impressora)
    private final Lock queueLock = new ReentrantLock();
    
    // Formato de data para exibir o tempo de execução em minutos, segundos e milissegundos
    private final SimpleDateFormat sdf = new SimpleDateFormat("mm:ss.SSS.sss");

    // Método que simula a impressão de um documento
    public void printJob(Object document) {
        
        // Aquisição do bloqueio para garantir que apenas uma thread acesse o método por vez
        queueLock.lock();
        
        // Exibindo a data e hora do início da impressão
        System.out.println("::  at : " + sdf.format(new Date()));

        try {
            // Gerando uma duração aleatória para a impressão (entre 0 e 10000 milissegundos)
            long duration = (long) (Math.random() * 10000);
            
            // Exibindo o nome da thread que está imprimindo e a duração da impressão
            System.out.printf("%s: PrintQueue: Printing a Job during %d seconds, sleep at %s \n", 
                              Thread.currentThread().getName(), 
                              (duration / 1000), 
                              sdf.format(new Date()));
                              
            // Simulando o tempo de impressão (dormindo por 'duration' milissegundos)
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            // Caso a thread seja interrompida durante o sleep, o erro é exibido
            e.printStackTrace();
        } finally {
            // Exibindo a data e hora do término da impressão
            System.out.println("::  at : " + sdf.format(new Date()) + "\r\n");

            // Liberando o bloqueio para que outras threads possam acessar o método
            queueLock.unlock();
        }
    }
}

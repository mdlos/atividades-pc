package atividades.aula5_ex6.Cenario1;
/**
 *
 * @author Marcio de Arruda Fonseca
 */
 
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintQueue {

    // Formato de data para exibir o tempo de execução em minutos, segundos e milissegundos
    private final SimpleDateFormat sdf = new SimpleDateFormat("mm:ss.SSS.sss");

    // Método que simula a impressão de um documento (sem uso de Lock)
    public void printJob(Object document) {
        
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
        }
    }
}


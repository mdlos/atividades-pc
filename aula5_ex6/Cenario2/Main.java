package atividades.aula5_ex6.Cenario2;
/**
 *
 * @author Marcio de Arruda Fonseca
 */
public class Main {

	public static void main(String[] args) {
		PrintQueue printQueue = new PrintQueue();

		Thread thread[] = new Thread[10];
		for (int i = 0; i < 10; i++) {
			thread[i] = new Thread(new Job(printQueue), "Thread " + i);
		}

		for (int i = 0; i < 10; i++) {
			thread[i].start();
		}
	}
}
/**
Saida:

::  at : 12:34.567.890
Thread 0: PrintQueue: Printing a Job during 5 seconds, sleep at 12:34.567.890
::  at : 12:34.572.890

::  at : 12:34.572.890
Thread 1: PrintQueue: Printing a Job during 3 seconds, sleep at 12:34.572.890
::  at : 12:34.575.890

::  at : 12:34.575.890
Thread 2: PrintQueue: Printing a Job during 7 seconds, sleep at 12:34.575.890
::  at : 12:34.582.890

*/

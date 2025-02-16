package atividades.aula8_ex3;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {
	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();

		List<Task> taskList = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			Task task = new Task("Task-" + i);
			taskList.add(task);
		}

		List<Future<Result>> resultList = null;
		// List<Future<Result>>resultList = null;

		System.out.println(new Date());
		try {
			resultList = executor.invokeAll(taskList);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Finish the executor
		executor.shutdown();
		System.out.println(new Date());

		System.out.printf("Core: Printing the results\n");
		for (int i = 0; i < resultList.size(); i++) {
			Future<Result> future = resultList.get(i);

			try {
				Result result = future.get();
				System.out.printf("%s: %s\n", result.getName(), result.getValue());
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 	Wed May 15 13:20:39 CST 2013
		Task-1: Staring
		Task-2: Staring
		Task-0: Staring
		Task-1: Waiting 6 seconds for results.
		Task-2: Waiting 7 seconds for results.
		Task-0: Waiting 6 seconds for results.
		Task-1: Ends
		Task-0: Ends
		Task-2: Ends
		Wed May 15 13:20:47 CST 2013
		Core: Printing the results
		Task-0: 202
		Task-1: 302
		Task-2: 159
	 */
}

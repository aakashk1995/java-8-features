package com.example.java8.java8features.competableFutures;

import java.util.List;
import java.util.concurrent.*;

import com.example.java8.java8features.streamapi.dao.EmployeeDao;
import com.example.java8.java8features.streamapi.model.Employee;


/**
 * If we want to run some background task asynchronously and want to return
 * anything from that task, then use CompletableFuture.supplyAsync() method. It
 * takes a Supplier<T> and returns CompletableFuture<T> where T is the type of
 * the value obtained by calling the given supplier.
 * 
 * CompletableFuture.supplyAsync(Supplier<T>)
 * 
 * Returns a new CompletableFuture that is asynchronously completed by a task
 * running in the {@link ForkJoinPool#commonPool()} with the value obtained by
 * calling the given Supplier.
 * 
 * CompletableFuture.supplyAsync(Supplier<T>,Executor)
 * 
 * Returns a new CompletableFuture that is asynchronously completed by a task
 * running in the given executor with the value obtained by calling the given
 * Supplier.
 *
 */
public class SupplyAsyncMethod {
	static ExecutorService executor = Executors.newFixedThreadPool(5);

	public CompletableFuture<List<Employee>> getEmployees() throws InterruptedException, ExecutionException {
		CompletableFuture<List<Employee>> completableFuture = CompletableFuture.supplyAsync(() -> {
			System.out.println("Thread : " + Thread.currentThread().getName());
			// Thread : ForkJoinPool.commonPool-worker-1 i.e; global thread pool
			delay(10);
			return EmployeeDao.getEmployees();
		});
		return completableFuture;
	}

	public CompletableFuture<List<Employee>> getEmployeesCustomExecutor() throws InterruptedException, ExecutionException {
		CompletableFuture<List<Employee>> completableFuture = CompletableFuture.supplyAsync(() -> {
			System.out.println("Thread : " + Thread.currentThread().getName());
			// Thread : pool-1-thread-1 i.e; own thread pool
			delay(5);
			return EmployeeDao.getEmployees();
		}, executor);
		return completableFuture;
	}

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		SupplyAsyncMethod method = new SupplyAsyncMethod();
		System.out.println("executing employees1");
		CompletableFuture<List<Employee>> employees1 = method.getEmployees();
		System.out.println("executing emplyess custom executor");
		CompletableFuture<List<Employee>> employeesCustomExecutor = method.getEmployeesCustomExecutor();
		System.out.println("executor custom finished");

		System.out.println(employees1.get().size());
		System.out.println(employeesCustomExecutor.get().size());
		executor.shutdown();
	}

	private static void delay(int sec) {
		try {
			TimeUnit.SECONDS.sleep(sec);
		} catch (InterruptedException e) {
			e.getMessage();
		}
	}
}

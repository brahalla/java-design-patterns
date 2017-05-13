package com.brahalla.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class App {

  public static void main(String[] args) {

    List<Task> taskList = new ArrayList<>();
    taskList.add(new CoffeeBrewingTask(2));
    taskList.add(new WoodChoppingTask(2));
    taskList.add(new WoodChoppingTask(4));
    taskList.add(new CoffeeBrewingTask(3));
    taskList.add(new WoodChoppingTask(1));
    taskList.add(new CoffeeBrewingTask(6));
    taskList.add(new CoffeeBrewingTask(14));
    taskList.add(new WoodChoppingTask(2));
    taskList.add(new WoodChoppingTask(1));
    taskList.add(new CoffeeBrewingTask(7));
    taskList.add(new CoffeeBrewingTask(2));
    taskList.add(new WoodChoppingTask(1));
    taskList.add(new WoodChoppingTask(17));
    taskList.add(new CoffeeBrewingTask(1));
    taskList.add(new WoodChoppingTask(2));
    taskList.add(new WoodChoppingTask(1));
    taskList.add(new CoffeeBrewingTask(1));
    taskList.add(new WoodChoppingTask(9));
    taskList.add(new WoodChoppingTask(1));
    taskList.add(new CoffeeBrewingTask(1));


    // Fixed threadpool invoking each task manually
    System.out.println("Fixed threadpool execution starting!");
    ExecutorService fixedExecutor = Executors.newFixedThreadPool(3);
    taskList.forEach(t -> {
      Runnable worker = new Worker(t);
      fixedExecutor.execute(worker);
    });

    fixedExecutor.shutdown();
    while (!fixedExecutor.isTerminated()) {
      Thread.yield();
    }
    System.out.println("Fixed threadpool execution finished!");


    // Cached threadpool invoking a list of callable tasks
    System.out.println("Cached threadpool execution starting!");
    ExecutorService cachedExecutor = Executors.newCachedThreadPool();
    List<Callable<Task>> callList = taskList.stream()
      .map(Caller::new)
      .collect(Collectors.toList());

    try {
      cachedExecutor.invokeAll(callList)
        .forEach(f -> {
          try {
            System.out.println(f.get());
          } catch (Exception e) {
            System.out.println("Task execution failed.");
          }
        });
    } catch (InterruptedException e) {
      System.out.println("Thread execution timed out.");
    }
    cachedExecutor.shutdown();
    System.out.println("Cached threadpool execution finished!");


  }

}

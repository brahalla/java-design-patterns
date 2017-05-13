package com.brahalla.threadpool;

public class Worker implements Runnable {

  private Task task;

  public Worker(final Task task) {
    this.task = task;
  }

  @Override
  public void run() {
    System.out.println(String.format("%s processing %s", Thread.currentThread().getName(), this.task.toString()));
    try {
      Thread.sleep(this.task.getSleepMs());
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}

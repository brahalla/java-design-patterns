package com.brahalla.threadpool;

import java.util.concurrent.Callable;

public class Caller implements Callable<Task> {

  private Task task;

  public Caller(final Task task) {
    this.task = task;
  }

  @Override
  public Task call() throws Exception {
    Thread.sleep(this.task.getSleepMs());
    return this.task;
  }

}

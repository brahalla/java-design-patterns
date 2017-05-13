package com.brahalla.threadpool;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class Task {

  private static final AtomicInteger ID_GENERATOR = new AtomicInteger();

  private int id;
  private int sleepMs;

  public Task(final int sleepMs) {
    this.id = ID_GENERATOR.incrementAndGet();
    this.sleepMs = sleepMs;
  }

  public int getId() {
    return this.id;
  }

  public int getSleepMs() {
    return this.sleepMs;
  }

  @Override
  public String toString() {
    return String.format("%s: id: %s, sleep: %s ms", this.getClass().getSimpleName(), this.id, this.sleepMs);
  }

}

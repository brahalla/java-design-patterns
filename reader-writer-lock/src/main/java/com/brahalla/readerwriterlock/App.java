package com.brahalla.readerwriterlock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.stream.IntStream;

public class App {

  public static void main(String[] args) {

    ExecutorService executor = Executors.newFixedThreadPool(10);
    ReadWriteLock lock = new ReentrantReadWriteLock();

    IntStream.range(0, 5)
      .forEach(i -> executor.submit(new Reader(lock.readLock(), "Reader" + i)));

    IntStream.range(0, 5)
      .forEach(i -> executor.submit(new Writer(lock.writeLock(), "Writer" + i)));

    executor.shutdown();
    try {
      executor.awaitTermination(5, TimeUnit.SECONDS);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

  }

}

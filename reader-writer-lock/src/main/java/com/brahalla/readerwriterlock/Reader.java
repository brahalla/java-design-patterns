package com.brahalla.readerwriterlock;

import java.util.concurrent.locks.Lock;

public class Reader implements Runnable {

  private Lock lock;
  private String name;

  public Reader(final Lock lock, final String name) {
    this.lock = lock;
    this.name = name;
  }

  public void read() throws InterruptedException {
    System.out.println(String.format("%s beginning read", this.name));
    Thread.sleep(250);
    System.out.println(String.format("%s ending read", this.name));
  }

  @Override
  public void run() {
    this.lock.lock();
    try {
      this.read();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      this.lock.unlock();
    }
  }

}

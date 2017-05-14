package com.brahalla.readerwriterlock;

import java.util.concurrent.locks.Lock;

public class Writer implements Runnable {

  private Lock lock;
  private String name;

  public Writer(final Lock lock, final String name) {
    this.lock = lock;
    this.name = name;
  }

  public void write() throws InterruptedException {
    System.out.println(String.format("%s beginning write", this.name));
    Thread.sleep(250);
    System.out.println(String.format("%s ending write", this.name));
  }

  @Override
  public void run() {
    this.lock.lock();
    try {
      this.write();
    } catch (InterruptedException e) {
      e.printStackTrace();
    } finally {
      this.lock.unlock();
    }
  }

}

package com.brahalla.threadpool;

public class CoffeeBrewingTask extends Task {

  private static final int TIME_PER_POT = 100;

  public CoffeeBrewingTask(final int numPots) {
    super(numPots * TIME_PER_POT);
  }

}

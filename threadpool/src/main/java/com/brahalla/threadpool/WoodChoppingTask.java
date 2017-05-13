package com.brahalla.threadpool;

public class WoodChoppingTask extends Task {

  private static final int TIME_PER_LOG = 100;

  public WoodChoppingTask(final int numLogs) {
    super(numLogs * TIME_PER_LOG);
  }

}

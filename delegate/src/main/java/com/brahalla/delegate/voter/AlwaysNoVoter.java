package com.brahalla.delegate.voter;

public class AlwaysNoVoter implements Voter {

  private String name;

  public AlwaysNoVoter(final String name) {
    this.name = name;
  }

  @Override
  public boolean vote() {
    return false;
  }

  @Override
  public String getName() {
    return this.name;
  }

}

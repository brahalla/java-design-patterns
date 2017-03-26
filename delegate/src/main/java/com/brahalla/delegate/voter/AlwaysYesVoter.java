package com.brahalla.delegate.voter;

public class AlwaysYesVoter implements Voter {

  private String name;

  public AlwaysYesVoter(final String name) {
    this.name = name;
  }

  @Override
  public boolean vote() {
    return true;
  }

  @Override
  public String getName() {
    return this.name;
  }

}

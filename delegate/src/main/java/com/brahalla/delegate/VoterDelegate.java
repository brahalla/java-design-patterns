package com.brahalla.delegate;

import com.brahalla.delegate.voter.Voter;

import java.util.LinkedList;
import java.util.List;

public class VoterDelegate {

  private List<Voter> voters = new LinkedList<Voter>();

  public void addVoter(Voter voter, int position) throws IndexOutOfBoundsException {
    this.voters.add(position, voter);
  }

  public Voter performVote() {
    return this.voters.stream()
      .filter(v -> v.vote())
      .findFirst().orElse(null);
  }

}

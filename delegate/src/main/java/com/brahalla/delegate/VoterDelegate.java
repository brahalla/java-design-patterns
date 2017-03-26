package com.brahalla.delegate;

import com.brahalla.delegate.voter.Voter;

import java.util.LinkedList;
import java.util.List;

public class VoterDelegate {

  private List<Voter> voters;

  public VoterDelegate() {
    this.voters = new LinkedList<Voter>();
  }

  public VoterDelegate(List<Voter> voters) {
    this.voters = voters;
  }

  public void addVoter(Voter voter, int position) throws IndexOutOfBoundsException {
    this.voters.add(position, voter);
  }

  public int getNumberOfVoters() {
    return this.voters.size();
  }

  public Voter performVote() {
    return this.voters.stream()
      .filter(v -> v.vote())
      .findFirst().orElse(null);
  }

}

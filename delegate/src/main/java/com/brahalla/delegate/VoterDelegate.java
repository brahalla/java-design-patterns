package com.brahalla.delegate;

import com.brahalla.delegate.voter.Voter;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class VoterDelegate {

  public enum Strategy {
    PRIORITY,
    ROUND_ROBIN
  }

  private final Strategy DEFAULT_STRATEGY = Strategy.PRIORITY;
  private LinkedList<Voter> voters;
  private Strategy strategy;

  public VoterDelegate() {
    this.voters = new LinkedList<Voter>();
    this.strategy = DEFAULT_STRATEGY;
  }

  public VoterDelegate(LinkedList<Voter> voters) {
    this.voters = voters;
    this.strategy = DEFAULT_STRATEGY;
  }

  public List<Voter> getVoters() {
    return this.voters;
  }

  public void addVoter(Voter voter) {
    this.voters.addLast(voter);
  }

  public void addVoter(Voter voter, int position) throws IndexOutOfBoundsException {
    this.voters.add(position, voter);
  }

  public Strategy getStrategy() {
    return this.strategy;
  }

  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  public int getNumberOfVoters() {
    return this.voters.size();
  }

  public Voter performVote() {
    Voter winner = winner = this.voters.stream()
      .filter(v -> v.vote())
      .findFirst().orElse(null);

    if (winner != null && Strategy.ROUND_ROBIN.equals(this.strategy)) {
      this.voters.remove(winner);
      this.voters.addLast(winner);
    }

    return winner;
  }

}

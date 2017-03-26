package com.brahalla.delegate;

import com.brahalla.delegate.VoterDelegate.Strategy;
import com.brahalla.delegate.voter.*;

public class App {

  public static void main(String[] args) {

    VoterDelegate delegate = new VoterDelegate();
    delegate.addVoter(new AlwaysNoVoter("alwaysVotesNo"), 0);
    delegate.addVoter(new AlwaysYesVoter("alwaysVotesYes"), 1);
    delegate.addVoter(new AlwaysYesVoter("alwaysVotesYesTwo"), 2);

    System.out.println(String.format("Running elections using priority strategy"));

    Voter winner = delegate.performVote();
    System.out.println(String.format("Election 1 winner: %s", winner.getName()));
    winner = delegate.performVote();
    System.out.println(String.format("Election 2 winner: %s", winner.getName()));
    winner = delegate.performVote();
    System.out.println(String.format("Election 3 winner: %s", winner.getName()));

    delegate.setStrategy(Strategy.ROUND_ROBIN);
    System.out.println(String.format("Running elections using round robin strategy"));

    winner = delegate.performVote();
    System.out.println(String.format("Election 4 winner: %s", winner.getName()));
    winner = delegate.performVote();
    System.out.println(String.format("Election 5 winner: %s", winner.getName()));
    winner = delegate.performVote();
    System.out.println(String.format("Election 6 winner: %s", winner.getName()));

  }

}

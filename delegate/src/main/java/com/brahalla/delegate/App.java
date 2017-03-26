package com.brahalla.delegate;

import com.brahalla.delegate.voter.*;

public class App {

  public static void main(String[] args) {

    VoterDelegate delegate = new VoterDelegate();
    delegate.addVoter(new AlwaysNoVoter("alwaysVotesNo"), 0);
    delegate.addVoter(new AlwaysYesVoter("alwaysVotesYes"), 1);
    delegate.addVoter(new AlwaysYesVoter("alwaysVotesYesTwo"), 2);

    Voter winner = delegate.performVote();

    System.out.println(String.format("Winner: %s", winner.getName()));

  }

}

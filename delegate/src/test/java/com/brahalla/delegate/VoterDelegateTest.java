package com.brahalla.delegate;

import com.brahalla.delegate.VoterDelegate.Strategy;
import com.brahalla.delegate.voter.*;

import com.flextrade.jfixture.JFixture;
import com.flextrade.jfixture.utility.SpecimenType;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class VoterDelegateTest {

  private final JFixture fixture = new JFixture();
  private VoterDelegate delegate;
  private LinkedList<Voter> voters;

  @Before
  public void before() {
    this.fixture.customise().useSubType(Voter.class, AlwaysNoVoter.class);
    LinkedList<Voter> v = this.createNoVoters();
    this.voters = spy(v);
    this.delegate = new VoterDelegate(this.voters);
  }

  @Test
  public void defaultStrategy_ShouldBePriority() {
    assertEquals(this.delegate.getStrategy(), Strategy.PRIORITY);
  }

  @Test
  public void addVoter_WithPosition_ShouldAddVoterToCorrectPosition() {
    int initialSize = this.delegate.getNumberOfVoters();
    Voter voter = this.fixture.create(Voter.class);

    int position = initialSize / 2;
    this.delegate.addVoter(voter, position);

    assertEquals(this.delegate.getNumberOfVoters(), initialSize + 1);
    assertTrue(this.voters.contains(voter));
    assertEquals(this.voters.indexOf(voter), position);
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void addVoter_WithInvalidPosition_ShouldThrowException() {
    int initialSize = this.delegate.getNumberOfVoters();
    Voter voter = this.fixture.create(Voter.class);

    int position = initialSize + 1;
    this.delegate.addVoter(voter, position);
  }

  @Test
  public void addVoter_WithNoPosition_ShouldAddVoterToEndOfList() {
    Voter voter = this.fixture.create(Voter.class);

    this.delegate.addVoter(voter);
    int size = this.voters.size();

    assertEquals(this.voters.get(size - 1), voter);
  }

  @Test
  public void getNumberOfVoters_ShouldReturnTotalNumberOfVoters() {
    assertEquals(this.voters.size(), this.delegate.getNumberOfVoters());
  }

  @Test
  public void performVote_WithNoVotersThatVoteYes_ShouldReturnNull() {
    Voter winner = this.delegate.performVote();

    assertNull(winner);
  }

  @Test
  public void performVote_WithOneYesVoter_ShouldReturnYesVoter() {
    this.fixture.customise().useSubType(Voter.class, AlwaysYesVoter.class);
    Voter yesVoter = this.fixture.create(Voter.class);
    this.delegate.addVoter(yesVoter);

    Voter winner = this.delegate.performVote();

    assertEquals(winner, yesVoter);
  }

  @Test
  public void performVote_WithManyYesVoters_ShouldReturnFirstYesVoter() {
    this.fixture.customise().useSubType(Voter.class, AlwaysYesVoter.class);
    Voter firstYesVoter = this.fixture.create(Voter.class);
    Voter secondYesVoter = this.fixture.create(Voter.class);
    Voter thirdYesVoter = this.fixture.create(Voter.class);
    this.delegate.addVoter(firstYesVoter, 0);
    this.delegate.addVoter(secondYesVoter, this.delegate.getNumberOfVoters() / 2);
    this.delegate.addVoter(thirdYesVoter);

    Voter winner = this.delegate.performVote();

    assertEquals(winner, firstYesVoter);
  }

  @Test
  public void performVote_UsingPriorityStrategy_ShouldRetainListOrder() {
    LinkedList<Voter> v = this.createYesVoters();
    this.voters = spy(v);
    this.delegate = new VoterDelegate(this.voters);

    Voter firstWinner = this.delegate.performVote();
    Voter secondWinner = this.delegate.performVote();

    assertEquals(firstWinner, secondWinner);
    assertEquals(this.voters.indexOf(firstWinner), 0);
  }

  @Test
  public void performVote_UsingRoundRobinStrategy_ShouldMoveWinnerToEndOfList() {
    LinkedList<Voter> v = this.createYesVoters();
    this.voters = spy(v);
    this.delegate = new VoterDelegate(this.voters);
    this.delegate.setStrategy(Strategy.ROUND_ROBIN);

    Voter firstWinner = this.delegate.performVote();
    Voter secondWinner = this.delegate.performVote();

    assertNotEquals(firstWinner, secondWinner);
    assertEquals(this.voters.indexOf(firstWinner), this.voters.size() - 2);
    assertEquals(this.voters.indexOf(secondWinner), this.voters.size() - 1);
  }

  private LinkedList<Voter> createYesVoters() {
    this.fixture.customise().useSubType(Voter.class, AlwaysYesVoter.class);
    LinkedList<Voter> v = this.fixture.create(new SpecimenType<LinkedList<Voter>> () {});
    return v;
  }

  private LinkedList<Voter> createNoVoters() {
    this.fixture.customise().useSubType(Voter.class, AlwaysNoVoter.class);
    LinkedList<Voter> v = this.fixture.create(new SpecimenType<LinkedList<Voter>> () {});
    return v;
  }

}

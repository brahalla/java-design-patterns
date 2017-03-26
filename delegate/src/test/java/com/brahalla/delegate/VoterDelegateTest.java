package com.brahalla.delegate;

import com.brahalla.delegate.voter.*;

import com.flextrade.jfixture.JFixture;
import com.flextrade.jfixture.utility.SpecimenType;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class VoterDelegateTest {

  private final JFixture fixture = new JFixture();
  private VoterDelegate delegate;
  private List<Voter> voters;
  private List<Voter> votersSpy;

  @Before
  public void before() {
    this.fixture.customise().useSubType(Voter.class, AlwaysNoVoter.class);
    this.voters = this.fixture.create(new SpecimenType<List<Voter>> () {});
    this.votersSpy = spy(this.voters);
    this.delegate = new VoterDelegate(this.voters);
  }

  @Test
  public void addVoter_WithPosition_ShouldAddVoterToCorrectPosition() {
    int initialSize = this.delegate.getNumberOfVoters();
    Voter voter = this.fixture.create(Voter.class);

    int position = initialSize / 2;
    this.delegate.addVoter(voter, position);

    assertEquals(this.delegate.getNumberOfVoters(), initialSize + 1);
    assertTrue(this.votersSpy.contains(voter));
    assertEquals(this.votersSpy.indexOf(voter), position);
  }

  @Test(expected = IndexOutOfBoundsException.class)
  public void addVoter_WithInvalidPosition_ShouldThrowException() {
    int initialSize = this.delegate.getNumberOfVoters();
    Voter voter = this.fixture.create(Voter.class);

    int position = initialSize + 1;
    this.delegate.addVoter(voter, position);
  }

  @Test
  public void getNumberOfVoters_ShouldReturnTotalNumberOfVoters() {
    assertEquals(this.votersSpy.size(), this.delegate.getNumberOfVoters());
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
    this.delegate.addVoter(yesVoter, this.delegate.getNumberOfVoters() - 1);

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
    this.delegate.addVoter(thirdYesVoter, this.delegate.getNumberOfVoters() - 1);

    Voter winner = this.delegate.performVote();

    assertEquals(winner, firstYesVoter);
  }

}

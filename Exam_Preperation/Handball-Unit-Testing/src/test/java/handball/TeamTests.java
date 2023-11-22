package handball;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TeamTests {

    private final static String TEAM_NAME = "Barcelona";
    private final static int POSITION = 3;
    private final HandballPlayer TEST1_PLAYER = new HandballPlayer("Stefan");
    private final HandballPlayer TEST2_PLAYER = new HandballPlayer("Mitko");
    private final HandballPlayer TEST3_PLAYER = new HandballPlayer("Vladko");
    private Team team;

    @Before
    public void setTeam() {
        this.team = new Team(TEAM_NAME, POSITION);
        team.add(TEST1_PLAYER);
        team.add(TEST2_PLAYER);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateTeamThrowExceptionWithNegativePosition() {
        this.team = new Team(TEAM_NAME, -1);
    }
    @Test
    public void testCreateTeamWithValidPosition() {
        Assert.assertEquals(POSITION, team.getPosition());
    }

    @Test(expected = NullPointerException.class)
    public void testCreateTeamThrowExceptionWithNullName() {
        this.team = new Team(null, POSITION);
    }

    @Test(expected = NullPointerException.class)
    public void testCreateTeamThrowExceptionWithWhiteSpaces() {
        this.team = new Team("", POSITION);
    }
    @Test
    public void testCreateTeamWithValidName() {
       Assert.assertEquals(TEAM_NAME, team.getName());
    }

    @Test
    public void testGetNameMethodReturnsFieldName() {
        Assert.assertEquals(TEAM_NAME, team.getName());
    }

    @Test
    public void testGetPositionReturnsFieldPosition() {
        Assert.assertEquals(POSITION, team.getPosition());
    }

    @Test
    public void testGetCountMethodReturnsNumberOfPlayers() {
        this.team = new Team(TEAM_NAME,POSITION);
        Assert.assertEquals(0, team.getCount());
    }

    @Test
    public void testAddMethodSuccessfullyAddPlayer() {
        team.add(TEST3_PLAYER);
        Assert.assertEquals(3, team.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddMethodThrowExceptionWhenTeamIsFull() {
        team.add(TEST3_PLAYER);
        team.add(TEST1_PLAYER);
    }

    @Test
    public void testRemoveMethodSuccessfullyRemovePlayer() {
        team.add(TEST3_PLAYER);

        team.remove(TEST2_PLAYER.getName());

        Assert.assertEquals(2, team.getCount());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testRemoveMethodThrowExceptionOnInvalidPlayer() {
        team.remove("Invalid");
    }

    @Test
    public void testPlayerForAnotherTeam() {
        HandballPlayer returnedPlayer = team.playerForAnotherTeam(TEST1_PLAYER.getName());
        Assert.assertFalse(returnedPlayer.isActive());
    }


    @Test (expected = IllegalArgumentException.class)
    public void testPlayerForAnotherTeamThrowException() {
        team.playerForAnotherTeam("Invalid");
    }

    @Test
    public void testGetStatisticsMethodSuccessfullyWork() {
        String expectedResult = "The player Stefan, Mitko is in the team Barcelona.";
        Assert.assertEquals(expectedResult,team.getStatistics());
    }

}

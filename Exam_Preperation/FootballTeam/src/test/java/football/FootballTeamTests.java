package football;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class FootballTeamTests {
    private FootballTeam footballTeam;

    @Before
    public void setFootballTeam() {
        this.footballTeam = new FootballTeam("Barcelona", 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateFootballTeamThrowExceptionOnNegativePosition() {
        this.footballTeam = new FootballTeam("Barcelona", -10);
    }

    @Test(expected = NullPointerException.class)
    public void testCreateFootballTeamThrowExceptionOnNullName() {
        this.footballTeam = new FootballTeam(null, 0);
    }

    @Test(expected = NullPointerException.class)
    public void testCreateFootballTeamThrowExceptionOnEmptyName() {
        this.footballTeam = new FootballTeam("", 0);
    }

    @Test
    public void testCreateFootballTeamCreateValidObject() {
        Assert.assertEquals("Barcelona", footballTeam.getName());
        Assert.assertEquals(3, footballTeam.getVacantPositions());
        Assert.assertEquals(0, footballTeam.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddFootballerThrowExceptionOnFullCapacity() {
        Footballer footballer1 = new Footballer("Messi");
        Footballer footballer2 = new Footballer("Ronaldo");
        Footballer footballer3 = new Footballer("Berbatov");
        Footballer footballer4 = new Footballer("Stoichkov");

        footballTeam.addFootballer(footballer1);
        footballTeam.addFootballer(footballer2);
        footballTeam.addFootballer(footballer3);
        footballTeam.addFootballer(footballer4);
    }

    @Test
    public void testAddFootballerSuccessfullyAddPlayer() {
        Footballer footballer1 = new Footballer("Messi");
        Footballer footballer2 = new Footballer("Ronaldo");
        Footballer footballer3 = new Footballer("Berbatov");

        footballTeam.addFootballer(footballer1);
        Assert.assertEquals(1, footballTeam.getCount());
        ;
        footballTeam.addFootballer(footballer2);
        Assert.assertEquals(2, footballTeam.getCount());
        footballTeam.addFootballer(footballer3);
        Assert.assertEquals(3, footballTeam.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveFootballerThrowExceptionOnNonExistingFootballer() {
        Footballer footballer1 = new Footballer("Messi");
        Footballer footballer2 = new Footballer("Ronaldo");
        Footballer footballer3 = new Footballer("Berbatov");

        footballTeam.addFootballer(footballer1);
        footballTeam.addFootballer(footballer2);

        footballTeam.removeFootballer(footballer3.getName());
    }

    @Test
    public void testRemoveFootballerSuccessfullyRemoveExistingFootballer() {
        Footballer footballer1 = new Footballer("Messi");
        Footballer footballer2 = new Footballer("Ronaldo");

        footballTeam.addFootballer(footballer1);
        footballTeam.addFootballer(footballer2);

        footballTeam.removeFootballer(footballer2.getName());
        Assert.assertEquals(1, footballTeam.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFootballerForSaleThrowExceptionOnNonExistingFootballer() {
        Footballer footballer1 = new Footballer("Messi");
        Footballer footballer2 = new Footballer("Ronaldo");
        Footballer footballer3 = new Footballer("Berbatov");

        footballTeam.addFootballer(footballer1);
        footballTeam.addFootballer(footballer2);

        footballTeam.footballerForSale(footballer3.getName());
    }

    @Test
    public void testFootballerForSaleSuccessfullySellExistingFootballer() {
        Footballer footballer1 = new Footballer("Messi");
        Footballer footballer2 = new Footballer("Ronaldo");

        footballTeam.addFootballer(footballer1);
        footballTeam.addFootballer(footballer2);

        Footballer result = footballTeam.footballerForSale(footballer2.getName());
        Assert.assertFalse(footballer2.isActive());
        Assert.assertEquals(footballer2, result);
    }

    @Test
    public void testGetStatistics() {
        Footballer footballer1 = new Footballer("Messi");
        Footballer footballer2 = new Footballer("Ronaldo");
        footballTeam.addFootballer(footballer1);
        footballTeam.addFootballer(footballer2);

        String expectedResult = "The footballer Messi, Ronaldo is in the team Barcelona.";
        Assert.assertEquals(expectedResult, footballTeam.getStatistics());
    }

}

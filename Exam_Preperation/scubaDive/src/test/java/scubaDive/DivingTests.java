package scubaDive;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DivingTests {

    private Diving diving;

    @Before
    public void setDiving() {
        this.diving = new Diving("BlackSea", 3);
    }

    @Test
    public void testGetNameReturnCorrectName() {
        Assert.assertEquals("BlackSea", diving.getName());
    }

    @Test(expected = NullPointerException.class)
    public void testCreateDivingThrowExceptionOnNullName() {
        this.diving = new Diving(null, 3);
    }

    @Test(expected = NullPointerException.class)
    public void testCreateDivingThrowExceptionOnEmptyName() {
        this.diving = new Diving(" ", 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateDivingThrowExceptionOnNegativeCapacity() {
        this.diving = new Diving("BlackSea", -15);
    }

    @Test
    public void testCreateDivingCreateEmptyList() {
        Assert.assertEquals(0, diving.getCount());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddDeepWaterDiverTrowExceptionOnFullCapacity() {
        DeepWaterDiver diver1 = new DeepWaterDiver("Stefan", 90);
        DeepWaterDiver diver2 = new DeepWaterDiver("Vladi", 50);
        DeepWaterDiver diver3 = new DeepWaterDiver("Krasi", 30);
        DeepWaterDiver diver4 = new DeepWaterDiver("Cveti", 20);

        diving.addDeepWaterDiver(diver1);
        diving.addDeepWaterDiver(diver2);
        diving.addDeepWaterDiver(diver3);
        diving.addDeepWaterDiver(diver4);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddDeepWaterDiverTrowExceptionOnExistingDiver() {
        DeepWaterDiver diver1 = new DeepWaterDiver("Stefan", 90);
        DeepWaterDiver diver2 = new DeepWaterDiver("Vladi", 50);

        diving.addDeepWaterDiver(diver1);
        diving.addDeepWaterDiver(diver2);
        diving.addDeepWaterDiver(diver1);
    }

    @Test
    public void testAddDeepWaterDiverSuccessfullyAddDiver() {
        DeepWaterDiver diver1 = new DeepWaterDiver("Stefan", 90);
        DeepWaterDiver diver2 = new DeepWaterDiver("Vladi", 50);

        diving.addDeepWaterDiver(diver1);
        Assert.assertEquals(1, diving.getCount());
        diving.addDeepWaterDiver(diver2);
        Assert.assertEquals(2, diving.getCount());
    }

    @Test
    public void testRemoveDeepWaterDiverReturnFalseOnNonExistingDiver() {
        DeepWaterDiver diver1 = new DeepWaterDiver("Vladi", 50);
        boolean result = diving.removeDeepWaterDiver(diver1.getName());
        Assert.assertFalse(result);
    }

    @Test
    public void testRemoveDeepWaterDiverReturnTrueOnExistingDiver() {
        DeepWaterDiver diver1 = new DeepWaterDiver("Vladi", 50);
        diving.addDeepWaterDiver(diver1);
        boolean result = diving.removeDeepWaterDiver(diver1.getName());
        Assert.assertTrue(result);
        Assert.assertEquals(0, diving.getCount());
    }
}

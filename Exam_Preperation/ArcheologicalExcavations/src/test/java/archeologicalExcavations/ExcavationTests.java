package archeologicalExcavations;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ExcavationTests {
    private Excavation excavation;

    @Before
    public void setExcavation() {
        this.excavation = new Excavation("Perperikon", 3);
    }

    @Test(expected = NullPointerException.class)
    public void testCreateExcavationThrowExceptionOnNullName() {
        excavation = new Excavation(null, 5);
    }

    @Test(expected = NullPointerException.class)
    public void testCreateExcavationThrowExceptionOnWhiteSpaceName() {
        excavation = new Excavation("", 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateExcavationThrowExceptionOnNegativeCapacity() {
        excavation = new Excavation("Perperikon", -5);
    }

    @Test
    public void testCreateExcavationCreateNewArchaeologistsList() {
        Assert.assertEquals(0, excavation.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddMethodThrowExceptionOnFullCapacity() {
        Archaeologist archaeologist1 = new Archaeologist("Mitko", 100);
        Archaeologist archaeologist2 = new Archaeologist("Stefcho", 10);
        Archaeologist archaeologist3 = new Archaeologist("Gosho", 50);
        excavation.addArchaeologist(archaeologist1);
        excavation.addArchaeologist(archaeologist2);
        excavation.addArchaeologist(archaeologist3);

        Archaeologist archaeologist4 = new Archaeologist("Pesho", 55);
        excavation.addArchaeologist(archaeologist4);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddMethodThrowExceptionOnExistingArchaeologist() {
        Archaeologist archaeologist1 = new Archaeologist("Mitko", 100);
        Archaeologist archaeologist2 = new Archaeologist("Pesho", 10);
        Archaeologist archaeologist3 = new Archaeologist("Pesho", 10);
        excavation.addArchaeologist(archaeologist1);
        excavation.addArchaeologist(archaeologist2);
        excavation.addArchaeologist(archaeologist3);
    }

    @Test
    public void testAddMethodAddNonExistingArchaeologist() {
        Archaeologist archaeologist1 = new Archaeologist("Mitko", 100);
        Archaeologist archaeologist2 = new Archaeologist("Pesho", 10);
        Archaeologist archaeologist3 = new Archaeologist("Gosho", 110);
        excavation.addArchaeologist(archaeologist1);
        excavation.addArchaeologist(archaeologist2);
        Assert.assertEquals(2, excavation.getCount());
        excavation.addArchaeologist(archaeologist3);
        Assert.assertEquals(3, excavation.getCount());
    }

    @Test
    public void testRemoveMethodReturnsFalseOnNonExistingArchaeologist() {
        Archaeologist archaeologist1 = new Archaeologist("Mitko", 100);
        Archaeologist archaeologist2 = new Archaeologist("Pesho", 10);
        Archaeologist archaeologist3 = new Archaeologist("Gosho", 110);
        excavation.addArchaeologist(archaeologist1);
        excavation.addArchaeologist(archaeologist2);
        boolean result = excavation.removeArchaeologist(archaeologist3.getName());

        Assert.assertFalse(result);
    }

    @Test
    public void testRemoveMethodReturnsTrueOnExistingArchaeologist() {
        Archaeologist archaeologist1 = new Archaeologist("Mitko", 100);
        Archaeologist archaeologist2 = new Archaeologist("Pesho", 10);
        Archaeologist archaeologist3 = new Archaeologist("Gosho", 110);
        excavation.addArchaeologist(archaeologist1);
        excavation.addArchaeologist(archaeologist2);
        excavation.addArchaeologist(archaeologist3);
        boolean result = excavation.removeArchaeologist(archaeologist3.getName());

        Assert.assertTrue(result);
    }
}

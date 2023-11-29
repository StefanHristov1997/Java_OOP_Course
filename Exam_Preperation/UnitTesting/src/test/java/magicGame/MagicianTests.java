package magicGame;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class MagicianTests {

    private Magician magician;

    @Before
    public void setMagician() {
        this.magician = new Magician("Stefan", 100);
    }

    @Test(expected = NullPointerException.class)
    public void testCreateMagicianThrowExceptionOnNullName() {
        this.magician = new Magician(null, 100);
    }

    @Test(expected = NullPointerException.class)
    public void testCreateMagicianThrowExceptionOnEmptyName() {
        this.magician = new Magician("", 100);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateMagicianThrowExceptionOnNegativeHealth() {
        this.magician = new Magician("Gosho", -10);
    }

    @Test
    public void testCreateMagicianCreateValidObject() {
        Assert.assertEquals("Stefan", magician.getUsername());
        Assert.assertEquals(100, magician.getHealth());
        Assert.assertEquals(0, magician.getMagics().size());
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetMagicsMethodReturnsUnmodifiableList() {
        Magic magic = new Magic("Shazam", 10);
        magician.getMagics().add(magic);
    }

    @Test(expected = IllegalStateException.class)
    public void testTakeDamageThrowExceptionOnDeadMagician() {
        this.magician = new Magician("Gosho", 0);
        magician.takeDamage(15);
    }

    @Test
    public void testTakeDamageReturnsZeroHealthWhenDamageIsHigherThanHealth() {
        this.magician = new Magician("Gosho", 10);
        magician.takeDamage(15);
        Assert.assertEquals(0, magician.getHealth());
    }

    @Test
    public void testTakeDamageDecreaseHealth() {
        this.magician = new Magician("Gosho", 10);
        magician.takeDamage(5);
        Assert.assertEquals(5, magician.getHealth());
    }

    @Test(expected = NullPointerException.class)
    public void testAddMagicThrowExceptionOnNullMagic() {
        Magic magic = null;
        magician.addMagic(magic);
    }

    @Test
    public void testAddMagicAddSuccessfullyMagic() {
        Magic shazam = new Magic("Shazam", 10);
        magician.addMagic(shazam);

        Assert.assertEquals(1, magician.getMagics().size());

        Magic darkMagic = new Magic("dark", 15);
        magician.addMagic(darkMagic);

        Assert.assertEquals(2, magician.getMagics().size());
    }

    @Test
    public void testRemoveMagicReturnTrueOnSuccessfullyRemovedMagic() {
        Magic shazam = new Magic("Shazam", 10);
        magician.addMagic(shazam);

        boolean result = magician.removeMagic(shazam);

        Assert.assertTrue(result);
    }

    @Test
    public void testRemoveMagicReturnFalseOnUnSuccessfullyRemovedMagic() {
        Magic shazam = new Magic("Shazam", 10);
        boolean result = magician.removeMagic(shazam);

        Assert.assertFalse(result);
    }

    @Test
    public void testGetMagicSuccessfullyReturnsMagicByName() {
        Magic shazam = new Magic("Shazam", 10);
        magician.addMagic(shazam);
        Magic darkMagic = new Magic("dark", 15);
        magician.addMagic(darkMagic);

        Magic result = magician.getMagic("dark");

        Assert.assertEquals(darkMagic, result);
    }

    @Test
    public void testGetMagicSuccessfullyReturnsNullOnNonExistingMagic() {
        Magic shazam = new Magic("Shazam", 10);
        magician.addMagic(shazam);
        Magic darkMagic = new Magic("dark", 15);
        magician.addMagic(darkMagic);

        Magic result = magician.getMagic("bam bam");

        Assert.assertNull(result);
    }


}

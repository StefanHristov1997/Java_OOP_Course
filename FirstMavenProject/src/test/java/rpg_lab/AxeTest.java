package rpg_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AxeTest {

    public final static int AXE_ATTACK_POINTS = 10;
    public final static int AXE_DURABILITY_POINTS = 10;
    public final static int BROKEN_AXE = 0;
    public final static int DUMMY_HEALTH = 100;
    public final static int DUMMY_EXPERIENCE = 100;

    public Dummy dummy;

    @Before
    public void setDummy() {
        this.dummy = new Dummy(DUMMY_HEALTH, DUMMY_EXPERIENCE);
    }


    @Test
    public void testWeaponLostDurabilityAfterAttack() {

        Axe axe = new Axe(AXE_ATTACK_POINTS, AXE_DURABILITY_POINTS);
        axe.attack(dummy);

        Assert.assertEquals(AXE_DURABILITY_POINTS - Axe.LOSES_DURABILITY, axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void testBrokenAxeThrowsExceptionIfAttack() {
        Axe axe = new Axe(AXE_ATTACK_POINTS, BROKEN_AXE);
        axe.attack(dummy);
    }
}
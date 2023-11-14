package rpg_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DummyTest {

    public final static int AXE_ATTACK_POINTS = 10;
    public final static int DUMMY_HEALTH = 100;
    public final static int DUMMY_EXPERIENCE = 100;
    public final static int DEAD_DUMMY = 0;

    private Dummy dummy;

    @Before
    public void setDeadDummy() {
        this.dummy = new Dummy(DEAD_DUMMY, DUMMY_EXPERIENCE);
    }

    @Before
    public void setAliveDummy() {
        this.dummy = new Dummy(DUMMY_HEALTH, DUMMY_EXPERIENCE);
    }

    @Test
    public void testDummyLosesHealthAfterAttack() {
        setAliveDummy();
        dummy.takeAttack(AXE_ATTACK_POINTS);
        Assert.assertEquals(DUMMY_HEALTH - AXE_ATTACK_POINTS, dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void testDeadDummyThrowsExceptionIfAttacked() {
        setDeadDummy();
        dummy.takeAttack(AXE_ATTACK_POINTS);
    }

    @Test
    public void testDeadDummyGivesExp() {
        setDeadDummy();
        dummy.giveExperience();
        Assert.assertEquals(100, dummy.giveExperience());
    }

    @Test(expected = IllegalStateException.class)
    public void testAliveDummyDoNotGiveExp() {
        setAliveDummy();
        dummy.giveExperience();
    }


}
package rpg_lab;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class HeroTest {

    public final static String HERO_NAME = "Stefan";
    public final int TARGET_XP = 10;

   @Test
    public void testHeroGainExpAfterTargetIsDead(){
        Weapon weaponMock = Mockito.mock(Weapon.class);
        Target targetMock = Mockito.mock(Target.class);

        Mockito.when(targetMock.isDead()).thenReturn(true);
        Mockito.when(targetMock.giveExperience()).thenReturn(TARGET_XP);

        Hero hero = new Hero(HERO_NAME, weaponMock);

        hero.attack(targetMock);

       Assert.assertEquals(TARGET_XP, hero.getExperience());
   }

}
package rpg_lab;

public interface Target {

    int giveExperience();
    void takeAttack(int attackPoints);

    boolean isDead();
    int getHealth();
}

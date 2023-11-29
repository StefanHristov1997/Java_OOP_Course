package magicGame.models.magicians;

import magicGame.common.ExceptionMessages;
import magicGame.models.magics.Magic;

public abstract class MagicianImpl implements Magician {

    private String username;

    private int health;

    private int protection;
    private boolean isAlive;

    private Magic magic;

    public MagicianImpl(String username, int health, int protection, Magic magic) {
        this.setUsername(username);
        this.setHealth(health);
        this.setProtection(protection);
        this.isAlive = isAlive();
        this.setMagic(magic);
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.INVALID_MAGICIAN_NAME);
        }
        this.username = username;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    public void setHealth(int health) {
        if (health < 0) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_MAGICIAN_HEALTH);
        }
        this.health = health;
    }

    @Override
    public int getProtection() {
        return this.protection;
    }

    public void setProtection(int protection) {
        if (protection < 0) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_MAGICIAN_PROTECTION);
        }
        this.protection = protection;
    }

    @Override
    public Magic getMagic() {
        return this.magic;
    }

    public void setMagic(Magic magic) {
        if (magic == null) {
            throw new NullPointerException(ExceptionMessages.INVALID_MAGIC);
        }
        this.magic = magic;
    }

    @Override
    public boolean isAlive() {
        return getHealth() > 0;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    @Override
    public void takeDamage(int points) {
        int currentProtection = getProtection();
        int currentHealth = getHealth();

        while (points > 0) {
            points--;
            if (currentProtection > 0) {
                currentProtection--;
            } else {
                currentHealth--;
            }

            if (currentHealth <= 0) {
                setAlive(false);
                break;
            }
        }
        setProtection(currentProtection);
        setHealth(currentHealth);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s: %s", getClass().getSimpleName(), username)).append(System.lineSeparator());
        sb.append(String.format("Health: %d", health)).append(System.lineSeparator());
        sb.append(String.format("Protection: %d", protection)).append(System.lineSeparator());
        sb.append(String.format("Magic: %s", getMagic().getName()));

        return sb.toString();
    }
}

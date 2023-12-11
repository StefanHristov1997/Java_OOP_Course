package harpoonDiver.models.diver;

import harpoonDiver.common.ConstantMessages;
import harpoonDiver.common.ExceptionMessages;
import harpoonDiver.models.seaCatch.BaseSeaCatch;
import harpoonDiver.models.seaCatch.SeaCatch;

public abstract class BaseDiver implements Diver {
    private String name;
    private double oxygen;
    private SeaCatch seaCatch;

    public BaseDiver(String name, double oxygen) {
        this.setName(name);
        this.setOxygen(oxygen);
        this.seaCatch = new BaseSeaCatch();
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.DIVER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public double getOxygen() {
        return this.oxygen;
    }

    public void setOxygen(double oxygen) {
        if (oxygen < 0) {
            throw new IllegalArgumentException(ExceptionMessages.DIVER_OXYGEN_LESS_THAN_ZERO);
        }
        this.oxygen = oxygen;
    }

    @Override
    public boolean canDive() {
        return oxygen > 0;
    }

    @Override
    public SeaCatch getSeaCatch() {
        return this.seaCatch;
    }

    @Override
    public void shoot() {
        double currentOxygen = getOxygen();
        currentOxygen -= 30;
        if (currentOxygen < 0) {
            currentOxygen = 0;
        }
        setOxygen(currentOxygen);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format(ConstantMessages.FINAL_DIVER_NAME, name)).append(System.lineSeparator());
        sb.append(String.format(ConstantMessages.FINAL_DIVER_OXYGEN, oxygen)).append(System.lineSeparator());
        sb.append("Diver's catch: ");
        if (getSeaCatch().getSeaCreatures().isEmpty()) {
            sb.append("None");
        }else{
            String seaCatch = String.join(", ", getSeaCatch().getSeaCreatures());
            sb.append(seaCatch);
        }
        return sb.toString().trim();
    }
}

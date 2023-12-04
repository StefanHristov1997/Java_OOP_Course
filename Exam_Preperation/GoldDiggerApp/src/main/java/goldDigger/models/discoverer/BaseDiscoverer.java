package goldDigger.models.discoverer;

import goldDigger.common.ConstantMessages;
import goldDigger.common.ExceptionMessages;
import goldDigger.models.museum.BaseMuseum;
import goldDigger.models.museum.Museum;

public abstract class BaseDiscoverer implements Discoverer {
    private String name;
    private double energy;
    private Museum museum;

    public BaseDiscoverer(String name, double energy) {
        this.setName(name);
        this.setEnergy(energy);
        this.museum = new BaseMuseum();
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.DISCOVERER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public double getEnergy() {
        return this.energy;
    }

    public void setEnergy(double energy) {
        if (energy < 0) {
            throw new IllegalArgumentException(ExceptionMessages.DISCOVERER_ENERGY_LESS_THAN_ZERO);
        }
        this.energy = energy;
    }

    @Override
    public boolean canDig() {
        return this.energy > 0;
    }

    @Override
    public Museum getMuseum() {
        return this.museum;
    }

    @Override
    public void dig() {
        double currentEnergy = getEnergy();
        currentEnergy -= 15;
        if (currentEnergy < 0) {
            currentEnergy = 0;
        }
        setEnergy(currentEnergy);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(ConstantMessages.FINAL_DISCOVERER_NAME, getName())).append(System.lineSeparator());
        sb.append(String.format(ConstantMessages.FINAL_DISCOVERER_ENERGY, getEnergy())).append(System.lineSeparator());

        if (getMuseum().getExhibits().isEmpty()) {
            sb.append("Museum exhibits: None");
        } else {
            sb.append("Museum exhibits: ");
            sb.append(String.join(", ", museum.getExhibits()));
        }
        return sb.toString();
    }
}

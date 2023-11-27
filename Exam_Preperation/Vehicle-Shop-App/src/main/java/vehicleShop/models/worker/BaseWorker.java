package vehicleShop.models.worker;

import vehicleShop.common.ExceptionMessages;
import vehicleShop.models.tool.Tool;

import java.util.ArrayList;
import java.util.Collection;


public abstract class BaseWorker implements Worker {
    private String name;
    private int strength;
    private Collection<Tool> tools;

    public BaseWorker(String name, int strength) {
        this.setName(name);
        this.setStrength(strength);
        this.tools = new ArrayList<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name == null || name.equals(" ")) {
            throw new IllegalArgumentException(ExceptionMessages.WORKER_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public int getStrength() {
        return this.strength;
    }

    protected void setStrength(int strength) {
        if (strength < 0) {
            throw new IllegalArgumentException(ExceptionMessages.WORKER_STRENGTH_LESS_THAN_ZERO);
        }
        this.strength = strength;
    }

    @Override
    public Collection<Tool> getTools() {
        return this.tools;
    }

    public void setTools(Collection<Tool> tools) {
        this.tools = tools;
    }

    @Override
    public void working() {
        int currentStrength = getStrength();
        currentStrength -= 10;
        if(currentStrength < 0){
            currentStrength = 0;
        }

        setStrength(currentStrength);
    }


    @Override
    public void addTool(Tool tool) {
        this.tools.add(tool);
    }

    @Override
    public boolean canWork() {
        return this.getStrength() > 0;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        long countFitTools = getTools().stream().filter(tool -> tool.getPower() > 0).count();
        sb.append("Name: ").append(getName()).append(", Strength: ").append(getStrength()).append(System.lineSeparator());
        sb.append("Tools: ").append(countFitTools).append(" fit left").append(System.lineSeparator());

        return sb.toString();
    }
}

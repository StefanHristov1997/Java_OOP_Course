package robotService.entities.services;

import robotService.common.ExceptionMessages;
import robotService.entities.robot.Robot;
import robotService.entities.supplements.Supplement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import static robotService.common.ConstantMessages.NOT_ENOUGH_CAPACITY_FOR_ROBOT;

public abstract class BaseService implements Service {

    private String name;

    private int capacity;

    private Collection<Supplement> supplements;
    private Collection<Robot> robots;

    public BaseService(String name, int capacity) {
        setName(name);
        this.capacity = capacity;
        this.supplements = new ArrayList<>();
        this.robots = new ArrayList<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.SERVICE_NAME_CANNOT_BE_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public Collection<Robot> getRobots() {
        return Collections.unmodifiableCollection(robots);
    }

    @Override
    public Collection<Supplement> getSupplements() {
        return Collections.unmodifiableCollection(supplements);
    }

    @Override
    public void addRobot(Robot robot) {
        if (supplements.size() == capacity) {
            throw new IllegalArgumentException(NOT_ENOUGH_CAPACITY_FOR_ROBOT);
        }

        robots.add(robot);
    }

    @Override
    public void removeRobot(Robot robot) {
        robots.remove(robot);
    }

    @Override
    public void addSupplement(Supplement supplement) {
        supplements.add(supplement);
    }

    @Override
    public void feeding() {
        robots.forEach(Robot::eating);
    }

    @Override
    public int sumHardness() {
        return supplements.stream().mapToInt(Supplement::getHardness).sum();
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();

        sb.append(this.name).append(" ").append(getClass().getSimpleName()).append(":").append(System.lineSeparator());
        sb.append("Robots: ");

        if (robots.isEmpty()) {
            sb.append("none");
        } else {
            int index = 0;
            for (Robot robot : robots) {
                if (index < robots.size() - 1) {
                    sb.append(robot.getName()).append(" ");
                    index++;
                }else{
                    sb.append(robot.getName());
                }
            }
        }

        sb.append(System.lineSeparator());
        sb.append("Supplements: ").append(String.format("%d Hardness: %d", supplements.size(), sumHardness()));

        return sb.toString();
    }
}

package handball.entities.gameplay;

import handball.common.ExceptionMessages;
import handball.entities.equipment.Equipment;
import handball.entities.team.Team;

import java.util.ArrayList;
import java.util.Collection;

public abstract class BaseGameplay implements Gameplay {
    private String name;
    private int capacity;
    private Collection<Equipment> equipments;
    private Collection<Team> teams;

    public BaseGameplay(String name, int capacity) {
        this.setName(name);
        this.capacity = capacity;
        this.equipments = new ArrayList<>();
        this.teams = new ArrayList<>();
    }

    @Override
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.GAMEPLAY_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public int allProtection() {
        return equipments.stream().mapToInt(Equipment::getProtection).sum();
    }

    @Override
    public void addTeam(Team team) {
        teams.add(team);
    }

    @Override
    public void removeTeam(Team team) {
        teams.remove(team);
    }

    @Override
    public void addEquipment(Equipment equipment) {
        equipments.add(equipment);
    }

    @Override
    public void teamsInGameplay() {
        teams.forEach(Team::play);
    }

    @Override
    public Collection<Team> getTeam() {
        return this.teams;
    }

    @Override
    public Collection<Equipment> getEquipments() {
        return this.equipments;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String gameplay = String.format("%s %s\n", name, getClass().getSimpleName());
        sb.append(gameplay);
        sb.append("Team: ");
        int index = 0;
        if (teams.isEmpty()) {
            sb.append("none").append(System.lineSeparator());
        } else {
            for (Team team : teams) {
                if (index < teams.size() - 1){
                    sb.append(team.getName()).append(" ");
                    index++;
                }else {
                    sb.append(team.getName());
                }
            }
            sb.append(System.lineSeparator());
        }
        String equipment = String.format("Equipment: %d, Protection: %d", equipments.size(), allProtection());
        sb.append(equipment);

        return sb.toString();
    }
}

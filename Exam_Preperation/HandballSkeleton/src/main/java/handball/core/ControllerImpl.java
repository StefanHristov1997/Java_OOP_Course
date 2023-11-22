package handball.core;

import handball.common.ExceptionMessages;
import handball.entities.equipment.ElbowPad;
import handball.entities.equipment.Equipment;
import handball.entities.equipment.Kneepad;
import handball.entities.gameplay.Gameplay;
import handball.entities.gameplay.Indoor;
import handball.entities.gameplay.Outdoor;
import handball.entities.team.Bulgaria;
import handball.entities.team.Germany;
import handball.entities.team.Team;
import handball.repositories.EquipmentRepository;
import handball.repositories.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

import static handball.common.ConstantMessages.*;
import static handball.common.ExceptionMessages.INVALID_TEAM_TYPE;

public class ControllerImpl implements Controller {

    private Repository equipment;
    private Collection<Gameplay> gameplays;

    public ControllerImpl() {
        this.equipment = new EquipmentRepository();
        this.gameplays = new ArrayList<>();
    }

    @Override
    public String addGameplay(String gameplayType, String gameplayName) {
        if (!gameplayType.equals("Outdoor") && !gameplayType.equals("Indoor")) {
            throw new NullPointerException(ExceptionMessages.INVALID_GAMEPLAY_TYPE);
        }

        switch (gameplayType) {
            case "Outdoor":
                Gameplay outdoorGameplay = new Outdoor(gameplayName);
                gameplays.add(outdoorGameplay);
                break;
            case "Indoor":
                Gameplay indoorGameplay = new Indoor(gameplayName);
                gameplays.add(indoorGameplay);
                break;
        }

        return String.format(SUCCESSFULLY_ADDED_GAMEPLAY_TYPE, gameplayType);
    }

    @Override
    public String addEquipment(String equipmentType) {
        if (!equipmentType.equals("Kneepad") && !equipmentType.equals("ElbowPad")) {
            throw new IllegalArgumentException(ExceptionMessages.INVALID_EQUIPMENT_TYPE);
        }
        switch (equipmentType) {
            case "Kneepad":
                Equipment kneedPad = new Kneepad();
                equipment.add(kneedPad);
                break;
            case "ElbowPad":
                Equipment elbowPad = new ElbowPad();
                equipment.add(elbowPad);
                break;
        }

        return String.format(SUCCESSFULLY_ADDED_EQUIPMENT_TYPE, equipmentType);
    }

    @Override
    public String equipmentRequirement(String gameplayName, String equipmentType) {
        Equipment equipmentAddToGameplay = equipment.findByType(equipmentType);

        if (equipmentAddToGameplay == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.NO_EQUIPMENT_FOUND, equipmentType));
        }

        Gameplay gameplay = gameplays.stream().filter(game -> game.getName().equals(gameplayName)).findFirst().get();
        gameplay.addEquipment(equipmentAddToGameplay);
        equipment.remove(equipmentAddToGameplay);

        return String.format(SUCCESSFULLY_ADDED_EQUIPMENT_IN_GAMEPLAY, equipmentType, gameplayName);

    }

    @Override
    public String addTeam(String gameplayName, String teamType, String teamName, String country, int advantage) {
        if (!teamType.equals("Bulgaria") && !teamType.equals("Germany")) {
            throw new IllegalArgumentException(INVALID_TEAM_TYPE);
        }

        Gameplay gameplay = gameplays.stream().filter(game -> game.getName().equals(gameplayName)).findFirst().get();

        if (teamType.equals("Bulgaria") && gameplay.getClass().getSimpleName().equals("Outdoor")) {
            Team bulgariaTeam = new Bulgaria(teamName, country, advantage);
            gameplay.addTeam(bulgariaTeam);
            return String.format(SUCCESSFULLY_ADDED_TEAM_IN_GAMEPLAY, teamType, gameplayName);
        } else if (teamType.equals("Germany") && gameplay.getClass().getSimpleName().equals("Indoor")) {
            Team germanyTeam = new Germany(teamName, country, advantage);
            gameplay.addTeam(germanyTeam);
            return String.format(SUCCESSFULLY_ADDED_TEAM_IN_GAMEPLAY, teamType, gameplayName);
        }

        return GAMEPLAY_NOT_SUITABLE;

    }

    @Override
    public String playInGameplay(String gameplayName) {
        Gameplay gameplay = gameplays.stream().filter(game -> game.getName().equals(gameplayName)).findFirst().get();
        gameplay.teamsInGameplay();

        int teamsHavePlayed = gameplay.getTeam().size();

        return String.format(TEAMS_PLAYED, teamsHavePlayed);
    }

    @Override
    public String percentAdvantage(String gameplayName) {
        Gameplay gameplay = gameplays.stream().filter(gameplay1 -> gameplay1.getName().equals(gameplayName)).findFirst().get();
        int percentAdvantage = gameplay.getTeam().stream().mapToInt(Team::getAdvantage).sum();

        return String.format(ADVANTAGE_GAMEPLAY, gameplayName, percentAdvantage);
    }

    @Override
    public String getStatistics() {
        return this.gameplays.stream()
                .map(Gameplay::toString)
                .collect(Collectors.joining(System.lineSeparator())).trim();
    }
}

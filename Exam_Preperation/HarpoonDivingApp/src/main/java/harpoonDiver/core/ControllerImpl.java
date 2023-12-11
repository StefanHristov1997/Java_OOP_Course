package harpoonDiver.core;

import harpoonDiver.common.ConstantMessages;
import harpoonDiver.common.ExceptionMessages;
import harpoonDiver.models.diver.DeepWaterDiver;
import harpoonDiver.models.diver.Diver;
import harpoonDiver.models.diver.OpenWaterDiver;
import harpoonDiver.models.diver.WreckDiver;
import harpoonDiver.models.diving.Diving;
import harpoonDiver.models.diving.DivingImpl;
import harpoonDiver.models.divingSite.DivingSite;
import harpoonDiver.models.divingSite.DivingSiteImpl;
import harpoonDiver.repositories.DiverRepository;
import harpoonDiver.repositories.DivingSiteRepository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {

    private DiverRepository diverRepository;
    private DivingSiteRepository divingSiteRepository;
    private int diversTookPlaces;

    public ControllerImpl() {
        this.diverRepository = new DiverRepository();
        this.divingSiteRepository = new DivingSiteRepository();
        this.diversTookPlaces = 0;
    }

    @Override
    public String addDiver(String kind, String diverName) {
        Diver diver;
        if (kind.equals("DeepWaterDiver")) {
            diver = new DeepWaterDiver(diverName);
        } else if (kind.equals("OpenWaterDiver")) {
            diver = new OpenWaterDiver(diverName);
        } else if (kind.equals("WreckDiver")) {
            diver = new WreckDiver(diverName);
        } else {
            throw new IllegalArgumentException(ExceptionMessages.DIVER_INVALID_KIND);
        }
        diverRepository.add(diver);
        return String.format(ConstantMessages.DIVER_ADDED, kind, diverName);
    }

    @Override
    public String addDivingSite(String siteName, String... seaCreatures) {
        DivingSite divingSite = new DivingSiteImpl(siteName);
        List<String> creatures = Arrays.stream(seaCreatures).collect(Collectors.toList());
        for (String creature : creatures) {
            divingSite.getSeaCreatures().add(creature);
        }
        divingSiteRepository.add(divingSite);
        return String.format(ConstantMessages.DIVING_SITE_ADDED, siteName);
    }

    @Override
    public String removeDiver(String diverName) {
        Diver diver = diverRepository.byName(diverName);
        if (diver == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.DIVER_DOES_NOT_EXIST, diverName));
        }

        diverRepository.remove(diver);
        return String.format(ConstantMessages.DIVER_REMOVE, diverName);
    }

    @Override
    public String startDiving(String siteName) {
        List<Diver> diversWithOxygen = diverRepository.getCollection().stream().filter(diver -> diver.getOxygen() > 30).collect(Collectors.toList());
        if (diversWithOxygen.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.SITE_DIVERS_DOES_NOT_EXISTS);
        }
        Diving diving = new DivingImpl();

        DivingSite divingSite = divingSiteRepository.byName(siteName);
        int removedDivers = 0;
        while (!diversWithOxygen.isEmpty() && divingSite.getSeaCreatures().iterator().hasNext()) {
            Diver diver = diversWithOxygen.get(0);
            diversTookPlaces++;
            diving.searching(divingSite, diversWithOxygen);
            if (!diver.canDive()) {
                diversWithOxygen.remove(diver);
                removedDivers++;
            }
        }

        return String.format(ConstantMessages.SITE_DIVING, siteName, removedDivers);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format(ConstantMessages.FINAL_DIVING_SITES, diversTookPlaces)).append(System.lineSeparator());
        sb.append(ConstantMessages.FINAL_DIVERS_STATISTICS).append(System.lineSeparator());
        diverRepository.getCollection().forEach(diver -> sb.append(diver.toString()).append(System.lineSeparator()));
        return sb.toString().trim();
    }
}

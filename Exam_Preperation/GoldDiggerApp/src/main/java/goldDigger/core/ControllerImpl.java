package goldDigger.core;

import goldDigger.common.ConstantMessages;
import goldDigger.common.ExceptionMessages;
import goldDigger.models.discoverer.Anthropologist;
import goldDigger.models.discoverer.Archaeologist;
import goldDigger.models.discoverer.Discoverer;
import goldDigger.models.discoverer.Geologist;
import goldDigger.models.operation.Operation;
import goldDigger.models.operation.OperationImpl;
import goldDigger.models.spot.Spot;
import goldDigger.models.spot.SpotImpl;
import goldDigger.repositories.DiscovererRepository;
import goldDigger.repositories.SpotRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
    private DiscovererRepository discoverers;
    private SpotRepository spots;
    private int inspectedSpots;

    public ControllerImpl() {
        this.discoverers = new DiscovererRepository();
        this.spots = new SpotRepository();
        this.inspectedSpots = 0;
    }

    @Override
    public String addDiscoverer(String kind, String discovererName) {
        Discoverer discoverer;

        if (kind.equals("Anthropologist")) {
            discoverer = new Anthropologist(discovererName);
        } else if (kind.equals("Archaeologist")) {
            discoverer = new Archaeologist(discovererName);
        } else if (kind.equals("Geologist")) {
            discoverer = new Geologist(discovererName);
        } else {
            throw new IllegalArgumentException(ExceptionMessages.DISCOVERER_INVALID_KIND);
        }

        discoverers.add(discoverer);
        return String.format(ConstantMessages.DISCOVERER_ADDED, kind, discovererName);
    }

    @Override
    public String addSpot(String spotName, String... exhibits) {
        Spot spot = new SpotImpl(spotName);
        for (String exhibit : exhibits) {
            spot.getExhibits().add(exhibit);
        }

        spots.add(spot);
        return String.format(ConstantMessages.SPOT_ADDED, spotName);
    }

    @Override
    public String excludeDiscoverer(String discovererName) {
        Discoverer discoverer = discoverers.byName(discovererName);
        if (discoverer == null) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.DISCOVERER_DOES_NOT_EXIST, discovererName));
        }
        discoverers.remove(discoverer);
        return String.format(ConstantMessages.DISCOVERER_EXCLUDE, discovererName);
    }

    @Override
    public String inspectSpot(String spotName) {
        List<Discoverer> suitableDiscovers = discoverers.getCollection().stream()
                .filter(discoverer -> discoverer.getEnergy() > 45)
                .collect(Collectors.toList());
        if (suitableDiscovers.isEmpty()) {
            throw new IllegalArgumentException(ExceptionMessages.SPOT_DISCOVERERS_DOES_NOT_EXISTS);
        }
        Spot spot = spots.byName(spotName);
        Operation operation = new OperationImpl();
        operation.startOperation(spot, suitableDiscovers);
        long excludedDiscoverers = suitableDiscovers.stream().filter(discoverer -> !discoverer.canDig()).count();
        inspectedSpots++;
        return String.format(ConstantMessages.INSPECT_SPOT, spotName, excludedDiscoverers);
    }

    @Override
    public String getStatistics() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format(ConstantMessages.FINAL_SPOT_INSPECT, inspectedSpots)).append(System.lineSeparator());
        sb.append(ConstantMessages.FINAL_DISCOVERER_INFO).append(System.lineSeparator());
        String collect = discoverers.getCollection().stream().map(Discoverer::toString).collect(Collectors.joining(System.lineSeparator()));
        sb.append(collect);
        return sb.toString();
    }
}

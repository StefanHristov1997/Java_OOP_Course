package goldDigger.models.operation;

import goldDigger.models.discoverer.Discoverer;
import goldDigger.models.museum.BaseMuseum;
import goldDigger.models.museum.Museum;
import goldDigger.models.spot.Spot;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class OperationImpl implements Operation {
    @Override
    public void startOperation(Spot spot, Collection<Discoverer> discoverers) {
        List<Discoverer> discoverersWithEnergy = discoverers.stream().filter(discoverer -> discoverer.getEnergy() > 0).collect(Collectors.toList());
        Museum museum = new BaseMuseum();
        while (!discoverersWithEnergy.isEmpty() && spot.getExhibits().iterator().hasNext()) {
            String currentExhibit = spot.getExhibits().iterator().next();
            Discoverer currentDiscover = discoverersWithEnergy.get(0);
            currentDiscover.dig();
            museum.getExhibits().add(currentExhibit);
            spot.getExhibits().remove(currentExhibit);
            if (!currentDiscover.canDig()) {
                discoverersWithEnergy.remove(currentDiscover);
            }
        }
    }
}


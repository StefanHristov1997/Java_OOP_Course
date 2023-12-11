package harpoonDiver.models.diving;

import harpoonDiver.models.diver.Diver;
import harpoonDiver.models.divingSite.DivingSite;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class DivingImpl implements Diving {
    @Override
    public void searching(DivingSite divingSite, Collection<Diver> divers) {
        List<Diver> diversWithPositiveOxygen = divers.stream().filter(diver -> diver.getOxygen() > 0).collect(Collectors.toList());

        while (!diversWithPositiveOxygen.isEmpty() && divingSite.getSeaCreatures().iterator().hasNext()) {
            Diver currentDiver = diversWithPositiveOxygen.get(0);
            String currentSeaCatch = divingSite.getSeaCreatures().iterator().next();
            currentDiver.shoot();
            currentDiver.getSeaCatch().getSeaCreatures().add(currentSeaCatch);
            divingSite.getSeaCreatures().remove(currentSeaCatch);
            if (!currentDiver.canDive()) {
                diversWithPositiveOxygen.remove(currentDiver);
            }
        }

    }

}

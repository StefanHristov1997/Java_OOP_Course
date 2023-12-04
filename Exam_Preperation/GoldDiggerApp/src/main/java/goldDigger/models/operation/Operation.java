package goldDigger.models.operation;

import goldDigger.models.spot.Spot;
import goldDigger.models.discoverer.Discoverer;

import java.util.Collection;

public interface Operation {
    void startOperation(Spot spot, Collection<Discoverer> discoverers);

}

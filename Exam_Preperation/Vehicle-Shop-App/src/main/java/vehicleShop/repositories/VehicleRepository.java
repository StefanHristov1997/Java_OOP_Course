package vehicleShop.repositories;

import vehicleShop.models.vehicle.Vehicle;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class VehicleRepository implements Repository<Vehicle> {

    private Collection<Vehicle> vehicles;

    public VehicleRepository() {
        this.vehicles = new ArrayList<>();
    }

    @Override
    public Collection getWorkers() {
        return Collections.unmodifiableCollection(vehicles);
    }

    @Override
    public void add(Vehicle vehicle) {
        vehicles.add(vehicle);
    }
    @Override
    public boolean remove(Vehicle vehicle) {
        return vehicles.remove(vehicle);
    }
    @Override
    public Vehicle findByName(String name) {
        return vehicles.stream().filter(vehicle -> vehicle.getName().equals(name)).findFirst().get();
    }
}

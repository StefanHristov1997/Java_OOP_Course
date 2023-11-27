package vehicleShop.models.vehicle;

import vehicleShop.common.ExceptionMessages;

public class VehicleImpl implements Vehicle {
    private String name;

    private int strengthRequired;

    public VehicleImpl(String name, int strengthRequired) {
        this.setName(name);
        this.setStrengthRequired(strengthRequired);
    }

    @Override

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        if (name == null || name.equals(" ")) {
            throw new IllegalArgumentException(ExceptionMessages.VEHICLE_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    @Override
    public int getStrengthRequired() {
        return this.strengthRequired;
    }

    private void setStrengthRequired(int strengthRequired) {
        if (strengthRequired < 0) {
            throw new IllegalArgumentException(ExceptionMessages.VEHICLE_STRENGTH_LESS_THAN_ZERO);
        }
        this.strengthRequired = strengthRequired;
    }

    @Override
    public boolean reached() {
        return this.strengthRequired == 0;
    }

    @Override
    public void making() {
      int currentStrength = getStrengthRequired();
      currentStrength -= 5;
      if(currentStrength < 0){
          currentStrength = 0;
      }
      setStrengthRequired(currentStrength);
    }
}

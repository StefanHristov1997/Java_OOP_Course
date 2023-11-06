package InterfaceAndAbstraction_Exercise_04.FirstTask_01;

public class Robot implements Identifiable {
    private String model;
    private String id;

    public Robot(String id, String model) {
        this.id = id;
        this.model = model;
    }
    @Override
    public String getId() {
        return this.id;
    }

    public String getModel() {
        return this.model;
    }
}

package InterfaceAndAbstraction_Lab_04.SayHello_02;

public class European extends BasePerson {
    public European(String name) {
        super(name);
    }
    @Override
    public String sayHello() {
        return "Hello";
    }
}

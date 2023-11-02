package InterfaceAndAbstraction_Lab_04.SayHello_02;

public class Bulgarian extends BasePerson {
    public Bulgarian(String name){
        super(name);
    }
    @Override
    public String sayHello() {
        return "Здравей";
    }
}

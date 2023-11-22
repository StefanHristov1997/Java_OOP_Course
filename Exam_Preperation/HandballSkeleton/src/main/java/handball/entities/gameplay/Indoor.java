package handball.entities.gameplay;

public class Indoor extends BaseGameplay {
    private final static int CAPACITY = 250;
    public Indoor(String name) {
        super(name, CAPACITY);
    }
}

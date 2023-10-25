package WorkingAbstraction_Exercise_01.TrafficLights_04;

public class Light {

    private ColorOfLight color;

    public Light(ColorOfLight color) {
        this.color = color;
    }

    public ColorOfLight getColor() {
        return color;
    }

    public void changeColor(){
        if(this.color == ColorOfLight.RED) {
            this.color = ColorOfLight.GREEN;
        }else if(this.color == ColorOfLight.GREEN){
            this.color = ColorOfLight.YELLOW;
        }else if(this.color == ColorOfLight.YELLOW){
            this.color = ColorOfLight.RED;
        }
    }
}

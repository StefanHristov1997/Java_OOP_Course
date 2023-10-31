package PizzaCalories_04;

public class Dough {

//+	calculateCalories (): double
    private String flourType;
    private String bakingTechnique;

    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    private void setWeight(double weight) {
        if(weight < 1 || weight > 200){
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }

        this.weight = weight;
    }

    private void setFlourType(String flourType) {
        if(flourType.equals("White") || flourType.equals("Wholegrain")){
            this.flourType = flourType;
        }else{
            throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    private void setBakingTechnique(String bakingTechnique) {
        switch (bakingTechnique) {
            case "Crispy":
                this.bakingTechnique = bakingTechnique;
                break;
            case "Chewy" :
                this.bakingTechnique = bakingTechnique;
                break;
            case "Homemade":
                this.bakingTechnique = bakingTechnique;
                break;
            default :
                throw new IllegalArgumentException("Invalid type of dough.");
        }
    }

    public double calculateCalories (){
        double caloriesOfFlour = 0;
         switch (flourType){
             case "White":
                 switch (bakingTechnique) {
                     case "Crispy":
                         caloriesOfFlour = (2 * weight) * 1.5 * 0.9;
                         break;
                     case "Chewy" :
                         caloriesOfFlour = (2 * weight) * 1.5 * 1.1;
                         break;
                     case "Homemade":
                         caloriesOfFlour = (2 * weight) * 1.5 * 1.0;
                         break;
                 }
                 break;
             case "Wholegrain":
                 switch (bakingTechnique) {
                     case "Crispy":
                         caloriesOfFlour = (2 * weight) * 1.0 * 0.9;
                         break;
                     case "Chewy" :
                         caloriesOfFlour = (2 * weight) * 1.0 * 1.1;
                         break;
                     case "Homemade":
                         caloriesOfFlour = (2 * weight) * 1.0 * 1.0;
                         break;
                 }
                 break;
          }
          return caloriesOfFlour;
    }
}

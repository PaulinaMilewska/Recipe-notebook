package recipes.mainProject;

import org.hibernate.validator.internal.constraintvalidators.bv.past.PastValidatorForReadableInstant;

import java.util.List;

public class Recipe {
    private int id;
    private String title;
    private List<String> ingredientsList;
    private List<String> kitchenAppliancesList;
    private String descriptionOfPreparation;
    private int preparingTimeInMinutes;
    private double cost;
    private DegreesOfDifficulty degree;

    public static int index = 1;

    public Recipe() {
    }

    public Recipe(String title, List<String> ingredientsList, List<String> kitchenAppliancesList,
                  String descriptionOfPreparation, int preparingTimeInMinutes, double cost, DegreesOfDifficulty degree) {
        this.id = index++;
        this.title = title;
        this.ingredientsList = ingredientsList;
        this.kitchenAppliancesList = kitchenAppliancesList;
        this.descriptionOfPreparation = descriptionOfPreparation;
        this.preparingTimeInMinutes = preparingTimeInMinutes;
        this.cost = cost;
        this.degree = degree;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getIngredientsList() {
        return ingredientsList;
    }

    public void setIngredientsList(List<String> ingredientsList) {
        this.ingredientsList = ingredientsList;
    }

    public List<String> getKitchenAppliancesList() {
        return kitchenAppliancesList;
    }

    public void setKitchenAppliancesList(List<String> kitchenAppliancesList) {
        this.kitchenAppliancesList = kitchenAppliancesList;
    }

    public String getDescriptionOfPreparation() {
        return descriptionOfPreparation;
    }

    public void setDescriptionOfPreparation(String descriptionOfPreparation) {
        this.descriptionOfPreparation = descriptionOfPreparation;
    }

    public int getPreparingTimeInMinutes() {
        return preparingTimeInMinutes;
    }

    public void setPreparingTimeInMinutes(int preparingTimeInMinutes) {
        this.preparingTimeInMinutes = preparingTimeInMinutes;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public DegreesOfDifficulty getDegree() {
        return degree;
    }

    public void setDegree(DegreesOfDifficulty degree) {
        this.degree = degree;
    }
}

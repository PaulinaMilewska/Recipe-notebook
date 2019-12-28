package recipes.mainProject;

import org.hibernate.validator.internal.constraintvalidators.bv.past.PastValidatorForReadableInstant;

import java.util.List;
import java.util.Objects;

public class Recipe {
    private Long id;
    private String title;
    private List<Ingredient> ingredientsList;
    private List<String> kitchenAppliancesList;
    private String descriptionOfPreparation;
    private int preparingTimeInMinutes;
    private double cost;
//    private DegreesOfDifficulty degree;
    private String degree;

    public static Long index = Long.valueOf(1);


    public Recipe() {
    }

    public Recipe(String title, List<Ingredient> ingredientsList, List<String> kitchenAppliancesList,
                  String descriptionOfPreparation, int preparingTimeInMinutes, double cost,
//                  DegreesOfDifficulty degree
                  String degree
    ) {
        this.id = index++;
        this.title = title;
        this.ingredientsList = ingredientsList;
        this.kitchenAppliancesList = kitchenAppliancesList;
        this.descriptionOfPreparation = descriptionOfPreparation;
        this.preparingTimeInMinutes = preparingTimeInMinutes;
        this.cost = cost;
        this.degree = degree;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Ingredient> getIngredientsList() {
        return ingredientsList;
    }

    public void setIngredientsList(List<Ingredient> ingredientsList) {
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

    public
//    DegreesOfDifficulty
    String
    getDegree() {
        return degree;
    }

    public void setDegree(
//            DegreesOfDifficulty
            String
                    degree) {
        this.degree = degree;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return preparingTimeInMinutes == recipe.preparingTimeInMinutes &&
                Double.compare(recipe.cost, cost) == 0 &&
                Objects.equals(id, recipe.id) &&
                Objects.equals(title, recipe.title) &&
                Objects.equals(ingredientsList, recipe.ingredientsList) &&
                Objects.equals(kitchenAppliancesList, recipe.kitchenAppliancesList) &&
                Objects.equals(descriptionOfPreparation, recipe.descriptionOfPreparation) &&
                degree == recipe.degree;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, ingredientsList, kitchenAppliancesList, descriptionOfPreparation, preparingTimeInMinutes, cost, degree);
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", ingredientsList=" + ingredientsList +
                ", kitchenAppliancesList=" + kitchenAppliancesList +
                ", descriptionOfPreparation='" + descriptionOfPreparation + '\'' +
                ", preparingTimeInMinutes=" + preparingTimeInMinutes +
                ", cost=" + cost +
                ", degree=" + degree +
                '}';
    }
}

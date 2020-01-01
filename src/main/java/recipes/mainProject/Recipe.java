package recipes.mainProject;

import org.hibernate.validator.internal.constraintvalidators.bv.past.PastValidatorForReadableInstant;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//@Entity
public class Recipe {
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String title;
//    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true)
//    private List<Ingredient> ingredientsList;

    private String descriptionOfPreparation;
    private int preparingTimeInMinutes;
    private double cost;
    //    private DegreesOfDifficulty degree;
    private String degree;

    public static Long index = Long.valueOf(1);


    public Recipe() {
    }

    public Recipe(String title,
//                  List<Ingredient> ingredientsList,
                  String descriptionOfPreparation, int preparingTimeInMinutes, double cost,
//                  DegreesOfDifficulty degree
                  String degree
    ) {
        this.id = index++;
        this.title = title;
//        this.ingredientsList = ingredientsList;
        this.descriptionOfPreparation = descriptionOfPreparation;
        this.preparingTimeInMinutes = preparingTimeInMinutes;
        this.cost = cost;
        this.degree = degree;
    }

    public Recipe(String descriptionOfPreparation, int preparingTimeInMinutes, double cost, String degree) {
        this.id = index++;
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

//    public List<Ingredient> getIngredientsList() {
//        if (ingredientsList == null) {
//            ingredientsList = new ArrayList<>();
//        }
//        return ingredientsList;
//    }

//    public void setIngredientsList(List<Ingredient> ingredientsList) {
//        this.ingredientsList = ingredientsList;
//    }


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
//                Objects.equals(ingredientsList, recipe.ingredientsList) &&
                Objects.equals(descriptionOfPreparation, recipe.descriptionOfPreparation) &&
                degree == recipe.degree;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title,
//                ingredientsList,
                descriptionOfPreparation, preparingTimeInMinutes, cost, degree);
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", ingredientsList=" +
//                ingredientsList +
                ", descriptionOfPreparation='" + descriptionOfPreparation + '\'' +
                ", preparingTimeInMinutes=" + preparingTimeInMinutes +
                ", cost=" + cost +
                ", degree=" + degree +
                '}';
    }
}

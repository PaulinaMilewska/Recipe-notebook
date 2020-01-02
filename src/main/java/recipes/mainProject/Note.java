package recipes.mainProject;

import java.util.ArrayList;
import java.util.List;

public class Note {
    private Long id;
    Recipe recipe;
    List<Ingredient> ingredientList;

    public static Long index = Long.valueOf(1);

    public Note( Recipe recipe, List<Ingredient> ingredientList) {
        this.id = index++;
        this.recipe = recipe;
        this.ingredientList = ingredientList;
        ingredientList= new ArrayList<>();
    }

    public Note() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public List<Ingredient> getIngredientList() {
        return ingredientList;
    }

    public void setIngredientList(List<Ingredient> ingredientList) {
        this.ingredientList = ingredientList;
    }

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", recipe=" + recipe +
                ", ingredientList=" + ingredientList +
                '}';
    }
}

package recipes.mainProject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class RecipeController {
    public List<Recipe> recipesList;
    public List<String> ingredients; ;
    public List<String> kitchenAppliancesList;


    public RecipeController() {
        recipesList = new ArrayList<>();
        ingredients = new ArrayList<>();
        ingredients.add("pomidor" );
        ingredients.add("cebula");
        kitchenAppliancesList = new ArrayList<>();
        kitchenAppliancesList.add("pot");
        recipesList.add(new Recipe("Pomidorowa", ingredients, kitchenAppliancesList, "cook", 50, 100, DegreesOfDifficulty.C  ));
        recipesList.add(new Recipe("Ogórkowa", ingredients, kitchenAppliancesList, "cook carefully", 30, 24, DegreesOfDifficulty.B  ));

    }

    @RequestMapping("/")
    public String indexGet() {
        return "recipes/index";
    }



    @RequestMapping(value = "/viewrecipes", method = RequestMethod.GET)
    public ModelAndView viewrecipes(Model model) {
        return new ModelAndView("recipes/viewrecipes", "recipesList", recipesList);
    }




    @RequestMapping(value = "/addrecipe")
    public ModelAndView showForm() {
        return new ModelAndView("recipes/addrecipe", "recipe", new Recipe());
    }

    @RequestMapping(value = "/save_recipe")
    public ModelAndView save(@ModelAttribute(value = "recipe") Recipe recipe) {

        if (recipe.getId() < 1){
            recipe.setId(Recipe.index++);
            System.out.printf("Adding the new recipe");
            recipe.setId(recipesList.size()+1);
            recipesList.add(recipe);
        } else {
            Recipe recipeTemp = getRecipesById(recipe.getId());
            recipeTemp.setTitle(recipe.getTitle());
            recipeTemp.setIngredientsList(recipe.getIngredientsList());
            recipeTemp.setKitchenAppliancesList(recipe.getKitchenAppliancesList());
            recipeTemp.setDescriptionOfPreparation(recipe.getDescriptionOfPreparation());
            recipeTemp.setPreparingTimeInMinutes(recipe.getPreparingTimeInMinutes());
            recipeTemp.setCost(recipe.getCost());
            recipeTemp.setDegree(recipe.getDegree());

        }
//        EmailExecutor.sendMail("pkozlowska.pw@gmail.com");
        return new ModelAndView("redirect:/viewrecipes");
    }
        Recipe recipe1 = new Recipe();
    @RequestMapping(value = "/viewone", method = RequestMethod.POST)
    public ModelAndView show(@RequestParam(value = "recipe_id") String recipe_id) {
        recipe1 = recipesList.get(getRecipesById(Integer.parseInt(recipe_id)).getId()-1);
        return new ModelAndView("recipes/viewone", "recipe1", recipe1);
    }

//    @RequestMapping(value = "/viewone", method = RequestMethod.GET)
//    public ModelAndView viewone(Model model) {
//        return new ModelAndView("recipes/viewone");
////        return new ModelAndView("recipes/viewone", "recipe1", recipesList);
//    }


    @RequestMapping(value = "/delete_recipe", method = RequestMethod.POST)
    public ModelAndView delete(@RequestParam(value = "recipe_id") String recipe_id) {
        recipesList.remove(getRecipesById(Integer.parseInt(recipe_id)));
        return new ModelAndView("redirect:/viewrecipes");
    }

    @RequestMapping(value = "/edit_recipe")
    public ModelAndView editing(@RequestParam(value = "recipe_id") String recipe_id) {
        Recipe recipe = getRecipesById(Integer.parseInt(recipe_id));
        return new ModelAndView("recipes/addrecipe", "recipe", recipe);
    }

    private Recipe getRecipesById(@RequestParam int id){
        return recipesList.stream().filter(f->f.getId() == id).findFirst().get();
    }
}

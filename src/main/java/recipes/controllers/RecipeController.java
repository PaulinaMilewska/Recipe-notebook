package recipes.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import recipes.mainProject.DegreesOfDifficulty;
import recipes.mainProject.Ingredient;
import recipes.mainProject.Measure;
import recipes.mainProject.Recipe;

import java.util.ArrayList;
import java.util.List;

import static recipes.controllers.IngredientController.ingredientList;

@Controller
public class RecipeController {
    public List<Recipe> recipesList;
    public List<Ingredient> ingredientsForTomatoSoup;
    public List<Ingredient> ingredientsForCucumberSoup;



    public RecipeController() {
        recipesList = new ArrayList<>();
//        ingredientsForTomatoSoup = new ArrayList<>();
//        ingredientsForCucumberSoup = new ArrayList<>();
//
//        Ingredient tomato = new Ingredient( "tomato", 5, Measure.PIECE);
//        Ingredient cucumber = new Ingredient( "cucumber", 10, Measure.PIECE);
//        Ingredient salt = new Ingredient( "salt", 2, Measure.SALTSPOON);
//        Ingredient broth = new Ingredient( "broth", 1, Measure.LITER);
//        Ingredient carrot = new Ingredient( "carrot", 2, Measure.PIECE);
//
//        ingredientsForTomatoSoup.add(tomato);
//        ingredientsForTomatoSoup.add(broth);
//        ingredientsForCucumberSoup.add(broth);
//        ingredientsForCucumberSoup.add(cucumber);
//        ingredientsForCucumberSoup.add(salt);


        recipesList.add(new Recipe("Tomato soup",  "Add tomatoes to broth. Cook on small fire.", 50, 100, DegreesOfDifficulty.C.getDifficultyDescription()));
        recipesList.add(new Recipe("Cucumber soup",   "Add cucumbers to hot broth. Cook for 30 minuts.", 30, 24, DegreesOfDifficulty.B.getDifficultyDescription()));

    }

    @RequestMapping("/")
    public String indexGet() {
        return "recipes/index";
    }


    @RequestMapping(value = "/viewrecipes", method = RequestMethod.GET)
    public ModelAndView viewrecipes(Model model) {
//        model.addAttribute("newRecipe", new Recipe());
        return new ModelAndView("recipes/viewrecipes", "recipesList", recipesList);
    }


    @RequestMapping(value = "/addrecipe")
    public ModelAndView showForm(Model model) {
        model.addAttribute("ingredientList", ingredientList);
        return new ModelAndView("recipes/addrecipe", "recipe", new Recipe());
    }

    @RequestMapping(value = "/save_recipe")
    public ModelAndView save(@ModelAttribute(value = "recipe") Recipe recipe) {

//        if (recipe.getId() < 1) {
            recipe.setId(Recipe.index++);
            System.out.printf("Adding the new recipe");
            recipe.setId(Long.valueOf(recipesList.size() + 1));
            recipesList.add(recipe);
//        } else {
//            Recipe recipeTemp = getRecipesById(recipe.getId());
//            recipeTemp.setTitle(recipe.getTitle());
////            recipeTemp.setIngredientsList(recipe.getIngredientsList());
//            recipeTemp.setDescriptionOfPreparation(recipe.getDescriptionOfPreparation());
//            recipeTemp.setPreparingTimeInMinutes(recipe.getPreparingTimeInMinutes());
//            recipeTemp.setCost(recipe.getCost());
//            recipeTemp.setDegree(recipe.getDegree());
//        }
//        EmailExecutor.sendMail("pkozlowska.pw@gmail.com");
        return new ModelAndView("redirect:/viewrecipes");
    }

    Recipe recipe1 = new Recipe();
//
//    @RequestMapping(value = "/viewone", method = RequestMethod.POST)
//    public ModelAndView show(@RequestParam(value = "recipe_id") String recipe_id) {
//        System.out.println("Here1");
//        recipe1 =  recipesList.get(Math.toIntExact(getRecipesById(Long.valueOf(Integer.parseInt(recipe_id))).getId() - 1));
//        System.out.println("Here2");
//        return new ModelAndView("recipes/viewone", "recipe1", recipe1);
//    }


    @RequestMapping(value = "/delete_recipe", method = RequestMethod.POST)
    public ModelAndView delete(@RequestParam(value = "recipe_id") String recipe_id) {
        recipesList.remove(getRecipesById(Long.valueOf(Integer.parseInt(recipe_id))));
        return new ModelAndView("redirect:/viewrecipes");
    }

    @RequestMapping(value = "/edit_recipe")
    public ModelAndView editing(@RequestParam(value = "recipe_id") String recipe_id) {
        Recipe recipe = getRecipesById(Long.valueOf(Integer.parseInt(recipe_id)));
        return new ModelAndView("recipes/addrecipe", "recipe", recipe);
    }


//    @PostMapping(value = "/bmi")
//    public String calculateBMI(@ModelAttribute (value = "height") String height){
//        return "redirect:/viewrecipes";
//    }

//    @GetMapping(value = "/viewingredients")
//    public ModelAndView viewingredients(Model model) {
//        return new ModelAndView("recipes/viewingredients", "ingredientList", ingredientList);
//    }

    private Recipe getRecipesById(@RequestParam Long id) {
        return recipesList.stream().filter(f -> f.getId() == id).findFirst().get();
    }
}

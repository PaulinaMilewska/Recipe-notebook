package recipes.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import recipes.mainProject.Ingredient;
import recipes.mainProject.Measure;
import recipes.mainProject.Note;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IngredientController {
    Note note;
//    List<Ingredient> list;
    public static List<Ingredient> ingredientList;
    public IngredientController() {
        ingredientList = new ArrayList<>();
        ingredientList.add(new Ingredient( "tomato", 5, Measure.PIECE));
        ingredientList.add(new Ingredient( "cucumber", 10, Measure.PIECE));
        ingredientList.add(new Ingredient( "salt", 2, Measure.SALTSPOON));
        ingredientList.add(new Ingredient( "broth", 1, Measure.LITER));
        ingredientList.add(new Ingredient( "carrot", 2, Measure.PIECE));
    }

    @RequestMapping(value = "/viewingredients", method = RequestMethod.GET)
    public ModelAndView viewingredients(Model model) {
        return new ModelAndView("recipes/viewingredients", "ingredientList", ingredientList);
    }

    private Ingredient getIngredientById(@RequestParam Long id) {
        return ingredientList.stream().filter(f -> f.getId() == id).findFirst().get();
    }

    }



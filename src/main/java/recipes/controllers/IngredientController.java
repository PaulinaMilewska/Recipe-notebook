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

//    @RequestMapping(value = "/add_to_note")
//    public ModelAndView showForm(@RequestParam(value = "note_id") String note_id) {
//        Note note1 = getNoteById(Integer.parseInt(note_id));
//        List<Ingredient> note1list = note1.getIngredientList();
//        Ingredient ingredient1 = new Ingredient();
//        note1list.add(ingredient1);
//        return new ModelAndView("add_to_note", "ingredient", ingredient1);
//    }

//    @RequestMapping(value = "/save_ingredient")
//    public ModelAndView saveIng(@ModelAttribute(value = "ingredient") Ingredient ingredient) {
//
//
////        if (ingredient.getId() < 1) {
//            ingredient.setId(Ingredient.index++);
//            System.out.printf("Adding the new recipe");
//            ingredient.setId(Long.valueOf(ingredientList.size() + 1));
//            ingredientList.add(ingredient);
//            note = new Note();
//            note.setIngredientList(ingredientList);
////        } else {
////            Ingredient ingredientTemp = getIngredientById(ingredient.getId());
////            ingredientTemp.setName(ingredient.getName());
////            ingredientTemp.setQuantity(ingredient.getQuantity());
////            ingredientTemp.setMeasure(ingredient.getMeasure());
////
////        }
////        EmailExecutor.sendMail("pkozlowska.pw@gmail.com");
//        return new ModelAndView("redirect:/viewnotes");
//    }


    private Ingredient getIngredientById(@RequestParam Long id) {
        return ingredientList.stream().filter(f -> f.getId() == id).findFirst().get();
    }

//    private Note getNoteById(@RequestParam int id) {
//        return NoteController.noteList.stream().filter(f -> f.getId() == id).findFirst().get();
//    }
    }



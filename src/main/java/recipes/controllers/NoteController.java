package recipes.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import recipes.mainProject.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//import static recipes.controllers.IngredientController.ingredientList;

@Controller
public class NoteController {
    public List<Ingredient> itemIngredientList;
    public List<Ingredient> ingredientList;
    public List<Note> noteList;
    public List<Ingredient> list;
    public Recipe recipe;
    public Note note1;
    //    public static String note_id;
    private Ingredient ingredient;

    public NoteController() {
        recipe = new Recipe("Pieczarkowa", "Add mushrooms to hot broth",
                12, 25, DegreesOfDifficulty.E.getDifficultyDescription());
        list = new ArrayList<>();
        list.add(new Ingredient("mushroom", 5, Measure.PIECE));
        list.add(new Ingredient("broth", 1, Measure.LITER));


        noteList = new ArrayList<>();
        noteList.add(new Note(recipe, list));
        itemIngredientList = new ArrayList<>();
//        ingredientList = new ArrayList<>();
    }

    @RequestMapping(value = "/viewnotes", method = RequestMethod.GET)
    public ModelAndView viewnotes(@ModelAttribute(value = "ingredient") Ingredient ingredient) {
//        @ModelAttribute(value = "ingredient") Ingredient ingredient
        List<Ingredient> newList = new ArrayList<>();
//        newList.add(ingredient);
//       int size = noteList.size();
//       Note note1 =  noteList.get(size-1);
//       note1.setIngredientList(newList);

//        noteList.get(size, noteList.get(size).setIngredientList(newList));
        System.out.println(noteList);
        System.out.println("test");
        return new ModelAndView("recipes/viewnotes", "noteList", noteList);
    }


    @RequestMapping(value = "/addnote")
    public ModelAndView showForm(Model model) {
        model.addAttribute("noteList", noteList);
        return new ModelAndView("recipes/addnote", "note", new Note());
    }

    @RequestMapping(value = "/save_note")
    public ModelAndView save(@ModelAttribute(value = "note") Note note) {

//        if (recipe.getId() < 1) {
        note.setId(Recipe.index++);
        System.out.printf("Adding the new note");
        note.setId(Long.valueOf(noteList.size() + 1));
        Long noteId = note.getId();
        noteList.add(note);
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
        return new ModelAndView("redirect:/viewnotes");
    }


    @RequestMapping(value = "/addingredient", method = RequestMethod.POST)
    public ModelAndView addingggg(@RequestParam(value = "note_id") String note_id
//            , @RequestParam(value = "ingredient") Ingredient ingredient
    ) {
//        public ModelAndView adding(Model model) {
//            model.addAttribute("note_id", note_id);
//
//            return new ModelAndView("recipes/add_to_note", "ingredient", new Ingredient());
//        }
        note1 = getNoteById(Integer.parseInt(note_id));
//        itemIngredientList = new ArrayList<>();
        itemIngredientList = note1.getIngredientList();

        return new ModelAndView("recipes/add_to_note", "ingredient", new Ingredient());
    }

    @RequestMapping(value = "/save_ingredient")
    public ModelAndView save(@ModelAttribute(value = "ingredient") Ingredient ingredient) {

        System.out.println("Set ingredient index1");
        ingredient.setId(Ingredient.index++);
        System.out.println(ingredient);
        System.out.println("Set ingredient index2");
        List<Ingredient> listlist = new ArrayList<>();
        List<Ingredient> listlist1 = new ArrayList<>();

        itemIngredientList = new ArrayList<>();
        itemIngredientList.add(ingredient);
        System.out.println("itemIngredientList" + itemIngredientList);
        ingredientList = new ArrayList<>();
        ingredientList.add(ingredient);
        System.out.println("ingredientList" + ingredientList);

        if ((note1.getIngredientList() == null)) {
            listlist1 = itemIngredientList;
            note1.setIngredientList(ingredientList);
            System.out.println("vol 1");
        } else {
            itemIngredientList.addAll(note1.getIngredientList());
            listlist = itemIngredientList;
            note1.setIngredientList(listlist);
            System.out.println("vol 2");
        }
        return new ModelAndView("redirect:/viewnotes");
    }

    private Note getNoteById(@RequestParam int id) {
        return noteList.stream().filter(f -> f.getId() == id).findFirst().get();
    }

    private Ingredient getIngredientById(@RequestParam Long id) {
        return itemIngredientList.stream().filter(f -> f.getId() == id).findFirst().get();
    }

}

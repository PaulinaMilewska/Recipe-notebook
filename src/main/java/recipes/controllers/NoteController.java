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


@Controller
public class NoteController {
    public List<Ingredient> itemIngredientList;
    public List<Ingredient> ingredientList;
    public List<Note> noteList;
    public List<Ingredient> list1;
    public List<Ingredient> list2;
    public List<String> difficultyList;
    public List<Measure> measureList;
    public Recipe recipe1;
    public Recipe recipe2;
    public Note note1;

    public NoteController() {
        recipe1 = new Recipe("Mushroom soup", "Add mushrooms to hot broth",
                40, 25, DegreesOfDifficulty.E.getDifficultyDescription());
        recipe2 = new Recipe("Pancakes", "Add flour to the milk",
                20, 10, DegreesOfDifficulty.A.getDifficultyDescription());
        list1 = new ArrayList<>();
        list2 = new ArrayList<>();
        list1.add(new Ingredient("mushroom", 5, Measure.PIECE));
        list1.add(new Ingredient("broth", 1, Measure.LITER));
        list2.add(new Ingredient("flour", 10, Measure.TABLESPOON));
        noteList = new ArrayList<>();
        noteList.add(new Note(recipe1, list1));
        noteList.add(new Note(recipe2, list2));
        itemIngredientList = new ArrayList<>();
        difficultyList = new ArrayList<>();
//        difficultyList = Arrays.asList("VERY EASY", "EASY", "MEDIUM", "HARD", "EXTRA HARD");
        difficultyList = Arrays.asList(DegreesOfDifficulty.A.getDifficultyDescription(), DegreesOfDifficulty.B.getDifficultyDescription(), DegreesOfDifficulty.C.getDifficultyDescription(), DegreesOfDifficulty.D.getDifficultyDescription(), DegreesOfDifficulty.E.getDifficultyDescription());
        measureList = new ArrayList<>();
        measureList = Arrays.asList(Measure.PIECE, Measure.LITER, Measure.SALTSPOON, Measure.TABLESPOON, Measure.COFFEESPOON, Measure.CUP, Measure.DASH, Measure.DROP, Measure.GRAM, Measure.PINCH, Measure.PINT, Measure.POTTLE);
    }

    @RequestMapping("/")
    public String get() {
        return "recipes/index";
    }

    @RequestMapping(value = "/viewnotes", method = RequestMethod.GET)
    public ModelAndView viewnotes(@ModelAttribute(value = "ingredient") Ingredient ingredient) {
        List<Ingredient> newList = new ArrayList<>();
        System.out.println(noteList);
        System.out.println("test");
        return new ModelAndView("recipes/viewnotes", "noteList", noteList);
    }

    @RequestMapping(value = "/edit_note")
    public ModelAndView editing(@RequestParam(value = "note_id") String note_id) {
        Note note = getNoteById(Integer.parseInt(note_id));
//        return new ModelAndView("recipes/addnote", "note", note);
        return new ModelAndView("recipes/addeditnote", "note", note);
    }

    @RequestMapping(value = "/save_edit_note")
    public ModelAndView save_edit_note(@ModelAttribute(value = "note") Note note) {
        System.out.println("Note show   " + note);
        Note noteTemp = getNoteById(Math.toIntExact(note.getId()));
        noteTemp.setId(note.getId());
        noteTemp.setRecipe(note.getRecipe());
        noteTemp.getRecipe().setId(note.getRecipe().getId());
        noteTemp.setIngredientList(note.getIngredientList());
        System.out.println("SHOW LIST   " + note.getIngredientList());
        System.out.println("SHOW LIST   " + noteTemp.getIngredientList());
        return new ModelAndView("redirect:/viewnotes");
    }

    @RequestMapping(value = "/addnote")
    public ModelAndView showForm(Model model) {
        model.addAttribute("noteList", noteList);
        model.addAttribute("difficultyList", difficultyList);
        return new ModelAndView("recipes/addnote", "note", new Note());
    }

    @RequestMapping(value = "/save_note")
    public ModelAndView save(@ModelAttribute(value = "note") Note note,
                             @ModelAttribute(value = "difficulty") String difficulty) {
        note.getRecipe().setDegree(difficulty);
        note.setId(Recipe.index++);
        note.getRecipe().setId(Recipe.index++);
        System.out.printf("Adding the new note");
        note.setId(Long.valueOf(noteList.size() + 1));
        Long noteId = note.getId();
        noteList.add(note);
        return new ModelAndView("redirect:/viewnotes");
    }


    @RequestMapping(value = "/addingredient", method = RequestMethod.POST)
    public ModelAndView adding(Model model, @RequestParam(value = "note_id") String note_id
    ) {
        model.addAttribute("measureList", measureList);
        note1 = getNoteById(Integer.parseInt(note_id));
        itemIngredientList = note1.getIngredientList();
        return new ModelAndView("recipes/add_to_note", "ingredient", new Ingredient());
    }

    @RequestMapping(value = "/save_ingredient")
    public ModelAndView save(@ModelAttribute(value = "ingredient") Ingredient ingredient,
                             @ModelAttribute(value = "measure") Measure measure) {

        System.out.println("Set ingredient index1");
        ingredient.setId(Ingredient.index++);
        System.out.println(ingredient);
        System.out.println("Set ingredient index2");
        List<Ingredient> listlist = new ArrayList<>();
        List<Ingredient> listlist1 = new ArrayList<>();

        ingredient.setMeasure(measure);
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

    Note noteToView = new Note();

    @RequestMapping(value = "/viewone", method = RequestMethod.POST)
    public ModelAndView show(@RequestParam(value = "note_id") String note_id) {
        noteToView = noteList.get(Math.toIntExact((getNoteById(Integer.parseInt(note_id))).getId() - 1));
        System.out.println(noteToView.getRecipe().getId());
        return new ModelAndView("recipes/viewone", "noteToView", noteToView);
    }

    @RequestMapping(value = "/delete_note", method = RequestMethod.POST)
    public ModelAndView delete(@RequestParam(value = "note_id") String note_id) {
        noteList.remove(getNoteById(Math.toIntExact(Long.valueOf(Integer.parseInt(note_id)))));
        return new ModelAndView("redirect:/viewnotes");
    }

    private Note getNoteById(@RequestParam int id) {
        return noteList.stream().filter(f -> f.getId() == id).findFirst().get();
    }

    private Ingredient getIngredientById(@RequestParam Long id) {
        return itemIngredientList.stream().filter(f -> f.getId() == id).findFirst().get();
    }

}

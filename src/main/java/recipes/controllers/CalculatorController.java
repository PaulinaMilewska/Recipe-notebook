package recipes.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import recipes.mainProject.Calculator;

@Controller
public class CalculatorController {

    public CalculatorController() {
    }

    @RequestMapping(value = "/bmi")
    public ModelAndView createOperationModel(Model model) {
        model.addAttribute("operationModel", new Calculator());
        return new ModelAndView("recipes/bmi", "operationModel", new Calculator());
    }

    @RequestMapping(value = "/bmicount")
    public ModelAndView add(@ModelAttribute("operationModel") Calculator calculator) {
        calculator.setId(Calculator.index++);
        double heightModel = calculator.getHeight()/100;
        double result1 = calculator.getWeight() / (heightModel*heightModel);
        double result2 = result1 * 100;
        int result3 = (int) result2;
        double result = (double) result3/100;
        return new ModelAndView("recipes/bmiresult", "result", result);
    }

}
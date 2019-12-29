package recipes.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import recipes.mainProject.Calculator;
import recipes.mainProject.CalculatorFromData;

@Controller
public class CalculatorController {
    @Autowired
    Calculator calculator;

    @RequestMapping(value = "/bmi")
    public String createOperationModel(Model model) {
        model.addAttribute("operationModel", new CalculatorFromData());
        return "bmi";
    }

    @RequestMapping(path="/bmi", method = RequestMethod.POST)
    public String add(@ModelAttribute("operationModel") CalculatorFromData calculatorFromData, Model model) {
        model.addAttribute("result", calculator.calculate(calculatorFromData.getWeight(), calculatorFromData.getHeight() ));
        return "bmi";
    }
}

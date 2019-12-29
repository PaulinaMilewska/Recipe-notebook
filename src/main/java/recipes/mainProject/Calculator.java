package recipes.mainProject;

import org.springframework.stereotype.Component;

@Component
public class Calculator {
public double calculate(double weight, double height){
    return weight/(height*height);
}

}

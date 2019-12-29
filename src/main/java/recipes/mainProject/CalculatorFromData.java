package recipes.mainProject;

public class CalculatorFromData {
    private double height;
    private double weight;

    public CalculatorFromData(double height, double weight) {
        this.height = height;
        this.weight = weight;
    }

    public CalculatorFromData() {
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}

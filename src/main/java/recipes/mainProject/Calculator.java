package recipes.mainProject;


public class Calculator {
    private int id;
    private double weight;
    private double height;

    public static int index = 1;

    public Calculator() {
    }

    public Calculator(double weight, double height) {
        this.id = index++;
        this.weight = weight;
        this.height = height;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public String toString() {
        return "Calculator{" +
                "id=" + id +
                ", weight=" + weight +
                ", height=" + height +
                '}';
    }


}



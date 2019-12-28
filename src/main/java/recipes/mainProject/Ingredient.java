package recipes.mainProject;

import java.util.Objects;

public class Ingredient {
    private Long id;
    private String name;
    private double quantity;
    private Measure measure;

    public Ingredient() {
    }

    public Ingredient(Long id, String name, double quantity, Measure measure) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.measure = measure;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public Measure getMeasure() {
        return measure;
    }

    public void setMeasure(Measure measure) {
        this.measure = measure;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return Double.compare(that.quantity, quantity) == 0 &&
                Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                measure == that.measure;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, quantity, measure);
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", measure=" + measure +
                '}';
    }
}

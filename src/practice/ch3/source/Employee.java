package practice.ch3.source;

public class Employee implements Measurable {
    private String name;
    private double measure;

    public Employee(String name, double measure) {
        this.name = name;
        this.measure = measure;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public double getMeasure() {
        return this.measure;
    }
}

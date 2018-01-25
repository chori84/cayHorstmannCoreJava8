package practice.ch3.source;

public class HQ {
    public double average(Measurable[] objects) {
        double sum = 0;

        for (Measurable measurable : objects) {
            sum += measurable.getMeasure();
        }

        return sum / objects.length;
    }

    public Measurable largest(Measurable[] objects) {
        Measurable largestMeasurable = objects[0];

        for (Measurable measurable : objects) {
            if(measurable.getMeasure() > largestMeasurable.getMeasure()) {
                largestMeasurable = measurable;
            }
        }

        return largestMeasurable;
    }
}

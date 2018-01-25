package practice.ch3.source;

import java.util.Arrays;
import java.util.Comparator;

public class EmployeeSort {
    static Comparator<Employee> employeeComparator
            = Comparator.comparingDouble(Employee::getMeasure).reversed().thenComparing(Employee::getName);

    public static void sortAsc(Employee[] employees) {
        Arrays.sort(employees, employeeComparator);
    }

    public static void sortDesc(Employee[] employees) {
        Arrays.sort(employees, (e1, e2) -> employeeComparator.compare(e2, e1));
    }
}

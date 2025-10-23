package examples.composition;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private final String name;
    private final String dept;
    private final int salary;
    private final List<Employee> subordinates;

    // constructor
    public Employee(String name, String dept, int sal) {
        this.name = name;
        this.dept = dept;
        this.salary = sal;
        this.subordinates = new ArrayList<Employee>();
    }

    public void addSubordinate(Employee e) {
        subordinates.add(e);
    }

    public void removeSubordinate(Employee e) {
        subordinates.remove(e);
    }

    public List<Employee> getSubordinates() {
        return subordinates;
    }

    public String toString() {
        return ("Employee: [Name : " + name + ", dept : " + dept + ", salary :" + salary + " ]");
    }

    private List<String> toStringList() {
        List<String> strings = new ArrayList<>();
        strings.add("Employee: [Name : " + name + ", dept : " + dept + ", salary :" + salary + " ]");
        for (Employee e : subordinates) {
            for (String str : e.toStringList()) {
                strings.add("\t" + str);
            }
        }
        return strings;
    }

    public String toStringNew() {
        StringBuilder builder = new StringBuilder();
        for (String s : toStringList()) {
            builder.append("\n");
            builder.append(s);
        }
        return builder.toString();
    }

}

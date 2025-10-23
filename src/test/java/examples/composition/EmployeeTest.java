package examples.composition;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    void testEmployee() {
        Employee CEO = new Employee("John","CEO", 30000);
        Employee headSales = new Employee("Robert","Head Sales", 20000);
        Employee headMarketing = new Employee("Michel","Head Marketing", 20000);
        Employee clerk1 = new Employee("Laura","Marketing", 10000);
        Employee clerk2 = new Employee("Bob","Marketing", 10000);
        Employee salesExecutive1 = new Employee("Richard","Sales", 10000);
        CEO.addSubordinate(headSales);
        CEO.addSubordinate(headMarketing);
        headSales.addSubordinate(salesExecutive1);
        headMarketing.addSubordinate(clerk1);
        headMarketing.addSubordinate(clerk2);
        //print all employees of the organization
        System.out.println(CEO);
        for (Employee headEmployee : CEO.getSubordinates()) {
            System.out.println(headEmployee);
            for (Employee employee : headEmployee.getSubordinates()) {
                System.out.println(employee);
            }
        }
    }

    @Test
    void testEmployee2() {
        Employee CEO = new Employee("John","CEO", 30000);
        Employee headSales = new Employee("Robert","Head Sales", 20000);
        Employee headMarketing = new Employee("Michel","Head Marketing", 20000);
        Employee clerk1 = new Employee("Laura","Marketing", 10000);
        Employee clerk2 = new Employee("Bob","Marketing", 10000);
        Employee salesExecutive1 = new Employee("Richard","Sales", 10000);
        CEO.addSubordinate(headSales);
        CEO.addSubordinate(headMarketing);
        headSales.addSubordinate(salesExecutive1);
        headMarketing.addSubordinate(clerk1);
        headMarketing.addSubordinate(clerk2);

        //print all employees of the organization
        System.out.println(CEO);
    }

}
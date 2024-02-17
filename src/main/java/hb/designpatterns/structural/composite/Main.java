package hb.designpatterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

// Component interface representing a company component
interface CompanyComponent {
    void displayDetails();
}

// Leaf class representing an employee
class Employee implements CompanyComponent {
    private String name;
    private String position;

    public Employee(String name, String position) {
        this.name = name;
        this.position = position;
    }

    @Override
    public void displayDetails() {
        System.out.println("Employee: " + name + ", Position: " + position);
    }
}

// Composite class representing a department
class Department implements CompanyComponent {
    private String name;
    private List<CompanyComponent> components;

    public Department(String name) {
        this.name = name;
        this.components = new ArrayList<>();
    }

    public void addComponent(CompanyComponent component) {
        components.add(component);
    }

    public void removeComponent(CompanyComponent component) {
        components.remove(component);
    }

    @Override
    public void displayDetails() {
        System.out.println("Department: " + name);
        for (CompanyComponent component : components) {
            component.displayDetails();
        }
    }
}

// Example usage
public class Main {
    public static void main(String[] args) {
        // Creating employee objects
        Employee emp1 = new Employee("John Doe", "Software Engineer");
        Employee emp2 = new Employee("Alice Smith", "Marketing Specialist");

        // Creating department objects
        Department engineeringDept = new Department("Engineering Department");
        Department marketingDept = new Department("Marketing Department");

        // Adding employees to departments
        engineeringDept.addComponent(emp1);
        marketingDept.addComponent(emp2);

        // Creating a composite department
        Department parentDept = new Department("Parent Department");
        parentDept.addComponent(engineeringDept);
        parentDept.addComponent(marketingDept);

        // Displaying details of the parent department
        parentDept.displayDetails();
    }
}


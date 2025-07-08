// 6) Perform CRUD operation using ArrayList collection in an EmployeeCRUD class for the below Employee
// class Employee{
// 	private int id;
// 	private String name;
// 	private String department;
// }


// Answer:
// Employee class:
public class Employee {
    private int id;
    private String name;
    private String department;

    // Constructors, Getters, Setters
}

// EmployeeCRUD class:
import java.util.*;

public class EmployeeCRUD {
    private List<Employee> employees = new ArrayList<>();

    public void addEmployee(Employee emp) {
        employees.add(emp);
    }

    public void updateEmployee(int id, String name, String department) {
        for (Employee e : employees) {
            if (e.getId() == id) {
                e.setName(name);
                e.setDepartment(department);
            }
        }
    }

    public void deleteEmployee(int id) {
        employees.removeIf(e -> e.getId() == id);
    }

    public void listEmployees() {
        for (Employee e : employees) {
            System.out.println(e.getId() + " " + e.getName() + " " + e.getDepartment());
        }
    }
}

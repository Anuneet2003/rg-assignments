// 7) Perform CRUD operation using JDBC in an EmployeeJDBC class for the below Employee
// class Employee{
// 	private int id;
// 	private String name;
// 	private String department;
// }

// Answer:
// EmployeeJDBC class:
import java.sql.*;

public class EmployeeJDBC {
    private Connection connect() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/dbname", "user", "password");
    }

    public void addEmployee(Employee emp) throws SQLException {
        String sql = "INSERT INTO employees (id, name, department) VALUES (?, ?, ?)";
        try (Connection conn = connect(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, emp.getId());
            ps.setString(2, emp.getName());
            ps.setString(3, emp.getDepartment());
            ps.executeUpdate();
        }
    }

    public void updateEmployee(Employee emp) throws SQLException {
        String sql = "UPDATE employees SET name=?, department=? WHERE id=?";
        try (Connection conn = connect(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, emp.getName());
            ps.setString(2, emp.getDepartment());
            ps.setInt(3, emp.getId());
            ps.executeUpdate();
        }
    }

    public void deleteEmployee(int id) throws SQLException {
        String sql = "DELETE FROM employees WHERE id=?";
        try (Connection conn = connect(); PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    public void listEmployees() throws SQLException {
        String sql = "SELECT * FROM employees";
        try (Connection conn = connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " " + rs.getString("name") + " " + rs.getString("department"));
            }
        }
    }
}
public class Main {
    public static void main(String[] args) {
        EmployeeCRUD crud = new EmployeeCRUD();

        // Adding employees
        crud.addEmployee(new Employee(1, "Alice", "HR"));
        crud.addEmployee(new Employee(2, "Bob", "IT"));
        crud.addEmployee(new Employee(3, "Charlie", "Finance"));

        System.out.println("All Employees:");
        crud.listEmployees();

        // Updating an employee
        crud.updateEmployee(2, "Bob Marley", "Security");
        System.out.println("\nAfter Updating Employee with ID 2:");
        crud.listEmployees();

        // Deleting an employee
        crud.deleteEmployee(1);
        System.out.println("\nAfter Deleting Employee with ID 1:");
        crud.listEmployees();
    }
}



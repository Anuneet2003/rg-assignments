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
        try {
            EmployeeJDBC db = new EmployeeJDBC();

            // Add employees
            db.addEmployee(new Employee(1, "Alice", "HR"));
            db.addEmployee(new Employee(2, "Bob", "IT"));

            // List all employees
            System.out.println("All Employees:");
            db.listEmployees();

            // Update an employee
            db.updateEmployee(new Employee(2, "Bob Marley", "Security"));
            System.out.println("\nAfter Update:");
            db.listEmployees();

            // Delete an employee
            db.deleteEmployee(1);
            System.out.println("\nAfter Deletion:");
            db.listEmployees();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}




CREATE DATABASE student_database;

USE student_database;

CREATE TABLE students (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(50) NOT NULL,
  age INT NOT NULL,
  email VARCHAR(50) NOT NULL
);





// CRUD opration on above students table

import java.sql.*;

public class StudentDatabase {

    private Connection conn ;

    public StudentDatabase(String url, String user, String password) throws SQLException {
        conn = DriverManager.getConnection(url, user, password);
    }

    public void addStudent(String name, int age, String email) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO students (name, age, email) VALUES (?, ?, ?)");
        stmt.setString(1, name);
        stmt.setInt(2, age);
        stmt.setString(3, email);
        stmt.executeUpdate();
    }

    public void updateStudent(int id, String name, int age, String email) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("UPDATE students SET name = ?, age = ?, email = ? WHERE id = ?");
        stmt.setString(1, name);
        stmt.setInt(2, age);
        stmt.setString(3, email);
        stmt.setInt(4, id);
        stmt.executeUpdate();
    }

    public void deleteStudent(int id) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM students WHERE id = ?");
        stmt.setInt(1, id);
        stmt.executeUpdate();
    }

    public ResultSet getAllStudents() throws SQLException {
        Statement stmt = conn.createStatement();
        return stmt.executeQuery("SELECT * FROM students");
    }

    public void close() throws SQLException {
        conn.close();
    }

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/student_database";
        String user = "root";
        String password = "password";

        try {
            StudentDatabase db = new StudentDatabase(url, user, password);

            // Add a new student
            db.addStudent("Prem", 22, "premkdam246@gmail.com");

            // Update an existing student
            db.updateStudent(1, "Suraj", 21, "premkdam23@gmail.com");

            // Delete a student
            db.deleteStudent(1);

            // Get all students
            ResultSet rs = db.getAllStudents();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String email = rs.getString("email");
                System.out.println(id + "\t" + name + "\t" + age + "\t" + email);
            }

            db.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

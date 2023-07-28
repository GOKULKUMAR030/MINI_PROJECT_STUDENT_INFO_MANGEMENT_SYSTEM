package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.StudentModel;
import utility.ConnectionManager;

public class StudentDao {

    public void addStudent(StudentModel student) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionManager.getConnection();
            String query = "INSERT INTO students(studentId, studentName, studentClass, studentCourse, studentDateOfBirth, studentAge, studentAddress, studentCgpa) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, student.getStudentId());
            preparedStatement.setString(2, student.getStudentName());
            preparedStatement.setString(3, student.getStudentClass());
            preparedStatement.setString(4, student.getStudentCourse());
            preparedStatement.setString(5, student.getStudentDateOfBirth());
            preparedStatement.setInt(6, student.getStudentAge());
            preparedStatement.setString(7, student.getStudentAddress());
            preparedStatement.setDouble(8, student.getStudentCgpa());

            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public ArrayList<StudentModel> getAllStudents() {
        ArrayList<StudentModel> students = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionManager.getConnection();
            String query = "SELECT * FROM students";
            preparedStatement = connection.prepareStatement(query);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int studentId = resultSet.getInt("studentId");
                String studentName = resultSet.getString("studentName");
                String studentClass = resultSet.getString("studentClass");
                String studentCourse = resultSet.getString("studentCourse");
                String studentDateOfBirth = resultSet.getString("studentDateOfBirth");
                int studentAge = resultSet.getInt("studentAge");
                String studentAddress = resultSet.getString("studentAddress");
                double studentCgpa = resultSet.getDouble("studentCgpa");

                StudentModel student = new StudentModel(studentId, studentName, studentClass, studentCourse, studentDateOfBirth,
                        studentAge, studentAddress, studentCgpa);
                students.add(student);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return students;
    }

    public StudentModel getStudentById(int studentId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = ConnectionManager.getConnection();
            String query = "SELECT * FROM students WHERE studentId = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, studentId);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String studentName = resultSet.getString("studentName");
                String studentClass = resultSet.getString("studentClass");
                String studentCourse = resultSet.getString("studentCourse");
                String studentDateOfBirth = resultSet.getString("studentDateOfBirth");
                int studentAge = resultSet.getInt("studentAge");
                String studentAddress = resultSet.getString("studentAddress");
                double studentCgpa = resultSet.getDouble("studentCgpa");

                return new StudentModel(studentId, studentName, studentClass, studentCourse, studentDateOfBirth,
                        studentAge, studentAddress, studentCgpa);
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return null;
    }

    public void updateStudent(StudentModel student) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionManager.getConnection();
            String query = "UPDATE students SET studentName = ?, studentClass = ?, studentCourse = ?, studentDateOfBirth = ?, studentAge = ?, studentAddress = ?, studentCgpa = ? WHERE studentId = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, student.getStudentName());
            preparedStatement.setString(2, student.getStudentClass());
            preparedStatement.setString(3, student.getStudentCourse());
            preparedStatement.setString(4, student.getStudentDateOfBirth());
            preparedStatement.setInt(5, student.getStudentAge());
            preparedStatement.setString(6, student.getStudentAddress());
            preparedStatement.setDouble(7, student.getStudentCgpa());
            preparedStatement.setInt(8, student.getStudentId());

            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void deleteStudent(int studentId) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionManager.getConnection();
            String query = "DELETE FROM students WHERE studentId = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, studentId);

            preparedStatement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}

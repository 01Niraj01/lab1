import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.collections.*;
import javafx.geometry.Insets;

import java.sql.*;

public class MainApp extends Application {

    // Database connection parameters
    private static final String DB_URL = "jdbc:mysql://localhost:3306/school_db";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    private TableView<Student> tableView;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // TableView setup
        tableView = new TableView<>();
        TableColumn<Student, Integer> idCol = new TableColumn<>("ID");
        idCol.setCellValueFactory(cell -> cell.getValue().idProperty().asObject());

        TableColumn<Student, String> nameCol = new TableColumn<>("Name");
        nameCol.setCellValueFactory(cell -> cell.getValue().nameProperty());

        TableColumn<Student, String> programCol = new TableColumn<>("Program");
        programCol.setCellValueFactory(cell -> cell.getValue().programProperty());

        tableView.getColumns().addAll(idCol, nameCol, programCol);

        // Button to load data
        Button loadButton = new Button("Load Students");
        loadButton.setOnAction(e -> loadStudents());

        // Student Info Label
        Label info = new Label("Name: Niraj Bhandari | Student ID: 123456789 | Date: 2025-07-10");

        VBox layout = new VBox(10, info, tableView, loadButton);
        layout.setPadding(new Insets(15));

        primaryStage.setTitle("NirajBhandariJavaFXApp");
        primaryStage.setScene(new Scene(layout, 600, 400));
        primaryStage.show();
    }

    // Database Connection and Data Load
    private void loadStudents() {
        ObservableList<Student> students = FXCollections.observableArrayList();

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "SELECT * FROM students";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                students.add(new Student(rs.getInt("id"), rs.getString("name"), rs.getString("program")));
            }

            tableView.setItems(students);

        } catch (SQLException e) {
            e.printStackTrace();
            Alert alert = new Alert(Alert.AlertType.ERROR, "Database Error: " + e.getMessage());
            alert.show();
        }
    }
}

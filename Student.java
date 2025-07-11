import javafx.beans.property.*;

public class Student {
    private final IntegerProperty id;
    private final StringProperty name;
    private final StringProperty program;

    public Student(int id, String name, String program) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.program = new SimpleStringProperty(program);
    }

    public IntegerProperty idProperty() { return id; }
    public StringProperty nameProperty() { return name; }
    public StringProperty programProperty() { return program; }
}

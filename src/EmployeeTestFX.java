import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


public class EmployeeTestFX extends Application
{
    private Employee employee1 = new Employee("Mike", "Benton", "male", (byte)29, 5005575);
    private Label nameLabel = new Label("Name: ");
    private TextField nameField = new TextField();
    private RadioButton maleButton = new RadioButton("Male: ");
    private RadioButton femaleButton = new RadioButton("Female: ");
    private FlowPane layout = new FlowPane();
    private Scene scene;
    
    @Override
    public void start(Stage primaryStage)
    {
        nameField.setPrefColumnCount(14);
        nameField.setText(employee1.getFirstName() + " " + employee1.getLastName());
        if(employee1.getGender().equals("male"))
        {
            maleButton.setSelected(true);
            femaleButton.setSelected(false);
        }
        else if(employee1.getGender().equals("female"))
        {
            maleButton.setSelected(false);
            femaleButton.setSelected(true);
        }
        else
        {
            maleButton.setSelected(false);
            femaleButton.setSelected(false);
        }
        
        layout.getChildren().addAll(nameLabel, nameField, maleButton, femaleButton);
        scene = new Scene(layout, 200, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Employee Information");
        primaryStage.show();
    }

}
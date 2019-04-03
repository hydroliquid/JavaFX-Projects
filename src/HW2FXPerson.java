import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


public class HW2FXPerson extends Application
{
    private byte age = 29;
    private Legionnaire legionnaire1 = new Legionnaire();

//String fN, String lN, String mN, String title, String suffix, String sex, byte age, String legionID, String CType, String fact, double rankXP, double lvlXP
    private Label sxfLabel = new Label("Suffix         :");
    private TextField sxField = new TextField();
    private Label fnLabel = new Label("First Name     : ");
    private TextField fnField = new TextField();
    private Label miLabel = new Label("Middle Initial : ");
    private TextField miField = new TextField();
    private Label lnLabel = new Label("Last Name      : ");
    private TextField lnField = new TextField();

    private RadioButton maleButton = new RadioButton("Male: ");
    private RadioButton femaleButton = new RadioButton("Female: ");

    private Label ageLabel = new Label("Age          :");
    private TextField ageField = new TextField();

    private Label legionIDLabel = new Label("legion ID    :");
    private TextField legionIDField = new TextField();

    private String[] classes = {"Trainee", "Ranger", "Storm", "Executioner", "Angelic", "Berserk"};
    private String[] factions = {"Blood Cloud", "Blue Foundation", "Generation 17", "Mercenary"};
    private Integer[] ranks = {1,2,3,4,5,6,7,8,9,10,11};

    //private Label


    private FlowPane layout = new FlowPane();
    private Scene scene;

    @Override
    public void start(Stage primaryStage)
    {
        //nameField.setPrefColumnCount(14);
        //nameField.setText(legionnaire1.getFirstName() + " " + legionnaire1.getLastName());

        if(legionnaire1.getGender().equals("male"))
        {
            maleButton.setSelected(true);
            femaleButton.setSelected(false);
        }
        else if(legionnaire1.getGender().equals("female"))
        {
            maleButton.setSelected(false);
            femaleButton.setSelected(true);
        }
        else
        {
            maleButton.setSelected(false);
            femaleButton.setSelected(false);
        }

        //layout.getChildren().addAll(nameLabel, nameField, maleButton, femaleButton);
        scene = new Scene(layout, 200, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Employee Information");
        primaryStage.show();
    }

}

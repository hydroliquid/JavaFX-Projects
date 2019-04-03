import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


public class HW2FXPerson extends Application
{

    private Legionnaire legionnaire1 = new Legionnaire();


    // String suffix String title
    private Label titleLabel = new Label("Title:");
    private ComboBox<String> titleDropDown = new ComboBox();
    // "Mr", "Mrs", "Ms". "Miss", or "Dr"
    private String[] titlesArray = {"Mr", "Mrs", "Ms", "Miss", "Dr"};
    // String fN
    private Label fnLabel = new Label("First Name: ");
    private TextField fnField = new TextField();
    // String mN
    private Label miLabel = new Label("Middle Initial: ");
    private TextField miField = new TextField();
    // String lN
    private Label lnLabel = new Label("Last Name: ");
    private TextField lnField = new TextField();
    // String suffix String title
    private Label suffixLabel = new Label("Suffix:");
    private ComboBox suffixDropDown = new ComboBox();
    private String[] suffixArray = {"Jr", "II", "III", "IV", "PhD"};
    // String sex
    private RadioButton manButton = new RadioButton("Male: ");
    private RadioButton womanButton = new RadioButton("Female: ");
    private RadioButton unspecifiedButton = new RadioButton("I do not declare: ");
    // byte age
    private Label ageLabel = new Label("Age:");
    private TextField ageField = new TextField();
    private byte ageHolder = 0;
    // String legionID
    private Label legionIDLabel = new Label("legion ID:");
    private TextField legionIDField = new TextField();
    // String CType, String fact, double rankXP
    // todo: ComboBox, Label
    private Label classLabel = new Label("Class: ");
    private ComboBox<String> classesDropDown = new ComboBox<>();
    private String[] classesArray = {"Trainee", "Ranger", "Storm", "Executioner", "Angelic", "Berserk"};
    // todo: ComboBox
    private Label factionLabel = new Label("Faction: ");
    private ComboBox<String> factionsDropDown = new ComboBox<>();
    private String[] factionsArray = {"Blood Cloud", "Blue Foundation", "Generation 17", "Mercenary"};
    // todo: ComboBox
    private Label rankXPLabel = new Label("Rank Experience: ");
    private ComboBox<Double> rankXPDropDown = new ComboBox<>();
    private Double[] rankXPsArray = {1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0,9.0,10.0,11.0};
    // todo: Label
    private Label rankLabel = new Label("Rank: ");
    private String[] ranksArray = {"Private", "Private 1st Class", "Specialist", "Sargent", "Staff Sargent",
            "Sargent 1st Class", "Master Sargent", "1st Sargent", "Sargent Major", "Command Sargent Major",  "Sargent Major of the Army"};
    // todo: double lvlXP

    private FlowPane layout = new FlowPane();

    private Scene scene;

    @Override
    public void start(Stage primaryStage)
    {
        layout.setVgap(8);
        layout.setHgap(4);

        BorderPane pane = new BorderPane();

        titleLabel.setPrefWidth(40);
        BorderPane paneForTitleComboBox = new BorderPane();
        paneForTitleComboBox.setLeft(new Label("Title: "));
        paneForTitleComboBox.setLeft(titleDropDown);
        pane.setTop(paneForTitleComboBox);
        titleDropDown.setPrefWidth(80);
        titleDropDown.setValue(null);
        ObservableList<String> titles = FXCollections.observableArrayList(titlesArray);
        titleDropDown.getItems().addAll(titles);
        //legionnaire1.setCourtesyTitle(titleDropDown.getValue());

        suffixLabel.setPrefWidth(40);
        BorderPane paneForSuffixComboBox = new BorderPane();
        paneForSuffixComboBox.setLeft(new Label("Suffix: "));
        paneForSuffixComboBox.setLeft(suffixDropDown);
        pane.setTop(paneForSuffixComboBox);
        suffixDropDown.setPrefWidth(80);
        suffixDropDown.setValue(null);
        ObservableList<String> suffixes = FXCollections.observableArrayList(suffixArray);
        suffixDropDown.getItems().addAll(suffixes);

        // titleLabel.setText(legionnaire1.getFirstName() + " " + legionnaire1.getLastName());

        if(legionnaire1.getGender().equals("male"))
        {
            manButton.setSelected(true);
            womanButton.setSelected(false);
            unspecifiedButton.setSelected(false);
        }
        else if(legionnaire1.getGender().equals("female"))
        {
            manButton.setSelected(false);
            womanButton.setSelected(true);
            unspecifiedButton.setSelected(false);
        }
        else if(legionnaire1.getGender().equals("unspecified"))
        {
            manButton.setSelected(false);
            womanButton.setSelected(false);
            unspecifiedButton.setSelected(true);
        }
        else
        {
            manButton.setSelected(false);
            womanButton.setSelected(false);
            unspecifiedButton.setSelected(false);
        }

        layout.getChildren().addAll(titleLabel,titleDropDown, fnLabel, fnField, miLabel,miField,lnLabel,lnField, suffixLabel,
                suffixDropDown, manButton, womanButton, unspecifiedButton,ageLabel, ageField, legionIDLabel, legionIDField, classLabel,
                classesDropDown,factionLabel, factionsDropDown, rankXPLabel, rankXPDropDown, rankLabel);
        scene = new Scene(layout, 400, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Legionnaire Application");
        primaryStage.show();
    }

}

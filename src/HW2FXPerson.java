import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.*;


public class HW2FXPerson extends Application
{

    private Legionnaire legionnaire1 = new Legionnaire();


    // String suffix String title
    private Label titleLabel = new Label("Title:");
    private ComboBox<String> titleDropDown = new ComboBox();
    // "Mr", "Mrs", "Ms". "Miss", or "Dr"
    private String[] titlesArray = {"Mr", "Mrs", "Ms", "Miss", "Dr"};
    // String fN
    private Label firstNameLabel = new Label("First Name: ");
    private TextField firstNameField = new TextField();
    // String mN
    private Label middleNameLabel = new Label("Middle Initial: ");
    private TextField middleNameField = new TextField();
    // String lN
    private Label lastNameLabel = new Label("Last Name: ");
    private TextField lastNameField = new TextField();
    // String suffix String title
    private Label suffixLabel = new Label("Suffix:");
    private ComboBox<String> suffixDropDown = new ComboBox();
    private String[] suffixArray = {"Jr", "II", "III", "IV", "PhD"};
    // String sex
    private Label genderLabel = new Label("Gender: ");
    private ToggleGroup answer = new ToggleGroup();
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
    // todo: ComboBox Class section
    private Label classLabel = new Label("Class: ");
    private ComboBox<String> classesDropDown = new ComboBox<>();
    private String[] classesArray = {"Trainee", "Ranger", "Storm", "Executioner", "Angelic", "Berserk"};
    // todo: ComboBox faction Section
    private Label factionLabel = new Label("Faction: ");
    private ComboBox<String> factionsDropDown = new ComboBox<>();
    private String[] factionsArray = {"Blood Cloud", "Blue Foundation", "Generation 17", "Mercenary"};
    // todo: ComboBox rank section
    private Label rankXPLabel = new Label("Rank Experience: ");
    private ComboBox<Double> rankXPDropDown = new ComboBox<>();
    private Double[] rankXPsArray = {1.0,2.0,3.0,4.0,5.0,6.0,7.0,8.0,9.0,10.0,11.0};
    // todo: rank title auto Label
    private Label rankLabel = new Label("Rank: ");
    private Label rankDisplayLabel = new Label(legionnaire1.getRankTitle());
    private String[] ranksArray = {"Private", "Private 1st Class", "Specialist", "Sargent", "Staff Sargent",
            "Sargent 1st Class", "Master Sargent", "1st Sargent", "Sargent Major", "Command Sargent Major",  "Sargent Major of the Army"};
    // todo: double lvlXP

    // todo: Submit button
    private Button submitButton = new Button("Submit Application");

    private FlowPane layout = new FlowPane();

    private VBox mainLayout = new VBox();
    private HBox radios = new HBox();

    private Scene scene;

    @Override
    public void start(Stage primaryStage)
    {

        mainLayout.setSpacing(5);
        mainLayout.setPadding(new Insets(15,15,15,15));

        BorderPane pane = new BorderPane();

        Label[] labelsArray = {titleLabel,firstNameLabel,middleNameLabel,lastNameLabel,suffixLabel,ageLabel,rankDisplayLabel,
                                rankLabel,legionIDLabel,factionLabel,rankXPLabel,classLabel,genderLabel};
        TextField[] textFieldsArray = {firstNameField,middleNameField,lastNameField,ageField,legionIDField};

        for(int i = 0; i < labelsArray.length; i++){
            Label tempLabel;
            tempLabel = labelsArray[i];
            tempLabel.setPrefWidth(100);
        }
        for(int i = 0; i < textFieldsArray.length; i++){
            TextField tempTextField;
            tempTextField = textFieldsArray[i];
            tempTextField.setPrefWidth(130);
        }
        // todo: Title section - Completed

        ComboBox[] dropDownsArray = {titleDropDown,suffixDropDown,classesDropDown,factionsDropDown};
        String[][] arraysArray = {titlesArray,suffixArray,classesArray,factionsArray};
        BorderPane paneForComboBox = new BorderPane();

        for(int i = 0; i < dropDownsArray.length; i++){

            ComboBox tempComboBox = dropDownsArray[i];

            paneForComboBox.setLeft(null);
            paneForComboBox.setLeft(tempComboBox);
            pane.setTop(paneForComboBox);
            tempComboBox.setPrefWidth(130);
            tempComboBox.setValue(null);
            ObservableList<String> tempList = FXCollections.observableArrayList(arraysArray[i]);
            tempComboBox.getItems().addAll(tempList);
        }

        // todo: sex picker - work properly
        radios.setPrefWidth(250);
        radios.setSpacing(10);
        radios.setPadding(new Insets(0,0,0,0));

        // todo: Setup toggle group
        manButton.setToggleGroup(answer);
        womanButton.setToggleGroup(answer);
        unspecifiedButton.setToggleGroup(answer);

        manButton.setOnAction(new ButtonListener());
        womanButton.setOnAction(new ButtonListener());
        unspecifiedButton.setOnAction(new ButtonListener());

        // todo: ComboBox rank section
        rankXPLabel.setPrefWidth(100);
        BorderPane paneForRankXPComboBox = new BorderPane();
        paneForRankXPComboBox.setLeft(new Label("Rank Experience: "));
        paneForRankXPComboBox.setLeft(rankXPDropDown);
        pane.setTop(paneForRankXPComboBox);
        rankXPDropDown.setPrefWidth(130);
        rankXPDropDown.setValue(0.0);
        ObservableList<Double> rankXPs = FXCollections.observableArrayList(rankXPsArray);
        rankXPDropDown.getItems().addAll(rankXPs);
        // todo: rank title auto Label
        rankLabel.setPrefWidth(100);

        SetRankStatus(rankXPDropDown.getValue());

        legionnaire1.setRankTitle(rankXPDropDown.getValue());


        // todo: create button load
        submitButton.setPrefWidth(120);
        submitButton.setAlignment(Pos.CENTER);

        submitButton.setOnAction(new ButtonListener());


        mainLayout.setCenterShape(true);
        mainLayout.getChildren().addAll(titleLabel,titleDropDown, firstNameLabel, firstNameField, middleNameLabel,middleNameField,lastNameLabel,lastNameField, suffixLabel,
                suffixDropDown,genderLabel, manButton, womanButton, unspecifiedButton,ageLabel, ageField, legionIDLabel, legionIDField, classLabel,
                classesDropDown,factionLabel, factionsDropDown, rankXPLabel, rankXPDropDown, rankLabel, rankDisplayLabel, submitButton);

        scene = new Scene(mainLayout, 450, 720);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Legionnaire Application");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    // todo: Create Action Event
    private class ButtonListener implements EventHandler<ActionEvent> {


        @Override
        public void handle(ActionEvent e) {
            if (e.getSource() instanceof Button) {
                try {

                    legionnaire1.setCourtesyTitle(titleDropDown.getValue());
                    legionnaire1.setFirstName(firstNameField.getText());
                    legionnaire1.setMiddleName(middleNameField.getText());
                    legionnaire1.setLastName(lastNameField.getText());
                    legionnaire1.setSuffix(suffixDropDown.getValue());
                    legionnaire1.setGender(checkGender());
                    legionnaire1.setRankTitle(rankXPDropDown.getValue());
                    legionnaire1.setRankXP(rankXPDropDown.getValue());
                    legionnaire1.setRank(rankXPDropDown.getValue());
                    ageHolder = Byte.parseByte(ageField.getText());
                    legionnaire1.setAge(ageHolder);
                    legionnaire1.setClassType(classesDropDown.getValue());
                    legionnaire1.setFaction(factionsDropDown.getValue());
                    legionnaire1.setMylegionID(legionIDField.getText());
                    legionnaire1.setLegionTitle();

                    JOptionPane.showMessageDialog(null, "Name: " + legionnaire1.getCourtesyTitle() + " "
                            + legionnaire1.getFirstName() + " " + legionnaire1.getMiddleName() + " " + legionnaire1.getLastName()
                            + " " + legionnaire1.getSuffix() + "\n"
                            + "Age :   " + legionnaire1.getAge() + "\n"
                            + "Gender: " + legionnaire1.getGender() + "\n"
                            + legionnaire1.getRankTitle() + " with rank of: " + legionnaire1.getRank() + "\n"
                            + legionnaire1.getClassType() + " " + legionnaire1.getLegionnaireID() + " of " + legionnaire1.getFaction() + "\n"
                            + "Your application has been submitted." + "\n"
                            + legionnaire1.getLegionTitle()
                    );

                }
                catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(null, "Please enter a correct values");
                }
            }
        }
    }

    public String SetRankStatus(Double rankXP)
    {
        String rank;
        legionnaire1.setRankTitle(rankXP);
        rank = legionnaire1.getRankTitle();

        return rank;
    }

    public Gender checkGender(){

        Gender tempGender;

        if(manButton.isSelected())
        {
            tempGender = Gender.male;
        }
        else if(womanButton.isSelected())
        {
            tempGender = Gender.female;
        }
        else if(unspecifiedButton.isSelected())
        {
            tempGender = Gender.unspecified;
        }
        else
        {
            tempGender = null;
        }
        return tempGender;
    }


}

/* redundant old code


        if(manButton.isSelected())
        {
            manButton.setSelected(true);
            womanButton.setSelected(false);
            unspecifiedButton.setSelected(false);
        }
        else if(womanButton.isSelected())
        {
            manButton.setSelected(false);
            womanButton.setSelected(true);
            unspecifiedButton.setSelected(false);
        }
        else if(unspecifiedButton.isSelected())
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

        // titleLabel.setPrefWidth(100);

        BorderPane paneForTitleComboBox = new BorderPane();
        paneForTitleComboBox.setLeft(new Label("Title: "));
        paneForTitleComboBox.setLeft(titleDropDown);
        pane.setTop(paneForTitleComboBox);
        titleDropDown.setPrefWidth(130);
        titleDropDown.setValue(null);
        ObservableList<String> titles = FXCollections.observableArrayList(titlesArray);
        titleDropDown.getItems().addAll(titles);
        legionnaire1.setCourtesyTitle(titleDropDown.getValue());

        // todo: first name - Completed
        firstNameLabel.setPrefWidth(100);
        firstNameField.setPrefWidth(130);
         todo: middle name - Completed
        middleNameLabel.setPrefWidth(100);
        middleNameField.setPrefWidth(130);
        // todo: last name - Completed
        lastNameLabel.setPrefWidth(100);
        lastNameField.setPrefWidth(130);
        // todo: Suffix section - Completed
        suffixLabel.setPrefWidth(100);
        BorderPane paneForSuffixComboBox = new BorderPane();
        paneForSuffixComboBox.setLeft(new Label("Suffix: "));
        paneForSuffixComboBox.setLeft(suffixDropDown);
        pane.setTop(paneForSuffixComboBox);
        suffixDropDown.setPrefWidth(130);
        suffixDropDown.setValue(null);
        ObservableList<String> suffixes = FXCollections.observableArrayList(suffixArray);
        suffixDropDown.getItems().addAll(suffixes);


        // todo: Age section - Completed
        ageLabel.setPrefWidth(100);
        ageField.setPrefWidth(100);

        // todo: Legion ID section
        legionIDLabel.setPrefWidth(100);
        legionIDField.setPrefWidth(100);

        // todo: ComboBox Class section - Completed
        classLabel.setPrefWidth(100);
        BorderPane paneForClassComboBox = new BorderPane();
        paneForClassComboBox.setLeft(new Label("Class: "));
        paneForClassComboBox.setLeft(classesDropDown);
        pane.setTop(paneForClassComboBox);
        classesDropDown.setPrefWidth(130);
        classesDropDown.setValue("Excecutioner");
        ObservableList<String> classes = FXCollections.observableArrayList(classesArray);
        classesDropDown.getItems().addAll(classes);

        // todo: ComboBox faction Section
        factionLabel.setPrefWidth(100);
        BorderPane paneForFactionComboBox = new BorderPane();
        paneForFactionComboBox.setLeft(new Label("Faction: "));
        paneForFactionComboBox.setLeft(factionsDropDown);
        pane.setTop(paneForFactionComboBox);
        factionsDropDown.setPrefWidth(130);
        factionsDropDown.setValue("Mercenary");
        ObservableList<String> factions = FXCollections.observableArrayList(factionsArray);
        factionsDropDown.getItems().addAll(factions);

        //rankDisplayLabel.setPrefWidth(130);


                            //outputVolumeName = dropDown2.getValue();
                    //inputMeasure = Double.parseDouble(convertNumber.getText());
                    //double answer = ConvertMeasure.Convert(inputMeasure, dropDown1, dropDown2);
                    //outputMeasure = answer;

 */

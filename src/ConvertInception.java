/*
 * Exam 2 -
 * Michael Benton
 * Chemen Wong
 * Rodolfo Punzalan
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;

import javax.swing.*;


public class ConvertInception  extends Application
{
    private Label enterNumber = new Label("Enter a Value: ");
    private TextField convertNumber = new TextField();
    private Label fromLabel = new Label("From");
    private ComboBox<String> dropDown1 = new ComboBox<>();
    private Label toLabel = new Label("To");
    private ComboBox<String> dropDown2 = new ComboBox<>();

    private FlowPane mainPane = new FlowPane();
    private Scene scene;
    private String[] volumeTitles = {"Teaspoons", "Tablespoons", "Ounces", "Cups", "Pints", "Quarts", "Gallons"};

    private Button ConvertButton = new Button("Convert");

    @Override
    public void start(Stage primaryStage)
    {
        BorderPane pane = new BorderPane();

        enterNumber.setPrefWidth(100);
        convertNumber.setPrefWidth(120.0);
        fromLabel.setPrefWidth(30);
        toLabel.setPrefWidth(30);
        BorderPane paneforComboBox1 = new BorderPane();
        paneforComboBox1.setLeft(new Label("Select from Measurement: "));
        paneforComboBox1.setLeft(dropDown1);
        pane.setTop(paneforComboBox1);
        dropDown1.setPrefWidth(180);
        dropDown1.setValue("Teaspoons");

        BorderPane paneforComboBox2 = new BorderPane();
        paneforComboBox2.setRight(new Label("Select to Measurement: "));
        paneforComboBox2.setRight(dropDown1);
        pane.setTop(paneforComboBox1);
        dropDown2.setPrefWidth(180);
        dropDown2.setValue("Teaspoons");

        ObservableList<String> measurements = FXCollections.observableArrayList(volumeTitles);
        dropDown1.getItems().addAll(measurements);
        dropDown2.getItems().addAll(measurements);

        ConvertButton.setOnAction(new ButtonListener());
        dropDown1.setOnAction(e -> dropDown1.getValue());
        dropDown2.setOnAction(e -> dropDown2.getValue());

        mainPane.getChildren().addAll(enterNumber,convertNumber,fromLabel,dropDown1,toLabel,dropDown2,ConvertButton);
        scene = new Scene(mainPane, 220, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Measurement Conversion");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    private class ButtonListener implements EventHandler<ActionEvent>
    {
        private String inputVolumeName;
        private String outputVolumeName;
        private double inputMeasure = 0.0;
        private double outputMeasure = 0.0;

        @Override
        public void handle(ActionEvent e)
        {
            if (e.getSource() instanceof Button)
            {
                try {

                    outputVolumeName = dropDown2.getValue();

                    inputMeasure = Double.parseDouble(convertNumber.getText());


                    double answer = ConvertMeasure.Convert(inputMeasure, dropDown1, dropDown2);

                    outputMeasure = answer;

                    JOptionPane.showMessageDialog(null, outputMeasure + outputVolumeName);

                }
                //If the user entered in a non-numeric value, let the user know so that they can fix it
                catch (NumberFormatException nfe)
                {
                    //JOptionPane.showMessageDialog(null, "Please enter a numeric value");
                    new MessageBox("Please enter a numeric value", 200, 100);
                }
            }
        }
    }
}

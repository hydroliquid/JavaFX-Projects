import javafx.application.Application;
import javafx.event.*;						//This package gives us access to the 
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class TemperatureConversionFX extends Application
{
	//All interface elements are declared at the top of the class definition
	private Label tempLabel = new Label("Gimme a Temperature: ");
	private TextField tempField = new TextField();
	private Button fToCButton = new Button("F to C");
	private Button cToFButton = new Button("C to F");
	private FlowPane pane = new FlowPane();
	private Scene scene;
	
	//We have to override the start method in every program that extends Application
	@Override
	public void start(Stage primaryStage)
	{
		//Set the width of the TextField
		tempField.setPrefColumnCount(7);
		//Attach the proper EventHandler object to the element that the actions will
		//  be performed on
		fToCButton.setOnAction(new ButtonListener());
		cToFButton.setOnAction(new ButtonListener());
		//Add all interface elements into the Children container of the layout object
		pane.getChildren().addAll(tempLabel, tempField, fToCButton, cToFButton);
		//Instantiate the Scene object by putting the layout in it, and setting
		//  the size in pixels
		scene = new Scene(pane, 250 , 250);
		primaryStage.setTitle("Fahreneheit\\Celsius Converter");
		//Put the Scene on the Stage and render it
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	//A private class, usually called an inner class is a class that has a use specific to this
	//  program
	//We can only create objects of this class inside this application (see above where we attach
	//  the EventHandler to the appropriate Button controls)
	//The implements keyword is used when we implement or define the function of the abstract
	//  methods of an Interface.  An Interface is a special class time where all methods are
	//  abstract
	//The arrow brackets, <>, allow us to specify the data type for this method when we code it
	//This is called a Generic, and allows the Interface coder to make a single method that can
	//  respond to a variety of types
	//We select the ActionEvent type here since that is what the setOnAction method for Buttons
	//  requires
	private class ButtonListener implements EventHandler<ActionEvent>
	{
		//Create variables to hold the input and output values
		private double inputTemperature = 0.0, outputTemperature = 0.0;
		//This Button object is a reference (or pointer) to the Button that was pressed by the user
		private Button pressedButton = new Button();
		
		//The handle method is the only method of this Interface, so it is the only one we need to
		//  implement
		//The data type passed in has to match the one declared in the Generic above
		@Override
		public void handle(ActionEvent e)
		{
			//We use the instanceof operator to check if the Object object on the left is also
			//  an instance of the class on the right side (here it is Button)
			if (e.getSource() instanceof Button)
			{
				//Since the user could have entered in a non-numeric value, we place the code
				//  in a try and catch block
				try
				{
					//If the user entered in a non-numeric value, then a NumberFormatException
					//  is thrown
					inputTemperature = Double.parseDouble(tempField.getText());
					//If the user entered in a numeric value, we set a reference to the Button
					//  that was pressed
					pressedButton = (Button) e.getSource();
					//The appropriate formula is used to convert the input temperature to the
					//  output temperature, and dsiplayed properly.
					//Any /u escape sequence is followed byt the unicode value for the desired
					//  character (00B0 is the degree symbol, and 2109 if the degree symbol with an F)
					if (pressedButton.getText().equals("F to C"))
					{
						outputTemperature = (inputTemperature - 32) * 5/9;
						//Since we display the degree symbol alone here, we need the C at the end
						JOptionPane.showMessageDialog(null, outputTemperature + "\u00B0C");
					}
					if (pressedButton.getText().equals("C to F"))
					{
						outputTemperature = ((inputTemperature * 9)/5) + 32;
						JOptionPane.showMessageDialog(null, outputTemperature + "\u2109");
					}
				}
				//If the user entered in a non-numeric value, let the user know so that they can fix it
				catch(NumberFormatException nfe)
				{
					//JOptionPane.showMessageDialog(null, "Please enter a numeric value");
					new MessageBox("Please enter a numeric value", 200, 100);
				}
			}
		}
	}
}


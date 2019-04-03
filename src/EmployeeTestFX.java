import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;				//This library gives us access to the Label, TextField, and RadioButton classes
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

//All JavaFX Applications extend the Application class - This superclass gives the framework necessary for the JavaFX GUI
//  Framework
public class EmployeeTestFX extends Application
{
	//An Employee object to display property values in the simple GUI program	
	private Employee employee1 = new Employee("Brian", "Bourgon", Gender.male, (byte) 49, 1000001);
	
	//I generally put my interface elements at the global level of the class to make them easily accessible to all methods
	//If these items are placed in the start method, any called methods that access them require the element to be passed
	private Label nameLabel = new Label("Name: ");					//Labels are static text to label another element
	private TextField nameField = new TextField();
	//Radio buttons are independent by default, and must be programmed to work together
	private RadioButton maleButton = new RadioButton("Male ");
	private RadioButton femaleButton = new RadioButton("Female ");
	//All JavaFX Scenes have their interface elements placed in some layout.  The FlowPane layout is one of the simplest
	//the FlowPane layout places all elements from left to right, then top to bottom
	private FlowPane layout = new FlowPane();
	//We declare the Scene globally for scope, but then instantiate once the controls have been placed in the layout below
	private Scene scene;
	
	//The @Override annotation tells the compiler that we are trying to override or replace a method inherited from the
	//  superclass.  In this case, the abstract method start is overridden to implement the interface for this application
	//Abstract methods have the header defined, but no implemented body.  This allows other code to be written to called
	//  this method before it is created.
	//When the JavaFX application starts, a Stage is passed in to use for all of the "action" to occur on
	@Override
	public void start(Stage primaryStage)
	{
		//The TextField class does not have a constructor that sets its width, so we do that here
		nameField.setPrefColumnCount(14);
		//We use the TextFields setText method to prepopulate the TextField with the Employee objects's default name
		nameField.setText(employee1.getFirstName() + " " + employee1.getLastName());
		//We are deciding which radio button (if either) to select based on the Employee object's gender
		//We don't have to set the radio buttons not selected to false, but it is a good practice since radio buttons
		//  are intended to only allow one at a time to be selected.
		if (employee1.getGender().equals("male"))
		{
			maleButton.setSelected(true);
			femaleButton.setSelected(false);
		}
		else if(employee1.getGender().equals("female"))
		{
			maleButton.setSelected(false);
			femaleButton.setSelected(true);
		}
		//The else case is when the Employee object has its gender set to "unspecified"
		else
		{
			maleButton.setSelected(false);
			femaleButton.setSelected(false);
		}
		
		//We get the Children container from the layout so that we can put interface elements in it
		//The addAll method allows us to add several elements at a time
		//Since the FlowPane layout places elements in the Scene from left to right, top to bottom
		//  the order the elements appear in the list matters
		layout.getChildren().addAll(nameLabel, nameField, maleButton, femaleButton);
		//We place the layout in the scene and set the size of the Window in pixels
		scene = new Scene(layout, 200, 200);
		//We put the scene on the Stage
		primaryStage.setScene(scene);
		primaryStage.setTitle("Employee Information");
		//We render or display the Stage in the Application
		primaryStage.show();
	}
	
	//In Java 8, a main method is not necessary, however some versions of the Virtual Machine,
	//  especially in certain IDEs, a main method is needed
	//The main method can always be supplied, and will look like this for JavaFX applications
	public static void main(String[] args)
	{
		launch(args);
	}	
}
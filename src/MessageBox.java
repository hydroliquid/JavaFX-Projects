import javafx.event.*;			//ActionEvent class and EventHandler interface
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;		//Label and Button classes
import javafx.scene.layout.VBox;
import javafx.stage.*;			//Stage and Window classes and the Modality enum

/**
* Basic pop-up modal Message Box for displaying a message or output
*
* @author Brian Bourgon
* @version 1.0
*/

//Since this is not a stand alone application, but a new Stage that we can use in other
//JavaFX Applications, we extned Stage instead of Application.  This is not runnable on its own
public class MessageBox extends Stage
{
	/**
	* MessageBox Constructor that takes in the message to be displayed as a String
	* as well as the width and height of the MessageBox itself
	*
	* @param message	The message to be displayed in the pop-up Message Box
	* @param width		The width in pixels of the pop-up Message Box
	* @param height		The height in pixels of the pop-up Message Box
	*/
	
	//We do all of the work in the constructor, since this is just a simple pop-up
	//with a message that can be closed
	public MessageBox(String message, int width, int height)
	{
		//Create the base Stage object
		super();
		//Set the modality to WINDOW_MODAL with the Modality enum
		//WINDOW_MODAL puts focus on this Window until you close it
		this.initModality(Modality.WINDOW_MODAL);
		//This is the message to be displayed on the pop-up
		Label messageLabel = new Label(message);
		//Center the text in the Label
		messageLabel.setAlignment(Pos.BASELINE_CENTER);
		//Create the Button to close the pop-up
		Button closeButton = new Button("OK");
		//Uncomment the following line to use the inner class version
		//closeButton.setOnAction(new ButtonHandler());

		//Since we only create one of these Event Handlers, we can remove
		//  the naming part of the class definition
		//This is called an anonymous class
		//The class has no name.  The EventHandler<ActionEvent> implies
		//  we are implementing the EventHanlder interface witn an
		//  ActionEvent
		//Comment out from here through the end of the call to setOnAction
		//  to use the inner class version
		closeButton.setOnAction(new EventHandler<ActionEvent>() {
			//The implementation of the anonymous class is identical
			//  to the inner class version (see below)
			@Override
			public void handle(ActionEvent e)
			{
				if (e.getSource() instanceof Button)
				{
					//The following four lines do the same thing
					//  as the commented line below them
					Button callingButton = (Button) e.getSource();
					Scene callingScene = callingButton.getScene();
					Window dialogToClose = callingScene.getWindow();
					dialogToClose.hide();
					//((Button) e.getSource()).getScene().getWindow().hide();
				}
			}
		});	//This closes the argument to the setOnAction method call above

		//The VBox layout arranges the controls from top to bottom
		//Elements are separated by 10 pixels here
		//Using 0 for the separation puts elements on top of each other
		VBox layout = new VBox(10.0);
		//Center the items in the VBox
		layout.setAlignment(Pos.BASELINE_CENTER);
		//Put the controls into the Layout's Children collection
		layout.getChildren().addAll(messageLabel, closeButton);
		this.setScene(new Scene(layout, width, height));
		this.setResizable(false);
		this.show();
	}
	
	//Uncomment this implementation of the ButtonHandler as an inner class
	//  if you want to see that version.
	/* private class ButtonHandler implements EventHandler<ActionEvent>
	{
		@Override
		public void handle(ActionEvent e)
		{
			if (e.getSource() instanceof Button)
			{
				Button callingButton = (Button) e.getSource();
				Scene callingScene = callingButton.getScene();
				Window dialogToClose = callingScene.getWindow();
				dialogToClose.hide();
			}
		}
	} */
}
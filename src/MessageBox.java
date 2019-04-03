import javafx.event.*;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.*;

public class MessageBox extends Stage
{
    public MessageBox(String message, int width, int height)
    {
        super();
        this.initModality(Modality.WINDOW_MODAL);
        Label messageLabel = new Label(message);
        messageLabel.setAlignment(Pos.BASELINE_CENTER);
        Button closeButton = new Button("OK");

        // The implementation is below
        // closeButton.setOnAction(new ButtonHandler());
        // This takes the implementation of the class with the calling of the constructor with the call of the object.
        closeButton.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent e)
            {
                if (e.getSource() instanceof Button)
                {
                ((Button) e.getSource()).getScene().getWindow().hide();
                }
            }
        });

        VBox layout = new VBox(10.0);
        layout.setAlignment(Pos.BASELINE_CENTER);
        layout.getChildren().addAll(messageLabel, closeButton);
        this.setScene(new Scene(layout, width, height));
        this.setResizable(false);
        this.show();
    }
    /* This class was shortened to the close button express above.
    private class ButtonHandler implements EventHandler<ActionEvent>
    {
        @Override
        public void handle(ActionEvent e)
        {
            if (e.getSource() instanceof Button)
            {
                /* This
                Button callingButton = (Button) e.getSource();
                Scene callingScene = callingButton.getScene();
                Window dialogToClose = callingScene.getWindow();
                dialogToClose.hide();
                ------------ turns into this -----------

                ((Button) e.getSource()).getScene().getWindow().hide();
            }
        }
    }
    */
}

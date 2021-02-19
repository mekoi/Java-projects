package Exercise;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Driver extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			String fxmlFileName = "TicketsManager.fxml";
	        Parent root = FXMLLoader.load(getClass().getResource(fxmlFileName));
	        primaryStage.setTitle("Tickets Manager");
	        Scene scene = new Scene(root);
	        primaryStage.setScene(scene);
	        primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

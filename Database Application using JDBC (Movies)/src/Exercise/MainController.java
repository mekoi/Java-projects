package Exercise;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainController implements Initializable  {
  
  	@FXML
	private void searchButtonPressed(ActionEvent event) {
  		openSearchWindow();
	}
  	
 	@FXML
	private void entryButtonPressed(ActionEvent event) {
 		openNewEntryWindow();
  	}
 
 	@FXML
	private void modifyButtonPressed(ActionEvent event) {
 		openModifyWindow();
  	} 	
  	
  	@FXML
	private void deleteButtonPressed(ActionEvent event) {
  		openDeleteWindow();
	}  	
	
  private void openSearchWindow()
	{				
		try {
			Stage stage = new Stage();
			String fxmlFileName = "SearchTicket.fxml";
			FXMLLoader loader = new  FXMLLoader(getClass().getResource(fxmlFileName));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			stage.setTitle("Search movies tickets");
			stage.setScene(scene);
			stage.show();			

		} catch (IOException e) {
			e.printStackTrace();
		}
	}	

  private void openModifyWindow()
	{				
		try {
			Stage stage = new Stage();
			String fxmlFileName = "ModifyTicket.fxml";
			FXMLLoader loader = new  FXMLLoader(getClass().getResource(fxmlFileName));
			Parent root = loader.load();
			//ModifyTicketController controller = loader.<ModifyTicketController>getController();
			Scene scene = new Scene(root);
			stage.setTitle("Modify movie ticket");
			stage.setScene(scene);
			stage.show();			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
  
  private void openNewEntryWindow()
	{				
		try {
			Stage stage = new Stage();
			String fxmlFileName = "EnterTicket.fxml";
			FXMLLoader loader = new  FXMLLoader(getClass().getResource(fxmlFileName));
			Parent root = loader.load();
			//EnterTicketController controller = loader.<EnterTicketController>getController();
			Scene scene = new Scene(root);
			stage.setTitle("Enter movie ticket");
			stage.setScene(scene);
			stage.show();			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
    
  private void openDeleteWindow()
	{				
		try {			
			Stage stage = new Stage();
			String fxmlFileName = "DeleteTicket.fxml";
			FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFileName));
			Parent root = loader.load();
			//DeleteTicketController controller = loader.<DeleteTicketController>getController();
			Scene scene = new Scene(root);
			stage.setTitle("Delete movie ticket");
			stage.setScene(scene);
			stage.show();			

		} catch (IOException e) {
			e.printStackTrace();
		}
	}	
	
	@FXML
	private void exitButtonPressed(ActionEvent event) {
		System.exit(0);	
	}	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {		
	}
}



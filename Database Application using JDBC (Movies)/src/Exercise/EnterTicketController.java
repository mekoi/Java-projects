package Exercise;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class EnterTicketController {

    @FXML
    private TextField txtFieldEnterLocation;

    @FXML
    private TextField txtFieldEnterMovieName;

    @FXML
    private TextField txtFieldEnterTicketNumber;

    @FXML
    private TextField txtFieldEnterSeatNumber;

    @FXML
    private TextField txtFieldEnterStartTime;

    @FXML
    private Button btnEnterTicket;
    
    @FXML
    private Label lblOperationResult;
    
    @FXML
   	private void enterTicketButtonPressed(ActionEvent event) {
    	
    	TicketQueries queries = new TicketQueries();
	
    	Ticket insertTicket = new Ticket(1,txtFieldEnterLocation.getText(),txtFieldEnterMovieName.getText(),txtFieldEnterTicketNumber.getText(),Integer.parseInt(txtFieldEnterSeatNumber.getText()),txtFieldEnterStartTime.getText());
    	int insertResult=queries.createNewTicket(insertTicket);
     	
    	if (insertResult==1) 
    		lblOperationResult.setText("Ticket inserted successfully in the database!");    	
    	else 
    		lblOperationResult.setText("Ticket is not inserted in the database, as there are more than 2 records!");
    	
    	queries.close();
     	
       } 			
}

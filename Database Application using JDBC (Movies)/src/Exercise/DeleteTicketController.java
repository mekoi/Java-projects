package Exercise;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class DeleteTicketController implements Initializable  {
	
  	@FXML
    private TextField txtTicketNumberToDelete;

    @FXML
    private Button btnDeleteTicket;

    @FXML
    private Button btnExit;

    @FXML
    private Label lblDeleteResultMessage;

    @FXML
    private void deleteButtonPressed(ActionEvent event) {
    	
    	TicketQueries queries = new TicketQueries();
    	
    	System.out.println(4);
    	int deleteResult = queries.deleteTicket(txtTicketNumberToDelete.getText());
    	System.out.println(5);
    	
    	if (deleteResult==0)
    		lblDeleteResultMessage.setText("Record not deleted!");   	
    	else 
    		lblDeleteResultMessage.setText("Record deleted successfully!");	    		   	
    	queries.close();
    }

    @FXML
	void exitButtonPressed(ActionEvent event) {
	    	System.exit(0);	
	    }
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {	
	}
}



   



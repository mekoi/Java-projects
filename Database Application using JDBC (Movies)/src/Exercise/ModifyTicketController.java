package Exercise;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ModifyTicketController implements Initializable  {
	
	
	
    @FXML
    private TextField txtFieldModifyLocation;

    @FXML
    private TextField txtFieldModifyMovieName;

    @FXML
    private TextField txtFieldModifyTicketNumber;

    @FXML
    private TextField txtFieldModifySeatNumber;

    @FXML
    private TextField txtFieldModifyStartTime;

    @FXML
    private Button btnModifyTicket;

    @FXML
    private Label lblOperationResult;

    @FXML
    private TextField txtFieldTicketIdToModify;

    @FXML
    void modifyTicketButtonPressed(ActionEvent event) {
    	
    	TicketQueries queries = new TicketQueries();	

    	Ticket modifyTicket = new Ticket(Integer.parseInt(txtFieldTicketIdToModify.getText()), txtFieldModifyLocation.getText(), txtFieldModifyMovieName.getText(),txtFieldModifyTicketNumber.getText(), Integer.parseInt(txtFieldModifySeatNumber.getText()),txtFieldModifyStartTime.getText());
    	int modifyResult=queries.modifyTicketAtributes(modifyTicket);
    	
    	if (modifyResult==1) 
    		lblOperationResult.setText("Ticket is successfully updated in the database!");    	
    	else 
    		lblOperationResult.setText("Ticket not updated!");		
    	
    	queries.close();
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {		
	}
}

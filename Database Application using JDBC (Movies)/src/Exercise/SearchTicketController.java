package Exercise;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


public class SearchTicketController implements Initializable {
	
	private final ObservableList<Ticket> allTickets = FXCollections.observableArrayList();

    @FXML
    private TextField txtFieldSearchTicketID;
    
    @FXML
    private Button btnfindticket;
    
    @FXML
    private TextField txtFieldShowTicket;   
	
    @FXML
    private Button btnViewAllTickets;

    @FXML
    private ListView<Ticket> listViewTickets;

    @FXML
    private Button btnExit;
   	
    @FXML
	private void findAllTicketsButtonPressed(ActionEvent event) {
    	
    	TicketQueries queries = new TicketQueries();
    	
    	listViewTickets.getItems().clear();
    	List<Ticket> tickets = queries.showAllTickets();
    	for (Ticket item : tickets) {
    		allTickets.add(item);    		
    	}
    	listViewTickets.setItems(allTickets);
    	queries.close();
	}
    
    @FXML
	private void findTicketByIdButtonPressed(ActionEvent event) {
    	
    	TicketQueries queries = new TicketQueries();
    	
    	txtFieldShowTicket.setText("");
    	Ticket ticket = queries.findTicketById(Integer.parseInt(txtFieldSearchTicketID.getText()));
    	txtFieldShowTicket.setText("ticketID: " + ticket.getTicketID() + ", location: " + ticket.getLocation() + ", movieName: " + ticket.getMovieName() + ", ticketNumber: " + ticket.getTicketNumber() + ", seatNumber: " + ticket.getSeatNumber() + ", startTime: " + ticket.getStartTime());   	
    	queries.close();    
    } 
    
	@FXML
	private void exitButtonPressed(ActionEvent event) {
		System.exit(0);	
	
	}
		
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub	
	}
}



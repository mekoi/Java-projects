package Exercise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TicketQueries {
	
	   private static final String URL = "jdbc:derby:movies_db";
	   private static final String USERNAME = "iris";
	   private static final String PASSWORD = "iris"; 
	   public Connection connection;	   
	   private PreparedStatement countTickets;
	   private PreparedStatement createTicket;
	   private PreparedStatement selectAllTickets;
	   private PreparedStatement selectTicketById;
	   private PreparedStatement updateTicket;
	   private PreparedStatement deleteTicket;
	   private static final String TABLE_NAME="tickets";
	
	public TicketQueries()  {
		
		try {
			connection=DriverManager.getConnection(URL,USERNAME,PASSWORD);
			
			countTickets=connection.prepareStatement("SELECT count(*) FROM " + TABLE_NAME);
			createTicket=connection.prepareStatement("INSERT INTO " + TABLE_NAME + "(location, movieName, ticketNumber, seatNumber, startTime) VALUES (?,?,?,?,?)");
			selectAllTickets=connection.prepareStatement("SELECT * FROM " + TABLE_NAME);
			selectTicketById=connection.prepareStatement("SELECT * FROM " + TABLE_NAME + " WHERE ticketID = ?");
			updateTicket=connection.prepareStatement("UPDATE " + TABLE_NAME + " SET location = ?, movieName = ?, ticketNumber = ?, seatNumber = ?, startTime = ? WHERE ticketID = ?");
			deleteTicket=connection.prepareStatement("DELETE FROM " + TABLE_NAME + " WHERE ticketNumber = ?");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}							
	}

	public int createNewTicket(Ticket ticket)
	{
		int insertResult=0;
		int countRecords=0;
		
		try {
			ResultSet selectResult = countTickets.executeQuery();	
			if (selectResult.next()) {
				countRecords=selectResult.getInt(1);
				
				if (countRecords < 3)
				{
					try {
						createTicket.setString(1, ticket.getLocation());
						createTicket.setString(2, ticket.getMovieName());
						createTicket.setString(3, ticket.getTicketNumber());
						createTicket.setInt(4, ticket.getSeatNumber());
						createTicket.setString(5, ticket.getStartTime());
						insertResult = createTicket.executeUpdate();						
						return insertResult;						
					} 
					catch (SQLException e) {
						e.printStackTrace();
					}						
				}				
			}				
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}		
	
	public List<Ticket> showAllTickets()
	{
		try (ResultSet resultset = selectAllTickets.executeQuery()){
			List<Ticket> results = new ArrayList<Ticket>();	
			while (resultset.next()) {
				Ticket ticket=new Ticket(resultset.getInt("ticketID"),resultset.getString("location"),resultset.getString("movieName"),resultset.getString("ticketNumber"),resultset.getInt("seatNumber"),resultset.getString("startTime"));
				results.add(ticket);
			}
			return results;
		}	
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}	
	
	public Ticket findTicketById(int ticketID)
	{
		try {
			selectTicketById.setInt(1, ticketID);
		} 
		catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		try (ResultSet resultset = selectTicketById.executeQuery()) {
			if (resultset.next())
			{
				Ticket result = new Ticket(resultset.getInt("ticketID"),resultset.getString("location"),resultset.getString("movieName"),resultset.getString("ticketNumber"),resultset.getInt("seatNumber"),resultset.getString("startTime"));				
				return result;
			}
			else
			{
			    System.out.println("no tickets with this id");
			    return null;
			}
		}
		catch (SQLException sqlException) {
			sqlException.printStackTrace();
			return null;
		}
	}
	
	public int modifyTicketAtributes (Ticket ticket)
	{
		int result=0;
		
		try {
			updateTicket.setString(1, ticket.getLocation());
			updateTicket.setString(2, ticket.getMovieName());
			updateTicket.setString(3, ticket.getTicketNumber());
			updateTicket.setInt(4, ticket.getSeatNumber());
			updateTicket.setString(5, ticket.getStartTime());	
			updateTicket.setInt(6, ticket.getTicketID());			
			result = updateTicket.executeUpdate();
		} 		
		catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int deleteTicket (String ticketNumber)
	{
		try {
			System.out.println(1);
			deleteTicket.setString(1, ticketNumber);
			System.out.println(2);
			return deleteTicket.executeUpdate();
		} 		
		catch (SQLException e) {
			System.out.println(3);
			e.printStackTrace();
			return 0;
		}		
	}
	
	public void close() {
		try {
			connection.close();
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
	}
}
	
	
	   
	   


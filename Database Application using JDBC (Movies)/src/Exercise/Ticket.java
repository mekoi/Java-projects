package Exercise;

public class Ticket {

	int ticketID;
	String location;
	String movieName;
	String ticketNumber;
	int seatNumber;
	String startTime;
	
	public Ticket(int ticketID, String location, String movieName, String ticketNumber, int seatNumber, String startTime) {
		super();
		this.ticketID = ticketID;
		this.location = location;
		this.movieName = movieName;
		this.ticketNumber = ticketNumber;
		this.seatNumber = seatNumber;
		this.startTime = startTime;
	}
	
	public int getTicketID() {
		return ticketID;
	}
	public void setTicketID(int ticketID) {
		this.ticketID = ticketID;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getTicketNumber() {
		return ticketNumber;
	}
	public void setTicketNumber(String ticketNumber) {
		this.ticketNumber = ticketNumber;
	}
	public int getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	
	@Override
	public String toString() {
		return "ticketID=" + ticketID + ", location=" + location + ", movieName=" + movieName
				+ ", ticketNumber=" + ticketNumber + ", seatNumber=" + seatNumber + ", startTime=" + startTime;
	}

}

package com.spring.boot.micro;

import java.sql.Time;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="ticket")
public class Ticket {
	
	@NotNull 
	@Id 
	//@GeneratedValue(strategy=GenerationType.AUTO)	
	@Column(name="ticketid")
	private int ticketId;
	
	@NotNull(message="Move name is needed")
	@Size(min=1, max=100)
	@Column(name="moviename")
	private String movieName;	
	
	@NotNull(message="Ticket ID is needed")
	@Column(name="customerid")
	@Min(value=1)
	@Max(value=9999)	
	private int customerId;	
	
	@NotNull(message="An amount is needed")	
	@DecimalMin("0.00") 
	@DecimalMax("999.99") 
	@Digits(integer=3, fraction=2)
	@Column(name="amountpaid")
	private double amountPaid;	
	
	@NotNull(message="Number of tickets are needed")
	@Min(1) @Max(10)	
	@Column(name="numberoftickets")
	private int numberOfTickets;	
	
	@NotNull(message="Date of movie is needed")
	@Future(message="Date of movie can be only a future one") 
	@Column(name="ticketdate")
	private Date ticketDate;	
	
	@NotNull(message="Time of movie is needed")
	//@Pattern(regexp = "([01]?[0-9]|2[0-3]):[0-5][0-9]")
	//@Pattern(regexp = "([01]?[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]")
	@Column(name="tickettime")
	private Time ticketTime;
	
	@NotNull(message="Move name is needed")
	@Size(min=1, max=100)
	@Column(name="venue")
	private String venue;
	
	public Ticket() {		
	}

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public double getAmountPaid() {
		return amountPaid;
	}

	public void setAmountPaid(double amountPaid) {
		this.amountPaid = amountPaid;
	}

	public int getNumberOfTickets() {
		return numberOfTickets;
	}

	public void setNumberOfTickets(int numberOfTickets) {
		this.numberOfTickets = numberOfTickets;
	}

	public Date getTicketDate() {
		return ticketDate;
	}

	public void setTicketDate(Date ticketDate) {
		this.ticketDate = ticketDate;
	}

	public Date getTicketTime() {
		return ticketTime;
	}

	public void setTicketTime(Time ticketTime) {
		this.ticketTime = ticketTime;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}
}


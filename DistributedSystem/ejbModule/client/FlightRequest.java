package client;

import java.io.Serializable;
import java.util.Date;

public class FlightRequest implements Serializable {

	private String departure, arrival;
	private Date date;
	
	/**
	 * No argument Constructor, required for deserialization
	 */
	public FlightRequest() {
		
	}
	
	/**
	 * Creates a serilizable FlieghtRequest object, to be sent to the client queue;
	 * The request will then be retrieved and processed by the fipu;
	 * @param departure
	 * @param arrival
	 * @param date
	 */
	public FlightRequest (String departure, String arrival, Date date) {

		this.departure = departure;
		this.arrival = arrival;
		this.date = date;
	}
	
	
	// Getters and Setter
	
	public Date getDate() {
		return this.date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}

	public String getDeparture() {
		return this.departure;
	}
	
	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public String getArrival() {
		return this.arrival;
	}
	
	public void setDate(String arrival) {
		this.arrival = arrival;
	}

	
	/**
	 * Returns a String rappresentation of the object FlightRequest
	 */
	public String toString() {
		return "Departure " + departure + " arrival " + arrival + " date " + date;
	}
}
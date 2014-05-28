package client;

public class Flight {

	private String departure, arrival, date;
	// departure/arrival date, departure/arrival airport, airline, flight no.
	public Flight (String departure, String arrival, String date) {

		this.departure = departure;
		this.arrival = arrival;
		this.date = date;
	}

	public String toString() {

		return "Departure " + departure + " arrival " + arrival + " date " + date;
	}
}
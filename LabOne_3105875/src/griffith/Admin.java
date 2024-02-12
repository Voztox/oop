//Mert Faruk Gunes 3105875 2nd Year Computer Science (Hons) FT
package griffith;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Admin {
	public static void main(String[] args) {
		// Create flights
		Flight flightOne = new Flight("TK2575", "Denizli", "Istanbul", "2023-09-06");
		Flight flightTwo = new Flight("TK2421", "Istanbul", "Dublin", "2023-09-07");

		// Create passengers
		List<Passenger> passengers = new ArrayList<>();
		passengers.add(new Passenger("Mert Faruk Gunes", "567293125", "2002-04-20"));
		passengers.add(new Passenger("Tracey Cassells", "895834172", "1990-12-21"));
		passengers.add(new Passenger("Micheal Higgins", "645182475", "1940-03-08"));
		passengers.add(new Passenger("Ryan Gosling", "000000000", "1988-04-07"));
		passengers.add(new Passenger("Micheal Jackson", "717223222", "1965-01-01"));

		// Create reservations
		List<Reservation> reservations = new ArrayList<>();
		reservations.add(new Reservation(flightOne, passengers.get(0), 1));
		reservations.add(new Reservation(flightOne, passengers.get(1), 2));
		reservations.add(new Reservation(flightOne, passengers.get(2), 3));
		reservations.add(new Reservation(flightOne, passengers.get(3), 4));

		reservations.add(new Reservation(flightTwo, passengers.get(0), 3));
		reservations.add(new Reservation(flightTwo, passengers.get(1)));
		reservations.add(new Reservation(flightTwo, passengers.get(4), 4));

		// Assign seats for reservations that are still missing seats
		for (Reservation reservation : reservations) {
			reservation.assignSeat();
		}

		// Test the printFlightAndSeatDetails method for both flights
		flightOne.printFlightAndSeatDetails(reservations);

		flightTwo.printFlightAndSeatDetails(reservations);

		// Call the bookings method for each passenger
		for (Passenger passenger : passengers) {
			bookings(passenger, reservations);
		}
	}

	public static void bookings(Passenger passenger, List<Reservation> reservations) {
		System.out.println("Bookings for Passenger: " + passenger.getPasName() + " (Passport: " + passenger.getPasID() + ")");

		for (Reservation reservation : reservations) {
			if (reservation.getPassenger().equals(passenger) && reservation.getAssignedSeat() != null) {
				Flight flight = reservation.getFlight();
				System.out.println(flight.getFlightCode());
				System.out.println("Flight: " + flight.getFlightCode());
				System.out.println("Seat: " + reservation.getAssignedSeat());
			}
		}
	}
}
class Passenger {
	private String pasName;
	private String pasID;
	private String pasDate;

	public Passenger(String name, String passportID, String dateOfBirth) {
		pasName = name;
		pasID = passportID;
		pasDate = dateOfBirth;
	}

	public String getPasName() {
		return pasName;
	}

	public String getPasID() {
		return pasID;
	}

	public String getPasDate() {
		return pasDate;
	}
}

class Flight {
	private String flightCode;
	private String origin;
	private String destination;
	private String flightDate;
	private List<Integer> emptySeats;
	public Flight(String flightNumber, String origin, String destination, String flightDate) {
		this.flightCode = flightNumber;
		this.origin = origin;
		this.destination = destination;
		this.flightDate = flightDate;
		//needed to use "this" to avoid the warning. shadow variable maybe i am not sure going to ask that on lab?
		//I asked, got the response of "using this always better to avoid errors." thanks for the help. 
		emptySeats = new ArrayList<>();
		for (int i = 1; i <= 10; i++) {
			emptySeats.add(i);
		}
		//counting the seats
	}
	public String getFlightCode() {
		return flightCode;
	}

	public void printFlightDetails() {
		//method for printing flight details.
		System.out.println("Origin: " + origin);
		System.out.println("Destination: " + destination);
		System.out.println("Flight Date: " + flightDate);
		System.out.println("Flight Number: " + flightCode);
	}

	public List<Integer> getAvailableSeatNumbers() {
		return emptySeats;
	}

	public void bookSeat(int seatNumber) {
		//method for booking seats. After assigning the seat, seat gets removed with the "remove".
		if (emptySeats.contains(seatNumber)) {
			emptySeats.remove(Integer.valueOf(seatNumber));
			System.out.println("Seat " + seatNumber + " booked successfully.");
		} else {
			System.out.println("Seat " + seatNumber + " is not available.");
		}
		System.out.println(emptySeats);

	}
	public void printFlightAndSeatDetails(List<Reservation> reservations) {
		// Print flight details
		printFlightDetails();

		// Print seat assignments
		System.out.println("Seat Assignments:");
		System.out.println("Seat Number");
		System.out.println("Passenger Name");
		for (int seatNumber = 1; seatNumber <= 10; seatNumber++) {
			String passengerName = "EMPTY"; // Default if no passenger is assigned
			for (Reservation reservation : reservations) {
				if (reservation.getFlight().equals(this) && reservation.getAssignedSeat() != null
						&& reservation.getAssignedSeat() == seatNumber) {
					passengerName = reservation.getPassenger().getPasName();
					break;
				}
			}
			System.out.println(seatNumber + "\t\t" + passengerName);
		}
	}
}

class Reservation {
	private Flight flight;
	private Passenger pass;
	private Integer seat;
	//Integer required to make this.seat null. otherwise it gives me an error.

	public Reservation(Flight flight, Passenger passenger) {
		this.flight = flight;
		this.pass = passenger;
		List<Integer> availableSeats = flight.getAvailableSeatNumbers();
		//seat checking whether it is available and error check with it.
		if (availableSeats.isEmpty()) {
			System.out.println("Seat that you tried to choose is not available for this flight.");
			this.seat = null;
		}
		else {
			int firstAvailableSeat = availableSeats.get(0);
			this.seat = firstAvailableSeat;
			flight.bookSeat(firstAvailableSeat);
			System.out.println("Reservation created in a success.");
		}
	}
	public Reservation(Flight flight, Passenger passenger, int assignedSeat) {
		this.flight = flight;
		this.pass = passenger;
		if (flight.getAvailableSeatNumbers().contains(assignedSeat)) {
			this.seat = assignedSeat;
			flight.bookSeat(assignedSeat);
			System.out.println("Reservation created successfully.");
		} else {
			System.out.println("The seat " + assignedSeat + " is not available for this flight.");
			this.seat = null;
		}
	}

	public Flight getFlight() {
		return flight;
	}

	public Passenger getPassenger() {
		return pass;
	}

	public Integer getAssignedSeat() {
		return seat;
	}
	public void assignSeat() {
		// Check if a seat is already assigned
		if (seat != null) {
			System.out.println("Seat already assigned for this reservation.");
		} else {
			List<Integer> availableSeats = flight.getAvailableSeatNumbers();
			if (availableSeats.isEmpty()) {
				System.out.println("No available seats for this flight.");
			} else {
				System.out.println("Available seats: " + availableSeats);
				Scanner input = new Scanner(System.in);
				// Ask the user for input
				System.out.print("Enter the seat number you would like: ");
				int selectedSeat = input.nextInt();
				input.next();//tried to adding this line to fix the problem with not getting the input to console.
				if (availableSeats.contains(selectedSeat)) {
					seat = selectedSeat;
					flight.bookSeat(selectedSeat);
					System.out.println("Seat " + selectedSeat + " assigned successfully.");
				} else {
					System.out.println("Invalid seat selection. Please choose from available seats.");
				}
				input.close();
				//to avoid the warning of open input.
			}
		}
	}
}
package hb.designpatterns.structural.facade;

// Subsystem - Flight booking
class FlightBookingSystem {
    public void bookFlight(String origin, String destination, String date) {
        // Logic to book a flight
        System.out.println("Flight booked from " + origin + " to " + destination + " on " + date);
    }
}

// Subsystem - Hotel booking
class HotelBookingSystem {
    public void bookHotel(String location, String checkInDate, String checkOutDate) {
        // Logic to book a hotel
        System.out.println("Hotel booked at " + location + " from " + checkInDate + " to " + checkOutDate);
    }
}

// Subsystem - Car rental
class CarRentalSystem {
    public void rentCar(String pickupLocation, String returnLocation, String pickupDate, String returnDate) {
        // Logic to rent a car
        System.out.println("Car rented from " + pickupLocation + " to " + returnLocation +
                " from " + pickupDate + " to " + returnDate);
    }
}

// Facade class providing a simplified interface to the travel booking system
class TravelBookingFacade {
    private FlightBookingSystem flightBookingSystem;
    private HotelBookingSystem hotelBookingSystem;
    private CarRentalSystem carRentalSystem;

    public TravelBookingFacade() {
        this.flightBookingSystem = new FlightBookingSystem();
        this.hotelBookingSystem = new HotelBookingSystem();
        this.carRentalSystem = new CarRentalSystem();
    }

    public void bookTrip(String origin, String destination, String flightDate,
                         String hotelLocation, String checkInDate, String checkOutDate,
                         String carPickupLocation, String carReturnLocation, String carPickupDate, String carReturnDate) {
        flightBookingSystem.bookFlight(origin, destination, flightDate);
        hotelBookingSystem.bookHotel(hotelLocation, checkInDate, checkOutDate);
        carRentalSystem.rentCar(carPickupLocation, carReturnLocation, carPickupDate, carReturnDate);
    }
}

// Example usage
public class Main {
    public static void main(String[] args) {
        // Creating a facade for travel booking
        TravelBookingFacade travelFacade = new TravelBookingFacade();

        // Booking a trip using the facade
        travelFacade.bookTrip("New York", "Los Angeles", "2024-02-17",
                "Hilton", "2024-02-20", "2024-02-25",
                "Hertz", "Hertz", "2024-02-20", "2024-02-25");
    }
}

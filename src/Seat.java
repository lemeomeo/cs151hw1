/**
 * Created by le on 9/22/16
 */
public class Seat {
    //instance variable
    Passenger passenger;
    String row;
    String preference;
    String seatNumber;
    String serviceClass;

    /**
     * Create a seat that have a row, preference and service class
     *
     * @param row
     * @param letter
     */
    //constructor
    public Seat(String row, String letter, String serviceClass) {
        this.passenger = null;
        this.row = row;
        this.seatNumber = letter;
        this.serviceClass = serviceClass;
        if (serviceClass.equals("F")) {
            if (letter.equals("A") || letter.equals("D")) {
                preference = "W";
            } else if (letter.equals("B") || letter.equals("C")) {
                preference = "A";
            }
        } else if (serviceClass.equals("E")) {
            if (letter.equals("A") || letter.equals("F")) {
                preference = "W";
            } else if (letter.equals("C") || letter.equals("D")) {
                preference = "A";
            } else if (letter.equals("E") || letter.equals("B")) {
                preference = "C";
            }
        }


    }

    /**
     * Returns seat's row
     *
     * @return the row
     */
    public String getRow() {
        return row;
    }

    /**
     * Returns seat's number
     *
     * @return seat number
     */
    public String getSeatNumber() {
        return seatNumber;
    }

    /**
     * Returns seat preference
     *
     * @return seat preference
     */
    public String getPreference() {
        return preference;
    }

    /**
     * Returns a passenger
     *
     * @return passenger
     */
    public Passenger getPassenger() {
        return passenger;
    }

    /**
     * Set passenger to the seat
     *
     * @param p passenger
     */
    public void assignSeat(Passenger p) {
        passenger = p;
    }
}

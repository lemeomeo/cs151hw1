/**
 * An airlane that hold seats
 *
 * @author Le Dao
 * @version 1.0
 * @since 2016-09-22
 */

import java.util.*;

public class Plane {
    Seat[][] first;
    Seat[][] economy;
    private int firstW;
    private int firstA;
    private int economyW;
    private int economyA;
    private int economyC;

    /**
     * Creates an airplanes with first class and economy class
     */
    public Plane() {
        first = new Seat[2][4];
        economy = new Seat[20][6];
        firstW = 4;
        firstA = 4;
        economyW = 40;
        economyA = 40;
        economyC = 40;
        //fill in seats for first class
        for (int i = 0; i < first.length; i++) {
            for (int j = 0; j < first[0].length; j++) {
                int r = i + 1;
                String row = "" + r;
                if (j == 0) {
                    first[i][j] = new Seat(row, "A", "F");
                } else if (j == 1) {
                    first[i][j] = new Seat(row, "B", "F");
                } else if (j == 2) {
                    first[i][j] = new Seat(row, "C", "F");
                } else if (j == 3) {
                    first[i][j] = new Seat(row, "D", "F");
                }
            }
        }
        for (int i = 0; i < economy.length; i++) {
            for (int j = 0; j < economy[0].length; j++) {
                int r = i + 10;
                String row = "" + r;
                if (j == 0) {
                    economy[i][j] = new Seat(row, "A", "E");
                } else if (j == 1) {
                    economy[i][j] = new Seat(row, "B", "E");
                } else if (j == 2) {
                    economy[i][j] = new Seat(row, "C", "E");
                } else if (j == 3) {
                    economy[i][j] = new Seat(row, "D", "E");
                } else if (j == 4) {
                    economy[i][j] = new Seat(row, "E", "E");
                } else if (j == 5) {
                    economy[i][j] = new Seat(row, "F", "E");
                }
            }
        }
    }

    /**
     *Loads the prior run program file to airplane
     * @params row row number
     * @params seatNumber seat number
     * @params p passenger to be seated
     */
    public void load(int row, String seatNumber, Passenger p) {
        if (row >= 10) // if row belongs to economy
        {
            int r = row - 10;
            if (seatNumber.equals("A")) {
                economy[r][0].assignSeat(p);
                economyW -= 1;
            } else if (seatNumber.equals("B")) {
                economy[r][1].assignSeat(p);
                economyC -= 1;
            } else if (seatNumber.equals("C")) {
                economy[r][2].assignSeat(p);
                economyA -= 1;
            } else if (seatNumber.equals("D")) {
                economy[r][3].assignSeat(p);
                economyA -= 1;
            } else if (seatNumber.equals("E")) {
                economy[r][4].assignSeat(p);
                economyC -= 1;
            } else if (seatNumber == "F") {
                economy[r][5].assignSeat(p);
                economyW -= 1;
            }
        } else {
            int r = row - 1;
            if (seatNumber.equals("A")) {
                first[r][0].assignSeat(p);
                firstW -= 1;
            } else if (seatNumber.equals("B")) {
                first[r][1].assignSeat(p);
                firstA -= 1;
            } else if (seatNumber.equals("C")) {
                first[r][2].assignSeat(p);
                firstA -= 1;
            } else if (seatNumber.equals("D")) {
                first[r][3].assignSeat(p);
                firstW -= 1;
            }
        }
    }

    /**
     * Returns a manifest list for first class
     * @return a mnaifest list
     */
    public String getManifestFirst() {
        String chart = "\nFirst\n\n";
        for (int i = 0; i < first.length; i++) {
            for (int j = 0; j < first[0].length; j++) {
                if (first[i][j] != null && first[i][j].getPassenger() != null) {
                    Seat seat = first[i][j];
                    chart += seat.getRow();
                    chart += seat.getSeatNumber() + ": ";
                    chart += seat.getPassenger().getName();
                    chart += "\n";
                }
            }
        }
        return chart;
    }

    /**
     * Returns a manifest list for economy class
     * @return a manifest list
     */
    public String getManifestEconomy() {
        String chart = "\nEconomy\n\n";
        for (int i = 0; i < economy.length; i++) {
            for (int j = 0; j < economy[0].length; j++) {
                if (economy[i][j] != null && economy[i][j].getPassenger() != null) {
                    Seat seat = economy[i][j];
                    chart += seat.getRow();
                    chart += seat.getSeatNumber() + ": ";
                    chart += seat.getPassenger().getName();
                    chart += "\n";
                }
            }
        }
        return chart;
    }

    /**
     * Returns an availability list for first class
     * @return an availability list
     */
    public String getAvailabilityFirst() {
        String chart = "\nFirst\n\n";
        for (int i = 0; i < first.length; i++) {
            chart += first[i][0].getRow() + ": ";
            for (int j = 0; j < first[0].length; j++) {
                if (first[i][j].getPassenger() == null) {
                    Seat seat = first[i][j];
                    chart += seat.getSeatNumber() + ", ";
                }
            }
            chart = chart.substring(0, chart.length() - 2);
            chart += "\n";
        }
        return chart;
    }

    /**
     * Returns an availability list for economy class
     * @return an availability list
     */
    public String getAvailabilityEconomy() {
        String chart = "\nEconomy\n\n";
        for (int i = 0; i < economy.length; i++) {
            chart += economy[i][0].getRow() + ": ";
            for (int j = 0; j < economy[0].length; j++) {
                if (economy[i][j].getPassenger() == null) {
                    Seat seat = economy[i][j];
                    chart += seat.getSeatNumber() + ", ";
                }
            }
            chart = chart.substring(0, chart.length() - 2);
            chart += "\n";
        }
        return chart;
    }

    /**
     * Adds a passenger
     * @param name name of passenger
     * @param serviceClass serive class passenger chooses
     * @param position preference passenger chooses
     */
    public void addPassenger(String name, String serviceClass, String position) {
        if (serviceClass.equals("First")) {
            outerloop:
            for (int i = 0; i < first.length; i++) {
                for (int j = 0; j < first[0].length; j++) {
                    if (position.equals(first[i][j].getPreference())) {
                        if (first[i][j].getPassenger() == null) {
                            Passenger p = new Passenger(name, "");
                            first[i][j].assignSeat(p);
                            if (position.equals("W")) {
                                firstW -= 1;
                            } else {
                                firstA -= 1;
                            }
                            break outerloop;
                        }
                    }
                }
            }
        } else if (serviceClass.equals("Economy")) {
            outerloop:
            for (int i = 0; i < economy.length; i++) {
                for (int j = 0; j < economy[0].length; j++) {
                    if (position.equals(economy[i][j].getPreference())) {
                        if (economy[i][j].getPassenger() == null) {
                            Passenger p = new Passenger(name, "");
                            economy[i][j].assignSeat(p);
                            if (position.equals("W")) {
                                economyW -= 1;
                            } else if (position.equals("A")) {
                                economyA -= 1;
                            } else {
                                economyC -= 1;
                            }
                            break outerloop;
                        }
                    }
                }
            }
        }
    }

    /**
     * Returns number of occupied seats in First Class's Window
     * @return number of seat in first class's window preference
     */
    public int getFirstW() {
        return firstW;
    }

    /**
     * Returns number of occupied seats in First Class's Aisle
     * @return number of seat in first class's aisle preference
     */
    public int getFirstA() {
        return firstA;
    }

    /**
     * Returns number of occupied seats in Economy Class's Window
     * @return number of seat in economy class's window preference
     */
    public int getEconomyW() {
        return economyW;
    }

    public int getEconomyA() {
        return economyA;
    }

    public int getEconomyC() {
        return economyC;
    }

    /**
     * Returns a list of seated passengers
     * @return list of seated passengers
     */
    public String toFile() {
        String list = "";
        for (int i = 0; i < first.length; i++) {
            for (int j = 0; j < first[0].length; j++) {
                if (first[i][j].getPassenger() != null) {
                    Seat seat = first[i][j];
                    list += seat.getRow() + seat.getSeatNumber() + ", ";
                    if (seat.getPassenger().getGroup() != "") {
                        list += "G, " + seat.getPassenger().getGroup() + ", " + seat.getPassenger().getName();
                        list += "\n";
                    } else {
                        list += "I, " + seat.getPassenger().getName();
                        list += "\n";
                    }
                }
            }
        }

        for (int i = 0; i < economy.length; i++) {
            for (int j = 0; j < economy[0].length; j++) {
                if (economy[i][j].getPassenger() != null) {
                    Seat seat = economy[i][j];
                    list += seat.getRow() + seat.getSeatNumber() + ", ";
                    if (seat.getPassenger().getGroup() != "") {
                        list += "G, " + seat.getPassenger().getGroup() + ", " + seat.getPassenger().getName();
                        list += "\n";
                    } else {
                        list += "I, " + seat.getPassenger().getName();
                        list += "\n";
                    }
                }
            }
        }
        return list;
    }

}

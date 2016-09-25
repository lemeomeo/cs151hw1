/**
 * A reservation system of a plane for an airline
 *
 * @author Le Dao
 * @version 1.0
 * @since 2016-09-22
 */

import java.util.*;
import java.io.*;

public class ReservationSystem {
    public static void main(String[] args) throws IOException {
        Plane plane = new Plane();
        String group;
        File file = new File(args[0]);

        Scanner reader = new Scanner(System.in); //take input from user
        reader.useDelimiter("\\n");

        if (!file.exists()) {
            file.createNewFile();
            boolean quit = false;

            while (!quit) {
                System.out.println("Add [P]assenger, Add [G]roup, [C]ancel Reservations, Print Seating [A]vailability Chart, Print [M]anifest, [Q]uit");
                String input = reader.next();

                if (input.equals("P") || input.equals("p")) {
                    System.out.print("Name: ");
                    String name = reader.next() + "\n";

                    System.out.print("Service Class: ");
                    String service_class = reader.next() + "\n";

                    System.out.print("Seat Preference: ");
                    String preference = reader.next() + "\n";

                    name = name.replace("\n", "");
                    service_class = service_class.replace("\n", "");
                    preference = preference.replace("\n", "");


                    if (service_class.equals("First") && preference.equals("W") && plane.getFirstW() < 1) {
                        System.out.println("No Window seat available. Please select a different service class or preference");
                    } else if (service_class.equals("First") && preference.equals("A") && plane.getFirstA() < 1) {
                        System.out.println("No Aisle seat available. Please select a different service class or preference");
                    } else if (service_class.equals("Economy") && preference.equals("W") && plane.getEconomyW() < 1) {
                        System.out.println("No Window seat available. Please select a different service class or preference");
                    } else if (service_class.equals("Economy") && preference.equals("A") && plane.getEconomyA() < 1) {
                        System.out.println("No Aisle seat available. Please select a different service class or preference");
                    } else if (service_class.equals("Economy") && preference.equals("C") && plane.getEconomyC() < 1) {
                        System.out.println("No Center seat available. Please select a different service class or preference");
                    } else {
                        plane.addPassenger(name, service_class, preference);
                    }


                } else if (input.equals("G") || input.equals("g")) {

                } else if (input.equals("C") || input.equals("c")) {

                } else if (input.equals("A") || input.equals("a")) {
                    System.out.println("[F]irst class or [E]conomy?");
                    String in = reader.next();
                    if (in.equals("F") || in.equals("f")) {
                        System.out.println(plane.getAvailabilityFirst());
                    } else if (in.equals("E") || in.equals("e")) {
                        System.out.print(plane.getAvailabilityEconomy());
                    }
                } else if (input.equals("M") || input.equals("m")) {
                    System.out.println("[F]irst class or [E]conomy?");
                    String in = reader.next();
                    if (in.equals("F") || in.equals("f")) {
                        System.out.println(plane.getManifestFirst());
                    } else if (in.equals("E") || in.equals("e")) {
                        System.out.print(plane.getManifestEconomy());
                    }

                } else if (input.equals("Q") || input.equals("q")) {
                    PrintWriter out = new PrintWriter(args[0]);
                    out.println(plane.toFile());
                    out.close();
                    quit = true;
                }
            }
        } else {
            Scanner scan = new Scanner(file);

            //in here, we assume that a file is already created
            //TODO

            scan.nextLine(); // skip the first line
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                //line.replaceAll(",", ""); //get rid of commas
                String[] arr = line.split(", ");
                for (String a : arr) {
                    a.trim();
                }

                if (arr.length == 3) {
                    group = "";
                    Passenger p = new Passenger(arr[2], group);
                    if (arr[0].length() == 2) //1A, 2A
                    {
                        String seat = arr[0].substring(0, 1);
                        plane.load((Integer.parseInt(seat)), arr[0].substring(1, 2), p);
                    } else {
                        String seat = arr[0].substring(0, 2);
                        plane.load((Integer.parseInt(seat)), arr[0].substring(2, 3), p);
                    }
                } else if (arr.length == 4) {
                    group = arr[2];
                    Passenger p = new Passenger(arr[3], group);
                    if (arr[0].length() == 2) //1A, 2A
                    {
                        String seat = arr[0].substring(0, 1);
                        plane.load((Integer.parseInt(seat)), arr[0].substring(1, 2), p);
                    } else {
                        String seat = arr[0].substring(0, 2);
                        plane.load((Integer.parseInt(seat)), arr[0].substring(2, 3), p);
                    }
                }
            }
            scan.close();
            boolean quit = false;

            while (!quit) {
                System.out.println("Add [P]assenger, Add [G]roup, [C]ancel Reservations, Print Seating [A]vailability Chart, Print [M]anifest, [Q]uit");
                String input = reader.next();

                if (input.equals("P") || input.equals("p")) {
                    System.out.print("Name: ");
                    String name = reader.next() + "\n";

                    System.out.print("Service Class: ");
                    String service_class = reader.next() + "\n";

                    System.out.print("Seat Preference: ");
                    String preference = reader.next() + "\n";

                    name = name.replace("\n", "");
                    service_class = service_class.replace("\n", "");
                    preference = preference.replace("\n", "");


                    if (service_class.equals("First") && preference.equals("W") && plane.getFirstW() < 1) {
                        System.out.println("No Window seat available. Please select a different service class or preference");
                    } else if (service_class.equals("First") && preference.equals("A") && plane.getFirstA() < 1) {
                        System.out.println("No Aisle seat available. Please select a different service class or preference");
                    } else if (service_class.equals("Economy") && preference.equals("W") && plane.getEconomyW() < 1) {
                        System.out.println("No Window seat available. Please select a different service class or preference");
                    } else if (service_class.equals("Economy") && preference.equals("A") && plane.getEconomyA() < 1) {
                        System.out.println("No Aisle seat available. Please select a different service class or preference");
                    } else if (service_class.equals("Economy") && preference.equals("C") && plane.getEconomyC() < 1) {
                        System.out.println("No Center seat available. Please select a different service class or preference");
                    } else {
                        plane.addPassenger(name, service_class, preference);
                    }


                } else if (input.equals("G") || input.equals("g")) {

                } else if (input.equals("C") || input.equals("c")) {

                } else if (input.equals("A") || input.equals("a")) {
                    System.out.println("[F]irst class or [E]conomy?");
                    String in = reader.next();
                    if (in.equals("F") || in.equals("f")) {
                        System.out.println(plane.getAvailabilityFirst());
                    } else if (in.equals("E") || in.equals("e")) {
                        System.out.print(plane.getAvailabilityEconomy());
                    }
                } else if (input.equals("M") || input.equals("m")) {
                    System.out.println("[F]irst class or [E]conomy?");
                    String in = reader.next();
                    if (in.equals("F") || in.equals("f")) {
                        System.out.println(plane.getManifestFirst());
                    } else if (in.equals("E") || in.equals("e")) {
                        System.out.print(plane.getManifestEconomy());
                    }

                } else if (input.equals("Q") || input.equals("q")) {
                    PrintWriter out = new PrintWriter(args[0]);
                    out.println(plane.toFile());
                    out.close();
                    quit = true;
                }
            }

        }
    }
}

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class HouseFinder {
    private Scanner scanner;

    public HouseFinder(Scanner scanner) {
        this.scanner = scanner;
    }

    public void findHouse(List<House> houses) {
        System.out.println("\n+---------------------------------------------+");
        System.out.println("|               House Finder                  |");
        System.out.println("+---------------------------------------------+\n");

        if (houses.isEmpty()) {
            System.out.println("No houses available for search.");
            return;
        }

        // Get user input for house preferences
        String houseType = getUserInput("Enter the type of house (Apartment/Villa): ");
        double minArea = getUserInputDouble("Enter minimum area required: ");
        int minNumOfRooms = getUserInputInt("Enter minimum number of rooms required: ");
        String preferredCity = getUserInput("Enter preferred city: ");

        // Simulate searching delay
        System.out.print("Searching...\n");
        simulateDelay(2000); // Simulate a 2-second delay
        System.out.println("\nSearch completed!\n");

        // Find the most similar house based on user preferences
        List<House> matchingHouses = findMatchingHouses(houses, houseType, minArea, minNumOfRooms, preferredCity);

        // Suggest the most similar house to the user
        suggestHouse(matchingHouses);
    }

    public void displayHouseDetails(House house) {
        System.out.println("\nHouse Details:");
        System.out.println("+----+-------------+-------------+-------------+------------------------------+-------------+------------------+-------------+-------------+");
        System.out.println("| #  | Type        | Area        | # of Rooms  | Address                      | City        | Cost             | Garden/Pools| Floors      |");
        System.out.println("+----+-------------+-------------+-------------+------------------------------+-------------+------------------+-------------+-------------+");

        if (house instanceof Apartment) {
            Apartment apartment = (Apartment) house;
            System.out.printf("| %-2d | %-11s | %-11.2f | %-11d | %-28s | %-11s | %-16.2f | %-11s | %-11s |\n",
                    1, "Apartment", apartment.getArea(), apartment.getNumOfRooms(),
                    apartment.getAddress(), apartment.getCity(), apartment.getCost(),
                    "-", apartment.getFloor());
        } else if (house instanceof Villa) {
            Villa villa = (Villa) house;
            System.out.printf("| %-2d | %-11s | %-11.2f | %-11d | %-28s | %-11s | %-16.2f | %-11s | %-11s |\n",
                    1, "Villa", villa.getArea(), villa.getNumOfRooms(),
                    villa.getAddress(), villa.getCity(), villa.getCost(),
                    (villa.hasPool() ? "Yes" : "No"), villa.getNumFloors());
        }

        System.out.println("+----+-------------+-------------+-------------+------------------------------+-------------+------------------+-------------+-------------+");
    }

    private String getUserInput(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }

    private double getUserInputDouble(String message) {
        System.out.print(message);
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    private int getUserInputInt(String message) {
        System.out.print(message);
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }

    private void simulateDelay(int milliseconds) {
        try {
            if (scanner != null) {  // Check if the scanner is still open
                Thread.sleep(milliseconds);
            }
        } catch (InterruptedException | NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    private List<House> findMatchingHouses(List<House> houses, String houseType, double minArea, int minNumOfRooms, String preferredCity) {
        List<House> matchingHouses = new ArrayList<>();

        for (House house : houses) {
            if (houseType.equals("apartment") && house instanceof Apartment) {
                Apartment apartment = (Apartment) house;
                if (apartment.getArea() >= minArea && apartment.getNumOfRooms() >= minNumOfRooms && apartment.getCity().equalsIgnoreCase(preferredCity)) {
                    matchingHouses.add(apartment);
                }
            } else if (houseType.equals("villa") && house instanceof Villa) {
                Villa villa = (Villa) house;
                if (villa.getArea() >= minArea && villa.getNumOfRooms() >= minNumOfRooms && villa.getCity().equalsIgnoreCase(preferredCity)) {
                    matchingHouses.add(villa);
                }
            }
        }

        return matchingHouses;
    }

    private void suggestHouse(List<House> matchingHouses) {
        if (matchingHouses.isEmpty()) {
            System.out.println("\nNo matching houses found.");
        } else {
            System.out.println("\nSuggested House:");
            displayHouseDetails(findMostSimilarHouse(matchingHouses));
        }
    }

    private House findMostSimilarHouse(List<House> matchingHouses) {
        // Implement logic to find the most similar house based on user preferences
        // For simplicity, let's assume the first matching house is the most similar
        return matchingHouses.get(0);
    }
}
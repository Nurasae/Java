import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static final String[] FAMOUS_CITIES = {
            "Rome", "Paris", "London", "Washington", "Tokyo", "Berlin", "Madrid",
            "New York", "Los Angeles", "Sydney", "Toronto", "Beijing", "Dubai", "Mumbai",
            "San Francisco", "Chicago", "Melbourne", "Vancouver", "Shanghai", "Abu Dhabi", "Delhi",
            "Milan", "Florence", "Venice", "Naples", "Turin", "Bologna", "Palermo", "Genoa",
            "Moscow", "Istanbul", "Cairo", "Mexico City", "Rio de Janeiro", "Cape Town", "Bangkok",
            "Seoul", "Athens", "Amsterdam", "Dublin", "Vienna", "Stockholm", "Oslo", "Helsinki",
            "Copenhagen", "Prague", "Warsaw", "Budapest", "Brussels", "Lisbon", "Barcelona",
            "Zurich", "Geneva", "Frankfurt", "Munich", "Hamburg", "St. Petersburg", "Kiev",
            "Bucharest", "Sydney", "Bangkok", "Seoul", "Athens", "Amsterdam", "Dublin", "Vienna",
            "Stockholm", "Oslo", "Helsinki", "Copenhagen", "Prague", "Warsaw", "Budapest",
            "Brussels", "Lisbon", "Barcelona", "Zurich", "Geneva", "Frankfurt", "Munich",
            "Hamburg", "St. Petersburg", "Kiev", "Bucharest"
    };

    private static final int MIN_FLOORS = 1;
    private static final int MAX_FLOORS_APARTMENT = 30;
    private static final int MAX_FLOORS_VILLA = 5;
    private static final int MIN_ENERGY_CODE = 1;
    private static final int MAX_ENERGY_CODE = 10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("+-------------------------------------------------------------+");
        System.out.println("|               Welcome to the Building Information System    |");
        System.out.println("+-------------------------------------------------------------+\n");

        List<House> houses = new ArrayList<>();

        do {
            System.out.println("+-------------------------+");
            System.out.println("| Choose the house type:  |");
            System.out.println("+-------------------------+");
            System.out.println("| 1. Apartment            |");
            System.out.println("| 2. Villa                |");
            System.out.println("| 3. Both                 |");
            System.out.println("+-------------------------+");
            System.out.print("Enter your choice (1, 2, or 3): ");

            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a valid number.");
                scanner.nextLine();
                continue;
            }

            if (choice == 1) {
                houses.add(createApartment(scanner));
            } else if (choice == 2) {
                houses.add(createVilla(scanner));
            } else if (choice == 3) {
                houses.add(createApartment(scanner));
                houses.add(createVilla(scanner));
            } else {
                System.out.println("Invalid choice. Please enter 1, 2, or 3.");
            }

            System.out.print("\nDo you want to input data for another house? (yes/no): ");
        } while (scanner.next().equalsIgnoreCase("yes"));

        System.out.println("\n+-------------------------------------------------------------+");
        System.out.println("|                 Building creation successful!               |");
        System.out.println("+-------------------------------------------------------------+\n");

        System.out.println("+-------------------------------------------------------------------------------------------------------------------------------------------+");
        System.out.println("|                                                           House Details and Cost                                                          |");
        System.out.println("+----+-------------+-------------+-------------+-------------------------------+-------------+------------------+-------------+-------------+");
        System.out.println("| #  | Type        | Area        | # of Rooms  | Address     	               | City        | Cost             | Garden/Pools| Floors      |");
        System.out.println("+----+-------------+-------------+-------------+-------------------------------+-------------+------------------+-------------+-------------+");

        for (int i = 0; i < houses.size(); i++) {
            House house = houses.get(i);
            if (house instanceof Apartment) {
                Apartment apartment = (Apartment) house;
                System.out.printf("| %-2d | %-11s | %-11.2f | %-11d | %-29s | %-11s | %-16.2f | %-11s | %-11s |\n",
                        (i + 1), "Apartment", apartment.getArea(), apartment.getNumOfRooms(),
                        apartment.getAddress(), apartment.getCity(), apartment.getCost(),
                        "-", apartment.getFloor());
            } else if (house instanceof Villa) {
                Villa villa = (Villa) house;
                System.out.printf("| %-2d | %-11s | %-11.2f | %-11d | %-29s | %-11s | %-16.2f | %-11s | %-11s |\n",
                        (i + 1), "Villa", villa.getArea(), villa.getNumOfRooms(),
                        villa.getAddress(), villa.getCity(), villa.getCost(),
                        (villa.hasPool() ? "Yes" : "No"), villa.getNumFloors());
            }
        }

        System.out.println("+----+-------------+-------------+-------------+------------------------------+-------------+------------------+-------------+-------------+");

        // Esegui HouseFinder subito dopo BuildingInformationSystem
        HouseFinder houseFinder = new HouseFinder(scanner);
        houseFinder.findHouse(houses);

        // Find and display the most cost-effective house
        House mostCostEffectiveHouse = findMostCostEffectiveHouse(houses);
        if (mostCostEffectiveHouse != null) {
            System.out.println("\nMost Cost-Effective House:");
            houseFinder.displayHouseDetails(mostCostEffectiveHouse);
        }

        scanner.close();
    }

    private static Apartment createApartment(Scanner scanner) {
        System.out.println("\nInput for creating an Apartment:");
        System.out.println("Please provide the following details for the Apartment:");

        double apartmentArea;
        int apartmentNumOfRooms;
        String apartmentAddress;
        String apartmentCity;
        int apartmentEnergyCode;
        int apartmentFloor;
        double apartmentCost;

        try {
            System.out.print("Area (in square meters): ");
            apartmentArea = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("Number of Rooms: ");
            apartmentNumOfRooms = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Address: ");
            apartmentAddress = capitalizeFirstLetterEachWord(scanner.nextLine());

            System.out.print("City: ");
            apartmentCity = capitalizeFirstLetterEachWord(scanner.nextLine());

            if (!cityExists(apartmentCity)) {
                System.out.println("Invalid city. Please enter a valid city.");
                return createApartment(scanner);
            }

            System.out.print("Energy Code (between " + MIN_ENERGY_CODE + " and " + MAX_ENERGY_CODE + "): ");
            apartmentEnergyCode = scanner.nextInt();
            scanner.nextLine();
            if (apartmentEnergyCode < MIN_ENERGY_CODE || apartmentEnergyCode > MAX_ENERGY_CODE) {
                System.out.println("Invalid Energy Code. Please enter a value between " + MIN_ENERGY_CODE + " and " + MAX_ENERGY_CODE + ".");
                return createApartment(scanner);
            }

            // Verifica del numero di piani
            System.out.print("Floor (between 1 and " + MAX_FLOORS_APARTMENT + "): ");
            apartmentFloor = scanner.nextInt();
            scanner.nextLine();
            if (apartmentFloor < 1 || apartmentFloor > MAX_FLOORS_APARTMENT) {
                System.out.println("Invalid number of floors. Please enter a value between 1 and " + MAX_FLOORS_APARTMENT + ".");
                return createApartment(scanner);
            }

            System.out.print("Insert the cost of the apartment: ");
            apartmentCost = scanner.nextDouble();
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter valid numeric values.");
            scanner.nextLine();
            return createApartment(scanner);
        }

        return new Apartment(apartmentArea, apartmentNumOfRooms, apartmentAddress, apartmentCity, apartmentCost, apartmentEnergyCode, apartmentFloor);
    }

    private static Villa createVilla(Scanner scanner) {
        System.out.println("\nInput for creating a Villa:");
        System.out.println("Please provide the following details for the Villa:");

        double villaArea;
        int villaNumOfRooms;
        String villaAddress;
        String villaCity;
        int villaEnergyCode;
        boolean hasPool;
        int villaNumFloors;

        try {
            System.out.print("Area (in square meters): ");
            villaArea = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("Number of Rooms: ");
            villaNumOfRooms = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Address: ");
            villaAddress = capitalizeFirstLetterEachWord(scanner.nextLine());

            System.out.print("City: ");
            villaCity = capitalizeFirstLetterEachWord(scanner.nextLine());

            if (!cityExists(villaCity)) {
                System.out.println("Invalid city. Please enter a valid city.");
                return createVilla(scanner);
            }

            System.out.print("Energy Code (between " + MIN_ENERGY_CODE + " and " + MAX_ENERGY_CODE + "): ");
            villaEnergyCode = scanner.nextInt();
            scanner.nextLine();
            if (villaEnergyCode < MIN_ENERGY_CODE || villaEnergyCode > MAX_ENERGY_CODE) {
                System.out.println("Invalid Energy Code. Please enter a value between " + MIN_ENERGY_CODE + " and " + MAX_ENERGY_CODE + ".");
                return createVilla(scanner);
            }

            System.out.print("Has Pool? (yes/no): ");
            hasPool = scanner.nextLine().equalsIgnoreCase("yes");

            // Verifica del numero di piani
            System.out.print("Number of Floors (between 1 and " + MAX_FLOORS_VILLA + "): ");
            villaNumFloors = scanner.nextInt();
            scanner.nextLine();
            if (villaNumFloors < MIN_FLOORS || villaNumFloors > MAX_FLOORS_VILLA) {
                System.out.println("Invalid number of floors. Please enter a value between " + MIN_FLOORS + " and " + MAX_FLOORS_VILLA + ".");
                return createVilla(scanner);
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter valid numeric values.");
            scanner.nextLine();
            return createVilla(scanner);
        }

        return new Villa(villaArea, villaNumOfRooms, villaAddress, villaCity, villaEnergyCode, hasPool, villaNumFloors);
    }

    private static boolean cityExists(String city) {
        for (String famousCity : FAMOUS_CITIES) {
            if (famousCity.equalsIgnoreCase(city)) {
                return true;
            }
        }
        return false;
    }

    private static House findMostCostEffectiveHouse(List<House> houses) {
        if (houses.isEmpty()) {
            return null;
        }

        House mostCostEffectiveHouse = houses.get(0);
        double minCostPerSquareMeter = mostCostEffectiveHouse.getCost() / mostCostEffectiveHouse.getArea();

        for (int i = 1; i < houses.size(); i++) {
            House currentHouse = houses.get(i);
            double costPerSquareMeter = currentHouse.getCost() / currentHouse.getArea();

            if (costPerSquareMeter < minCostPerSquareMeter) {
                minCostPerSquareMeter = costPerSquareMeter;
                mostCostEffectiveHouse = currentHouse;
            }
        }

        return mostCostEffectiveHouse;
    }

    private static String capitalizeFirstLetterEachWord(String input) {
        StringBuilder result = new StringBuilder();
        String[] words = input.split("\\s");

        for (String word : words) {
            if (word.length() > 0) {
                result.append(Character.toUpperCase(word.charAt(0))).append(word.substring(1)).append(" ");
            }
        }

        return result.toString().trim();
    }
}
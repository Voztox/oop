//Mert Faruk Gunes - Computer Science 2nd year FT BcHons - 3105875
package griffith;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Map {
	    public static void main(String[] args) {
	        List<Building> buildings = new ArrayList<>();

	        // Example of residental-commercial and ordinary buildings.
	        buildings.add(new Building(new Address("D08PR66", "Meath St", "Dublin", 53.34091346459397, -6.278629207759358)));
	        buildings.add(new Building(new Address("D07R623", "Saint Gerard's St", "Dublin", 53.361531899964426, -6.28934344193108)));
	        buildings.add(new ResidentialBuilding(1, new Address("D08V04N", "S Circular Rd", "Dublin", 53.3309891, -6.2806927)));
	        buildings.add(new ResidentialBuilding(2, new Address("D08VW66", "Kevin St", "Dublin", 53.33748969560521, -6.266861621884818)));
	        buildings.add(new ResidentialBuilding(3, new Address("D04 EA36", "Raglan Rd.", "Dublin", 53.33018082908386, -6.2377646964267885)));
	        buildings.add(new CommercialBuilding("Lidl", "Shoopping Place","08:00-22:00", "https://www.lidl.ie" , new Address("D08K4AT", "CORK St", "Dublin", 53.33667145966107, -6.28714211778967)));
	        buildings.add(new CommercialBuilding("Kilkenny Castle", "Historical Place","09:00-17:30", "-" , new Address("R95YRK1", "The Parade", "Kilkenny", 52.65046651914221, -7.249300439372591)));
	        
	        Scanner input = new Scanner(System.in);

	        while (true) {
	            // Display the menu
	            System.out.println("1. to Find a Building by its EirCode. (With no Spaces.)");
	            System.out.println("2. to Get a Building's EirCode by coordinates.");
	            System.out.println("3. to Get the distance between two buildings.");
	            System.out.println("4. Quit the system.");
	            System.out.print("Enter your choice please:");
	            int choice = input.nextInt();
	            input.nextLine();  
	            // to Consume the newline character
	            
	            //swtich case scenerios for menu.
	            switch (choice) {
	                case 1:
	                    System.out.print("Enter EirCode: ");
	                    String eircodeToFind = input.nextLine();
	                    findBuildingByEircode(buildings, eircodeToFind);
	                    break;
	                case 2:
	                    System.out.print("Enter latitude: ");
	                    double latitude = input.nextDouble();
	                    System.out.print("Enter longitude: ");
	                    double longitude = input.nextDouble();
	                    getEircodeByCoordinates(buildings, latitude, longitude);
	                    break;
	                case 3:
	                    System.out.print("Enter the number of the first building: ");
	                    String firstEir = input.nextLine();
	                    System.out.print("Enter the number of the second building: ");
	                    String secondEir = input.nextLine();
	                    getDistanceBetweenBuildings(buildings, firstEir, secondEir);
	                    break;
	                case 4:
	                    System.out.println("Thank you for using my program.!");
	                    input.close();
	                    //closing the input. 
	                    System.exit(0);
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	                    break;
	            }
	        }
	    }
	    public static void findBuildingByEircode(List<Building> buildings, String eircode) {
	    	//finding the building by the eircode. instanceof used for printing more informations on commercial building.
	        for (Building building : buildings) {
	            if (building.getaddress().getEircode().equalsIgnoreCase(eircode)) {
	                System.out.println("Location: " + building.getInfo());
	                if (building instanceof ResidentialBuilding) {
	                    ResidentialBuilding residentalBuilding = (ResidentialBuilding) building;
	                    System.out.println("Build Number: " + residentalBuilding.getbuildNo());
	                }
	                else if (building instanceof CommercialBuilding) {
	                	CommercialBuilding commercialBuilding = (CommercialBuilding) building;
	                	System.out.println("Build Name: " + commercialBuilding.getbuildName());
	                	System.out.println("Description: " + commercialBuilding.getdesc());
	                	System.out.println("Opening Hours: " + commercialBuilding.getopHrs());
	                	System.out.println("Web Site of the Building: " + commercialBuilding.getwebUrl());
	                }
	                return;
	            }
	        }
	        System.out.println("Building with Eircode " + eircode + " not found.");
	    }
	    public static void getEircodeByCoordinates(List<Building> buildings, double latitude, double longitude) {
	        for (Building building : buildings) {
	            if (building.getaddress().getLatitude() == latitude && building.getaddress().getLongitude() == longitude) {
	                System.out.println("Eircode: " + building.getaddress().getEircode());
	                return;
	            }
	        }
	        System.out.println("No building found at coordinates (Latitude: " + latitude + ", Longitude: " + longitude + ").");
	    }
	    public static void getDistanceBetweenBuildings(List<Building> buildings, String firstBuildingName, String secondBuildingName) {
	        Building firstBuilding = null;
	        Building secondBuilding = null;

	        // Find the buildings by name or number
	        for (Building building : buildings) {
	            if (building.getInfo().equalsIgnoreCase(firstBuildingName) ||
	                (building instanceof ResidentialBuilding && ((ResidentialBuilding) building).getbuildNo() == Double.parseDouble(firstBuildingName))) {
	                firstBuilding = building;
	            } else if (building.getInfo().equalsIgnoreCase(secondBuildingName) ||
	                (building instanceof ResidentialBuilding && ((ResidentialBuilding) building).getbuildNo() == Double.parseDouble(secondBuildingName))) {
	                secondBuilding = building;
	            }
	        }
	        //printing anad error message if both variables stays null.
	        if (firstBuilding != null && secondBuilding != null) {
	            double distance = distance(firstBuilding.getaddress(), secondBuilding.getaddress());
	            System.out.println("Distance between " + firstBuilding.getInfo() + " and " + secondBuilding.getInfo() + ": " + distance + " km");
	        } else {
	            System.out.println("One or both of the buildings not found.");
	        }
	    }
	    
    // Method to calculate the distance between two Locations
    public static double distance(Location first, Location second) {
        double latiOne = Math.toRadians(first.getLatitude());
        double latiTwo = Math.toRadians(second.getLatitude());
        double longOne = Math.toRadians(first.getLongitude());
        double longTwo = Math.toRadians(second.getLongitude());

        //found the formula on the internet.
        // Haversine formula for calculating distance between two points on the Earth's surface.
        double dlon = longTwo - longOne;
        double dlat = latiTwo - latiOne;
        double a = Math.pow(Math.sin(dlat / 2), 2) + Math.cos(latiOne) * Math.cos(latiTwo) * Math.pow(Math.sin(dlon / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double radius = 6371; // Earth's radius in kilometres
        return radius * c;
    }
}
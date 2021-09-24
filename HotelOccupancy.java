import java.util.*;
public class HotelOccupancy {
    
    static Scanner keyb = new Scanner(System.in);
    
    public static void main(String[] args) {
        System.out.println("Welcome to the Hotel Occupancy Program\n");
        
        int numFloors = getNumberOfFloors();
        
        double totalRooms = 0.0;
        double totalOccupied = 0.0;
        for (int floorNum = 1; floorNum <= numFloors; floorNum++) {
            int rooms = getNumberOfRooms(floorNum);
            totalRooms += rooms;
            
            totalOccupied += getNumberOfOccupiedRooms(floorNum,rooms);
            System.out.println();
        }

        displayResults(totalRooms,totalOccupied,numFloors);
          
        System.out.println("Thanks for using the Hotel Occupancy Program");
    }
    
    static int getNumberOfFloors() {
        System.out.print("How many floors are there? ");
        int numFloors = keyb.nextInt();
        while (numFloors < 1) {
            System.out.println("Please enter a value of 1 or greater");
            System.out.print("How many floors are there? ");
            numFloors = keyb.nextInt();
        }
        System.out.println();
        return numFloors;
    }
    
    static int getNumberOfRooms(int floorNum) {
        System.out.printf("How many rooms on floor %d? ", floorNum);
        int rooms = keyb.nextInt();
        while (rooms < 1) {
            System.out.println("Please enter a value of 1 or greater");
            System.out.printf("How many rooms on floor %d? ", floorNum);
            rooms = keyb.nextInt();
        }
        System.out.printf("Floor %d has %d rooms.\n", floorNum, rooms);
        return rooms;
    }
    
    static int getNumberOfOccupiedRooms(int floorNum, int rooms) {
        System.out.printf("How many occupied rooms on floor %d? ", floorNum);
        int roomsOccupied = keyb.nextInt();
        while (roomsOccupied < 0 || roomsOccupied > rooms) {
            System.out.printf("Please enter a value between 0 and %d\n", rooms);
            System.out.printf("How many occupied rooms on floor %d? ", floorNum);
            roomsOccupied = keyb.nextInt();
        }
        return roomsOccupied;
    }
    
    static void displayResults(double totalRooms, double totalOccupied, int numFloors) {
        double totalVacant = totalRooms - totalOccupied;
        double percentOccupied = (totalOccupied / totalRooms) * 100.0;
        System.out.printf("The hotel has %.0f rooms on %d floors\n",
                          totalRooms, numFloors);
        System.out.printf("%.0f rooms are vacant\n", totalVacant);
        System.out.printf("%.0f rooms are occupied (%.1f%%)\n",
                         totalOccupied, percentOccupied);
    }
    
}
import java.util.Scanner;

public class CabBookingApp {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        int choice;
        boolean bookingConfirmed = false;
        
        do {
            System.out.println("1. Book a cab");
            System.out.println("2. Confirm booking");
            System.out.println("3. Cancel booking");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            
            switch(choice) {
                case 1:
                    System.out.print("Enter pick-up location: ");
                    String pickupLocation = sc.next();
                    System.out.print("Enter drop location: ");
                    String dropLocation = sc.next();
                    System.out.print("Enter cab type (1. Micro, 2. Mini, 3. Sedan): ");
                    int cabType = sc.nextInt();
                    System.out.print("Enter number of passengers: ");
                    int numOfPassengers = sc.nextInt();
                    
                    // Code to book the cab and calculate fare
                    // Display the fare to the user
                    
                    bookingConfirmed = false;
                    break;
                case 2:
                    if(bookingConfirmed) {
                        System.out.println("Booking confirmed.");
                    } else {
                        System.out.println("Please book a cab first.");
                    }
                    break;
                case 3:
                    bookingConfirmed = false;
                    System.out.println("Booking cancelled.");
                    break;
                case 4:
                    System.out.println("Exiting the application.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
            
        } while(choice != 4);
        
        sc.close();
        
    }

}

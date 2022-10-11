package hotelroombooking;
import java.util.Scanner;

import food_order_management.CustomerFood;
public class Rooms{

	public void roomBooking(CustomerDetails customer) {
		//this.customer=customer;
		Scanner scanner =new Scanner(System.in);
		boolean option=true;
		
		while(option) {
			System.out.println("--------------------------------------------------------------------------------------------------------------");
			System.out.print("Enter 1 for Rooms Details\nEnter 2 for Rooms Bookings \nEnter 3 for Checking Payment Details\nEnter 4 for Exit");
			int roomChoice=scanner.nextInt();
			System.out.println("--------------------------------------------------------------------------------------------------------------");
			RoomsDetails roomsdet=new RoomsDetails();
			roomsdet.mainMenu();
			switch(roomChoice) {
			 case 1:{
				 roomsdet.menuDetails(roomsdet);
			}
			 break;
			 case 2:{
					System.out.println("--------------------------------------------------------------------------------------------------------------");

				 System.out.println("Thank You For Choosing Our Hotel...Let's Start to Book Your Rooms");
				 System.out.println("Enter any Rooms Numbers Between 1 to 20");
				 int roomChoosing=scanner.nextInt();
				 boolean roomChoices=true;
					 while(roomChoices) {
						 if(roomChoosing>0 && roomChoosing<=20) {
							 if(customer.check_Rooms_Availablity(roomChoosing)) {
								 customer.bookingRooms.add(roomChoosing);
								 System.out.println("Your Choice of Room is Available and Booked Successfully");
								 roomChoices=false;
							 }
							 roomChoices=false;
					 }
				 }
				System.out.println("--------------------------------------------------------------------------------------------------------------");
                System.out.println("--------------------------------------------------------------------------------------------------------------");
				boolean options=true;
				while(options) {
					System.out.println("--------------------------------------------------------------------------------------------------------------");

					System.out.println("Choose any Catagory of Rooms");
					System.out.println("1.AC Rooms \n2.Non-AC Rooms\n3.AC_Rooms_With_Foodfacility\n4.non_AC_Rooms_With_Foodfacility\n5.Main Menu");
					int roomsChoicing=scanner.nextInt();
					roomsdet.roomsAvailables(roomsChoicing);
					scanner.nextLine();
					System.out.println("Choose any Catagory:");
					int catagory=scanner.nextInt();
					System.out.println("How many days you want to stay in our hotel ");
					int days=scanner.nextInt();
					System.out.println("Do you Wnat any Extra Bed from Out hotel");
					System.out.println("Per Bed Cose is Rs.200");
					System.out.println("1.Yes\n2.No");
					int extraBed=scanner.nextInt();
					int beds = 0;
					if(extraBed==1) {
						System.out.println("How Many Beds You Want");
						beds=scanner.nextInt();
					}
					customer.arrange(roomsChoicing,catagory,days,beds,customer);
					System.out.println("\nDo you want to book extra rooms?(1.yes or 2.no)");
					int extraBook = scanner.nextInt();
					if (extraBook == 2)
						options=false;
				}	
				System.out.println("\nPayment details....");
				customer.billCalculation(customer.billAmount,customer);
				System.out.println("\nPayment is successfull");
				System.out.println("Show this Message in Reception You Can CheckIn Now");
				System.out.println("--------------------------------------------------------------------------------------------------------------");

				 break;
			}
			 case 3:{
				 System.out.println("Bill Details...");
				 customer.billing(customer);
			 }
			 break;
			 case 4:{
				 option=false;
			 }
			 break;
			 default:
				 System.out.println("Invalid Option");
			}
		}
	}
}
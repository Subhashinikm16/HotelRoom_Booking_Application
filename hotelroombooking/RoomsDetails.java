package hotelroombooking;

import java.util.*;

public class RoomsDetails {
	Scanner scanner=new Scanner(System.in);
	public static Map<Integer, LinkedHashMap<String, Integer>> roomsAvailablity = new LinkedHashMap<>();
	public static LinkedHashMap<String, Integer> AC_Rooms = new LinkedHashMap<>();
	public static LinkedHashMap<String, Integer> non_AC_Rooms = new LinkedHashMap<>();
	public static LinkedHashMap<String, Integer> AC_Rooms_With_Foodfacility = new LinkedHashMap<>();
	public static LinkedHashMap<String, Integer> non_AC_Rooms_With_Foodfacility = new LinkedHashMap<>();
	
	
	public void mainMenu() {
		roomsAvailablity.put(1, AC_Rooms);
		roomsAvailablity.put(2, non_AC_Rooms);
		roomsAvailablity.put(3, AC_Rooms_With_Foodfacility);
		roomsAvailablity.put(4, non_AC_Rooms_With_Foodfacility);
	   
	   AC_Rooms.put("Single Bed Room",700);
	   AC_Rooms.put("Double Bed Room",1200);
	   AC_Rooms.put("Triple Bed Room",1700);
	   
	   non_AC_Rooms.put("Single Bed Room",500);
	   non_AC_Rooms.put("Double Bed Room",1000);
	   non_AC_Rooms.put("Triple Bed Room",1400);
	   
	   AC_Rooms_With_Foodfacility.put("Single Bed Room",1000);
	   AC_Rooms_With_Foodfacility.put("Double Bed Room",1600);
	   AC_Rooms_With_Foodfacility.put("Triple Bed Room",2100);
	  
	   non_AC_Rooms_With_Foodfacility.put("Single Bed Room",800);
	   non_AC_Rooms_With_Foodfacility.put("Double Bed Room",1300);
	   non_AC_Rooms_With_Foodfacility.put("Triple Bed Room",1700);
	}
	public void menuDetails(RoomsDetails roomsdet) {
	//	Rooms rooms=new Rooms();
		//CustomerDetails customer=new CustomerDetails();
		boolean option=true;
		while(option) {
			System.out.println("--------------------------------------------------------------------------------------------------------------");
			System.out.println("We have totally 4 catagory of rooms");
			System.out.println("1.AC Rooms \n2.Non-AC Rooms \n3.AC_Rooms_With_Foodfacility\n4.non_AC_Rooms_With_Foodfacility\n5.Back Menu");
			int selectionRooms=scanner.nextInt();
			System.out.println("--------------------------------------------------------------------------------------------------------------");
			if(selectionRooms==5) {
				option=false;
			}
			roomsAvailables(selectionRooms);
		}
	}
	public void roomsAvailables(int selectionRooms) {
		int sequence=1;
		System.out.println();
		switch(selectionRooms) {
		case 1:{
			System.out.println("--------------------------------------------------------------------------------------------------------------");
			System.out.println("AC Rooms");
			System.out.printf("%-7s %-25s %-5s","s.no","Rooms Available","Amount per day");
			System.out.println();
			for (Map.Entry<String, Integer> rooms : AC_Rooms.entrySet()) {
				System.out.printf("%-7s %-25s %-5s",sequence++,rooms.getKey(),rooms.getValue());
				System.out.println();
		}
			System.out.println("--------------------------------------------------------------------------------------------------------------");

			}
		break;
		case 2:{
			System.out.println("--------------------------------------------------------------------------------------------------------------");
			System.out.println("Non_AC Rooms");
			System.out.printf("%-7s %-25s %-5s","s.no","Rooms Available","Amount per day");
			System.out.println();
			for (Map.Entry<String, Integer> rooms : non_AC_Rooms.entrySet()) {
				System.out.printf("%-7s %-25s %-5s",sequence++,rooms.getKey(),rooms.getValue());
				System.out.println();
		}
			System.out.println("--------------------------------------------------------------------------------------------------------------");

		}
		break;
		case 3:{
			System.out.println("--------------------------------------------------------------------------------------------------------------");
			System.out.println("AC_Rooms_With_Foodfacility");
			System.out.printf("%-7s %-25s %-5s","s.no","Rooms Available","Amount per day");
			System.out.println();
			for (Map.Entry<String, Integer> rooms : AC_Rooms_With_Foodfacility.entrySet()) {
				System.out.printf("%-7s %-25s %-5s",sequence++,rooms.getKey(),rooms.getValue());
				System.out.println();
		}
			System.out.println("--------------------------------------------------------------------------------------------------------------");

		}
		break;
		case 4:{
			System.out.println("--------------------------------------------------------------------------------------------------------------");
            System.out.println("non_AC_Rooms_With_Foodfacility");
			System.out.printf("%-7s %-25s %-5s","s.no","Rooms Available","Amount per day");
			System.out.println();
			for (Map.Entry<String, Integer> rooms : non_AC_Rooms_With_Foodfacility.entrySet()) {
				System.out.printf("%-7s %-25s %-5s",sequence++,rooms.getKey(),rooms.getValue());
				System.out.println();
		}
			System.out.println("--------------------------------------------------------------------------------------------------------------");
			}
		break;
		case 5:
			return;		
		default:
			System.out.println("Please Enter Correct Options");
		}
}
}


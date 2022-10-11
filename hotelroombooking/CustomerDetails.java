package hotelroombooking;
import java.util.*;

import food_order_management.CustomerFood;
import model.Customer;
public class CustomerDetails {
	private String customerName;
    private String mobileNumber;
    private String password;
    private String emailId;
    Map<String, Integer> roomBook = new LinkedHashMap<>();
    ArrayList<Integer> bookingRooms=new ArrayList<>();
    Map<String,Integer> roomFees=new LinkedHashMap<>();
    int billAmount=0;
    static int bill_id=1001;
    int roomNumber;
 
    public String getCustomerName() {
		return customerName;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	CustomerDetails (String name) {
		   customerName=name;
	}
    public CustomerDetails(String name, String mobileNum,String emailId,String password) {
		this.customerName=name;
		this.mobileNumber=mobileNum;
		this.password=password;
		this.emailId=emailId;
	}
	public boolean check_Rooms_Availablity(int roomNumber) {
    	if(bookingRooms.contains(roomNumber)) {
    		System.out.println("This Room is Already Booked. Please Choose Other Rooms");
    		return false;
    	}
    	return true;
    }
    public void arrange(int roomsChoicing,int catagory,int days,int beds,CustomerDetails customer ) {
        LinkedHashMap<String,Integer> availablity=RoomsDetails.roomsAvailablity.get(roomsChoicing);
    	int series=0;
    	int price=0;
    	int extraBedPrice=200;
    	String roomType="";
    	for(Map.Entry<String, Integer> roomsSelection: availablity.entrySet()) {
    		if(++series==catagory) {
    			price=roomsSelection.getValue().intValue();
    			roomType=roomsSelection.getKey();
    		}
    	}
    	billAmount+=price *days;
    	billAmount+=extraBedPrice*beds;
		roomBook.put(roomType,days);
		roomFees.put(roomType,price);    
    }
    public void billCalculation(int bill_amount,CustomerDetails customer) {
    	double gst_percentage = 0.00;
    	bill_amount = (int) (billAmount + (billAmount * gst_percentage));
    	customer.billing(customer);
    	bill_id=bill_id++;
    }
    
    public void billing(CustomerDetails customer)
	{
		if(customer.bookingRooms!=null)
		{
			System.out.println("Customer Name:"+customer.getCustomerName());
			System.out.println("Customer contact number:"+customer.getMobileNumber());
			System.out.println("\n------------------------------Room Details---------------------------------------------");
			System.out.printf("%-35s %-25s %-5s","Rooms","Days","Price per day");
			System.out.println("\n-----------------------------------------------------------------------------------------------");
			for(Map.Entry<String,Integer> roomOrder:customer.roomBook.entrySet())
			{
				System.out.printf("%-35s %-25s %-5s",roomOrder.getKey(),roomOrder.getValue(),customer.roomFees.get(roomOrder.getKey()));
				System.out.println();
			}
			System.out.println("\n-----------------------------------------------------------------------------------------------");
			System.out.println();
			System.out.println("\n-----------------------------------------------------------------------------------------------");
			System.out.printf("%60s %5s","Total bill amount =" ,billAmount);
			System.out.println();
		}
		else
		{
			System.out.println("You are not booked any rooms");
		}
    
	}
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("--------------------------------------------------------------------------------------------------------");
		System.out.println("Customer Name: "+this.customerName);
		System.out.println("Mobile Number: "+this.mobileNumber);
		System.out.println("emailId: "+this.emailId);
		System.out.println("--------------------------------------------------------------------------------------------------------");
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
}


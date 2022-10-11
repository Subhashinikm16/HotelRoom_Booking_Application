package hotelroombooking;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import bankapplication.Customer;
import food_order_management.CustomerFood;

public class Entrance {
	Scanner scanner=new Scanner(System.in);
    ArrayList<CustomerDetails> customerArray=new ArrayList<>();
	Rooms rooms=new Rooms();
	public static void main(String[] args) {
        Entrance entrance=new Entrance();
        entrance.beginning();
	}
	private void beginning() {
//		Entrance object=new Entrance();
		boolean choice=true;
		while(choice) {
			System.out.println("1.Login");
			System.out.println("2.Signin");
			System.out.println("3.About Us");
			System.out.println("4.Exit");
			int details=scanner.nextInt();
			switch(details) {
			case 1:{
				System.out.println("--------------------------------------------------------------------------------------------------------------");
				login();
				System.out.println("--------------------------------------------------------------------------------------------------------------");
			}
			break;
			case 2:{
				signUp();
			}
			break;
			case 3:{
				System.out.println("--------------------------------------------------------------------------------------------------------------");
				System.out.println("****Welcome to Raj Hotels");
				System.out.println("Here we have 4 types of Rooms..(Ac,Non_AC,Ac with Food Facility,Non_Ac with Food Facility)");
				//System.out.println();
				System.out.println("****Raj Hotels located onBeautiful Beaches of Pandicherry..We offers a superlative experience to its\n"
						+ "guest with dedicated services,attention to deatil,and an uncompromising commitments to qualtity");
				System.out.println("****We are providing 25% Discount on Group Bookings");
				System.out.println("****Cantact Us: ");
				System.out.println("****31,Pandicherry Main Road,");
				System.out.println("****pondycherry-633 001");
				System.out.println("--------------------------------------------------------------------------------------------------------------");
			}
			break;
			case 4:{
				choice=false;
			}
	}
			}
            choice=false;
}
	public void login() {
		CustomerDetails customer;
		Scanner ob=new Scanner(System.in);
		   System.out.println();
		   String emailId="";
		   System.out.println("Enter Your EmailId:");
		   emailId=ob.next();
		   System.out.println("Password:");
		   String pwd=ob.next();
		   int flag=1;
		   for(CustomerDetails customers:customerArray) {
			   if(emailId.equals(customers.getEmailId())) {
				   if(pwd.equals(customers.getPassword())) {
					   flag=0;
					   System.out.println("Login Successfully...");
					   System.out.println("Welcome Back "+customers.getCustomerName());
					   rooms.roomBooking(customers);
				   }
			   }
		   }
		   if(flag==1) {
			   System.out.println("Invalid EmailId or Password..");
		   }
		   System.out.println();
	}
	public void signUp() {
		System.out.println("Enter Your Full Name:");
		   String name=scanner.next();
		   scanner.nextLine();
		   String mobileNumber = "";
		   String phoneNumber;
		   boolean isValidph=false;
		   while(!isValidph)
		   {
			   System.out.println("Enter your Mobile Number:");
			   mobileNumber=scanner.next();
			//   scanner.next();
			   if(isValidMobile(mobileNumber)) {
				   isValidph=true;
				   phoneNumber=mobileNumber;
			   }
			   else {
				  System.out.println("Plase Enter Valid Mobile Number");
			   }
		   }
		   String emailId="";
		   boolean isValidemail=false;
		   while(!isValidemail)
		   {
			   System.out.println("Enter Your EmailId:");
			   emailId=scanner.next();
			   if(isValidEmailId(emailId)) {
				   isValidemail=true;
			   }
			   else {
				   System.out.println("Plase Enter Valid Email Id");
			   }
		   }
		   System.out.println("Enter Password: ");
		   String pwd=scanner.next();
		   CustomerDetails customer=new CustomerDetails(name,mobileNumber,emailId,pwd);
			this.customerArray.add(customer);
	    	customer.display();
	}
	public boolean isValidEmailId(String email_id)
	   {
		   Pattern emailPattern=Pattern.compile("([a-z]{1,10})([@][a-z]{1,5}[.][a-z | (com)]{3})");
		   Matcher emailMatcher=emailPattern.matcher(email_id);
		   if(emailMatcher.find()) {
			   return true;
		   }
		   return false;
	   }
	   public boolean isValidMobile(String mobile)
	   {
		   Pattern mobilePattern=Pattern.compile("(0 ||91)?[6-9][0-9]{9}");
		   Matcher mobileMatcher=mobilePattern.matcher(mobile);
		   if(mobileMatcher.find())
			   return true;
		   return false;
	   }
}
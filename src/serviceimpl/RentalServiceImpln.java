package serviceimpl;

import java.util.LinkedHashMap;
import java.util.Scanner;

import entity.Address;
import entity.Customer;
import service.RentalService;

public class RentalServiceImpln implements RentalService {
	
	Scanner ip = new Scanner(System.in);
	
	{
		for(int i=101;i<=108;i++)
			nac.put(i, null);
		
		for(int i=201;i<=205;i++)
			ac.put(i, null);
		
		for(int i=301;i<=303;i++)
			deluxe.put(i, null);
	}

	@Override
	public void info() {
	System.out.println("========Non Ac========");
	System.out.println("Fan");
	System.out.println("Wifi");
	System.out.println("Tv");
	System.out.println("2 members");
	System.out.println("Price:2000");
	System.out.println("========Ac========");
	System.out.println("Ac");
	System.out.println("Wifi");
	System.out.println("Tv");
	System.out.println("2 members");
	System.out.println("Price:2500");
	System.out.println("========Deluxe========");
	System.out.println("Fan");
	System.out.println("Wifi");
	System.out.println("Tv");
	System.out.println("fridge");
	System.out.println("3 to 4 members");
	System.out.println("Price:3000");
		
	}
	// we are checking the availability of rooms
	void checkRooms(LinkedHashMap<Integer, Customer> m,String type) {
		System.out.println("======"+type+"Rooms:=======");
		int c=0;
		for(Integer roomno:m.keySet()) {
			if(m.get(roomno)==null) {
				System.out.print(roomno+" ");
				c++;
			}
		}
		System.out.println();
		if(c==0) {
			System.out.println("No Rooms Available...!!!");
		}
	}

	@Override
	public void roomsAvialable() {
		checkRooms(nac, "Non AC");
		checkRooms(ac, "AC");
		checkRooms(deluxe, "Deluxe");
		
		
	}
	
	void allocate(LinkedHashMap<Integer, Customer> m,String roomType,double roomPrice) {
		System.out.println("Enter the roomnno:-");
		int roomno=ip.nextInt();
		if(m.containsKey(roomno)&&m.get(roomno)==null) {
			System.out.println("Enter Customer Id:-");
			int cid=ip.nextInt();
			System.out.println("Enter Customer Name:-");
			String cname=ip.next();
			System.out.println("Enter Customer Phno:-");
			long phno=ip.nextLong();
			System.out.println("Enter Customer House No:-");
			String houseNo=ip.next();
			System.out.println("Enter Street Name:-");
			String streetName=ip.next();
			System.out.println("Enter Pincode:-");
			int pinCode=ip.nextInt();
			
			Customer c=new Customer(cid, cname, phno, new Address(houseNo, streetName, pinCode), roomType, roomPrice, roomno);
			m.put(roomno, c);
			l1.add(c);
			System.out.println(c.getcName()+"had been allocate for"+roomType+" roomno :"+ roomno);
			System.out.println(c.getcName()+"need to pay Rs."+roomPrice);
		}
		else {
			System.out.println("Invalid Roomno:--------");
		}
	}

	@Override
	public void checkIn() 
	{
		System.out.println("========Check-IN========");
		System.out.println("1.Non Ac\n2.Ac\n3.Deluxe");
		System.out.println("Enter the Option:-");
		int op=ip.nextInt();
		switch(op) {
		case 1:allocate(nac,"Non Ac",2000);break;
		case 2:allocate(ac,"Non Ac",2500);break;
		case 3:allocate(deluxe,"Deluxe",3000);break;
		default: System.out.println("Invalid Options:-");
		
		}
		
	}
	
	void deAllocate(LinkedHashMap<Integer, Customer>  m) {
		System.out.println("Enter the roomnno:-");
		int roomno=ip.nextInt();
		if(m.containsKey(roomno)&&m.get(roomno)!=null) {
			Customer c=m.get(roomno);
			System.out.println(c.getcName()+"Thanks For Visting Our Hotel...!!!");
			m.put(roomno,null);		
			}
		else {
			System.out.println("Invalid RoomNo..!!!!");
		}
	}

	@Override
	public void checkOut() {
		System.out.println("========Check-Out========");
		System.out.println("1.Non Ac\n2.Ac\n3.Deluxe");
		System.out.println("Enter the Option:-");
		int op=ip.nextInt();
		switch(op) {
		case 1:deAllocate(nac);break;
		case 2:deAllocate(ac);break;
		case 3:deAllocate(deluxe);break;
		default: System.out.println("Invalid Options:-");
		
		}
		
	}

	@Override
	public void customerDetails() {
		int c=0;
		System.out.println("======Customer Details======");
		for(Customer ele:l1) {
			System.out.println(ele);
			c++;
		}
		if(c==0) {
			System.out.println("No Customer Data Found..!!!");
			
			
		}
		
		
	}

}

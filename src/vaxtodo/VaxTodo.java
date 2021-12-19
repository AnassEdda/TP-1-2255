package vaxtodo;

import java.io.*;
import java.util.*;

public class VaxTodo {

	public static LinkedList<User> users;
	public static LinkedList<Visitor> visitors;
	public static PriorityQueue<Reservation> reservations;
	
	public static void main(String args[]) throws IOException {
		users = readUsers();
		visitors = readVisitors();
		reservations = readReservations();
		
		Menu menu = new Menu();
		menu.open();
		
		writeUsers();
		writeVisitors();
		writeReservations();
	}
	
	//read stored users from users.txt
	private static LinkedList<User> readUsers() throws IOException {
		LinkedList<User> users = new LinkedList<User>();
		
		BufferedReader in = new BufferedReader(new FileReader("vaxtodo/bin/users.txt"));
		
		String line;
		while((line = in.readLine()) != null)
		{
		    String[] infos = line.split(" ");
		    
		    long code = Long.parseLong(infos[0]);
		    String password = infos[1];
		    String lastName = infos[2];
		    String firstName = infos[3];
		    String birthdate = infos[4];
		    String email = infos[5];
		    Address address = new Address(infos[6]);
		    String postalCode = infos[7];
		    String city = infos[8];
		    long phoneNumber = Long.parseLong(infos[9]);
		    String isEmployee = infos[10];
		    long accountNumber = Long.parseLong(infos[11]);
		    
		    if(infos[12].equals("empty")) {
		    	users.add(new User(code, password, lastName, firstName, birthdate, email, address, postalCode, city, phoneNumber, isEmployee, accountNumber, null));
		    }else {
		    	String[] schedule = infos[12].split("/");
			    WorkingDay[] days = new WorkingDay[schedule.length];
			    for(int i = 0; i < schedule.length; ++i) {
			    	days[i] = new WorkingDay(schedule[i]);
			    }
			    users.add(new User(code, password, lastName, firstName, birthdate, email, address, postalCode, city, phoneNumber, isEmployee, accountNumber, days));
		    }
		}
		in.close();
		
		return users;
	}
	
	//write users to users.txt before the program terminates
	private static void writeUsers() throws IOException {
		BufferedWriter out = new BufferedWriter(new FileWriter("vaxtodo/bin/users.txt"));
		
		out.write("");
		
		for(User user : VaxTodo.users) {
			out.append(user.toString() + "\n");
		}
		
		out.close();
	}
	
	//read stored visitors from visitors.txt
	private static LinkedList<Visitor> readVisitors() throws IOException {
		LinkedList<Visitor> visitors = new LinkedList<Visitor>();
		
		BufferedReader in = new BufferedReader(new FileReader("vaxtodo/bin/visitors.txt"));
		
		String line;
		while((line = in.readLine()) != null)
		{
		    String[] infos = line.split(" ");
		    
		    long accountNumber = Long.parseLong(infos[0]);
		    String lastName = infos[1];
		    String firstName = infos[2];
		    String birthdate = infos[3];
		    String email = infos[4];
		    Address address = new Address(infos[5]);
		    String postalCode = infos[6];
		    String city = infos[7];
		    long phoneNumber = Long.parseLong(infos[8]);
		    
		    if(infos[9].equals("empty")) {
		    	visitors.add(new Visitor(accountNumber, lastName, firstName, birthdate, email, address, postalCode, city, phoneNumber, new Vaccine[Vaccine.VACCINE_MAX_NUMBER]));
		    }else {
		    	String[] tempVax = infos[9].split("/");
			    Vaccine[] vaccines = new Vaccine[tempVax.length];
			    for(int i = 0; i < tempVax.length; ++i) {
			    	vaccines[i] = new Vaccine(tempVax[i]);
			    }
			    visitors.add(new Visitor(accountNumber, lastName, firstName, birthdate, email, address, postalCode, city, phoneNumber, vaccines));
		    }
		}
		
		in.close();
		
		return visitors;
	}
	
	//write visitors to visitors.txt before the program terminates
	private static void writeVisitors() throws IOException {
		BufferedWriter out = new BufferedWriter(new FileWriter("vaxtodo/bin/visitors.txt"));
		
		out.write("");
		
		for(Visitor visitor : VaxTodo.visitors) {
			out.append(visitor.toString() + "\n");
		}
		
		out.close();
	}
	
	//read stored reservations from reservations.txt
	private static PriorityQueue<Reservation> readReservations() throws IOException {
		PriorityQueue<Reservation> reservations = new PriorityQueue<Reservation>();
		
		BufferedReader in = new BufferedReader(new FileReader("vaxtodo/bin/reservations.txt"));
		
		String line;
		while((line = in.readLine()) != null)
		{
			String[] infos = line.split(" ");
			int reservationNumber = Integer.parseInt(infos[0]);
			String lastName = infos[1];
			String firstName = infos[2];
			String visitDate = infos[3];
			String visitTime = infos[4];
			int doseNumber = Integer.parseInt(infos[5]);
			
			reservations.add(new Reservation(reservationNumber, lastName, firstName, visitDate, visitTime, doseNumber));
		}
		return reservations;
	}		
	
	//write reservations to reservations.txt before the program terminates
	private static void writeReservations() throws IOException {
		BufferedWriter out = new BufferedWriter(new FileWriter("vaxtodo/bin/reservations.txt"));
		
		out.write("");
		
		while(!reservations.isEmpty()){
			out.append(reservations.poll().toString() + "\n");
		}
		
		out.close();
	}
}
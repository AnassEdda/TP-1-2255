package vaxtodo;

import java.io.*;
import java.util.*;

public class VaxTodo {

	public static LinkedList<User> users;
	public static LinkedList<Visitor> visitors;
	
	public static void main(String args[]) throws IOException {
		users = readUsers();
		visitors = readVisitors();
		writeUsers();
		writeVisitors();
	}
	
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
	
	private static void writeUsers() throws IOException {
		BufferedWriter out = new BufferedWriter(new FileWriter("vaxtodo/bin/users.txt"));
		
		String line = "";
		
		for(User user : VaxTodo.users) {
			line += user.toString() + "\n";
		}
		
		out.write(line);
		
		out.close();
	}
	
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
		    	visitors.add(new Visitor(accountNumber, lastName, firstName, birthdate, email, address, postalCode, city, phoneNumber, null));
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
	
	private static void writeVisitors() throws IOException {
		BufferedWriter out = new BufferedWriter(new FileWriter("vaxtodo/bin/visitors.txt"));
		
		String line = "";
		
		for(Visitor visitor : VaxTodo.visitors) {
			line += visitor.toString() + "\n";
		}
		
		out.write(line);
		
		out.close();
	}
}
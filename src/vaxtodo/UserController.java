package vaxtodo;

import java.util.ArrayList;

public class UserController {

public void createUser() {
		
	}
	
	public User modifyUser() {
		
		return null;
	}

	public User deleteUser() {
		
		return null;
	}
	
	public User find() {
		
		return null;
	}

	public void userList(){
		System.out.println("\nAffichage des informations des utilisateurs");
		
		for (User user: VaxTodo.users){
			
			String nextShift = "";
			
			if(user.getSchedule() == null) {
				nextShift = "aucun quart de travail planifie";
			}else {
				nextShift = "prochain quart de travail : " + user.getSchedule()[0].getDate() + ", de " 
							+ user.getSchedule()[0].getStartTime() + " a " + user.getSchedule()[0].getEndTime();
			}
			
			System.out.println(user.getFirstName() + " " + user.getLastName() + ", " + user.getEmail() + ", numero de telephone : " 
														+ user.getPhoneNumber() + ", " + nextShift);

		}
	}
	
}

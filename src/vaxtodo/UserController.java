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

	public ArrayList<User> userList(){
	    ArrayList<User> result= new ArrayList();
	    for (User user: VaxTodo.users){
	    	result.add(user);
	    }
			return result;
	}
	
}

package task;

import java.util.HashMap;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class MyParams {
	
	@Parameters
	public static HashMap<String,String> myData(){
		HashMap<String, String> myUsers = new HashMap<String, String>();
		
		for (int i = 0; i<SecondTest.usernum;i++) {
			myUsers.put(SecondTest.usernames[i], SecondTest.fullName[i]);
		}
		
		return myUsers;
	}
	
	
}

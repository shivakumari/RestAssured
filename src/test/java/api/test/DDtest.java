package api.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.userendpoints;
import api.payload.User;
import api.utilities.DataProviders;
import io.restassured.response.Response;

public class DDtest {
	
	
	@Test(priority=1, dataProvider="Data", dataProviderClass= DataProviders.class )
	public void testpostuser(String UserID,String Uname, String Fname, String lname, String email, String pswd, String ph){
		//should have the parameters in the same order which are available in excel 
		User userpayload=new User();// Create object for the pojo class to send all the above parameters data to userpayload 
		
		userpayload.setId(Integer.parseInt(UserID));
		userpayload.setLastName(lname);
		userpayload.setEmail(email);
		userpayload.setPhone(ph);
		userpayload.setPassword(pswd);
		userpayload.setUsername(Uname);
		userpayload.setFirstName(Fname);
		
		Response res=userendpoints.createuser(userpayload);
		Assert.assertEquals(res.getStatusCode(),200);
	}


}

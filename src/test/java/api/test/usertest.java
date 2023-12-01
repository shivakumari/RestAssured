package api.test;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.userendpoints;
import api.payload.User;
import io.restassured.response.Response;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class usertest {
	
	Faker faker;
	User userpayload;
	public Logger logger;

	@BeforeClass
	public void setupData() {
		 faker =new Faker();
		 userpayload=new User();
		 
		 userpayload.setId(faker.idNumber().hashCode());
		 userpayload.setFirstName(faker.name().firstName());
		 userpayload.setLastName(faker.name().lastName());
		 userpayload.setUsername(faker.name().username());
		 userpayload.setPassword(faker.internet().password(5,10));
		 userpayload.setPhone(faker.phoneNumber().cellPhone());
		 userpayload.setUserStatus(faker.idNumber().hashCode());
		 userpayload.setEmail(faker.internet().safeEmailAddress());
		 
		 logger= LogManager.getLogger(this.getClass());
	}
	@Test(priority =1)
	public void testPostUser() {
		
		logger.info("****Creating created *****");
		Response res=userendpoints.createuser(userpayload);
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(),200);
		logger.info("****User created successsfully *****");
		
	}
	@Test(priority =2)
	public void getUserByName() {
		Response res=userendpoints.getuser(this.userpayload.getUsername());
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(),200);
		
	}
	
	@Test(priority =3)
	
	public void updateUserDetails() {
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
	
		Response res=userendpoints.updateuser(this.userpayload.getUsername(),userpayload);
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(),200);
	}
	@Test(priority =4)
	public void deleteUser() {
		Response res=userendpoints.deleteuser(this.userpayload.getUsername());
		res.then().log().all();
		Assert.assertEquals(res.getStatusCode(),404);
	}
	
	
}


package api.endpoints;

import static io.restassured.RestAssured.given;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//UserEndpoints.java 
//Created to perform Create, Read, Update, Delete requests to the User services 
public class userendpoints {
	
	public static Response createuser(User payload){

		
		Response res =given()
				.contentType(ContentType.JSON)
				.accept(ContentType.JSON)
		        .body(payload)
		.when()
		.post(Routes.Post_url);
		return res; 
	}
public static Response getuser(String userName){

		
		Response res =given()
				.pathParam("username", userName)
         .when()
		.get(Routes.get_url);
		return res; 
	}
	

public static Response updateuser(String userName, User payload){

	
	Response res = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.pathParam("username", userName)
	        .body(payload)
	.when()
	.put(Routes.put_url);
	return res; 
}
public static Response deleteuser(String userName){

	
	Response res = given()
			.pathParam("userName", userName)
	.when()
	
     .delete(Routes.delete_url);
	return res; 
}
}

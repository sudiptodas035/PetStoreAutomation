package api.endpoints;

import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

//UserEndpoints.java
//Created to perform Create, Read, Update and Delete requests to the user API. 

public class UserEndPoints2 {

	// method created for getting URL's from properties file
	static ResourceBundle getURL() {
		ResourceBundle routes = ResourceBundle.getBundle("routes"); // load the properties file
		return routes;
	}

	public static Response createUser(User payload) {
		String str = getURL().getString("post_url");
		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON).body(payload).when()
				.post(getURL().getString("post_url"));
		return response;
	}

	public static Response readUser(String username) {
		Response response = given().pathParam("username", username).when().get(getURL().getString("get_url"));
		return response;
	}

	public static Response updateUser(String username, User payload) {

		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON)
				.pathParam("username", username).body(payload).when().put(getURL().getString("update_url"));
		return response;
	}

	public static Response deleteUser(String username) {
		Response response = given().pathParam("username", username).when().delete(getURL().getString("delete_url"));
		return response;
	}
}

package api.test;

import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests {

	Faker faker;
	User userPayload;
	public Logger logger; // for logs

	@BeforeClass
	public void setUp() {
		faker = new Faker();
		userPayload = new User();

		userPayload.setId(faker.idNumber().hashCode());
		userPayload.setUsername(faker.name().username());
		userPayload.setFirstname(faker.name().firstName());
		userPayload.setLastname(faker.name().lastName());
		userPayload.setEmail(faker.internet().safeEmailAddress());
		userPayload.setPassword(faker.internet().password(5, 10));
		userPayload.setPhone(faker.phoneNumber().cellPhone());

		// logs
		logger = LogManager.getLogger(this.getClass());
	}

	@Test(priority = 1)
	public void testPostUser() {
		try {
			logger.info("Creating User with the payload: " + userPayload);
			Response response = UserEndPoints.createUser(userPayload);
			response.then().log().all();
			Assert.assertEquals(response.getStatusCode(), 200);
			logger.debug("User created successfully response: " + response.getBody().asString());
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.fatal("Fatal Error Occured for Create User: " + ex.getMessage().toString());
			Assert.fail();
		}
	}

	@Test(priority = 2)
	public void testGetUserByName() {
		try {
			logger.info("Getting User: " + this.userPayload.getUsername());
			Response response = UserEndPoints.readUser(this.userPayload.getUsername());
			response.then().log().all();
			Assert.assertEquals(response.getStatusCode(), 200);
			logger.debug("User retrieved successfully : " + response.getBody().asString());
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.fatal("Fatal Error Occured for Read User: " + ex.getMessage().toString());
			Assert.fail();
		}
	}

	@Test(priority = 3)
	public void testUpdateUserByName() {
		try {
			// Update data
			userPayload.setFirstname(faker.name().firstName());
			userPayload.setLastname(faker.name().lastName());
			userPayload.setEmail(faker.internet().safeEmailAddress());

			logger.info("Updating User: " + this.userPayload.getUsername());
			Response response = UserEndPoints.updateUser(this.userPayload.getUsername(), userPayload);
			response.then().log().body();

			Assert.assertEquals(response.getStatusCode(), 200);

			// Checking data after update
			Response responseAfterUpdate = UserEndPoints.updateUser(this.userPayload.getUsername(), userPayload);
			responseAfterUpdate.then().log().body();

			Assert.assertEquals(response.getStatusCode(), 200);
			logger.debug("Updated User successfully: " + responseAfterUpdate.getBody().asString());

		} catch (Exception ex) {
			ex.printStackTrace();
			logger.fatal("Fatal Error Occured for Updating User: " + ex.getMessage().toString());
			Assert.fail();
		}
	}

	@Test(priority = 4)
	public void testDeleteUserByname() {
		try {
			logger.info("Deleting User: " + this.userPayload.getUsername());
			Response response = UserEndPoints.deleteUser(this.userPayload.getUsername());
			Assert.assertEquals(response.getStatusCode(), 200);
			logger.debug("Deleted User successfully: " + response.getBody().asString());
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.fatal("Fatal Error Occured for Deleting User: " + ex.getMessage().toString());
			Assert.fail();
		}
	}
}

package api.test;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.StoreEndPoints;
import api.payload.Store;
import io.restassured.response.Response;

public class StoreTests {
	Faker faker;
	Store storePayload;
	public Logger logger; // for logs

	@BeforeClass
	public void setUp() {
		faker = new Faker();
		storePayload = new Store();
		
		storePayload.setId(faker.idNumber().hashCode());
		storePayload.setPetId(faker.idNumber().hashCode());
		storePayload.setQuantity(faker.idNumber().hashCode());
		storePayload.setShipDate(new Date());
		storePayload.setStatus(faker.toString());
		storePayload.setComplete(true);

		// logs
		logger = LogManager.getLogger(this.getClass());
	}

	@Test(priority = 1)
	public void testPostStore() {
		try {
			logger.info("Creating Store with the payload: " + storePayload);
			Response response = StoreEndPoints.createStore(storePayload);
			response.then().log().all();
			Assert.assertEquals(response.getStatusCode(), 200);
			logger.debug("Store created successfully response: " + response.getBody().asString());
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.fatal("Fatal Error Occured for Create Store: " + ex.getMessage().toString());
			Assert.fail();
		}
	}

	@Test(priority = 2)
	public void testPostStoreProp() {
		try {
			logger.info("Creating Store with the payload: " + storePayload);
			Response response = StoreEndPoints.createStorefromProp(storePayload);
			response.then().log().all();
			Assert.assertEquals(response.getStatusCode(), 200);
			logger.debug("Store created successfully response: " + response.getBody().asString());
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.fatal("Fatal Error Occured for Create Store: " + ex.getMessage().toString());
			Assert.fail();
		}
	}

	@Test(priority = 3)
	public void testGetStoreByOrderId() {
		try {
			logger.info("Getting Store: " + this.storePayload.getId());
			Response response = StoreEndPoints.readStorefromProp(this.storePayload.getId());
			response.then().log().all();
			Assert.assertEquals(response.getStatusCode(), 200);
			logger.debug("Store retrieved successfully : " + response.getBody().asString());
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.fatal("Fatal Error Occured for Read Store: " + ex.getMessage().toString());
			Assert.fail();
		}
	}
	
	@Test(priority = 4)
	public void readStoreInventoryfromProp() {
		try {
			logger.info("Getting Store inventory: ");
			Response response = StoreEndPoints.readStoreInventoryfromProp();
			response.then().log().all();
			Assert.assertEquals(response.getStatusCode(), 200);
			logger.debug("Store inventory retrieved successfully : " + response.getBody().asString());
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.fatal("Fatal Error Occured for Read Store inventory: " + ex.getMessage().toString());
			Assert.fail();
		}
	}

	@Test(priority = 5)
	public void testDeleteStoreProp() {
		try {
			logger.info("Deleting Store : "+this.storePayload.getId());
			Response response = StoreEndPoints.deleteStorefromProp(this.storePayload.getId());
			response.then().log().all();
			Assert.assertEquals(response.getStatusCode(), 200);
			logger.debug("Store deleted successfully response: " + response.getBody().asString());
		} catch (Exception ex) {
			ex.printStackTrace();
			logger.fatal("Fatal Error Occured for delete Store: " + ex.getMessage().toString());
			Assert.fail();
		}
	}
}

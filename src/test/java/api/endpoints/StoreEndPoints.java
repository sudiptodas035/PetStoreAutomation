package api.endpoints;

import io.restassured.response.Response;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;

import api.common.Common;
import api.payload.Store;

//StoreEndPoints.java
//Created to perform Create, Read, Update and Delete requests to the Store API. 

public class StoreEndPoints {

	public static Response createStore(Store payload) {
		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON).body(payload).when()
				.post(Routes.store_post_url);
		return response;
	}

	public static Response createStorefromProp(Store payload) {
		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON).body(payload).when()
				.post(Common.getURL().getString("store_post_url"));
		return response;
	}

	public static Response readStorefromProp(int orderId) {
		Response response = given().pathParam("orderId", orderId).when()
				.get(Common.getURL().getString("store_get_url"));
		return response;
	}

	public static Response readStoreInventoryfromProp() {
		Response response = given().contentType(ContentType.JSON).accept(ContentType.JSON).when()
				.get(Common.getURL().getString("store_get_inventory_url"));
		return response;
	}
	
	public static Response deleteStorefromProp(int orderId) {
		Response response = given().pathParam("orderId",orderId).when()
				.delete(Common.getURL().getString("store_delete_url"));
		return response;
	}
}

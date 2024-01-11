package api.common;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AccessToken {

	public static String get_accessToken() {
		String responseBody = null;
		String accessToken = null;
		try {
			String url = Common.getURL().getString("url_access_token");
			RequestSpecification http_req = RestAssured.given().queryParam("grant_type", Common.grant_type)
					.queryParam("client_id", Common.client_id).queryParam("client_secret", Common.client_secret)
					.header("content-Type", Common.ContentType);
			Response response = http_req.post(url);
			responseBody = response.asString();
			String[] accessTokenParts = responseBody.split(",");
			String[] accessTokenText = accessTokenParts[0].split(":");
			accessToken = accessTokenText[1].replaceAll("\\W", "");
			System.out.println("accessToken: " + accessToken);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return accessToken;
	}
}

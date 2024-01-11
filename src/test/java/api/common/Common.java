package api.common;

import java.util.ResourceBundle;

public class Common {

	// Access token related pre-requisites
	public static String grant_type="client_credentials";
	public static String client_id = "0ee1153edfdc30f7cdb9c5bb2f7a96575faadcac62e37bbf66566d59acf2df96";
	public static String client_secret = "edae8332e57ade1ab0c41a263e8e6991bfc2ad5982e37c6afd97209378ea6cab";
	public static String ContentType="application/json";

	// method created for getting URL's from properties file
	public static ResourceBundle getURL() {
		ResourceBundle routes = ResourceBundle.getBundle("routes"); // load the properties file
		return routes;
	}

}

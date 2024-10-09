package fancode.fancode.CommonActions;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class GetMethod {

	public static Response ResponseBody(String BaseURI, String Resource) {
		RestAssured.baseURI = BaseURI;
		Response Response = given()
				.header("Content-Type", "application/json")
				.when().get(Resource)
				.then()
				.extract()
				.response();

		return Response;
	}

}

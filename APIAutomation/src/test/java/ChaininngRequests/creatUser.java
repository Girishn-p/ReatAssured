package ChaininngRequests;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.Test;

public class creatUser {

	  @Test(priority=1)
	    void getUsers() {
	        given()
	            .when()
	            .get("/api/users?page=2")
	        .then()
	            .statusCode(200)
	            .body("page", equalTo(2))
	            .log().all();
	    }
}

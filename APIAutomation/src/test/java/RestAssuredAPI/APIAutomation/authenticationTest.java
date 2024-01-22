package RestAssuredAPI.APIAutomation;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import java.util.HashMap;

public class authenticationTest {
	
	//@Test
	void testpreemptiveAuthentication()
	
	{
		given()
		 .auth().preemptive().basic("postman", "password")
	    .when()
	      .get("https://postman-echo.com/basic-auth")
	    .then()
	       .statusCode(200)
		   .body("authenticated",equalTo(true))
		   .log().all();
	}
	//@Test
	void testBasicAuthentication()
	
	{
		given()
		 .auth().basic("postman", "password")
	    .when()
	      .get("https://postman-echo.com/basic-auth")
	    .then()
	       .statusCode(200)
		   .body("authenticated",equalTo(true))
		   .log().all();
	}
	//@Test
	void testDigestAuthentication()
	
	{
		given()
		 .auth().digest("postman", "password")
	    .when()
	      .get("https://postman-echo.com/basic-auth")
	    .then()
	       .statusCode(200)
		   .body("authenticated",equalTo(true))
		   .log().all();
	}
	@Test
	void testBearerAuthentication()
	
	{
		String bearerTkoen= "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";
		
		given()
		 .header("Authorization","Bearer "+bearerTkoen)
		 .when()
	      .get("https://api.github.com/user/repos")
	    .then()
	       .statusCode(200)
		   .log().all();
	}

	@Test
	void testOauth1Authentication()
	
	{
		
		
		given()
		 .auth().oauth("consumerkey", "consumerSecrat", "accessTkoen", "tokenScreate")
		 .when()
	      .get("https://api.github.com/user")
	    .then()
	       .statusCode(200)
		   .log().all();
	}
	@Test
	void testOauth2Authentication()
	
	{
		
		
		given()
		 .auth().oauth2("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")
		 .when()
	      .get("https://api.github.com/user")
	    .then()
	       .statusCode(200)
		   .log().all();
	}
	@Test
	void testApikeyAuthentication()
	
	{
		
		
		given()
		 .queryParam("appiid", "value")
		 .when()
	      .get("https://api.github.com/user")
	    .then()
	       .statusCode(200)
		   .log().all();
	}
	
}




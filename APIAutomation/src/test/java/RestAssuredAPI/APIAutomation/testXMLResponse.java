package RestAssuredAPI.APIAutomation;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class testXMLResponse
{
	
	@Test
	void parsingXMLresponse()
	{
	given()
		.when()
		    .get("http://restapi.adequateshop.com/api/Traveler?page=1")
		.then()
		    .statusCode(200)
		    .header("Content-Type", "application/xml; charset=utf-8")
		    .body("TravelerinformationResponse.page", equalTo("1"))
		    .body("TravelerinformationResponse.travelers.Travelerinformation[0].name", equalTo("Developer"));
		  
	
	}
	//@Test
	void parsingXMLresponse2()
	{
	Response res=
	 given()
		.when()
		    .get("http://restapi.adequateshop.com/api/Traveler?page=1");
	         Assert.assertEquals(res.getStatusCode(), 200);
	         Assert.assertEquals(res.header("Content-Type"), "application/xml; charset=utf-8");
	         String pageNo = res.xmlPath().get("TravelerinformationResponse.page").toString();
	         Assert.assertEquals(pageNo, "1");
	         String travelerName = res.xmlPath().get("TravelerinformationResponse.travelers.Travelerinformation[0].name").toString();
	         Assert.assertEquals(travelerName, "Developer");
		
	
	}

	
}

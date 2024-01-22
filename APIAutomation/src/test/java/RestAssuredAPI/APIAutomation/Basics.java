package RestAssuredAPI.APIAutomation;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import java.util.HashMap;

public class Basics {
	int id;
	@BeforeClass
    public void setBaseURI() {
        RestAssured.baseURI = "https://reqres.in";
    }


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
    
    @Test(priority=2)
    void creatUser()
    {
    	HashMap<String, String> data = new HashMap<>();
    	
    	data.put("name", "girish");
    	data.put("job","Tester");
    	
        id=given()
    	    .contentType("application/json")
    	    .body(data)
    	
    	.when()
    	     .post("https://reqres.in/api/users")
    	     .jsonPath().getInt("id");
    	
    	//.then()
    	    // .statusCode(201)
    	   //  .log().all();
    	     
    }
    @Test(priority=3)
    void updateuser()
    {
HashMap<String, String> data = new HashMap<>();
    	
    	data.put("name", "girish");
    	data.put("job","Automation Tester");
    	
        given()
    	    .contentType("application/json")
    	    .body(data)
    	
    	.when()
    	     .post("https://reqres.in/api/users"+id)
    	     
    	.then()
    	    .statusCode(200)
    	    .log().all();
    }
}

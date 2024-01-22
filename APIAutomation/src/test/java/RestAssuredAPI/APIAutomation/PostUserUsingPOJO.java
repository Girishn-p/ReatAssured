package RestAssuredAPI.APIAutomation;

import org.json.JSONTokener;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileReader;

public class PostUserUsingPOJO {

    int id;

	//@Test
    void createUserUsingPojoS()
	{
		Pojo_PostRequest data = new Pojo_PostRequest();

        data.setName("scott");
        data.setLocation("Bagalkot");
        data.setPhone( "123456");

        String[] courseArr = {"c", "python"};
        data.setCourses(courseArr);

        id = given()
            .contentType("application/json")
            .body(data)
        .when()
            .post("https://reqres.in/api/users")
        .then()
            .log().all() // Log the response details
            .statusCode(201)
    
            .extract().jsonPath().getInt("id");
    }
    @Test
    void createUserUsingExternalJsonFile() {
        // Specify the path to your JSON file
        File jsonFile = new File(".\\body.json");

        try {
            // Read the JSON file using FileReader and JSONTokener
            FileReader fileReader = new FileReader(jsonFile);
            JSONTokener jsonTokener = new JSONTokener(fileReader);

            // Create a JSONObject using the JSONTokener
            org.json.JSONObject data = new org.json.JSONObject();
            // Make a POST request with the JSON data
            id = given()
                .contentType("application/json")
                .body(data.toString()) // Convert JSONObject to String
            .when()
                .post("https://reqres.in/api/users")
            .then()
                .log().all() // Log the response details
                .statusCode(201)
                .extract().jsonPath().getInt("id");

            // Now you can use the 'id' variable or perform additional assertions
        } catch (Exception e) {
            // Handle exceptions, e.g., if the file is not found or JSON is invalid
            e.printStackTrace();}
            
        }
    @Test
    void deleteUser() {
        given()
          .pathParam("id", id)
       .when()
          .delete("https://reqres.in/api/users/{id}")
       .then()
          .statusCode(204)
                .log().all();
    }
}

package RestAssuredAPI.APIAutomation;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class PostUserUsingJsonObject {

    int id;

	@Test
    void createUserUsingJson()
	{
        org.json.JSONObject data = new org.json.JSONObject();

        data.put("name", "scott");
        data.put("location", "Bagalkot");
        data.put("phone", "123456");

        String[] courseArr = {"c", "python"};
        data.put("courses", courseArr);

        id = given()
            .contentType("application/json")
            .body(data)
        .when()
            .post("https://reqres.in/api/users")
        .then()
            .log().all() // Log the response details
            .statusCode(201)
          // Correct assertion for the name
            .extract().jsonPath().getInt("id");
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

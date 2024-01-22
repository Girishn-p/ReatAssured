package RestAssuredAPI.APIAutomation;

import org.testng.annotations.Test;
import java.util.HashMap;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostUserUsingHashmap {

    int id;

  // @Test
    void createUserHashMap() {
        HashMap<String, Object> data = new HashMap<>();

        data.put("name", "girish");
        data.put("location", "Bagalkot");
        data.put("phone", "123456");

        String[] courseArr = { "c", "python" };
        data.put("courses", courseArr);

        id = given()
        		.contentType("application/json")
        		.body(data)
        		.when()
             	.post("https://reqres.in/api/users")
            .then()
                .statusCode(201)
                .body("name", equalTo("girish"))
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

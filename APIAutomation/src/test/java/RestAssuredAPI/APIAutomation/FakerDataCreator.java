package RestAssuredAPI.APIAutomation;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.github.javafaker.Faker;

public class FakerDataCreator {
	
	@Test
	void generateDummyTestData()
	
	{
		Faker fake =new Faker();
	String Author= fake.book().author();
	String Title = fake.book().title();
	System.out.println(Author);
	System.out.println(Title);
	}
	
}


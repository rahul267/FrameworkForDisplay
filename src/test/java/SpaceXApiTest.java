import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItems;

public class SpaceXApiTest {
    private static RequestSpecification requestSpecification = RestAssured.given();
    private String baseURL = "https://api.spacexdata.com/v4" ;
    private static Response response;

    @BeforeClass
   public void setup()
    {
        requestSpecification = new RequestSpecBuilder().setBaseUri(baseURL)
                .build().log().all();
        response = RestAssured.given()
                .spec(requestSpecification).basePath("/launches/latest")
                .when()
                .get();

    }

    @Test
    public void verifyLatestLauchOKResponseTest()
    {
        response.then()
                .statusCode(200) ;


    }

    @Test
    public void verifyLatestLauchHasValidShipTest()
    {
        response.then()
                .statusCode(200)
                .body("ships[0]",containsString("5ea6ed")) ;

    }

    @Test
    public void verifyLatestLauchHasCapsuleTest()
    {
        response.then()
                .statusCode(200)
                .body("capsules[0]",containsString("60b803")) ;

    }
    @Test
    public void verifyLatestLaunchPayloadTest()
    {
        response.then()
                .statusCode(200)
                .body("payloads[0]",containsString("5fe3b")) ;

    }

    @Test
    public void verifyLatestLauchHasJsonResponseTest()
    {
        response.then()
                .assertThat()
                .contentType(ContentType.JSON);

    }


}

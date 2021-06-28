package steps;

import io.restassured.http.ContentType;
import org.junit.BeforeClass;
import utils.Links;

import static io.restassured.RestAssured.given;

public class BaseAPI {
    public static String access_token;
    public static String accessToken(){
        access_token = given()
                .param("grant_type","client_credentials")
                .contentType(ContentType.JSON)
                .auth().preemptive()
                .basic(Links.PAYPAL_CLIENT_ID,Links.PAYPAL_SECRET_KEY)
                .post(Links.PAYPAL_AUTH_URL)
                .body()
                .jsonPath()
                .get("access_token").toString();

        return access_token;


    }
}

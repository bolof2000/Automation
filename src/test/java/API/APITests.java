package API;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.junit.Assert;
import org.testng.annotations.Test;
import pojo.*;
import utils.Links;

import java.io.*;

import static io.restassured.RestAssured.given;

public class APITests {


    @Test
    public  void testJsonMock() throws IOException {
        Response response =
                given().with().pathParam("id","1")
                .when()
                .get(Links.JSON_MOCK_SERVER_1 +"/{id}");

        response.getBody().prettyPrint();

        Assert.assertEquals(response.getBody().jsonPath().get("phone"),"1-770-736-8031 x56442");
        Assert.assertTrue(response.getBody().asString().contains("Multi-layered client-server neural-net"));
    }

    @Test
    public void PostRequestUsingSerializationOfJavaObject(){
        User user = new User();
        Address address = new Address();
        address.setStreet("1234 highlands ranch");
        address.setSuite("Apt 559");
        address.setCity("Denver");
        address.setZipcode("80109");

        Geo geo  = new Geo();
        geo.setLat("123435");
        geo.setLng("32.12222");


        Company company = new Company();
        company.setName("Vusa");
        company.setCatchPhrase("denver rtoad");
        company.setBs("Seialization of api request");

        user.setName("bolofinde");
        user.setEmail("bolofbaba@gmail.com");
        user.setAddress(address);
        user.setGeo(geo);
        user.setPhone("8322452388");
        user.setWebsite("test.com");
        user.setCompany(company);

        ValidatableResponse response = given()

                .contentType(ContentType.JSON)
                .when()
                .body(user)
                .put(Links.JSON_MOCK_SERVER_POST)
                .then()
                .statusCode(200)
                .log()
                .all();

        response.extract().statusLine();
    }

    @Test
    public void CreateDepartmentTestUsingPojo(){

        Department department = new Department();
       // department.setDepartmentId(11000L);
        department.setDepartmentCode("eeddd00001");
        department.setDepartmentAddress("1235 shea center drive");
        department.setDepartmentName("HR");

        ValidatableResponse response = given()
                .contentType(ContentType.JSON)
                .when()
                .body(department)
                .post(Links.JSON_DEPARTMENT_SERVER)
                .then()
                .statusCode(200)
                .log()
                .all();
    }

    @Test
    public void getDepartmentById(){
        ValidatableResponse response = given()
                .contentType(ContentType.JSON)
                .pathParam("id",1004)
                .when()
                .get(Links.JSON_DEPARTMENT_SERVER+"{id}")
                .then()
                .statusCode(200)
                .log()
                .all();






    }
}

package apitests.JamalClass;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;

import java.util.List;
import java.util.Map;

public class JsonToJavaCollection {

    @BeforeClass
    public void beforeClass() {

        RestAssured.baseURI = ConfigurationReader.getProperty("spartanapi_url");
    }


    @Test
    public void SpartanMap() {
        Response response = given().accept(ContentType.JSON)
                .and().pathParam("id", 15)
                .and().auth().basic("admin", "admin")
                .when().get("/api/spartans/{id}");

        assertEquals(response.statusCode(), 200);

        //we will convert Json response to Java Collection
        Map<String, Object> spartanMap = response.body().as(Map.class);

        System.out.println("spartanMap = " + spartanMap);
        String name = (String) spartanMap.get("name");

        assertEquals(name, "Meta");


    }

    @Test
    public void allSpartansWithList() {
        Response response = given().accept(ContentType.JSON)
                .and().auth().basic("admin", "admin")
                .when().get("/api/spartans");

        assertEquals(response.statusCode(),200);

        List<Map<String, Object>> allSpartanList = response.body().as(List.class);

       // System.out.println("allSpartanList = " + allSpartanList);

        //print first spartan first name,
        System.out.println("allSpartanList.get(0).get(\"name\") = " + allSpartanList.get(0).get("name"));


    }
}
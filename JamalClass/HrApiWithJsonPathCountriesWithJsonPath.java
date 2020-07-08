package apitests.JamalClass;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.annotations.BeforeClass;
import utilities.ConfigurationReader;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import utilities.ConfigurationReader;
import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import static org.testng.Assert.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigurationReader;

import java.util.List;

public class HrApiWithJsonPathCountriesWithJsonPath {

    @BeforeClass
    public void beforeClass() {
        RestAssured.baseURI = ConfigurationReader.getProperty("hrapi_url");
    }

    @Test
    public void CountriesWithJsonPath() {

        //request
        Response response = get("/countries");

        //assign response body to jsonpath
        JsonPath json = response.jsonPath();
/*
        //ready second country name
        String secondCountryName = json.getString("items.country_name[1]");
        System.out.println("secondCounttyName = " + secondCountryName);


        //get all country ids
        List<String> allCountryIds = json.getList("items.country_id");
        System.out.println(allCountryIds);

        System.out.println("countryIDs.size() = " + allCountryIDs.size());
        for (String countryID : allCountryIds) {
            System.out.println("countryID = " + countryID);
        }
*/
        //get all country names where their region id is equal to 2
        List<String> CountryNameWithRegion2 = json.getList("items.findAll {it.region_id==2}.country_name");

        System.out.println(CountryNameWithRegion2);

    }

}
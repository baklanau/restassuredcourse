package config;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.ResponseSpecification;
import org.junit.BeforeClass;

import static org.hamcrest.Matchers.lessThan;

public class TestConfig {

    public static RequestSpecification videoGameReqSpec;
    public static RequestSpecification footballReqSpec;
    public static ResponseSpecification responseSpecification;

    @BeforeClass
    public static void setup(){
//        RestAssured.baseURI="http://localhost";
//        RestAssured.port=8080;
//        RestAssured.basePath="/app/";

        //add this string if only fiddler is running
        //RestAssured.proxy("localhost", 8888);

//        RequestSpecification requestSpecification = new RequestSpecBuilder().
//                addHeader("Content-type", "application/json").
//                addHeader("Accept", "application/json").
//                build();
//
//        RestAssured.requestSpecification = requestSpecification;
//
//        ResponseSpecification responseSpecification = new ResponseSpecBuilder().
//                expectStatusCode(200).
//                build();
//
//        RestAssured.responseSpecification = responseSpecification;

        videoGameReqSpec = new RequestSpecBuilder().
                setBaseUri("http://localhost").
                setPort(8080).
                setBasePath("/app/").
                addHeader("Content-type", "application/json").
                addHeader("Accept", "application/json").
                build();

        //specification for videogames api
        //videogames app should be run
        RestAssured.requestSpecification = videoGameReqSpec;

        footballReqSpec = new RequestSpecBuilder().
                setBaseUri("http://api.football-data.org").
                setBasePath("/v1/").
                addHeader("X-Auth-Token", "302ffb3362e64a37805e136382545f0b").
                addHeader("X-Response-Control", "minified").
                build();


        responseSpecification = new ResponseSpecBuilder().
                expectStatusCode(200).
                expectResponseTime(lessThan(1500L)).
                build();

        RestAssured.responseSpecification = responseSpecification;




        }

}

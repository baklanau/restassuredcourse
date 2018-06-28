import config.TestConfig;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.equalTo;

public class FootballTests extends TestConfig {

    @Test
    public void getAllCompetitionsOneSeason(){
        //http://api.football-data.org/v1/competitions/?season=2016
        given().
                spec(footballReqSpec).
                queryParam("season", 2016).
        when().
                get("competitions/");
    }

    @Test
    public void getCountTeamOneComp(){
        given().
                spec(footballReqSpec).
        when().
                get("competitions/426/teams").
        then().
                body("count", equalTo(20));
    }

    @Test
    public void getFirstTeamName(){
        given().
                spec(footballReqSpec).
        when().
                get("competitions/426/teams").
        then().
                body("teams.name[0]", equalTo("Hull City FC"));
    }

    @Test
    public void getAllTeamData(){

        String responseBody = given().spec(footballReqSpec).when().get("competitions/426/teams").asString();
        System.out.println(responseBody);
    }

    @Test
    public void getAllTeamData_DoCheckFirst(){
        Response response =
                given().
                        spec(footballReqSpec).
                when().
                        get("competitions/426/teams").
                then().
                        contentType(ContentType.JSON).
                        extract().response();

        String jsonResponseAsString = response.asString();

    }


}

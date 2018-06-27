import config.TestConfig;
import org.junit.Test;

import static io.restassured.RestAssured.*;

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


}

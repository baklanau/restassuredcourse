import config.TestConfig;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.Map;

import static io.restassured.RestAssured.*;

public class GPathJSONTests extends TestConfig{

    @Test
    public void extractMapOfElementsWithFind(){

        Response response = get("competitions/426/teams");

        Map<String,?> allTeamDataForSingleTeam = response.path
                ("teams.find{ it.name == 'Tottenham Hotspur FC' }");

        System.out.println(allTeamDataForSingleTeam);
    }
}

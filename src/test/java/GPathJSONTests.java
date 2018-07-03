import config.TestConfig;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class GPathJSONTests extends TestConfig{

    //29 lesson
    @Test
    public void extractMapOfElementsWithFind(){

        Response response = get("competitions/426/teams");

        Map<String,?> allTeamDataForSingleTeam = response.path
                ("teams.find{ it.name == 'Tottenham Hotspur FC' }");

        System.out.println(allTeamDataForSingleTeam);
    }

    //30 lesson
    @Test
    public void extractSingleValueWithFind(){

        Response response = get("teams/66/players");

        String certainPlayer = response.path
                ("players.find{ it.jerseyNumber == 20 }.name");

        System.out.println(certainPlayer);
    }

    //30 lesson
    @Test
    public void extractListOfValuesWithFindAll(){

        Response response = get("teams/66/players");

        List<String> playerNames = response.path("players.findAll { it.jerseyNumber > 10 }.name");

        System.out.println(playerNames);
    }

    //31 lesson
    @Test
    public void extractSingleValueWithHighestNumber(){

        Response response = get("teams/66/players");

        String playerName = response.path("players.max { it.jerseyNumber }.name");

        System.out.println(playerName);
    }

    //31 lesson
    @Test
    public void extractMultipleValuesAndSumThem(){

        Response response = get("teams/66/players");

        int sumOfJerseys = response.path("players.collect{ it.jerseyNumber }.sum()");

        System.out.println(sumOfJerseys);

    }


}

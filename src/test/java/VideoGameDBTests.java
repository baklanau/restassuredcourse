import config.EndPoint;
import config.TestConfig;
import org.junit.Ignore;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class VideoGameDBTests extends TestConfig {


    @Test
    public void getAllVideoGames(){
        given().
        when().get(EndPoint.VIDEOGAMES).
        then();
    }

    @Test
    public void createNewGameByJSONPOST(){
        String gameBodyJson = "{\n" +
                "  \"id\": 11,\n" +
                "  \"name\": \"MyNewGame\",\n" +
                "  \"releaseDate\": \"2018-06-27T13:03:21.709Z\",\n" +
                "  \"reviewScore\": 40,\n" +
                "  \"category\": \"Action\",\n" +
                "  \"rating\": \"Excillent\"\n" +
                "}";

        given().
                body(gameBodyJson).
        when().post(EndPoint.VIDEOGAMES).
        then();
    }

    @Ignore
    @Test
    public void createNewGameByXmlPOST(){
        String gameBodyXml = "<videoGame category=\"Action\" rating=\"Excillent\">\n" +
                "    <id>12</id>\n" +
                "    <name>MyNewGame 2</name>\n" +
                "    <releaseDate>2018-06-27T00:00:00+03:00</releaseDate>\n" +
                "    <reviewScore>46</reviewScore>\n" +
                "  </videoGame>";

        given().
                body(gameBodyXml).
        when().post(EndPoint.VIDEOGAMES).
        then();
    }

    @Test
    public void updateGamePUT(){

        String gameBodyJson = "{\n" +
                "  \"id\": 11,\n" +
                "  \"name\": \"MyUpdatedGame\",\n" +
                "  \"releaseDate\": \"2018-06-27T13:03:21.709Z\",\n" +
                "  \"reviewScore\": 44,\n" +
                "  \"category\": \"Action\",\n" +
                "  \"rating\": \"Exc\"\n" +
                "}";

        given().
                body(gameBodyJson).
        when().
                put("/videogames/11").
        then();
    }

    @Test
    public void deleteGame(){

        given().
        when().delete("/videogames/11").
        then();
    }

    @Test
    public void getSingleGame(){

        given().
                pathParam("videoGameId", 5).
        when().get(EndPoint.SINGLEGAME);
    }
}

package api;

import io.restassured.response.Response;
import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import prediktive.challenge.base.ApiBase;
import prediktive.challenge.pojo.ImageResponse;

@Log4j2
public class DuckDuckSearchApiTests {

    private static ApiBase apiBase;

    @BeforeAll
    public static void setup() {
        apiBase = new ApiBase("https://api.duckduckgo.com/");
    }

    @Test
    public void testDuckDuckGoSearchAPI() {

        String endpoint = "?q=simpson&format=json";
        Response response = apiBase.get(endpoint);
        Assertions.assertEquals(200, response.getStatusCode(), "");
        log.info(response.asString());
        ImageResponse imageResponse = apiBase.deserializeResponse(response, ImageResponse.class);

        Assertions.assertNotNull(imageResponse, "La respuesta no debería ser null");
        Assertions.assertFalse(imageResponse.getRelatedTopics().isEmpty(), "La lista de RelatedTopics no debería estar vacía");

    }

}

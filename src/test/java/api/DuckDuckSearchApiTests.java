package api;

import io.qameta.allure.Description;
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
    @Description("Test to verify DuckDuckGo API search functionality for the term 'Simpson'")
    public void testDuckDuckGoSearchAPI() {
        log.traceEntry("Running test: testDuckDuckGoSearchAPI");

        String endpoint = "?q=simpson&format=json";

        log.info("Sending GET request to DuckDuckGo API");
        Response response = apiBase.get(endpoint);

        log.info(response.asString() + "with status code" + response.getStatusCode());
        Assertions.assertEquals(200, response.getStatusCode());

        ImageResponse imageResponse = apiBase.deserializeResponse(response, ImageResponse.class);
        Assertions.assertNotNull(imageResponse, "Response was null");
        Assertions.assertFalse(imageResponse.getRelatedTopics().isEmpty(), "RelatedTopicsList is empty");

        log.traceExit("Test completed! testDuckDuckGoSearchAPI");
    }

    @Test
    @Description("Negative test to verify DuckDuckGo API response for an invalid search term")
    public void testDuckDuckGoSearchAPIWithInvalidTerm() {
        log.traceEntry("Running test: testDuckDuckGoSearchAPIWithInvalidTerm");

        String invalidEndpoint = "?q=simpsons&format=json";

        log.info("Sending GET request to DuckDuckGo API with an invalid search term");
        Response response = apiBase.get(invalidEndpoint);

        log.info("Response: " + response.asString() + " with status code: " + response.getStatusCode());

        Assertions.assertEquals(200, response.getStatusCode(), "Expected HTTP status code 200");

        ImageResponse imageResponse = apiBase.deserializeResponse(response, ImageResponse.class);
        Assertions.assertNotNull(imageResponse, "Response was null");

        Assertions.assertTrue(imageResponse.getRelatedTopics().isEmpty(), "Expected RelatedTopicsList to be empty");

        log.traceExit("Test completed! testDuckDuckGoSearchAPIWithInvalidTerm");
    }

}

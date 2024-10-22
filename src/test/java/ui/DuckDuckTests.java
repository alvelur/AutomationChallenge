package ui;

import io.qameta.allure.Description;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import prediktive.challenge.core.DriverFactory;
import prediktive.challenge.pages.DuckDuckGoHomePage;
import prediktive.challenge.pages.DuckDuckGoResultsPage;

@Log4j2
class DuckDuckTests {
    private WebDriver driver;
    private DuckDuckGoHomePage duckDuckGoHomePage;
    private DuckDuckGoResultsPage duckDuckGoResultsPage;


    @BeforeEach
    public void setUp() {
        driver = DriverFactory.initializeDriver("chrome");
        duckDuckGoHomePage = new DuckDuckGoHomePage(driver);
    }

    @Test
    @Description("This test searches for 'android' in DuckDuckGo and validates that all result titles contain the word 'android'")
    public void searchForAndroid() {
        log.traceEntry("Running test: searchForAndroid");
        duckDuckGoHomePage.get("https://start.duckduckgo.com/");

        log.info("Performing search for 'android'");
        duckDuckGoResultsPage = duckDuckGoHomePage.searchFor("android");

        for(String title : duckDuckGoResultsPage.getResultsTitles()){
            log.info("Validating result title: {}", title);
            Assertions.assertTrue(title.toLowerCase().contains("android"),
                    "This title" + title + "does not contain the word android");
        }

        log.traceExit("Test completed! searchForAndroid");
    }

    @Test
    @Description("This test opens the all regions dropdown and verifies there are more than 10 regions available")
    public void countNumberOfRegions() {
        log.traceEntry("Running test: countNumberOfRegions");

        duckDuckGoHomePage.get("https://start.duckduckgo.com/");

        log.info("Performing search for 'android'");
        duckDuckGoResultsPage = duckDuckGoHomePage.searchFor("android");

        duckDuckGoResultsPage.openAllRegionsDropDown();
        log.info("Number of regions available: {}", duckDuckGoResultsPage.numberOfRegions());
        Assertions.assertTrue(duckDuckGoResultsPage.numberOfRegions() > 10,
                "There are not enough regions available" + duckDuckGoResultsPage.numberOfRegions());

        log.traceExit("Test completed! countNumberOfRegions");
    }

    @AfterEach
    public void tearDown() {
        log.info("Closing WebDriver and quitting session.");
        DriverFactory.quitDriver(driver);
    }
}

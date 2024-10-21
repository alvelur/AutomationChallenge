package ui;

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
    public void searchForAndroid() {
        duckDuckGoHomePage.get("https://start.duckduckgo.com/");
        duckDuckGoResultsPage = duckDuckGoHomePage.searchFor("android");
        for(String title : duckDuckGoResultsPage.getResultsTitles()){
            Assertions.assertTrue(title.toLowerCase().contains("android"),
                    "This title" + title + "does not contain the word android");
        }
    }

    @Test
    public void countNumberOfRegions() {
        duckDuckGoHomePage.get("https://start.duckduckgo.com/");
        duckDuckGoResultsPage = duckDuckGoHomePage.searchFor("android");
        duckDuckGoResultsPage.openAllRegionsDropDown();
        Assertions.assertTrue(duckDuckGoResultsPage.numberOfRegions() > 10,
                "There are not enough regions available" + duckDuckGoResultsPage.numberOfRegions());
    }

    @AfterEach
    public void tearDown() {
        DriverFactory.quitDriver(driver);
    }
}

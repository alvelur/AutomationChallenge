package ui;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import prediktive.challenge.core.DriverFactory;
import prediktive.challenge.pages.DuckDuckGoHomePage;
import prediktive.challenge.pages.DuckDuckGoResultsPage;

import static org.junit.Assert.assertTrue;

public class DuckDuckTests {
    private WebDriver driver;
    private DuckDuckGoHomePage duckDuckGoHomePage;
    private DuckDuckGoResultsPage duckDuckGoResultsPage;


    @Before
    public void setUp() {
        driver = DriverFactory.initializeDriver("chrome");
        duckDuckGoHomePage = new DuckDuckGoHomePage(driver);
    }

    @Test
    public void searchForAndroid() {
        duckDuckGoHomePage.get("https://start.duckduckgo.com/");
        duckDuckGoResultsPage = duckDuckGoHomePage.searchFor("android");
        for(String title : duckDuckGoResultsPage.getResultsTitles()){
            Assert.assertTrue( "This title" + title + "does not contain the word android",
                    title.toLowerCase().contains("android"));
        }
    }

    @Test
    public void countNumberOfRegions() {
        duckDuckGoHomePage.get("https://start.duckduckgo.com/");
        duckDuckGoResultsPage = duckDuckGoHomePage.searchFor("android");
        duckDuckGoResultsPage.openAllRegionsDropDown();
        Assert.assertTrue("There are not enough regions available" + duckDuckGoResultsPage.numberOfRegions(),duckDuckGoResultsPage.numberOfRegions() > 10);
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver(driver);
    }
}

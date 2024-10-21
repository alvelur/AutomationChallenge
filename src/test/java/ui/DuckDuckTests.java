package ui;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import prediktive.challenge.core.DriverFactory;
import prediktive.challenge.pages.DuckDuckGoHomePage;

import static org.junit.Assert.assertTrue;

public class DuckDuckTests {
    private WebDriver driver;
    private DuckDuckGoHomePage homePage;

    @Before
    public void setUp() {
        driver = DriverFactory.initializeDriver("chrome");
        homePage = new DuckDuckGoHomePage(driver);
    }

    @Test
    public void searchForAndroidAndVerifyResults() {
        homePage.get("https://start.duckduckgo.com/");
        homePage.searchFor("android");
    }

    @After
    public void tearDown() {
        DriverFactory.quitDriver(driver);
    }
}

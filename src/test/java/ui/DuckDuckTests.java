package ui;

import io.qameta.allure.Description;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.*;
import prediktive.challenge.base.BaseUiTest;
import prediktive.challenge.pages.DuckDuckGoHomePage;
import prediktive.challenge.pages.DuckDuckGoResultsPage;

@Log4j2
class DuckDuckTests extends BaseUiTest {
    private DuckDuckGoHomePage duckDuckGoHomePage;
    private DuckDuckGoResultsPage duckDuckGoResultsPage;

    @Test
    @Description("This test searches for 'android' in DuckDuckGo and validates that all result titles contain the word 'android'")
    public void searchForAndroid() {

        duckDuckGoHomePage = new DuckDuckGoHomePage(driver);
        duckDuckGoHomePage.get("https://start.duckduckgo.com/");

        log.info("Performing search for 'android'");
        duckDuckGoResultsPage = duckDuckGoHomePage.searchFor("android");

        for(String title : duckDuckGoResultsPage.getResultsTitles()){
            log.info("Validating result title: {}", title);
            Assertions.assertTrue(title.toLowerCase().contains("android"),
                    "This title" + title + "does not contain the word android");
        }
    }

    @Test
    @Description("This test opens the all regions dropdown and verifies there are more than 10 regions available")
    public void countNumberOfRegions() {
        duckDuckGoHomePage = new DuckDuckGoHomePage(driver);

        duckDuckGoHomePage.get("https://start.duckduckgo.com/");

        log.info("Performing search for 'android'");
        duckDuckGoResultsPage = duckDuckGoHomePage.searchFor("android");

        duckDuckGoResultsPage.openAllRegionsDropDown();
        log.info("Number of regions available: {}", duckDuckGoResultsPage.numberOfRegions());
        Assertions.assertTrue(duckDuckGoResultsPage.numberOfRegions() > 10,
                "There are not enough regions available" + duckDuckGoResultsPage.numberOfRegions());
    }
}

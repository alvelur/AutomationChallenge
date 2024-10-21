package prediktive.challenge.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import prediktive.challenge.core.Page;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;


import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class DuckDuckGoHomePage extends Page {

    private static final By searchInput = By.id("searchbox_input");

    public DuckDuckGoHomePage(WebDriver driver) {
        super(driver);
    }

    /**
     * Enters the specified search text into the search input field and submits the search.
     *
     *  @param text the search query to be entered into the search input field
     *  @throws NoSuchElementException if the search input field is not found
     */
    public DuckDuckGoResultsPage searchFor(String text) {
        waitFor(presenceOfElementLocated(searchInput)).sendKeys(text ,Keys.ENTER);
        return new DuckDuckGoResultsPage(this.getWebDriver());
    }

}

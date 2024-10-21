package prediktive.challenge.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import prediktive.challenge.core.Page;

import java.util.List;
import java.util.stream.Collectors;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfAllElementsLocatedBy;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class DuckDuckGoResultsPage extends Page {

    private static final By resultList = By.xpath("//ol[@class='react-results--main']//h2/a/span");
    private static final By allRegionsDropDown = By.xpath("//a[@data-testid='region-filter-label']");
    private static final By allRegionsDropDownOptions = By.xpath("//div[@class='fCp5GIWYTsUwPglO0ME2 eRQYVfFPOfM6ezz54H_V AgWckucr2h5uZCHmaoMA']//div[@class='BDI1KtNF8HUPBZ4Cw_nK']");

    public DuckDuckGoResultsPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getResultsTitles() {
        waitFor(presenceOfAllElementsLocatedBy(resultList));
        return findElements(resultList).stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public void openAllRegionsDropDown() {
        waitFor(presenceOfElementLocated(allRegionsDropDown)).click();
    }

    public int numberOfRegions(){
        return waitFor(presenceOfAllElementsLocatedBy(allRegionsDropDownOptions)).size();
    }

}

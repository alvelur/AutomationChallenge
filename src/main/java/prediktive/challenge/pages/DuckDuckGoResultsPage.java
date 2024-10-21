package prediktive.challenge.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import prediktive.challenge.core.Page;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfAllElementsLocatedBy;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class DuckDuckGoResultsPage extends Page {

    private static final By resultList = By.xpath("//ol[@class='react-results--main']//h2/a/span");

    public DuckDuckGoResultsPage(WebDriver driver) {
        super(driver);
    }

//    public List<String> getResultsTitles() {
//        waitFor(presenceOfAllElementsLocatedBy(resultList));
//
//        for (WebElement element : findElements(resultList)){
//            element.getText();
//        }
//    }


}

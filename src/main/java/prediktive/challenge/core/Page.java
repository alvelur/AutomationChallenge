package prediktive.challenge.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class Page extends Navigable{

    public Page(final WebDriver webDriver) {
        super(webDriver);
    }

    public void get(String url) {
        getWebDriver().get(url);
    }

    public String getCurrentUrl() {
        return getWebDriver().getCurrentUrl();
    }

    public String getTitle() {
        return getWebDriver().getTitle();
    }
}

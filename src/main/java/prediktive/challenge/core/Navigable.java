package prediktive.challenge.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

public abstract class Navigable{

    private static final Duration defaultWaitDuration = Duration.ofSeconds(20L);

    private final WebDriver webDriver;

    private final WebDriverWait webDriverWait;

    public Navigable(final WebDriver webDriver) {
        this.webDriver = webDriver;
        this.webDriverWait = new WebDriverWait(webDriver, defaultWaitDuration);
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }

    protected <V> V waitFor(final Function<? super WebDriver, V> isTrue) {
        return webDriverWait.until(isTrue);
    }

    public WebElement findElement(final By by) {
        return getWebDriver().findElement(by);
    }

    public List<WebElement> findElements(final By by) {
        return getWebDriver().findElements(by);
    }
}

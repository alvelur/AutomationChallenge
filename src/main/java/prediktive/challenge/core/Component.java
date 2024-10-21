package prediktive.challenge.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class Component extends Navigable {

    private final WebElement rootElement;

    public Component(WebDriver webDriver, WebElement rootElement) {
        super(webDriver);
        this.rootElement = rootElement;
    }

    protected WebElement getRootElement() {
        return rootElement;
    }

}

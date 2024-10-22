package prediktive.challenge.base;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.WebDriver;
import prediktive.challenge.core.DriverFactory;

@Slf4j
public class BaseUiTest {

    protected WebDriver driver;

    @BeforeEach
    public void setUp(TestInfo testInfo) {
        log.info("Starting test: {}", testInfo.getDisplayName());
        driver = DriverFactory.initializeDriver("chrome");
        log.info("Driver initialized");
    }

    @AfterEach
    public void tearDown(TestInfo testInfo) {
        log.info("Test completed: {}", testInfo.getDisplayName());
        DriverFactory.quitDriver(driver);
        log.info("Driver session quit successfully.");
    }
}

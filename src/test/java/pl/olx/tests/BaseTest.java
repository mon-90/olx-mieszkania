package pl.olx.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pl.olx.utils.DriverManager;
import pl.olx.utils.DriverUtils;

public class BaseTest {

    @BeforeMethod
    public void beforeTest() {
        DriverManager.getWebDriver();
        DriverUtils.setInitialConfiguration();
        DriverUtils.navigateToPage("https://www.olx.pl/d/nieruchomosci/mieszkania/sprzedaz/");
    }

    @AfterMethod
    public void afterTest() {
        DriverManager.disposeDriver();
    }
}
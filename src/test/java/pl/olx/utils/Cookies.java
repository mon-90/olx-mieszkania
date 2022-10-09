package pl.olx.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pl.olx.waits.WaitForElement;

public class Cookies {

    public static void acceptCookies() {
        WebElement cookiesBtn = DriverManager.getWebDriver().findElement(By.id("onetrust-accept-btn-handler"));
        WaitForElement.waitUntilElementIsClickable(cookiesBtn);
        cookiesBtn.click();
    }
}
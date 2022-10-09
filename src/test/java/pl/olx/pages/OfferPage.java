package pl.olx.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.olx.utils.DriverManager;
import pl.olx.waits.WaitForElement;

public class OfferPage {

    @FindBy(css = "div[data-testid='ad-price-container'] > h3")
    private WebElement price;

    public OfferPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public String getPrice() {
        WaitForElement.waitUntilElementIsVisible(price);
        return price.getText();
    }
}
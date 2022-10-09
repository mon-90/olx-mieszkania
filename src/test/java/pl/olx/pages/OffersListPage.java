package pl.olx.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pl.olx.utils.DriverManager;
import pl.olx.waits.WaitForElement;

import java.util.*;

public class OffersListPage {

    @FindBy(css = "input[data-testid='location-search-input']")
    private WebElement locationSearch;

    @FindBy(xpath = "//span[text()='Poznań, Wielkopolskie']")
    private WebElement locationListItem;

    @FindBy(css = "button[data-testid='search-submit']")
    private WebElement searchBtn;

    // xpath = "(//input[@data-testid='range-from-input'])[1]"
    @FindBy(xpath = "//p[text()='Cena ']/following-sibling::div//input[@data-testid='range-from-input']")
    private WebElement priceFrom;

    // xpath = "(//input[@data-testid='range-to-input'])[1]"
    @FindBy(xpath = "//p[text()='Cena ']/following-sibling::div//input[@data-testid='range-to-input']")
    private WebElement priceTo;

    @FindBy(css = "div[data-testid='listing-grid']>div:nth-child(4)")
    private WebElement selectedThirdOffer;

    @FindBy(xpath = "(//div[@data-testid='listing-grid']//p[@data-testid='ad-price'])[3]")
    private WebElement priceSelectedThirdOfferOnList;

    public OffersListPage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public List<WebElement> searchOffersByCity(String city) throws InterruptedException {
        WaitForElement.waitUntilElementIsVisible(locationSearch);
        locationSearch.sendKeys(city);
        WaitForElement.waitUntilElementIsVisible(locationListItem);
        locationListItem.click();

        Thread.sleep(1000);
        List<WebElement> locationOffersCards = DriverManager.getWebDriver().findElements(By.cssSelector("p[data-testid='location-date']"));

        return locationOffersCards;

        // TODO: znalezienie lepszego sposobu oczekiwania na odświeżenie listy locationOffersCards
    }

    public List<WebElement> searchOffersByPrice(String minPrice, String maxPrice) throws InterruptedException {
        WaitForElement.waitUntilElementIsClickable(priceFrom);
        priceFrom.sendKeys(minPrice);
        WaitForElement.waitUntilElementIsClickable(priceTo);
        priceTo.sendKeys(maxPrice);
        WaitForElement.waitUntilElementIsClickable(searchBtn);
        searchBtn.click();

        Thread.sleep(1000);
        List<WebElement> priceOffersCards = DriverManager.getWebDriver().findElements(By.cssSelector("p[data-testid='ad-price']"));

        return priceOffersCards;

        // TODO: znalezienie lepszego sposobu oczekiwania na odświeżenie listy priceOffersCards
    }

    public String showThirdOffer() {
        WaitForElement.waitUntilElementIsVisible(priceSelectedThirdOfferOnList);
        String priceFromList = priceSelectedThirdOfferOnList.getText();
        WaitForElement.waitUntilElementIsClickable(selectedThirdOffer);
        selectedThirdOffer.click();

        return priceFromList;
    }
}
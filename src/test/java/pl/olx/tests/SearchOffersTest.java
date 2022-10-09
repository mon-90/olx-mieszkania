package pl.olx.tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pl.olx.pages.OffersListPage;
import pl.olx.utils.Cookies;

import java.util.List;

public class SearchOffersTest extends BaseTest {

    @Test
    public void searchOffersByCity() throws InterruptedException {
        OffersListPage offersListPage = new OffersListPage();
        Cookies.acceptCookies();

        List<WebElement> locations = offersListPage.searchOffersByCity("Poznań");

        for(WebElement element : locations) {
            //System.out.println(element.getText());
            Assert.assertTrue(element.getText().contains("Poznań"));
        }
    }

    @Test
    public void searchOffersByPrice() throws InterruptedException {
        int minPrice = 100000;
        int maxPrice = 200000;

        OffersListPage offersListPage = new OffersListPage();
        Cookies.acceptCookies();

        List<WebElement> prices = offersListPage.searchOffersByPrice(String.valueOf(minPrice), String.valueOf(maxPrice));

        for(WebElement element : prices) {
            String priceWithoutCurrency;

            if(element.getText().contains("do negocjacji")) {
                priceWithoutCurrency = element.getText().substring(0, element.getText().length() - 17);
            } else {
                priceWithoutCurrency = element.getText().substring(0, element.getText().length() - 3);
            }

            StringBuilder sb = new StringBuilder(priceWithoutCurrency);
            String priceWithoutSpace = sb.deleteCharAt(sb.length() - 4).toString();
            //System.out.println(priceWithoutSpace);
            int priceInInt = Integer.parseInt(priceWithoutSpace);

            Assert.assertTrue(priceInInt >= minPrice && priceInInt <= maxPrice);
        }
    }
}
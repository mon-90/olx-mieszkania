package pl.olx.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.olx.pages.OfferPage;
import pl.olx.pages.OffersListPage;
import pl.olx.utils.Cookies;

public class ShowOfferTest extends BaseTest {

    @Test
    public void showThirdOffer() {
        OffersListPage offersListPage = new OffersListPage();
        Cookies.acceptCookies();

        String priceFromList = offersListPage.showThirdOffer();

        OfferPage offerPage = new OfferPage();
        String priceFromOffer = offerPage.getPrice();

        //System.out.println(priceFromList + " - price from list BEFORE substring");
        //System.out.println(priceFromOffer + " - price from offer BEFORE substring");

        if(priceFromList.contains("do negocjacji"))
            priceFromList = priceFromList.substring(0, priceFromList.length() - 14);

        //System.out.println(priceFromList + " - price from list AFTER substring");
        //System.out.println(priceFromOffer + " - price from offer AFTER substring");

        Assert.assertEquals(priceFromList, priceFromOffer);

        // TODO: do obsługi sytuacja, gdy nowa oferta otwiera się na otodom, a nie na olx
    }
}
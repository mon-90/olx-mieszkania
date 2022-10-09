package pl.olx.utils;

public class DriverUtils {

    public static void setInitialConfiguration() {
        //DriverManager.getWebDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        DriverManager.getWebDriver().manage().window().maximize();
    }

    public static void navigateToPage(String url) {
        DriverManager.getWebDriver().navigate().to(url);
    }
}
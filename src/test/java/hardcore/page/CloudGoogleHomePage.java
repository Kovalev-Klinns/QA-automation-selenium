package hardcore.page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CloudGoogleHomePage extends AbstractPage {
    private static final String HOME_URL = "https://cloud.google.com";

    @FindBy(xpath = "//input[@placeholder='Результаты поиска']")
    WebElement searchingField;

    public CloudGoogleHomePage(WebDriver driver) {
        super(driver);
    }

    public CloudGoogleHomePage openPage() {
        driver.get(HOME_URL);
        explicitWaitForElementVisibility(searchingField, 30);
        return this;
    }

    public CloudGoogleResultsPage toFind(String input) {
        searchingField.sendKeys(input + Keys.ENTER);
        return new CloudGoogleResultsPage(driver);
    }
}

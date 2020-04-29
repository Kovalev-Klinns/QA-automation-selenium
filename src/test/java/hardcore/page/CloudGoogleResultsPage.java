package hardcore.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CloudGoogleResultsPage extends AbstractPage {

    @FindBy(linkText = "Google Cloud Platform Pricing Calculator")
    WebElement googleCloudCalculatorLink;

    public CloudGoogleResultsPage(WebDriver driver) {
        super(driver);
    }

    public GoogleCloudCalculatorPage openGoogleCloudCalculatorLink() {
        explicitWaitForElementVisibility(googleCloudCalculatorLink, 35);
        googleCloudCalculatorLink.click();
        return new GoogleCloudCalculatorPage(driver);
    }
}

package hardcore.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TenMinutesEmail extends AbstractPage {

    @FindBy(id = "mail")
    WebElement emailAddress;

    @FindBy(linkText = "Google Cloud Platform Price Estimate")
    WebElement messageBtn;

    @FindBy(xpath = "//*[@id='mobilepadding']//td[2]/h3")
    WebElement totalCostInLetter;

    public TenMinutesEmail(WebDriver driver) {
        super(driver);
    }

    public TenMinutesEmail openPageInNewWindow() {
        ((JavascriptExecutor) driver).executeScript("window.open('https://10minemail.com/ru/')");

        for(String tab : driver.getWindowHandles()) {
            driver.switchTo().window(tab);
        }
        return this;
    }

    public String getEmailAddress() {
        return emailAddress.getAttribute("value");
    }

    public TenMinutesEmail expandMessage() {
        explicitWaitForElementVisibility(messageBtn, 80);
        clickElement(messageBtn);
        return this;
    }

    public TenMinutesEmail switchToPage() {
        for(String tab : driver.getWindowHandles()) {
            driver.switchTo().window(tab);
        }
        return this;
    }

    public String getTotalCostInLetterText() {
       return totalCostInLetter.getText();
    }
}

package hardcore.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {
    protected WebDriver driver;

    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    void clickElement(WebElement webElement) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", webElement);
    }

    void explicitWaitForElementVisibility(WebElement webElement, int waitingTime) {
        new WebDriverWait(driver, waitingTime)
                .until(ExpectedConditions.visibilityOf(webElement));
    }
}

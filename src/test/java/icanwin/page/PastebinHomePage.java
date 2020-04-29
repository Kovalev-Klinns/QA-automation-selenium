package icanwin.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PastebinHomePage {
    private WebDriver driver;
    private static final String HOME_URL = "https://pastebin.com";

    @FindBy(id = "paste_code")
    private WebElement newPasteField;

    @FindBy(xpath = "//*[@id='myform']/div[3]/div[2]//span/span[1]//span[2]")
    private WebElement pasteExpirationBtn;

    @FindBy(xpath = "//option[@value='10M']")
    private WebElement tenMinutesPasteExpiration;

    @FindBy(xpath = "//input[@name='paste_name']")
    private WebElement titleField;

    @FindBy(id = "submit")
    private WebElement createNewPasteBtn;

    public PastebinHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public PastebinHomePage openPage() {
        driver.get(HOME_URL);
        new WebDriverWait (driver, 10)
                .until(ExpectedConditions.visibilityOf(newPasteField));
        return this;
    }

    public PastebinHomePage inputNewPaste(String input) {
        newPasteField.sendKeys(input);
        return this;
    }

    public PastebinHomePage setTenMinutesPasteExpiration ()  {
        pasteExpirationBtn.click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.tagName(tenMinutesPasteExpiration.getTagName())));
        tenMinutesPasteExpiration.click();
        pasteExpirationBtn.click();
        return this;
    }

    public PastebinHomePage inputTitle(String input) {
        titleField.sendKeys(input);
        return this;
    }

    public PastebinHomePage createNewPaste() {
        createNewPasteBtn.click();
        return this;
    }
}
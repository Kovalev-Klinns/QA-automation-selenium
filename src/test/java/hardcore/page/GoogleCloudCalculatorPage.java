package hardcore.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleCloudCalculatorPage extends AbstractPage {

    @FindBy(xpath = "//*[@id='cloud-site']/devsite-iframe/iframe")
    WebElement firstFrame;

    @FindBy(id = "myFrame")
    WebElement secondFrame;

    @FindBy(id = "input_58")
    WebElement instancesField;

    @FindBy(id = "select_value_label_51")
    WebElement operatingSystemBtn;

    @FindBy(id = "select_option_60")
    WebElement necessaryOperatingSystem;

    @FindBy(id = "select_value_label_52")
    WebElement machineClassBtn;

    @FindBy(id = "select_option_72")
    WebElement necessaryMachineClass;

    @FindBy(id = "select_value_label_55")
    WebElement machineTypeBtn;

    @FindBy(id = "select_option_212")
    WebElement necessaryMachineType;

    @FindBy(xpath = "//md-checkbox[@aria-label='Add GPUs']")
    WebElement addGpusCheckbox;

    @FindBy(id = "select_value_label_332")
    WebElement numberOfGpusBtn;

    @FindBy(id = "select_option_341")
    WebElement necessaryGpus;

    @FindBy(id = "select_value_label_333")
    WebElement gpuTypeBtn;

    @FindBy(id = "select_option_346")
    WebElement necessaryGpuType;

    @FindBy(id = "select_value_label_169")
    WebElement localSsdBtn;

    @FindBy(id = "select_option_233")
    WebElement necessaryLocalSsd;

    @FindBy(id = "select_value_label_56")
    WebElement dataCenterLocationBtn;

    @FindBy(id = "select_option_181")
    WebElement necessaryCenterLocationBtn;

    @FindBy(id = "select_value_label_57")
    WebElement commitedUsageBtn;

    @FindBy(id = "select_option_90")
    WebElement necessaryCommitedUsage;

    @FindBy(xpath = "//button[@aria-label='Add to Estimate']")
    WebElement addToEstimateBtn;

    @FindBy(id = "email_quote")
    WebElement emailEstimateBtn;

    @FindBy(id = "input_401")
    WebElement emailField;

    @FindBy(xpath = "//button[@aria-label='Send Email']")
    WebElement sendLetterToEmailBtn;

    @FindBy(xpath = "//*[@id='resultBlock']//h2/b")
    WebElement totalCost;


    public GoogleCloudCalculatorPage(WebDriver driver) {
       super(driver);
    }

    public GoogleCloudCalculatorPage switchFrame() {
        driver.switchTo().frame(firstFrame).switchTo().frame(secondFrame);
        return this;
    }


    public GoogleCloudCalculatorPage setInstances(String numberOfInstances) {
        explicitWaitForElementVisibility(instancesField, 30);
        instancesField.sendKeys(numberOfInstances);
        return this;
    }

    public GoogleCloudCalculatorPage setFreeOperatingSystem()  {
        clickElement(operatingSystemBtn);
        clickElement(necessaryOperatingSystem);
        return this;
    }

    public GoogleCloudCalculatorPage setRegularMachineClass() {
        clickElement(machineClassBtn);
        clickElement(necessaryMachineClass);
        return this;
    }

    public GoogleCloudCalculatorPage setMachineType() {
        clickElement(machineTypeBtn);
        clickElement(necessaryMachineType);
        return this;
    }

    public GoogleCloudCalculatorPage addGPUS() {
        clickElement(addGpusCheckbox);
        explicitWaitForElementVisibility(numberOfGpusBtn, 15);
        clickElement(numberOfGpusBtn);
        clickElement(necessaryGpus);
        clickElement(numberOfGpusBtn);
        clickElement(gpuTypeBtn);
        clickElement(necessaryGpuType);
        return this;
    }

    public GoogleCloudCalculatorPage setLocalSsd() {
        clickElement(localSsdBtn);
        clickElement(necessaryLocalSsd);
        return this;
    }

    public GoogleCloudCalculatorPage setDataCenterLocation() {
        clickElement(dataCenterLocationBtn);
        clickElement(necessaryCenterLocationBtn);
        return this;
    }

    public GoogleCloudCalculatorPage setCommitedUsage() {
        clickElement(commitedUsageBtn);
        clickElement(necessaryCommitedUsage);
        return this;
    }

    public GoogleCloudCalculatorPage addToEstimate() {
        clickElement(addToEstimateBtn);
        return this;
    }

    public TenMinutesEmail emailEstimate() {
        clickElement(emailEstimateBtn);
        return new TenMinutesEmail(driver);
    }

    public GoogleCloudCalculatorPage pasteEmailAddressToField(String emailAddress) {
        emailField.sendKeys(emailAddress);
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.attributeContains(emailField, "value", emailAddress));
        return this;
    }

    public TenMinutesEmail sendLetterToEmail() {
        clickElement(sendLetterToEmailBtn);
        return new TenMinutesEmail(driver);
    }

    public GoogleCloudCalculatorPage switchToPage() {
        for(String tab : driver.getWindowHandles()) {
            driver.switchTo().window(tab);
            break;
        }
        switchFrame();
        return this;
    }

    public String getTotalCost() {
        return totalCost.getText();
    }
}
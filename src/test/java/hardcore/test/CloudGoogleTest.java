package hardcore.test;

import hardcore.page.CloudGoogleHomePage;
import hardcore.page.GoogleCloudCalculatorPage;
import hardcore.page.TenMinutesEmail;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CloudGoogleTest {
    private WebDriver driver;
    private String searchText = "Google Cloud Platform Pricing Calculator";
    private String necessaryNumberOfInstances = "4";
    private String emailAddress;
    String totalCostInLetter;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        driver = new ChromeDriver();
        CloudGoogleHomePage cloudGoogleHomePage = new CloudGoogleHomePage(driver);
        cloudGoogleHomePage
                .openPage()
                .toFind(searchText)
                .openGoogleCloudCalculatorLink()
                .switchFrame()
                .setInstances(necessaryNumberOfInstances)
                .setFreeOperatingSystem()
                .setRegularMachineClass()
                .setMachineType()
                .addGPUS()
                .setLocalSsd()
                .setDataCenterLocation()
                .setCommitedUsage()
                .addToEstimate();
    }

    @Test
    public void cloudGoogleCalculatorEmailLetterTest() {
        GoogleCloudCalculatorPage googleCloudCalculatorPage = new GoogleCloudCalculatorPage(driver);
        TenMinutesEmail tenMinutesEmail = new TenMinutesEmail(driver);
        googleCloudCalculatorPage
                .emailEstimate()
                .openPageInNewWindow();
        emailAddress = tenMinutesEmail.getEmailAddress();
        googleCloudCalculatorPage
                .switchToPage()
                .pasteEmailAddressToField(emailAddress)
                .sendLetterToEmail()
                .switchToPage()
                .expandMessage();
        totalCostInLetter = tenMinutesEmail.getTotalCostInLetterText();
        googleCloudCalculatorPage
                .switchToPage()
                .getTotalCost();
        Assert.assertTrue(googleCloudCalculatorPage.getTotalCost().contains(totalCostInLetter));
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
}

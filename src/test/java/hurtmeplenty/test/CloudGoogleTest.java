package hurtmeplenty.test;

import hurtmeplenty.page.CloudGoogleHomePage;
import hurtmeplenty.page.CloudGoogleResultsPage;
import hurtmeplenty.page.GoogleCloudCalculatorPage;
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
    private String expectedVMClass = "VM class: regular";
    private String expectedInstanceType = "Instance type: n1-standard-8";
    private String expectedRegion = "Region: Frankfurt";
    private String expectedLocalSSD = "Total available local SSD space 2x375 GiB";
    private String expectedCommitmentTerm = "Commitment term: 1 Year";
    private String expectedTotalEstimatedCost = "Total Estimated Cost: USD 1,082.77 per 1 month";

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        driver = new ChromeDriver();
        CloudGoogleHomePage cloudGoogleHomePage = new CloudGoogleHomePage(driver);
        CloudGoogleResultsPage cloudGoogleResultsPage = new CloudGoogleResultsPage(driver);
        GoogleCloudCalculatorPage googleCloudCalculatorPage = new GoogleCloudCalculatorPage(driver);

        cloudGoogleHomePage
                .openPage()
                .toFind(searchText)
                .openGoogleCloudCalculatorLink()
                .switchFrame()
                .setInstances(necessaryNumberOfInstances)
                .setFreeOperatingSystem()
                .setRegularMachineClass()
                .setMachineType()
                .addGpus()
                .setLocalSsd()
                .setDataCenterLocation()
                .setCommitedUsage()
                .addToEstimate();
    }

    @Test
    public void cloudGoogleCalculatorVMClassTest()  {
        GoogleCloudCalculatorPage googleCloudCalculatorPage = new GoogleCloudCalculatorPage(driver);
        Assert.assertEquals(googleCloudCalculatorPage.getResultVMClassText(), expectedVMClass);
    }

    @Test
    public void cloudGoogleCalculatorInstanceTypeTest() {
        GoogleCloudCalculatorPage googleCloudCalculatorPage = new GoogleCloudCalculatorPage(driver);
        Assert.assertEquals(googleCloudCalculatorPage.getResultInstanceTypeText(), expectedInstanceType);
    }

    @Test
    public void cloudGoogleCalculatorRegionTest() {
        GoogleCloudCalculatorPage googleCloudCalculatorPage = new GoogleCloudCalculatorPage(driver);
        Assert.assertEquals(googleCloudCalculatorPage.getResultRegionText(), expectedRegion);
    }

    @Test
    public void cloudGoogleCalculatorLocalSSDTest() {
        GoogleCloudCalculatorPage googleCloudCalculatorPage = new GoogleCloudCalculatorPage(driver);
        Assert.assertEquals(googleCloudCalculatorPage.getResultLocalSSDText(), expectedLocalSSD);
    }

    @Test
    public void cloudGoogleCalculatorCommitmentTermTest() {
        GoogleCloudCalculatorPage googleCloudCalculatorPage = new GoogleCloudCalculatorPage(driver);
        Assert.assertEquals(googleCloudCalculatorPage.getResultCommitmentTermText(), expectedCommitmentTerm);
    }

    @Test
    public void cloudGoogleCalculatorTotalEstimatedCostTest() {
        GoogleCloudCalculatorPage googleCloudCalculatorPage = new GoogleCloudCalculatorPage(driver);
        Assert.assertEquals(googleCloudCalculatorPage.getResultTotalEstimatedCostText(), expectedTotalEstimatedCost);
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
}

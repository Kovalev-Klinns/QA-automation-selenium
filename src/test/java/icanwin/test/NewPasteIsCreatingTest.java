package icanwin.test;

import icanwin.page.PastebinHomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//Открыть https://pastebin.com или аналогичный сервис в любом браузере
//Создать New Paste со следующими деталями:
//* Код: "Hello from WebDriver"
//* Paste Expiration: "10 Minutes"
//* Paste Name / Title: "helloweb"

public class NewPasteIsCreatingTest {
     WebDriver driver;
     String code = "Hello from WebDriver";
     String titleName = "helloweb";

     @BeforeMethod(alwaysRun = true)
     public void setBrowser() {
         driver = new ChromeDriver();
     }

    @Test
    public void newPasteIsCreatingTest() {
        PastebinHomePage pastebinHomePage = new PastebinHomePage(driver);
        pastebinHomePage
                .openPage()
                .inputNewPaste(code)
                .setTenMinutesPasteExpiration()
                .inputTitle(titleName)
                .createNewPaste();
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
         driver.quit();
    }
}

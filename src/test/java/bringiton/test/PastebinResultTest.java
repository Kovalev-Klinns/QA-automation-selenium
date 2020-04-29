package bringiton.test;

import bringiton.page.PastebinHomePage;
import bringiton.page.PastebinPastePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class PastebinResultTest {
    private WebDriver driver;
    private String code = "git config --global user.name  \"New Sheriff in Town\"\n" +
            "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
            "git push origin master --force";
    private String titleName = "how to gain dominance among developers";
    private List<String> expectedHighLightedSyntax = new ArrayList<>();
    private List<String> codeStrings = new ArrayList<>();

    @BeforeMethod(alwaysRun = true)
    public void setUp() {
        driver = new ChromeDriver();

        expectedHighLightedSyntax.add("git config");
        expectedHighLightedSyntax.add("git reset");
        expectedHighLightedSyntax.add("git commit-tree");
        expectedHighLightedSyntax.add("tree");
        expectedHighLightedSyntax.add("git push");

        codeStrings.add("git config --global user.name  \"New Sheriff in Town\"");
        codeStrings.add("git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")");
        codeStrings.add("git push origin master --force");

        PastebinPastePage pastebinPastePage = new PastebinPastePage(driver);
        PastebinHomePage pastebinHomePage = new PastebinHomePage(driver);
        pastebinHomePage
                .openPage()
                .inputNewPaste(code)
                .setBushSyntaxHighlighting()
                .setTenMinutesPasteExpiration()
                .inputTitle(titleName + " " + Math.round(Math.random() * 100))
                .createNewPaste();
    }

    @Test
    public void bashSyntaxHighlightedTest() {
        PastebinPastePage pastebinPastePage = new PastebinPastePage(driver);
        Assert.assertTrue(pastebinPastePage.isSyntaxHighlighted(expectedHighLightedSyntax), "Bash syntax is not highlighted");
    }

    @Test
    public void isTitleNameCorrect() {
        Assert.assertTrue(driver.getTitle().contains(titleName));
    }

    @Test
    public void isCodeCorrect() {
        PastebinPastePage pastebinPastePage = new PastebinPastePage(driver);
        Assert.assertTrue(pastebinPastePage.isCodeCorrect(codeStrings));
    }


    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        driver.quit();
    }
}

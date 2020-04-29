package bringiton.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class PastebinPastePage {
    private WebDriver driver;

    @FindBy(xpath = "//span[@class ='kw2']")
    List<WebElement> highlightedSyntax;

    @FindBy(xpath = "//li[@class='li1']")
    List<WebElement> codeStrings;

    public PastebinPastePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isSyntaxHighlighted(List<String> expectedHighLightedSyntax) {
        List<String> list = new ArrayList<>();
        for(int i = 0; i < highlightedSyntax.size(); i++) {
            list.add(highlightedSyntax.get(i).getText());
        }
        if (list.equals(expectedHighLightedSyntax)) {
            return true;
        }
        else {
            return false;
        }
    }

    public boolean isCodeCorrect (List<String> expectedCodeList) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < codeStrings.size(); i++) {
            list.add(codeStrings.get(i).getText());
        }
        if (list.equals(expectedCodeList)) {
            return true;
        } else {
            return false;
        }
    }
}

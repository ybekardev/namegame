package spring.pages;

import com.google.common.base.Verify;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import spring.utils.ConfigurationReader;
import spring.utils.Driver;
import spring.utils.BrowserUtil;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.valueOf;

public class LoginPage {

    @FindBy(css = "span[class=streak]")
    public WebElement streak;

    @FindBy(css = "span[class='correct']")
    public WebElement correct;

    @FindBy(css = "div[class='photo correct']")
    public WebElement photoName;

    @FindBy(css = "div[data-n='0']")
    public WebElement firstPicture;

    @FindBy(css = "div[data-n='1']")
    public WebElement secondPicture;

    @FindBy(css = "div[data-n='2']")
    public WebElement thirdPicture;

    @FindBy(css = "div[data-n='3']")
    public WebElement fourthPicture;

    @FindBy(css = "div[data-n='4']")
    public WebElement fifthPicture;

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void goToLandingPage(){
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    public void countingStrikes(){
        BrowserUtil.waitPlease(8);

        List<WebElement> webElementList = new ArrayList<>();
        webElementList.add(firstPicture);
        webElementList.add(secondPicture);
        webElementList.add(thirdPicture);
        webElementList.add(fourthPicture);
        webElementList.add(fifthPicture);

        int streakCounter = 0;
        while(true)
        for(WebElement wel : webElementList){

            wel.click();
            BrowserUtil.waitPlease(3);

            // Then Verify the streak counter is incrementing on correct selections
            if(streak.getText().equals("1")){
                streakCounter++;
                System.out.println("Streak trial number: " + streak.getText());
                System.out.println("SUCCESS, Streak is incremented by: " + streak.getText());

                // Verify name and displayed photos change after selecting the correct answer
                System.out.println("The displayed photo is changed after clicking from photo to: " + photoName.getAttribute("class"));
                assert (photoName.getAttribute("class").equals("photo correct"));

                //Verify that the correct counters are being incremented for tries and correct counters
                assert (valueOf(streakCounter).equals(correct.getText()));
                System.out.println("Correct number of trials: " + correct.getText());
                continue;
            }

            System.out.println("Streak trial number: " + streak.getText());
            String vl = streak.getText();

            // Verify the multiple “streak” counter resets after getting an incorrect answer
            assert (vl.equals("0"));

        }
    }
}

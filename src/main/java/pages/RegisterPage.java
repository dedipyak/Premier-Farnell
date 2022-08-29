package pages;

import com.browserPackage.BaseClass;
import com.browserPackage.Log;
import com.utility.Utility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.io.IOException;
import java.util.List;

public class RegisterPage extends BaseClass {

    public RegisterPage(WebDriver driver) throws IOException {
        RegisterPage.driver = driver;
        PageFactory.initElements(RegisterPage.driver, this);
    }

    @FindBy(how = How.XPATH,using = "//input[contains(@id,'_username')]")
    private WebElement userNameField;

    @FindBy(how = How.XPATH,using = "//input[contains(@id,'_email')]")
    private WebElement emailField;

    @FindBy(how = How.XPATH,using = "(//input[contains(@id,'_password')])[1]")
    private WebElement passwordField;

    @FindBy(how = How.XPATH,using = "//input[contains(@id,'_password2')]")
    private WebElement confirmPasswordField;

    @FindBy(how = How.XPATH,using = "//select[contains(@id,'_country')]")
    private WebElement countryField;

    @FindBy(how = How.XPATH,using = "//input[contains(@id,'_first-name')]")
    private WebElement firstNameField;

    @FindBy(how = How.XPATH,using = "//input[contains(@id,'_last-name')]")
    private WebElement lastNameField;

    @FindBy(how = How.XPATH,using = "//input[contains(@id,'_acceptAgreement')]")
    private WebElement acceptAgreementBox;

    @FindBy(how = How.XPATH,using = "//a[contains(text(),'Join now')]")
    private WebElement joinNowButton;

    @FindBy(how = How.XPATH,using = "//div[@class='recaptcha-checkbox-border']")
    private List<WebElement> captchaButton;

    @FindBy(how = How.XPATH,using = "//div[@id='rc-imageselect']//div[@class='button-holder help-button-holder']")
    private WebElement skipsolveButton;

    @FindBy(how = How.XPATH,using = "//iframe[@title='reCAPTCHA']")
    private WebElement captchaIframe;

    @FindBy(how = How.XPATH,using = "//iframe[contains(@title,'recaptcha challenge')]")
    private WebElement secondCaptchaFrame;

    String randomVal = Utility.getCurrentTime();

    public void enterSignInUserName() throws IOException {
        String userName = Utility.getConfigProperty("signinName")+randomVal;
        sendKeys(userNameField,userName);
    }

    public void enterEmail() throws IOException {
        String email = "autotest"+randomVal+"@gmail.com";
        sendKeys(emailField,email);
    }

    public void enterPassword() throws IOException {
        String pwd = Utility.getConfigProperty("password");
        sendKeys(passwordField,pwd);
    }

    public void enterConfirmPassword() throws IOException {
        String pwd = Utility.getConfigProperty("password");
        sendKeys(confirmPasswordField,pwd);
    }

    public void selectCountry() throws IOException {
        String country = Utility.getConfigProperty("country");
        Select countryDropDown = new Select(countryField);
        countryDropDown.selectByVisibleText(country);
    }

    public void enterFirstName() throws IOException {
        String firstName = Utility.getConfigProperty("firstname")+randomVal;
        sendKeys(firstNameField,firstName);
    }

    public void enterLastName() throws IOException {
        String lastName = Utility.getConfigProperty("lastname")+randomVal;
        sendKeys(lastNameField,lastName);
    }

    public void clickAgreeAgreement()
    {
        click(acceptAgreementBox);
    }

    public void clickJoinNow()
    {
      // below code is for buster.crx to skip the captcha 
      //  driver.switchTo().frame(captchaIframe);
        
      //  if(captchaButton.size()>0)
      //  {
      //      click(captchaButton.get(0));
      //      threadSleep(30);
      //      driver.switchTo().defaultContent();
      //     driver.switchTo().frame(secondCaptchaFrame);
      //      click(skipsolveButton);
      //      threadSleep(10);
      //  }
      //  driver.switchTo().defaultContent();
        threadSleep(10);
        click(joinNowButton);
    }
}

package common;

import com.browserPackage.BaseClass;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pages.RegisterPage;

import java.io.IOException;

public class RegisterPageTest extends BaseClass {

    public BaseClass baseClass;
    public RegisterPage registerPage;

    public RegisterPageTest(BaseClass base) throws IOException {
        registerPage = new RegisterPage(driver);
        this.baseClass = base;
    }

    @Then("User enters the required details")
    public void userEntersTheRequiredDetails() throws IOException {
        registerPage.enterSignInUserName();
        registerPage.enterEmail();
        registerPage.enterPassword();
        registerPage.enterConfirmPassword();
        registerPage.selectCountry();
        registerPage.enterFirstName();
        registerPage.enterLastName();
        registerPage.clickAgreeAgreement();
    }

    @Then("User clicks on join now button")
    public void userClicksOnJoinNowButton() {
        threadSleep(10);
        registerPage.clickJoinNow();
    }
}

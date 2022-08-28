package pages;

import com.browserPackage.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.List;

public class HomePage extends BaseClass  {

    public HomePage(WebDriver driver) throws IOException {
        HomePage.driver = driver;
        PageFactory.initElements(HomePage.driver, this);
    }

    public void navigateToPage(String urlPage) {
        driver.get(urlPage);
    }

    @FindBy(how = How.XPATH,using = "//div[contains(@class,'user-links')]//a[@title='Register']/span")
    private WebElement registerButton;


    public void clickRegisterButton()
    {
        jsClick(registerButton);//click function is in base class which finds the element and clicks
    }

}

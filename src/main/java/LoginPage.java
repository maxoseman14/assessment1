import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    @FindBy (xpath = "//*[@id=\"txtUsername\"]")
    WebElement username;

    @FindBy (xpath = "//*[@id=\"txtPassword\"]")
    WebElement password;

    @FindBy (xpath = "//*[@id=\"btnLogin\"]")
    WebElement loginBtn;

    public void login (){
        username.sendKeys("Admin");
        password.sendKeys("AdminAdmin");
        loginBtn.click();
    }
}

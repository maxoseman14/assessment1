import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class EmployeeList {

    @FindBy(xpath = "//*[@id=\"employee_name_quick_filter_employee_list_value\"]")
    WebElement searchEmployee;

    @FindBy(xpath = "//*[@id=\"employeeListTable\"]/tbody/tr/td[3]")
    WebElement nameText;

    public Boolean searchForEmployee (WebDriver driver) throws InterruptedException {

        Actions action = new Actions(driver);

        String name = nameText.getText();

        searchEmployee.sendKeys("Bob Smith");
        action.sendKeys(Keys.ENTER);
        Thread.sleep(5000);

        if (name.equals("Bob Smith")){
            return true;
        } else {
            return false;
        }
    }
}

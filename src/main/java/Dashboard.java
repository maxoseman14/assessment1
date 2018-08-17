import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Dashboard {

    @FindBy(xpath = "//*[@id=\"menu_pim_viewPimModule\"]/a/span[2]")
    WebElement pimBtn;

    @FindBy(xpath = "//*[@id=\"menu_pim_addEmployee\"]/span[2]")
    WebElement addEmployeeBtn;

    //Create User GUI
    @FindBy(xpath = "//*[@id=\"pimAddEmployeeForm\"]/div[1]/div/materializecss-decorator[1]/div/sf-decorator/div/sf-decorator[1]/div/label")
    WebElement firstNameBtn;

    @FindBy(xpath = "//*[@id=\"firstName\"]")
    WebElement firstNameTxt;

    @FindBy(xpath = "//*[@id=\"pimAddEmployeeForm\"]/div[1]/div/materializecss-decorator[1]/div/sf-decorator/div/sf-decorator[3]/div/label")
    WebElement lastNameBtn;

    @FindBy(xpath = "//*[@id=\"lastName\"]")
    WebElement lastNameTxt;

    @FindBy(xpath = "//*[@id=\"location_inputfileddiv\"]/div/input")
    WebElement locationSelect;

    @FindBy(xpath = "//*[@id=\"select-options-0585b606-668c-c33a-e7f3-48aa98457f12\"]")
    WebElement dropDown;

    @FindBy(xpath = "//*[@id=\"location\"]/option[3]")
    WebElement location;

    //Create Login on GUI
    @FindBy(xpath = "//*[@id=\"pimAddEmployeeForm\"]/div[1]/div/materializecss-decorator[3]/div/sf-decorator/div/label")
    WebElement createLogin;

    @FindBy(xpath = "//*[@id=\"pimAddEmployeeForm\"]/div[1]/div/materializecss-decorator[4]/div/sf-decorator/div/sf-decorator[1]/div/label")
    WebElement usernameBtn;

    @FindBy(xpath = "//*[@id=\"username\"]")
    WebElement usernameTxt;

    @FindBy(xpath = "//*[@id=\"pimAddEmployeeForm\"]/div[1]/div/materializecss-decorator[4]/div/sf-decorator/div/sf-decorator[3]/div/div/label")
    WebElement passwordBtn;

    @FindBy(xpath = "//*[@id=\"password\"]")
    WebElement passwordTxt;

    @FindBy(xpath = "//*[@id=\"pimAddEmployeeForm\"]/div[1]/div/materializecss-decorator[4]/div/sf-decorator/div/sf-decorator[5]/div/div/label")
    WebElement confirmPassBtn;

    @FindBy(xpath = "//*[@id=\"confirmPassword\"]")
    WebElement confirmPassTxt;

    @FindBy(xpath = "//*[@id=\"essRoleId_inputfileddiv\"]/div/input")
    WebElement essRoleBtn;

    @FindBy(xpath = "//*[@id=\"essRoleId_inputfileddiv\"]")
    WebElement defaultESS;

    @FindBy(xpath = "//*[@id=\"supervisorRoleId_inputfileddiv\"]/div/input")
    WebElement supervisorBtn;

    @FindBy(xpath = "//*[@id=\"select-options-ed596df8-3cd2-b295-a57e-39abbdbc362b\"]/li[2]")
    WebElement defaultSuper;

    @FindBy(xpath = "//*[@id=\"systemUserSaveBtn\"]")
    WebElement saveBtn;

    //Search for Employee
    @FindBy(xpath = "//*[@id=\"menu_pim_viewPimModule\"]/div/ul/li[2]")
    WebElement employeeList;


    public void clickPIM() {
        pimBtn.click();
    }

    public void addEmployee() throws InterruptedException {
        addEmployeeBtn.click();
        Thread.sleep(20000);
    }


    public void employeeDetails(WebDriver driver) throws InterruptedException {

        //WebElement dynamicElement1 = (new WebDriverWait(driver, 15)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.valueOf(firstNameBtn))));
        firstNameBtn.click();
        Thread.sleep(2000);
        firstNameTxt.sendKeys("Bob");

        lastNameBtn.click();
        Thread.sleep(2000);
        lastNameTxt.sendKeys("Smith");

        locationSelect.click();
        //WebElement dynamicElement2 = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.valueOf(dropDown))));
        Thread.sleep(2000);
        location.click();

    }

    public void clickCreate() {

        createLogin.click();

    }

    public void createLogin(WebDriver driver) throws InterruptedException {

        Actions action = new Actions(driver);

        usernameBtn.click();
        Thread.sleep(1000);
        usernameTxt.sendKeys("Bob123");

        passwordBtn.click();
        Thread.sleep(1000);
        passwordTxt.sendKeys("12345678");

        confirmPassBtn.click();
        Thread.sleep(1000);
        confirmPassTxt.sendKeys("12345678");

        essRoleBtn.click();
        //WebElement dynamicElement = (new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.valueOf(defaultESS))));
        Thread.sleep(2000);
        action.sendKeys(Keys.ENTER);


        supervisorBtn.click();
        //WebElement dynamicElement2 = (new WebDriverWait(driver, 5)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(String.valueOf(defaultSuper))));
        Thread.sleep(2000);
        action.sendKeys(Keys.ENTER);


    }

    public void save() throws InterruptedException {

        saveBtn.click();
        Thread.sleep(3000);

    }

    public void searchForEmployee() throws InterruptedException {

        employeeList.click();
        Thread.sleep(3000);

    }



}

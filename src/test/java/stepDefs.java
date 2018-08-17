import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class stepDefs {

    static ChromeDriver driver;
    static ExtentReports reports;
    ExtentTest test;



    @Before
    public void setUp (){
        System.setProperty("webdriver.chrome.driver","C:\\chromedriver\\chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        reports = new ExtentReports("C:\\testReports\\report.html", true);
    }

    @After
    public void tearDown (){
        reports.endTest(test);
        reports.flush();
        driver.quit();
    }


    @Given("^the login page$")
    public void the_login_page()  {
        driver.get(Constants.url1);
    }

    @When("^I login$")
    public void i_login() {
        LoginPage login = PageFactory.initElements(driver, LoginPage.class);
        login.login();
    }

    @When("^I click the PIM tab$")
    public void i_click_the_PIM_tab() throws InterruptedException {
        Dashboard dash = PageFactory.initElements(driver, Dashboard.class);
        dash.clickPIM();
        Thread.sleep(3000);
    }

    @When("^then the Add Employee Tab$")
    public void then_the_Add_Employee_Tab() throws InterruptedException {
        Dashboard dash = PageFactory.initElements(driver, Dashboard.class);
        dash.addEmployee();
        Thread.sleep(5000);

    }

    @When("^I fill out the Add Employee Details correctly$")
    public void i_fill_out_the_Add_Employee_Details_correctly() throws InterruptedException {

        Dashboard dash = PageFactory.initElements(driver, Dashboard.class);
        dash.employeeDetails(driver);
    }

    @When("^I choose to create Login Details by clicking the appropriate button$")
    public void i_choose_to_create_Login_Details_by_clicking_the_appropriate_button()  {
        Dashboard dash = PageFactory.initElements(driver, Dashboard.class);
        dash.clickCreate();
    }

    @When("^I fill out the Login Details correctly$")
    public void i_fill_out_the_Login_Details_correctly() throws InterruptedException {
        Dashboard dash = PageFactory.initElements(driver, Dashboard.class);
        dash.createLogin(driver);
    }

    @When("^I click the Save button$")
    public void i_click_the_Save_button() throws InterruptedException {
        Dashboard dash = PageFactory.initElements(driver, Dashboard.class);
        dash.save();
    }

    @Then("^I can search for the Employee I have just created$")
    public void i_can_search_for_the_Employee_I_have_just_created() throws InterruptedException {

        test = reports.startTest("Employee created");

        Dashboard dash = PageFactory.initElements(driver, Dashboard.class);
        Thread.sleep(5000);
        dash.searchForEmployee();

        EmployeeList search = PageFactory.initElements(driver, EmployeeList.class);

        if(search.searchForEmployee(driver)) {
            test.log(LogStatus.PASS, "Employee created was found");
        }else{
            test.log(LogStatus.FAIL, "Employee not found");
        }

    }

        // @Then("^select them for inspection$")
        //  public void select_them_for_inspection()  {

        //  }

}

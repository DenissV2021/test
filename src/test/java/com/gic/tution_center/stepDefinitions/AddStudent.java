package com.gic.tution_center.stepdefinitions;


import com.gic.tution_center.pageFactory.AddNewStudentPage;
import com.gic.tution_center.pageFactory.AllStudentsPage;
import com.gic.tution_center.pageFactory.DashboardPage;
import com.gic.tution_center.pageFactory.LoginPage;
import com.gic.tution_center.utils.CommonFunctions;
import com.gic.tution_center.utils.Constants;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.jsoup.select.Evaluator;
import org.junit.Assert;
import org.openqa.selenium.By;

public class AddStudent extends CommonFunctions {

    LoginPage loginPage = new LoginPage(driver);
    DashboardPage dashboardPage = new DashboardPage(driver);
    AddNewStudentPage addNewStudentPage = new AddNewStudentPage(driver);
    AllStudentsPage allStudentsPage = new AllStudentsPage(driver);

    @Given("^I'm on LoginPage \"(.*?)\"$")
    public void i_m_on_LoginPage(String loginPageURL)  {

        driver.get(loginPageURL);

    }


    @When("^I enter Email \"(.*?)\"$")
    public void i_enter_Email(String userName) {

    loginPage.setUserName(userName);
    }

    @When("^I enter Password \"(.*?)\"$")
    public void i_enter_Password(String password) {
        loginPage.setPassword(password);

    }

    @When("^I click Login button$")
    public void i_click_Login_button() {
        loginPage.submitLoginDetails();

    }

    @When("^I click on Students$")
    public void i_click_on_Students() {
        dashboardPage.StudentsBtnClick();

    }

    @When("^I click Add New Student$")
    public void i_click_Add_New_Student() {
        dashboardPage.AddNewStudentBtnClick();

    }

    @When("^I type in valid email address \"(.*?)\" along with mandatory fields$")
    public void i_type_in_valid_email_address_along_with_mandatory_fields(String ValidEmail)  {

        addNewStudentPage.Email.sendKeys(ValidEmail);
        addNewStudentPage.EnterValidFirstName();
        addNewStudentPage.EnterValidLastName();
        addNewStudentPage.EnterValidPhone();
        addNewStudentPage.EnterValidBirthDate();
        addNewStudentPage.EnterValidPostCode();
        addNewStudentPage.EnterValidAddress();
        addNewStudentPage.EnterValidGuardiansFirstName();
        addNewStudentPage.EnterValidGuardiansLastName();
        addNewStudentPage.EnterValidGuardiansEmail();
        addNewStudentPage.EnterValidGuardiansPhone();
        addNewStudentPage.EnterValidHourlyFeesPeakHour();


    }

    @When("^I click Create Student$")
    public void i_click_Create_Student() {
        addNewStudentPage.CreateStudentBtnClick();
        dashboardPage.AllStudentsBtnClick();
    }

    @Then("^student record should be created successfully$")
    public void student_record_should_be_created_successfully()  {

    Assert.assertTrue(allStudentsPage.AddedStudent.isDisplayed());


}
}
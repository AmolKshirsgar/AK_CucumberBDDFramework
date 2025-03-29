package stepDefination;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.CommonUtils;


public class LoginApp 
{
	public WebDriver driver;
	public HomePage homePage;
	public LoginPage loginPage;
	public AccountPage accountPage;
	public CommonUtils commonUtils;
	
	
	@Given("User has navigated to login page")
	public void user_has_navigated_to_login_page()
	{
		driver=DriverFactory.getDriver();
		
		homePage=new HomePage(driver);
		homePage.clkMyAcc();
		loginPage=homePage.selectLogin();
	
	}

	@When("^User enters valid email address (.+) into email field$")
	public void user_enters_valid_email_address_into_email_field(String validEmailText) 
	{
//		loginPage= new LoginPage(driver);
		loginPage.enterEmailAddress(validEmailText);

	}

	@When("^User enters valid password address (.+) into password field$")
	public void user_enters_valid_password_address_into_password_field(String validPwdText) 
	{
		loginPage.enterPassword(validPwdText);
	}

	@When("User clicks on login button")
	public void user_clicks_on_login_button() 
	{
		accountPage=loginPage.clkLoginButton();
	}

	@Then("User should get successfully logged in")
	public void user_should_get_successfully_logged_in() 
	{
//		accountPage=new AccountPage(driver);
		Assert.assertTrue(accountPage.displayAcctPageStatus());
		
	}

	@When("User enters invalid email address into email field")
	public void user_enters_invalid_email_address_into_email_field()
	{
//		loginPage= new LoginPage(driver);								//its new scenario so hv to initilize
		commonUtils=new CommonUtils();									//use obj instead of static method
		loginPage.enterEmailAddress(commonUtils.getEmailTimeStamp());
		
	}

	@When("User enters invalid password address {string} into password field")
	public void user_enters_invalid_password_address_into_password_field(String invalidPwdText) 
	{
		loginPage.enterEmailAddress(invalidPwdText);

	}

	@Then("User should get proper warning message about credentials mismatch")
	public void user_should_get_proper_warning_message_about_credentials_mismatch()
	{
		Assert.assertTrue(loginPage.getWarningMsgTxt());
	}

	@When("User dont enter email into email field")
	public void user_dont_enter_email_into_email_field() 
	{
//		loginPage=new LoginPage(driver);
		loginPage.enterEmailAddress("");
		
	}

	@When("User dont enter password into password field")
	public void user_dont_enter_password_into_password_field()
	{
		loginPage.enterPassword("");
	}



}

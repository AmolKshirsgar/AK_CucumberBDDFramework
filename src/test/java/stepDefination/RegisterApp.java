package stepDefination;

import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.RegisterPage;
import utils.CommonUtils;



public class RegisterApp 
{
	public WebDriver driver;
	public HomePage homePage;
	public RegisterPage registerPage;
	public AccountSuccessPage accountSuccessPage;
	public CommonUtils commonUtils;
	
	@Given("User navigates to Register Account page")
	public void user_navigates_to_register_account_page() 
	{
		driver=DriverFactory.getDriver();
		
		homePage= new HomePage(driver);
		homePage.clkMyAcc();
		registerPage=homePage.selectRegister();
	}

	@When("User enters details in below fields")
	public void user_enters_details_in_below_fields(DataTable dataTable) 
	{
		Map<String, String> map = dataTable.asMap(String.class,String.class);
		
//		registerPage=new RegisterPage(driver);
		registerPage.enterFirstName(map.get("firstName"));
		registerPage.enterLastName(map.get("lastName"));
		
		commonUtils=new CommonUtils();
		registerPage.enterEmail(commonUtils.getEmailTimeStamp());
		
		registerPage.enterTelephone(map.get("telephone"));
		registerPage.enterPassword(map.get("password"));
		registerPage.enterConfirmPassword(map.get("password"));

	}
	
	@When("User enters details in below fields with duplicate email")
	public void User_enters_details_in_below_fields_with_duplicate_email(DataTable dataTable) 
	{
		Map<String, String> map = dataTable.asMap(String.class,String.class);
		
//		registerPage=new RegisterPage(driver);
		registerPage.enterFirstName(map.get("firstName"));
		registerPage.enterLastName(map.get("lastName"));
		registerPage.enterEmail(map.get("email"));
		registerPage.enterTelephone(map.get("telephone"));
		registerPage.enterPassword(map.get("password"));
		registerPage.enterConfirmPassword(map.get("password"));

	}

	@When("User select Provacy Policy")
	public void user_select_provacy_policy() 
	{
		registerPage.selectPrivacyPolicy();
	}

	@When("User clicks on Continue button")
	public void user_clicks_on_continue_button() 
	{
		accountSuccessPage=registerPage.clkContinue();
	}

	@Then("User account should get created successfully")
	public void user_account_should_get_created_successfully() 
	{
//		accountSuccessPage=new AccountSuccessPage(driver);
		Assert.assertTrue(accountSuccessPage.accSuccessPageConfirm());
	}

	@When("User selects Yes for Newsletter")
	public void user_selects_yes_for_newsletter() 
	{
		registerPage.clkNewsLetterBox();
	
	}

	@Then("User should get proper warning about duplicate email")
	public void user_should_get_proper_warning_about_duplicate_email() 
	{
		
		Assert.assertTrue(registerPage.duplicateUserWarningMsg());
	}

	@When("User dont enters any details into fields")
	public void user_dont_enters_any_details_into_fields() 
	{
//		registerPage=new RegisterPage(driver);   obj already created
	}

	@Then("User should get proper warning message for every mandatory fields")
	public void user_should_get_proper_warning_message_for_every_mandatory_fields() 
	{
//		registerPage=new RegisterPage(driver);
		
		Assert.assertTrue(registerPage.privacyPolicyWarningMsg());
		Assert.assertTrue(registerPage.firtNameWarningMsg());
		Assert.assertTrue(registerPage.lastNameWarningMsg());
		Assert.assertTrue(registerPage.emailWarningMsg());
		Assert.assertTrue(registerPage.telephoneWarningMsg());
		Assert.assertTrue(registerPage.passwordWarningMsg());
		
	}




}

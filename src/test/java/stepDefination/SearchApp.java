package stepDefination;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.ProductPage;

public class SearchApp 
{
	public WebDriver driver;
	public HomePage homePage;
	public ProductPage productPage;
	
	@Given("User opens the application")
	public void user_opens_the_application()
	{
		driver=DriverFactory.getDriver();
	}

	@When("User enters valid product {string} into search box field")
	public void user_enters_valid_product_into_search_box_field(String validProduct) 
	{
		homePage= new HomePage(driver);
		homePage.enterSearchProduct(validProduct);
	
	}

	@When("User clicks on Search button")
	public void user_clicks_on_search_button() 
	{
		productPage=homePage.clkSearchBtn();
	}

	@Then("User should get valid product displayed in search results")
	public void user_should_get_valid_product_displayed_in_search_results()
	{ 
//		productPage=new ProductPage(driver);
		Assert.assertTrue(productPage.productDisplayStatus());

	}

	@When("User enters invalid product {string} into search box field")
	public void user_enters_invalid_product_into_search_box_field(String invalidProduct) 
	{
		homePage= new HomePage(driver);
		homePage.enterSearchProduct(invalidProduct);
	}

	@Then("User should get message about no product matching")
	public void user_should_get_message_about_no_product_matching()
	{
//		productPage=new ProductPage(driver);
		Assert.assertTrue(productPage.noProdWarningMsg());
	}

	@When("User dont enters any product into search box field")
	public void user_dont_enters_any_product_into_search_box_field() 
	{
		homePage= new HomePage(driver);
	}







}

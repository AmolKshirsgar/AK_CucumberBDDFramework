package stepDefination;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.CheckOutPage;
import pages.HomePage;
import pages.LoginPage;
import pages.OrderSuccessPage;
import pages.ProductPage;
import pages.ShoppingCartPage;
import utils.ElementUtils;

public class OrderApp 
{
	public WebDriver driver;
	public HomePage homePage;
	public LoginPage loginPage;
	public AccountPage accountPage;
	public ProductPage productPage;
	public ShoppingCartPage shoppingCartPage;
	public CheckOutPage checkOutPage;
	public OrderSuccessPage orderSuccessPage;


	
	@Given("User login to the application")
	public void user_login_to_the_application() 
	{
		driver=DriverFactory.getDriver();
		
		homePage=new HomePage(driver);
		homePage.clkMyAcc();
		loginPage=homePage.selectLogin();
	}
	
	@When("User enters valid email address {string} into email field.")
	public void user_enters_valid_email_address_into_email_field(String validEmailText) 
	{
		loginPage.enterEmailAddress(validEmailText);
	}

	@When("User enters valid password address {string} into password field.")
	public void user_enters_valid_password_address_into_password_field(String validPwdText) 
	{
		loginPage.enterPassword(validPwdText);
	}
	
	@When("User clicks on login button.")
	public void user_clicks_on_login_button() 
	{
		accountPage=loginPage.clkLoginButton();
	}

	@When("User add a product {string} to a bag and checkout")
	public void user_add_a_product_to_a_bag_and_checkout(String validProduct) 
	{
		accountPage.enterSearchProduct(validProduct);
		productPage=accountPage.clkSearchBtn();
		Assert.assertTrue(productPage.productDisplayStatus());
		
		productPage.addToCart();
		productPage.addToCartFinal();
		shoppingCartPage=productPage.shoppintCartClick();
		
		checkOutPage=shoppingCartPage.clkCheckOut();
	}

	@When("User place an order")
	public void user_place_an_order() 
	{
		Assert.assertTrue(checkOutPage.checkOutPageDisplay());
		checkOutPage.billingContinueBtnClk();
		checkOutPage.deliveryContinueBtnClk();
		checkOutPage.deliveryMethodContinueBtnClk();
		checkOutPage.termsCondBtnClk();
		checkOutPage.CODContinueBtnClk();
		orderSuccessPage=checkOutPage.confirmOrderBtnClk();
	}

	@Then("User should see the order placed successfully")
	public void user_should_see_the_order_placed_successfully() 
	{

		Assert.assertTrue(orderSuccessPage.orderSuccessMsgDisplay());
	}

}

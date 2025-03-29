package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class ShoppingCartPage 
{
	public WebDriver driver;
	public ElementUtils elementUtils;
	
	public ShoppingCartPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		elementUtils=new ElementUtils(driver);
	}
	
	@FindBy(linkText="Checkout")
	private WebElement checkOut;
	
	public CheckOutPage clkCheckOut()
	{
		elementUtils.clickOnElement(checkOut, 10);
		return new CheckOutPage(driver);
	}
	
	

}

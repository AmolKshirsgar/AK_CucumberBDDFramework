package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class ProductPage 
{
	public WebDriver driver;
	public ElementUtils elementUtils;
	
	public ProductPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		elementUtils=new ElementUtils(driver);
		
	}
	
	@FindBy(linkText="HP LP3065")
	private WebElement productDisplay;
	
	public boolean productDisplayStatus()
	{
//		return productDisplay.isDisplayed();
		return elementUtils.displayStatusofElement(productDisplay, 10);
	}
	
	@FindBy(xpath="//p[contains(text(),'There is no product that matches the search criteria.')]")
	private WebElement noProdWarning;
	
	public boolean noProdWarningMsg()
	{
//		return noProdWarning.isDisplayed();
		return elementUtils.displayStatusofElement(noProdWarning, 10);
	}

	@FindBy(xpath="(//span[contains(text(),'Add to Cart')])[1]")
	private WebElement cartOption;
	
	public void addToCart()
	{
		elementUtils.clickOnElement(cartOption, 10);
	}
	
	@FindBy(xpath="//button[contains(text(),'Add to Cart')]")
	private WebElement cartOption1;
	
	public void addToCartFinal()
	{
		elementUtils.clickOnElement(cartOption1, 10);
	}
	
	@FindBy(xpath="//span[contains(text(),'Shopping Cart')]")
	private WebElement shoppintCart;
	
	public ShoppingCartPage shoppintCartClick()
	{
		elementUtils.clickOnElement(shoppintCart, 10);
		return new ShoppingCartPage(driver);
	}
	
	
	
}

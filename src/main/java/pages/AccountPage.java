package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class AccountPage 
{
	public WebDriver driver;
	public ElementUtils elementUtils;
	
	public AccountPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		elementUtils=new ElementUtils(driver);
	}
	
	@FindBy(linkText="Edit your account information")
	private WebElement acctPageConfim;
	
	public boolean displayAcctPageStatus()
	{
//		return acctPageConfim.isDisplayed();
		return elementUtils.displayStatusofElement(acctPageConfim, 10);
	}

	
	@FindBy(name="search")
	private WebElement searchProductField;
	
	public void enterSearchProduct(String product)
	{
		elementUtils.typeTextIntoElement(searchProductField, product, 10);
//		searchProduct.sendKeys(product);
	}
	
	@FindBy(xpath="//button[contains(@class,'btn-default')]")
	private WebElement searchBtn;
	
	public ProductPage clkSearchBtn()
	{
		elementUtils.clickOnElement(searchBtn, 10);
//		searchBtn.click();
		return new ProductPage(driver);
	}
}

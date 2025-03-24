package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class AccountSuccessPage 
{
	public WebDriver driver;
	public ElementUtils elementUtils;
	
	public AccountSuccessPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		elementUtils=new ElementUtils(driver);
	}
	
	
	
	@FindBy(xpath="//h1[contains(text(),'Your Account Has Been Created!')]")
	private WebElement accountSuccess;
	
	public boolean accSuccessPageConfirm()
	{
//		return accountSuccess.isDisplayed();
		return elementUtils.displayStatusofElement(accountSuccess, 10);
		
	}

}

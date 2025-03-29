package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class OrderSuccessPage 
{
	public WebDriver driver;
	public ElementUtils elementUtils;
	
	public OrderSuccessPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		elementUtils=new ElementUtils(driver);
	}
	
	
	@FindBy(xpath="//h1[text()='Your order has been placed!']")
	private WebElement orderSuccessMsg;
	
	public boolean orderSuccessMsgDisplay()
	{
		return elementUtils.displayStatusofElement(orderSuccessMsg, 10);
	}
	
	
	
}


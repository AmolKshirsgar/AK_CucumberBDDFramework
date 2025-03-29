package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class CheckOutPage
{
	public WebDriver driver;
	public ElementUtils elementUtils;
	
	public CheckOutPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		elementUtils=new ElementUtils(driver);
	}
	
	@FindBy(xpath="//h1[contains(text(),'Checkout')]")
	private WebElement chkoutPage;
	
	public boolean checkOutPageDisplay()
	{
		return elementUtils.displayStatusofElement(chkoutPage, 10);
	}
	
	
	@FindBy(id="button-payment-address")
	private WebElement billingContinue;
	
	public void billingContinueBtnClk()
	{
		elementUtils.clickOnElement(billingContinue, 10);
	}

	@FindBy(id="button-shipping-address")
	private WebElement deliveryContinue;
	
	public void deliveryContinueBtnClk()
	{
		elementUtils.clickOnElement(deliveryContinue, 10);
	}
	
	@FindBy(id="button-shipping-method")
	private WebElement deliveryMethodContinue;
	
	public void deliveryMethodContinueBtnClk()
	{
		elementUtils.clickOnElement(deliveryMethodContinue, 10);
	}
	
	@FindBy(xpath="//input[@name='agree']")
	private WebElement termsCond;
	
	public void termsCondBtnClk()
	{
		elementUtils.clickOnElement(termsCond, 10);
	}
	
	
	@FindBy(id="button-payment-method")
	private WebElement cashContinue;
	
	public void CODContinueBtnClk()
	{
		elementUtils.clickOnElement(cashContinue, 10);
	}
	
	@FindBy(id="button-confirm")
	private WebElement confirmOrder;
	
	public OrderSuccessPage confirmOrderBtnClk()
	{
		elementUtils.clickOnElement(confirmOrder, 10);
		return new OrderSuccessPage(driver);
	}


}

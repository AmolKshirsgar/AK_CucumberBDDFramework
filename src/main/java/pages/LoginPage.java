package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class LoginPage 
{
	public WebDriver driver;
	public ElementUtils elementUtils;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		elementUtils=new ElementUtils(driver);
	}
	
	
	@FindBy(id="input-email")
	private WebElement emailField;
	
	
	@FindBy(id="input-password")
	private WebElement pwdField;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement loginBtn;
	
	@FindBy(xpath="//div[contains(text(),'Warning: No match for E-Mail Address and/or Password.')]")
	private WebElement warningMessage;
	
	public void enterEmailAddress(String emailText)
	{
//		emailField.sendKeys(emailText);
		elementUtils.typeTextIntoElement(emailField, emailText, 10);
	}
	
	public void enterPassword(String pwdText)
	{
//		pwdField.sendKeys(pwdText);
		elementUtils.typeTextIntoElement(pwdField, pwdText, 10);
	}
	
	public AccountPage clkLoginButton()
	{
//		loginBtn.click();
		elementUtils.clickOnElement(loginBtn, 10);
		return new AccountPage(driver);
	}

	public boolean getWarningMsgTxt()
	{

//		return warningMessage.isDisplayed();
		return elementUtils.displayStatusofElement(warningMessage, 10);
	}
	
	
	
}

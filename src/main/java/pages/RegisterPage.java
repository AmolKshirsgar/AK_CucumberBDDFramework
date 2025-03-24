package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class RegisterPage 
{
	public WebDriver driver;
	public ElementUtils elementUtils;
	
	public RegisterPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		elementUtils=new ElementUtils(driver);
	}
	
	@FindBy(id="input-firstname")
	private WebElement firstNameField;
	
	@FindBy(id="input-lastname")
	private WebElement lastNameField;
	
	@FindBy(id="input-email")
	private WebElement emailField;
	
	@FindBy(id="input-telephone")
	private WebElement telephoneField;
	
	@FindBy(id="input-password")
	private WebElement passwordField;
	
	@FindBy(id="input-confirm")
	private WebElement confirmPasswordField;
	
	@FindBy(name="agree")
	private WebElement privacyPolicyField;
	
	@FindBy(name="newsletter")
	private WebElement newsLetter;
	
	@FindBy(xpath="//input[@value='Continue']")
	private WebElement continueBtn;
	
	@FindBy(xpath="//div[contains(text(),'Warning: E-Mail Address is already registered!')]")
	private WebElement duplicateUser;
	
	

	
	public void enterFirstName(String fName)
	{
//		firstNameField.sendKeys(fName);
		elementUtils.typeTextIntoElement(firstNameField, fName, 10);
	}
	
	public void enterLastName(String lName)
	{
//		lastNameField.sendKeys(lName);
		elementUtils.typeTextIntoElement(lastNameField, lName, 10);
	}
	
	public void enterEmail(String email)
	{
//		emailField.sendKeys(email);
		elementUtils.typeTextIntoElement(emailField, email, 10);
	}
	
	public void enterTelephone(String tPhone)
	{
//		telephoneField.sendKeys(tPhone);
		elementUtils.typeTextIntoElement(telephoneField, tPhone, 10);
	}
	
	public void enterPassword(String pwd)
	{
//		passwordField.sendKeys(pwd);
		elementUtils.typeTextIntoElement(passwordField, pwd, 10);
	}
	
	public void enterConfirmPassword(String confPwd)
	{
//		confirmPasswordField.sendKeys(confPwd);
		elementUtils.typeTextIntoElement(confirmPasswordField, confPwd, 10);
	}
	
	public void selectPrivacyPolicy()
	{
//		privacyPolicyField.click();
		elementUtils.clickOnElement(privacyPolicyField, 10);
	}
	
	public void clkNewsLetterBox()
	{
//		newsLetter.click();
		elementUtils.clickOnElement(newsLetter, 10);
	}
	
	public AccountSuccessPage clkContinue()
	{
//		continueBtn.click();
		elementUtils.clickOnElement(continueBtn, 10);
		return new AccountSuccessPage(driver);
	}
	
	public boolean duplicateUserWarningMsg()
	{
//		return duplicateUser.isDisplayed();
		return elementUtils.displayStatusofElement(duplicateUser, 10);
	}
	
	
	@FindBy(xpath="//div[contains(text(),'Warning: You must agree to the Privacy Policy!')]")
	private WebElement privacyPolicyWarning;
	
	public boolean privacyPolicyWarningMsg()
	{
//		return privacyPolicyWarning.isDisplayed();
		return elementUtils.displayStatusofElement(privacyPolicyWarning, 10);
	}
	
	@FindBy(xpath="//div[contains(text(),'First Name must be between 1 and 32 characters!')]")
	private WebElement firtNameWarning;
	
	public boolean firtNameWarningMsg()
	{
//		return firtNameWarning.isDisplayed();
		return elementUtils.displayStatusofElement(firtNameWarning, 10);
	}
	
	@FindBy(xpath="//div[contains(text(),'Last Name must be between 1 and 32 characters!')]")
	private WebElement lastNameWarning;
	
	public boolean lastNameWarningMsg()
	{
//		return lastNameWarning.isDisplayed();
		return elementUtils.displayStatusofElement(firtNameWarning, 10);
	}
	
	@FindBy(xpath="//div[contains(text(),'E-Mail Address does not appear to be valid!')]")
	private WebElement emailWarning;
	
	public boolean emailWarningMsg()
	{
//		return emailWarning.isDisplayed();
		return elementUtils.displayStatusofElement(emailWarning, 10);
	}
	
	@FindBy(xpath="//div[contains(text(),'E-Mail Address does not appear to be valid!')]")
	private WebElement telephoneWarning;
	
	public boolean telephoneWarningMsg()
	{
//		return telephoneWarning.isDisplayed();
		return elementUtils.displayStatusofElement(telephoneWarning, 10);
	}
	
	@FindBy(xpath="//div[contains(text(),'Password must be between 4 and 20 characters!')]")
	private WebElement passwordWarning;
	
	public boolean passwordWarningMsg()
	{
//		return passwordWarning.isDisplayed();
		return elementUtils.displayStatusofElement(passwordWarning, 10);
	}
	
}

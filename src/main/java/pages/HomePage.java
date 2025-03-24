package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ElementUtils;

public class HomePage 
{
	public WebDriver driver;
	public ElementUtils elementUtils;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		elementUtils=new ElementUtils(driver);      //to use common element actions call in constructor of Pageclass
	}
	
	
	
	@FindBy(xpath="//span[text()='My Account']")
	private WebElement myAccDDmenu;
	
	@FindBy(linkText="Login")
	private WebElement loginOption;
	
	@FindBy(linkText="Register")
	private WebElement registerOption;
	
	
	
	public void clkMyAcc()
	{
//		myAccDDmenu.click();										normal method
		elementUtils.clickOnElement(myAccDDmenu, 10);				//with common utils method
	}
	
	public LoginPage selectLogin()
	{
//		loginOption.click();
		elementUtils.clickOnElement(loginOption, 10);
		return new LoginPage(driver);
	}
	
	public RegisterPage selectRegister()
	{
//		registerOption.click();
		elementUtils.clickOnElement(registerOption, 10);
		return new RegisterPage(driver);
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

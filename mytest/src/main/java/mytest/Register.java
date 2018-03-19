package mytest;

import mytest.objects.TransactObject;
import mytest.others.GetElement;
import mytest.others.YamlReader;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Register {
	
	public String baseUrl = "http://demo.guru99.com/selenium/newtours/";
	String driverPath = "C:\\Users\\mraghavi\\Desktop\\softwares\\chromedriver_win32\\chromedriver.exe";
	public String username, password;
	public WebDriver driver;
	public String expected = null;
	public String actual = null;
	

	@BeforeMethod
	public void verifyHomepageTitle() {
		String expectedTitle = "Welcome: Mercury Tours";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}

	@BeforeTest
	public void launchBrowser() {

		try {

			YamlReader.yamlReader();
			username = YamlReader.user.getName();
			System.out.println("printing username "+username);
			password = YamlReader.user.getPassword();

			System.out.println("UserName is " + username);
			System.out.println("Password is " + password);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("launching chrome browser");
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get(baseUrl);
	}
	
	@Test
	public void register() throws Exception {

		boolean expectedSignInFlag= true;
		GetElement.getUIObject(TransactObject.REGISTER_LINK, driver).click();
		System.out.println("Clicked on register link");
		expected = "Register: Mercury Tours";
		actual = driver.getTitle();
		Assert.assertEquals(actual, expected);
		driver.findElement(By.id("email")).sendKeys("chandu");
		(GetElement.getUIObject(TransactObject.EMAIL_PASSWORD, driver)).sendKeys("rag@1990");
		(GetElement.getUIObject(TransactObject.EMAIL_CONFIRMPASSWORD, driver)).sendKeys("rag@1990");
		(GetElement.getUIObject(TransactObject.SUBMIT_BUTTON, driver)).click();
		Assert.assertEquals(GetElement.getUIObject(TransactObject.SIGNIN_LINK, driver).isDisplayed(), expectedSignInFlag);
		System.out.println("Registered Succesfully");
	}
	
	@AfterMethod
	public void goBackToHomepage() {
		driver.findElement(By.linkText("Home")).click();
	}

	@AfterTest
	public void terminateBrowser() {
		driver.close();
	}
}

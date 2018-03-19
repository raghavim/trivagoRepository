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

public class Login {
	
	public String baseUrl = "http://demo.guru99.com/selenium/newtours/";
	String driverPath = "C:\\Users\\mraghavi\\Desktop\\softwares\\chromedriver_win32\\chromedriver.exe";
	public String username, password;
	public WebDriver driver;
	public String expected = null;
	public String actual = null;
	
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

	@BeforeMethod
	public void verifyHomepageTitle() {
		String expectedTitle = "Welcome: Mercury Tours";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@AfterMethod
	public void goBackToHomepage() {
		driver.findElement(By.linkText("Home")).click();
	}

	@AfterTest
	public void terminateBrowser() {
		driver.close();
	}
	
	@Test
	public void login() {



		String loginStatusActual, loginStatusExpected = "userLoggedIn";
		try {

			GetElement.getUIObject(TransactObject.USERNAME, driver).sendKeys(username);;

			(GetElement.getUIObject(TransactObject.PASSWORD, driver))
			.sendKeys(password);
			(GetElement.getUIObject(TransactObject.SIGNIN_BUTTON, driver))
			.click();
			if ((GetElement.getUIObject(TransactObject.LOGIN_CHECK, driver))
					.isDisplayed()){
				System.out.println("User logged in successfully");
				loginStatusActual = "userLoggedIn";
			}
			else{
				System.out.println("User not logged in");
				loginStatusActual = "userNotLoggedIn";	
			}

			Assert.assertEquals(loginStatusActual, loginStatusExpected);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

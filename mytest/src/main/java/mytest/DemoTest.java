package mytest;

import java.util.concurrent.TimeUnit;

import mytest.objects.TransactObject;
import mytest.others.GetElement;
import mytest.others.YamlReader;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;


@Test
public class DemoTest {
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

	@Test(priority = 1)
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

		@Test(priority = 3)
		public void support() {
			driver.findElement(By.linkText("SUPPORT")).click();
			expected = "Under Construction: Mercury Tours";
			actual = driver.getTitle();
			Assert.assertEquals(actual, expected);
		}
	
	@Test(priority = 2)
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

	@AfterMethod
	public void goBackToHomepage() {
		driver.findElement(By.linkText("Home")).click();
	}

	@AfterTest
	public void terminateBrowser() {
		driver.close();
	}
}
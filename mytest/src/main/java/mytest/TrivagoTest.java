package mytest;

import static org.testng.Assert.assertTrue;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.ClickAction;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TrivagoTest {

	public static WebDriver driver;
	
	@BeforeTest
	public void launchBrowser() {
		ChromeOptions o = new ChromeOptions();
		o.addArguments("disable-extensions");
		o.addArguments("--start-maximized");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mraghavi\\Desktop\\softwares\\chromedriver_win32\\chromedriver.exe");
		 driver= new ChromeDriver();
		driver.get("https://www.trivago.in/");
	}
	
	@BeforeMethod
	public void verifyHomepageTitle() {
		String expectedTitle = "trivago.in - The world’s top hotel price comparison site";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
//	@AfterMethod
//	public void goBackToHomepage() {
//		driver.findElement(By.linkText("Home")).click();
//	}
//	
//	@AfterTest
//	public void terminateBrowser() {
//		driver.close();
//	}
	
	@Test
	 @Parameters({"resort","sortBy"})
	public void trivagoTestMethod(@Optional String resort, String sortBy) throws InterruptedException {
	
	//public static void main(String[] args) throws InterruptedException {
	
		System.out.println("resort name is" + resort);
		System.out.println("sortby select value is" + sortBy);
		
		// TODO Auto-generated method stub
		
		driver.manage().window().maximize();
		WebDriverWait wait=new WebDriverWait(driver, 100);
		WebElement searchTextBox= driver.findElement(By.xpath("//*[@id='horus-querytext']"));
		searchTextBox.sendKeys("Goa");
		driver.findElement(By.xpath("//*[@id='js-fullscreen-hero']/div/form/div/div[1]/div/div/div[2]/button/span/span")).click();
		wait.withTimeout(60, TimeUnit.SECONDS);
		
//		
//		Thread.sleep(10000);
//		WebElement price= driver.findElement(By.xpath("//*[@id='js-fullscreen-hero']//*[contains(text(),'Price')]"));
//		if((wait .ignoring(NoSuchElementException.class).until(ExpectedConditions.visibilityOfElementLocated((By) price))) != null){
//			driver.findElement(By.xpath("//*[@id='js-fullscreen-hero']//*[contains(text(),'Price')]")).click();
//			driver.findElement(By.xpath("//*[@id='js-fullscreen-hero']/div/form/section/div[2]/div[1]/div/div/div[1]/p[2]")).click();
//			
//		}
//		else{
//			driver.findElement(By.xpath("//*[@class='fl-slider__label fl-slider__label--cur']")).click();
//			wait.withTimeout(10, TimeUnit.SECONDS).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@class='tag tag--secondary js-refinement-row-tag taglist__item--id-price']"))));	
//		}
		
		
//		Thread.sleep(1000);
//		driver.findElement(By.id("max-price")).sendKeys("16000");
		
		/*if(driver.findElement(By.xpath("//*[@id='js-fullscreen-hero']/div/form/div[2]/div[1]/button")).isDisplayed())
			driver.findElement(By.xpath("//*[@id='js-fullscreen-hero']/div/form/div[2]/div[1]/button")).click();
		else
		driver.findElement(By.xpath("//*[@id='js-fullscreen-hero']/div/form/div[2]/div[1]/button/span[1]")).click();*/
		
//		WebElement priceSlider = driver.findElement(By.xpath("//*[@role='slider']"));
//		int priceSlideBarWidth = priceSlider.getSize().width;
//		System.out.println(priceSlideBarWidth);
//		Actions actSlider=new Actions(driver);
//		actSlider.clickAndHold(priceSlider);
//		actSlider.moveByOffset(20,0).build().perform();
		
		Select searchDropdown = new Select(driver.findElement(By.xpath("//*[@id='mf-select-sortby']")));
		searchDropdown.selectByVisibleText("Rating & Popularity");
		
		WebElement hotelNameSearch;
		wait.pollingEvery(5, TimeUnit.SECONDS).until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='hotel-name-search-input']")));
		
		
		
		if(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='hotel-name-search-input']")))!=null){
			
			hotelNameSearch=driver.findElement(By.xpath("//*[@id='hotel-name-search-input']"));
		hotelNameSearch.click();
		driver.findElement(By.xpath("//*[@id='hotel-name-search-btn']/span[1]"));
		}
		else{

			hotelNameSearch=driver.findElement(By.xpath("//*[@id='undefined-input']"));
					hotelNameSearch.click();	
		}
		//driver.findElement(By.xpath("//*[@id='js_filterlist']/div/div[2]/section[1]/div/div/div[1]/")).sendKeys("15500");
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView(true);",hotelNameSearch);
		hotelNameSearch.sendKeys("Resort");
		if(driver.findElement(By.xpath("//*[@id='hotel-name-search-btn']/span[1]")).isDisplayed())
			driver.findElement(By.xpath("//*[@id='hotel-name-search-btn']/span[1]")).click();
		else
		driver.findElement(By.xpath("//*[@id='suggestion-19000']/button")).click();
	//	wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("")));
		js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//*[@id='mf-select-sortby']")));
		
		Actions action = new Actions(driver);
		boolean mariottCheckFlag=false;
		do{
			
		wait.withTimeout(60, TimeUnit.SECONDS).ignoring(NoSuchElementException.class).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@class='item__details']")));
		List<WebElement> searchResultsOnPage = driver.findElements(By.xpath("//*[@class='item__details']"));
		System.out.println(searchResultsOnPage.size());
		
		for(int i =0;i<searchResultsOnPage.size();i++) {
			
			//WebElement mariotSpacheck=searchResultsOnPage.get(i);
			// String elementText = searchResultsOnPage.get(i).getText(); 
			
			wait.withTimeout(60, TimeUnit.SECONDS).pollingEvery(10, TimeUnit.SECONDS).ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
			
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//*[@class='item__details']")));
			 String elementText = searchResultsOnPage.get(i).getText();
			 
			 System.out.println(elementText); 
			 if(elementText.contains("Goa Marriott Resort & Spa")){
				  System.out.println("Got mariott");
				  mariottCheckFlag= true;
				  js.executeScript("arguments[0].scrollIntoView(true);", searchResultsOnPage.get(i));
				  action.click(searchResultsOnPage.get(i)).perform();
				  wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='js_item_99493']//*[@class='btn btn--deal btn--regular icon-bg-icn_arrow_deal fl-trailing']")));
				  driver.findElement(By.xpath("//*[@id='js_item_99493']//*[@class='btn btn--deal btn--regular icon-bg-icn_arrow_deal fl-trailing']")).click();
				  wait.withTimeout(20, TimeUnit.SECONDS);
				  driver.get("https://www.expedia.co.in/Goa-Hotels-Goa-Marriott-Resort-Spa.h522986.Hotel-Information?mctc=5&langid=2057&chid=4f8fb470-cd17-411f-b291-8a1be6013600&mdpcid=IN.META.TRIVAGO.HOTELSCORESEARCH.HOTEL&mdpdtl=HTL.522986.PANAJI&trv_curr=INR&chkin=30/03/2018&chkout=31/03/2018&rateplanid=202197910_24&trv_dp=17600&rm1=a2&paandi=true");
				  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='availability-check-in']")));
				  driver.findElement(By.xpath("//*[@id='availability-check-in']")).clear();
				  driver.findElement(By.xpath("//*[@id='availability-check-out']")).clear();
				  driver.findElement(By.xpath("//*[@id='availability-check-in']")).sendKeys("01/04/2018");
				  driver.findElement(By.xpath("//*[@id='availability-check-out']")).sendKeys("02/04/2018");
				  
				  Select roomSelector = new Select (driver.findElement(By.xpath("//*[@class='rooms-selector']")));
				  roomSelector.deselectAll();
				  roomSelector.selectByVisibleText("2");
				  Select adultSelector = new Select (driver.findElement(By.xpath("//*[@class='adult-selector']")));
				  adultSelector.deselectAll();
				  adultSelector.selectByVisibleText("3");
				  Select childSelector = new Select (driver.findElement(By.xpath("//*[@class='children-selector']")));
				  childSelector.deselectAll();
				  childSelector.selectByVisibleText("1");
				  driver.findElement(By.xpath("//*[@class='btn-secondary btn-action search-button']")).click();
				  driver.findElement(By.xpath("//*[@id='rooms-and-rates']/div/article/table/tbody[1]/tr[2]/td[3]/div/div[1]/button")).click();
				  driver.findElement(By.xpath("//*[@id='pay-now-button']")).click();
				  driver.findElement(By.xpath("//*[@id='preferences']/fieldset/div[3]/fieldset/div[2]/label/input")).sendKeys("Raghavi");
				  driver.findElement(By.xpath("//*[@id='preferences']/fieldset/div[3]/fieldset/div[2]/fieldset/div[2]/label/input")).sendKeys("9652824126");
				  break;
			 }else{
				 System.out.println("Looking for Mariot Resort in Next Element");
			 }
				 
		}
		 if(!mariottCheckFlag) {
			 System.out.println("Looking for Mariot Resort in Next page");
			 js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath("//*[@class='pagination melody-pagination']")));
				// wait.pollingEvery(10, TimeUnit.SECONDS).until(ExpectedConditions.visibilityOfElementLocated(driver.findElement(By.xpath("//*[@class='btn btn--pagination btn--small btn--page-arrow btn--next']"))));
				 Thread.sleep(10000);
				 driver.findElement(By.xpath("//*[@class='btn btn--pagination btn--small btn--page-arrow btn--next']")).click();
				 Thread.sleep(5000);
				 js.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//*[@id='mf-select-sortby']")));
		 }
		
	}while(true);
		

	}

	
}

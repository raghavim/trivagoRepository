package mytest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class proKarmaTest {
	
	public static void main(String args[]){
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\mraghavi\\Desktop\\softwares\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		JavascriptExecutor je = (JavascriptExecutor) driver;
		driver.get("https://www.amazon.in/");
		WebElement element;
		 driver.findElement(By.xpath("//*[@id='nav-link-shopall']/span[2]")).click();

		driver.findElement(By.xpath("//*[@id='shopAllLinks']/tbody/tr/td[2]/div[1]/ul/li[1]/a")).click();
		element =driver.findElement(By.xpath("//*[@id='leftNav']/ul[4]/div/li[2]/span/a/span"));
		je.executeScript("arguments[0].scrollIntoView(true);", element);
		
		element.click();
		driver.findElement(By.xpath("//*[@id='leftNavContainer']/ul[5]/div/li[2]/span/span/div/label/span/span")).click();
		driver.findElement(By.xpath("//*[@id='leftNavContainer']/ul[7]/div/li[2]/span/span/div/label/input")).click();
		Actions act= new Actions(driver);
		WebElement elem= driver.findElement(By.xpath("//*[@id='result_0']/div/div[3]/div[1]/a/h2"));
		String bgcolor_preHovering = elem.getCssValue("background-color");
		act.moveToElement(elem).build().perform();
		String bgcolor_postHovering = elem.getCssValue("background-color");
		
		if(bgcolor_postHovering.equals(bgcolor_preHovering))
			System.out.println("color Changed");
		else
			System.out.println("Color not changed");
		
		elem.click();
		
		
		driver.findElement(By.xpath("//*[@id='add-to-cart-button']")).click();
		driver.findElement(By.xpath("//*[@id='nav-cart']/span[3]")).click();
		
		
		
		
		
		
	}
	
	

}

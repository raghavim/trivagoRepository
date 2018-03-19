	import org.openqa.selenium.WebDriver;
	 
	import org.openqa.selenium.firefox.FirefoxDriver;
	 
	import org.sikuli.script.FindFailed;
	 
	import org.sikuli.script.Pattern;
	 
	import org.sikuli.script.Screen;
	
public class sikuliTest {
 
 
	public static void main(String[] args) throws FindFailed, InterruptedException {
	 
	// We have to create Screen class object to access method
	 
	Screen screen = new Screen();
	 
	// Create object of Pattern class and specify the images path
	 
	Pattern image = new Pattern("C:\\gmail.PNG");
	 
	Pattern image1 = new Pattern("C:\\images\\uname.PNG");
	 
	Pattern image2 = new Pattern("C:\\images\\password.PNG");
	 
	Pattern image3 = new Pattern("C:\\images\\click.PNG");
	 
	WebDriver driver=new FirefoxDriver();
	 
	driver.manage().window().maximize();
	 
	driver.get("http://www.google.com");
	 
	screen.wait(image, 10);
	 
	// using screen object we can call click method which will accept image path and will perform //action
	 
	// This will click on gmail image on google home page
	 
	screen.click(image);
	 
	// using screen object we can call type  method which will accept image path and content which //we have to type and will perform action.
	 
	// This  will type on username field
	 
	screen.type(image1, "mukeshotwani@gmail.com");
	 
	//This will type of password field
	 
	screen.type(image2, "password1");
	 
	// This will click on login button
	 
	screen.click(image3);
	 
	 
	}
}

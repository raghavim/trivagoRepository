package mytest.others;

import java.io.File;
import java.io.FileReader;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import mytest.objects.TransactObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class GetElement {
	


		public static WebElement getWebElement(String xInput,WebDriver driver) throws Exception{
//			WebDriverWait wait = new WebDriverWait(driver,20);
			WebElement element = null;
			Properties prop = new Properties();
				prop.load(new FileReader("config.properties"));
				File xmlFile = new File(prop.getProperty("xmlPath"));
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				Document doc = dBuilder.parse(xmlFile);
				//System.out.println("doc is "+doc);
				XPathFactory xpathFac = XPathFactory.newInstance();
				XPath xpath = xpathFac.newXPath();
				//System.out.println("XpathFac is " + xpath);
				XPathExpression expr = xpath.compile(xInput);
				//System.out.println("expr is " + expr);
				NodeList nl = (NodeList) expr.evaluate(doc,XPathConstants.NODESET);
				
				for (int i = 0; i < nl.getLength(); i++) {
					Node nNode = nl.item(i);
				
						if (nNode.getNodeType() == Node.ELEMENT_NODE) {
							Element e = (Element) nNode;
							if(e.hasAttribute("id")){
							System.out.println("printing id" +e.getAttribute("id"));
//							wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(e.getAttribute("id"))));
							element = driver.findElement(By.id(e.getAttribute("id")));
						}else if(e.hasAttribute("xpath")){
							System.out.println("printing xpath "+e.getAttribute("xpath"));
//							wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(e.getAttribute("xpath"))));
						element = driver.findElement(By.xpath(e.getAttribute("xpath")));
						}
					}
				}
			if(element== null)
				System.out.println("element is null");
			return element;
		}
	
	public static WebElement getUIObject(String objName,WebDriver driver) throws Exception{
		WebElement element = null;
		String xpath = null;
		xpath = objName.replaceAll("\\)", "']");
		xpath = xpath.replaceAll("\\.", "/");
		xpath = xpath.replaceAll("\\(", "[@Key='");
		xpath = "//"+xpath;
		System.out.println("Method in getUI Object " + xpath);
		element = getWebElement(xpath,driver);
		
		return element;
	}

	public static void main(String[] args) throws Exception{
		WebDriver driver = null;

		
		//getUIObject(TransactObject.REGISTER_LINK, driver);
		getUIObject(TransactObject.EMAIL_USERNAME, driver);
	getUIObject(TransactObject.EMAIL_PASSWORD, driver);
//		getUIObject(TransactObject.EMAIL_CONFIRMPASSWORD,driver);
//		getUIObject(TransactObject.SUBMIT_BUTTON, driver);
		
		//getUIObject("Browser(Transactions).Page(SignIn).WebElement(Delete_button)", driver);
		
	}
}

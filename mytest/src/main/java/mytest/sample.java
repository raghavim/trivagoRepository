package mytest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class sample {

	public static void main(String[] args) throws XPathExpressionException, FileNotFoundException, IOException, ParserConfigurationException, SAXException {
		// TODO Auto-generated method stub
		Properties prop = new Properties();
		prop.load(new FileReader("config.properties"));
		// String xmlPath="C:\\Users\\mraghavi\\mytest\\Guru99Objects.xml";
		File xmlFile = new File(prop.getProperty("xmlPath"));
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(xmlFile);
		System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
		XPathFactory xpathFac = XPathFactory.newInstance();
		XPath xpath = xpathFac.newXPath();
		System.out.println("xptah before parsing" + xpath);
		XPathExpression expr = xpath.compile("USERNAME");
		System.out.println("XPATH filure");
		NodeList nl = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
		for (int i = 0; i < nl.getLength(); i++) {
			Node nNode = nl.item(i);
//			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
//				Element e = (Element) nNode;
//				if (e.hasAttribute("id")) {
//					wait.until(ExpectedConditions.visibilityOfElementLocated(By
//							.id(e.getAttribute("id"))));
//					element = driver.findElement(By.id(e.getAttribute("id")));
//				} else if (e.hasAttribute("xpath")) {
//					wait.until(ExpectedConditions.visibilityOfElementLocated(By
//							.xpath(e.getAttribute("xpath"))));
//					element = driver.findElement(By.xpath(e
//							.getAttribute("xpath")));
//				}
//			}
		}
	}

}

package org.test.fullconcepts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public static WebElement path;
	public static List<WebElement> listdt;
	
	
	
	//launch the browser
	public static void launchbrowser(String browser) {
		
		if(browser.equals("Chrome"))
		{
			WebDriverManager.chromedriver().setup();
//			System.setProperty("webdriver.chrome.driver","E:\\Selenium\\FullValidation_Sample\\Browsers\\chromedriver.exe");
			driver=new ChromeDriver();
			
		}
		else if(browser.equals("Edge"))
		{
			WebDriverManager.edgedriver().setup();
//			System.setProperty("webdriver.edge.driver","E:\\Selenium\\FullValidation_Sample\\Browsers\\msedgedriver.exe");
			driver=new EdgeDriver();
		}
		else if(browser.equals("ie"))
		{
			WebDriverManager.iedriver().setup();
//			System.setProperty("webdriver.ie.driver","E:\\Selenium\\FullValidation_Sample\\Browsers\\msedgedriver.exe");
			driver=new InternetExplorerDriver();
		}
		else if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
//			System.setProperty("webdriver.gecko.driver","E:\\Selenium\\FullValidation_Sample\\Browsers\\msedgedriver.exe");
			driver=new FirefoxDriver();
		}
		else if(browser.equals("firefox"))
		{
			WebDriverManager.operadriver().setup();
//			System.setProperty("webdriver.opera.driver","E:\\Selenium\\FullValidation_Sample\\Browsers\\msedgedriver.exe");
			driver=new OperaDriver();
		}


	}
	
	
	//launch the url
	public static void url_launch(String url) {
			
		driver.get(url);
//		driver.navigate().to(url); 
	}
	
	
	//maximize the window of browser
	public static void win_max() {
			driver.manage().window().maximize();
	}
	
	//Refresh current web page
	public static void refresh() {
		
		driver.navigate().refresh();

	}
		
	//move forward or backward in the window
	public static void move_fwd_bwd(String move) {
		
		if(move=="fwd")
		{
			//To navigate to next page
			driver.navigate().forward();
		}
		else
		{
			//To navigate to previous page
			driver.navigate().back();
		}
	}
	
	//close entire browser
	public static void quit() {
		driver.quit();
	}
	
	
	//close current window
	public static void close() {
		driver.close();
	}
	
	//	find the elements by values
	public static void finds(String type, String value) {
		
		if(type=="id")
		{
			path=driver.findElement(By.id(value));
		}
		else if(type=="name")
		{
			path=driver.findElement(By.name(value));
		}
		else if(type=="classname")
		{
			path=driver.findElement(By.className(value));
		}
		else if(type=="tagname")
		{
			path=driver.findElement(By.tagName(value));
		}
		else if(type=="xpath")
		{
			path=driver.findElement(By.xpath(value));
		}
		else if(type=="linktext")
		{
			path=driver.findElement(By.linkText(value));
		}
		else if(type=="partiallinktext")
		{
			driver.findElement(By.partialLinkText(value));
		}
		else if(type=="cssselector")
		{
			path=driver.findElement(By.cssSelector(value));
			//			id represent #
			//			class represents .
		}

	}
	
	
	
//	find the list elements by values
	public static void findslist(String type, String value) {
		
		if(type=="id")
		{
			listdt=driver.findElements(By.id(value));
		}
		else if(type=="name")
		{
			listdt=driver.findElements(By.name(value));
		}
		else if(type=="classname")
		{
			listdt=driver.findElements(By.className(value));
		}
		else if(type=="tagname")
		{
			listdt=driver.findElements(By.tagName(value));
		}
		else if(type=="xpath")
		{
			listdt=driver.findElements(By.xpath(value));
		}
		else if(type=="linktext")
		{
			listdt=driver.findElements(By.linkText(value));
		}
		else if(type=="partiallinktext")
		{
			listdt=driver.findElements(By.partialLinkText(value));
		}
		else if(type=="cssselector")
		{
			listdt=driver.findElements(By.cssSelector(value));
			//			id represent #
			//			class represents .
		}

	}
	
	
	//send values for the particular element	
	public static void sends(String value) {
		
		path.sendKeys(value);

	}
	
	
//	To clear the textbox value
	public static void clear() {
		path.clear();
	}
	
//	To click the particular webElement(Button)
	public static void btnclick() {
		path.click();
	}
	
//	To get the text of the particular webelement
	public static String gettext() {
		String text = path.getText();
		return text;
	}
	
//	To get the text of the particular attribute
	public static String getattribute(String tag) {
		String attval = path.getAttribute(tag);
		return attval;
	}
	
//	To get the tagname of particular webelement
	public static String tagname() {
		String tagNames = path.getTagName();
		return tagNames;
	}
	
//	To get the size of particular webelement
	public static Dimension getsize() {
	 Dimension size = path.getSize();
		return size;
	}
	
//	To get the X axis and Y axis location of particular webelement	
	public static Point getlocation() {
		Point location = path.getLocation();
		return location;
	}
	
//	To check whether the particular webelement is displaying or not
	public static boolean disply() {
		boolean displayed = path.isDisplayed();
		return displayed;
	}
	
//	To check whether the textbox is enabled to enter the text or not
	public static boolean enable() {
		boolean enabled = path.isEnabled();
		return enabled;
	}
	
//	To check whether the radiobutton/dropdown is selected or not
	public static boolean selects() {
		boolean selected = path.isSelected();
		return selected;
	}
	
//	To click on an element only if the type ofthe element is submit 
	public static void submit() {
		path.submit();
	}
	
//	To get the title of current web page
	public static String get_title() {
		String title = driver.getTitle();
		return title;
	}
	
	
//	To get the url of current web page
	public static String get_curr_url() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;

	}
	
//	To get the page source of current web page
	public static String page_source() {
		String pageSource = driver.getPageSource();
		return pageSource;
	}
	
	
	public static void selectby(String type, String text, String value, int index) {
		Select s1=new Select(path);
		
		if(type=="value")
		{
			s1.selectByValue(value);
		}
		else if(type=="text")
		{
			s1.selectByVisibleText(text);
		}
		else if(type=="index")
		{
			s1.selectByIndex(index);
		}
	}
	
	public static void deselectby(String type, String text, String value, int index) {
		Select s1=new Select(path);
		
		if(type=="value")
		{
			s1.deselectByValue(value);
		}
		else if(type=="text")
		{
			s1.deselectByVisibleText(text);
		}
		else if(type=="index")
		{
			s1.deselectByIndex(index);
		}
		else if(type=="all")
		{
			s1.deselectAll();
		}
	}
	
//	To get all the selected options
	public static List<WebElement> allselectopt() {
		
		Select s1=new Select(path);
		List<WebElement> allSelectedOptions = s1.getAllSelectedOptions();
		return allSelectedOptions;

	}	
	
//	To get first selected options
	public static WebElement firstselect() {
		Select s1=new Select(path);
		WebElement firstSelectedOption = s1.getFirstSelectedOption();
		return firstSelectedOption;

	}
	

//	To get all the options	
	public static List<WebElement> allopt() {
		
		Select s1=new Select(path);
		List<WebElement> allOptions = s1.getOptions();
		return allOptions;

	}	
	
	
	public static boolean multiplesel() {
		Select s1=new Select(path);
		boolean multiple = s1.isMultiple();
		return multiple;

	}
	
	
	
	public static void seltable() {
		findslist("tag","tr");
		for(WebElement rows:listdt)
		{
			List<WebElement> tData = driver.findElements(By.tagName("td"));
			for(WebElement data:tData)
			{
				System.out.println(data.getText());
			}
		}

	}
	
	//scroll down and scroll up 
	public static void scroll(String dir) {
		
		JavascriptExecutor js=(JavascriptExecutor) driver;
		
		if(dir=="up")
		{
			js.executeScript("arguments[0].scrollIntoView(true)",path);
		}
		else
		{
			js.executeScript("arguments[0].scrollIntoView(false)",path);
		}

	}
	
	public void keyscontrol(int count) throws AWTException {
		Robot r=new Robot();
		
		for(int i=0;i<count;i++)
		{
			r.keyPress(KeyEvent.VK_DOWN);
			r.keyRelease(KeyEvent.VK_DOWN);
		}

		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

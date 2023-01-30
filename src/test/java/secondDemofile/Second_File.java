package secondDemofile;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Second_File {
	
	WebDriver driver;
	
	Actions action;
	
	WebDriverWait wait;
	
	@Before
	public void setPath()
	{
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.get("https://www.nykaa.com/");
		
		action = new Actions(driver);
		
		wait = new WebDriverWait(driver,20);
		
	}
	
	@Test
	public void testSite() throws InterruptedException
	{
		WebElement searchBox = driver.findElement(By.xpath("//input[@name='search-suggestions-nykaa']"));
		
		searchBox.click();
		Thread.sleep(2000);
		
		List<WebElement> ListOpenonClick = driver.findElements(By.xpath("//div//ul//li[@class='suggestionQuery css-1pkq9gi']"));
		
		System.out.println("The list Size Is: " +ListOpenonClick.size());
		
		for(int i=0; i<ListOpenonClick.size(); i++)
		{
			System.out.println("The List Item is : "+ListOpenonClick.get(i).getText());
			
		}

	}
	
	@After
	public void tearDown()
	{
		driver.quit();
	}
	

}

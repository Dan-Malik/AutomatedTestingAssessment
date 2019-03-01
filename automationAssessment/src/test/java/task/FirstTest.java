package task;
import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;


public class FirstTest {
	WebDriver driver;
	
@Before
public void setup() {
	System.setProperty("webdriver.chrome.driver", "C:/Users/Admin/Downloads/chromedriver_win32/chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get(Constants.getWebpage());
}

@Test
public void test1(){
	LoginPage logpage = PageFactory.initElements(driver, LoginPage.class);
	FrontPage frontpage = PageFactory.initElements(driver, FrontPage.class);
	NameConfigPage nameconfigpage = PageFactory.initElements(driver, NameConfigPage.class);
	NewJobPage newjobpage = PageFactory.initElements(driver, NewJobPage.class);
	ProjectNamePage projectnamepage = PageFactory.initElements(driver, ProjectNamePage.class);
	
	driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS); 
	logpage.login();
	driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS); 
	frontpage.clickAddTask();
	driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS); 
	newjobpage.createItem();
	driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS); 
	nameconfigpage.clickSave();
	driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS); 
	projectnamepage.clickBackToDashboard();
	
	assertEquals("AutomatedItem", frontpage.returnItemName());
}

@After
public void teardown() throws InterruptedException {
	
	Thread.sleep(300);
	driver.quit();
}


}

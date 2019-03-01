package task;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;

public class SecondTest {
	WebDriver driver;
	
	public static int usernum;
	public static String[] usernames;
	public static String[] fullName;
	
	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "C:/Users/Admin/Downloads/chromedriver_win32/chromedriver.exe");
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--headless");
		driver = new ChromeDriver(chromeOptions);
		driver.get(Constants.getWebpage());
		LoginPage logpage = PageFactory.initElements(driver, LoginPage.class);
		driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS); 
		logpage.login();
	}
	
	@Test
	public void test2() throws IOException {
		FrontPage frontpage = PageFactory.initElements(driver, FrontPage.class);
		ManageJenkinsPage mjpage = PageFactory.initElements(driver, ManageJenkinsPage.class);
		ManageUsersPage mupage = PageFactory.initElements(driver, ManageUsersPage.class);
		CreateUsersPage createUsersPage = PageFactory.initElements(driver, CreateUsersPage.class);
		
		frontpage.clickMJButton();
		mjpage.manageUsers();
		mupage.goToCreateUser();
		
		FileInputStream sheets = new FileInputStream("C:/Users/Admin/Downloads/AssessmentFriday.xlsx");
		XSSFWorkbook myWorkbook = new XSSFWorkbook(sheets);
		XSSFSheet mySheet = myWorkbook.getSheetAt(0);
		
		int numberOfUsers = mySheet.getPhysicalNumberOfRows()-1;
		usernum = numberOfUsers;
		
		usernames = new String[numberOfUsers];
		String[] passwords = new String[numberOfUsers];
		String[] confPasswords = new String[numberOfUsers];
		fullName = new String[numberOfUsers];
		String[] email = new String[numberOfUsers];
		
		
		
		for (int rowNum = 1; rowNum < mySheet.getPhysicalNumberOfRows(); rowNum++) {			
				usernames[rowNum-1] = mySheet.getRow(rowNum).getCell(0).getStringCellValue();
				fullName[rowNum-1] = mySheet.getRow(rowNum).getCell(1).getStringCellValue();
				passwords[rowNum-1] = mySheet.getRow(rowNum).getCell(2).getStringCellValue();
				confPasswords[rowNum-1] = mySheet.getRow(rowNum).getCell(3).getStringCellValue();
				email[rowNum-1] = mySheet.getRow(rowNum).getCell(4).getStringCellValue();
		}
		
		myWorkbook.close();
				
		for (int i = 0;i<numberOfUsers;i++) {
			createUsersPage.populateUsernameField(usernames[i]);
			createUsersPage.populatePasswordField(passwords[i]);
			createUsersPage.populateConfPasswordField(confPasswords[i]);
			createUsersPage.populateEmailField(email[i]);
			createUsersPage.populateFullNameField(fullName[i]);
			createUsersPage.formSubmit();
			
			//can't figure out how to test at end of each iteration
			}
			
		}
		
		
		
	}
	
}

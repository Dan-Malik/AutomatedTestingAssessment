package task;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ManageUsersPage {

	@FindBy (xpath = "//*[@id=\"tasks\"]/div[3]/a[2]")
	WebElement createUser;
	
	public void goToCreateUser() {
		createUser.click();
	}
}

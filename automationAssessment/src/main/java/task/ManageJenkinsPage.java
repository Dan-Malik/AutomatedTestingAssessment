package task;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ManageJenkinsPage {

	@FindBy (xpath = "//*[@id=\"main-panel\"]/div[16]/a/dl/dt")
	WebElement manageUsersButton;
	
	public void manageUsers() {
		manageUsersButton.click();
	}
}

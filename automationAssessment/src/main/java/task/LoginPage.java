package task;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage {

	@FindBy (id = "j_username")
	WebElement usernameField;
	
	@FindBy (xpath = "/html/body/div/div/form/div[2]/input")
	WebElement passwordField;
	
	public void login() {
		usernameField.sendKeys(Constants.getUsername());
		passwordField.sendKeys(Constants.getPassword());
		usernameField.submit();
	}
}

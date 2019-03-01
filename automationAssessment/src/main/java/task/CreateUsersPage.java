package task;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateUsersPage {

	@FindBy(id = "username")
	WebElement usernameField;
	
	@FindBy(id = "password1")
	WebElement passwordField;
	
	@FindBy(id = "password2")
	WebElement confPasswordField;
	
	@FindBy(id = "fullname")
	WebElement fullNameField;
	
	@FindBy(id = "email")
	WebElement emailField;
	
	public void populateUsernameField(String input) {
		 usernameField.sendKeys(input);
	}

	public void populatePasswordField(String input) {
		passwordField.sendKeys(input);
	}

	public void populateConfPasswordField(String input) {
		confPasswordField.sendKeys(input);
	}

	public void populateFullNameField(String input) {
		fullNameField.sendKeys(input);
	}

	public void populateEmailField(String input) {
		emailField.sendKeys(input);
	}
	
	public void formSubmit() {
		usernameField.submit();
	}
}

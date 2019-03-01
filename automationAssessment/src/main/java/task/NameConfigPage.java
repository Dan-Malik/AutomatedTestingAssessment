package task;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NameConfigPage {

	@FindBy(id = "yui-gen38-button")
	WebElement saveButton;
	
	public void clickSave() {
		saveButton.click();
	}
	
}

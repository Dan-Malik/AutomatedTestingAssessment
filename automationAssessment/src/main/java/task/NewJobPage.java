package task;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewJobPage {

	@FindBy (id = "name")
	WebElement itemNameField;
	
	@FindBy (xpath = "//*[@id=\"j-add-item-type-standalone-projects\"]/ul/li[1]/label/span")
	WebElement freestyleProjectButton;
	
	@FindBy (xpath = "//*[@id=\"ok-button\"]")
	WebElement okButton;
	
	public void createItem() {
		itemNameField.sendKeys(Constants.getItemName());
		freestyleProjectButton.click();
		okButton.click();
	}
}

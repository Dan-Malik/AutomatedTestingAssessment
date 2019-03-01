package task;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FrontPage {

	@FindBy (xpath = "//*[@id=\"tasks\"]/div[1]/a[2]")
	WebElement addTaskButton;
	
	@FindBy (xpath = "//*[@id=\"job_AutomatedItem\"]/td[3]/a")
	WebElement nameOfItem;
	
	@FindBy (xpath = "//*[@id=\"tasks\"]/div[4]/a[2]")
	WebElement manageJenkinsButton;
	
	public void clickAddTask() {
		addTaskButton.click();
	}
	
	public String returnItemName(){
		return nameOfItem.getText();
	}
	
	public void clickMJButton() {
		manageJenkinsButton.click();
	}
}

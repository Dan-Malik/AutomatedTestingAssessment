package task;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectNamePage {

	@FindBy(xpath = "//*[@id=\"tasks\"]/div[1]/a[2]")
	WebElement backToDashboardLink;
	
	public void clickBackToDashboard() {
		backToDashboardLink.click();
	}
	
}

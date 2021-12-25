package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DashboardPageObject {
	
	@FindBy(xpath="//*[@id=\"menu_dashboard_index\"]/b")
	public static WebElement dashBoard;
	
	@FindBy (xpath="//div[@id='task-list-group-panel-menu_holder']//following::td[1]")
	public static WebElement pendingLeaverequest;




}

package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRolePageObject {
	
	@FindBy(xpath="//ul[@id=\"mainMenuFirstLevelUnorderedList\"]//b")
	public static WebElement Admin;
	
	@FindBy(xpath="//a[@id='menu_admin_UserManagement']")
	public static WebElement userManagement;
	
	@FindBy(xpath="//a[@id='menu_admin_viewSystemUsers']")
	public static WebElement user;
	
	@FindBy(xpath="//select[@id='searchSystemUser_userType']")
	public static WebElement userRole;
	
	@FindBy(xpath="//select[@id='searchSystemUser_status']")
	public static WebElement status;
	
	
	@FindBy(id="searchBtn")
	public static WebElement serach;
	
	
	@FindBy(xpath="//tr/td[3]")
	public static WebElement userRoleSerach;
	
	@FindBy(xpath="//tr/td[5]")
	public static WebElement enable;


	

}

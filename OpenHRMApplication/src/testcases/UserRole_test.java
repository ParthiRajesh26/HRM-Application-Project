package testcases;

import org.apache.log4j.Logger;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import commonfunctions.CommonFunctions;
import pageObjects.UserRolePageObject;

public class UserRole_test extends CommonFunctions {
	
	String role;
	String finalstatus;
	
	static Logger logger=Logger.getLogger(UserRole_test.class);

	public void movingToUserRole() {
		Actions actions=new Actions(driver);
		actions.moveToElement(UserRolePageObject.Admin);
		actions.moveToElement(UserRolePageObject.userManagement);
		actions.moveToElement(UserRolePageObject.user).click().build().perform();
	}

	public void SelectFromDropDown() {
		Select selectUser=new Select(UserRolePageObject.userRole);
		selectUser.selectByIndex(1);
		Select selectStatus=new Select(UserRolePageObject.status);
		selectStatus.selectByIndex(1);
		UserRolePageObject.serach.click();

	}


	public void FindingUserStatus() {

		 role=UserRolePageObject.userRoleSerach.getText();
		 finalstatus=UserRolePageObject.enable.getText();
			
	}



	@Test
	public void getingUserRoleStatus() {
		PageFactory.initElements(driver, UserRolePageObject.class);
		logger.info("Moving to the Userrole page");
		movingToUserRole();
		logger.info("Selecting from the Dropdown");
		SelectFromDropDown();
		logger.info("Getting the User Status");
		FindingUserStatus();
		
		logger.info("Verifying the role");
		Assert.assertEquals(role, "Admin");
		logger.info("Verifying the Status");
		Assert.assertEquals(finalstatus, "Enabled");
		
		logger.info("End of the UserRole_test testcase ");






	}

}

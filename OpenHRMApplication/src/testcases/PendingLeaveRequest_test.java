package testcases;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import commonfunctions.CommonFunctions;
import pageObjects.DashboardPageObject;
import pageObjects.LoginPageObject;

class PendingLeaveRequest_test extends CommonFunctions {

	String actualMessage=null;
	
	 static Logger logger=Logger.getLogger(PendingLeaveRequest_test.class);

	public void loginApplication() {

		PageFactory.initElements(driver, LoginPageObject.class);
		LoginPageObject.username.sendKeys(properties.getProperty("username"));
		LoginPageObject.password.sendKeys(properties.getProperty("password"));
		LoginPageObject.loginButton.click();
	}


	public void getPendingLeave() {

		PageFactory.initElements(driver, DashboardPageObject.class);
		DashboardPageObject.dashBoard.click();
		actualMessage= DashboardPageObject.pendingLeaverequest.getText();
	}


	@Test
	public void verifyPendingLeave() {
		logger.info("Logging in to Application");
		loginApplication();
		logger.info("Getting pending leave requst");
		getPendingLeave();

        logger.info("Starting Assert Verification");
		Assert.assertEquals(actualMessage, "No Records are Available");
		logger.info("Verification Done");
		logger.info("End of the PendingLeaveRequest_test testcase ");
		

	}

}

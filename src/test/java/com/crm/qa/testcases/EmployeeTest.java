package com.crm.qa.testcases;

import static org.testng.Assert.assertEquals;

import java.net.MalformedURLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.crm.qa.base.TestBase;
import com.crm.qa.pages.EmployeeAndroidPage;

public class EmployeeTest extends TestBase {
	static Logger LOGGER = LoggerFactory.getLogger(EmployeeTest.class);
    EmployeeAndroidPage emp;
    String ToastMessage="Did not add due to 1 errors.";
   

	public EmployeeTest() {
		super();
	}
	
	


	@BeforeMethod
	public void setUp() throws InterruptedException, MalformedURLException {
		System.out.println("Launching App...........");
		 emp=new EmployeeAndroidPage();
		driver.launchApp();
		
	}
	

				// To Verify Employee not added
				@Test(priority = 1, enabled = true)
				public void VerifyEmployeeNotAdded() throws InterruptedException {
					System.out.println("*******************Step 1 Execution Start**************************");
					
					emp.clickOnPlusbutton();
					emp.enterFirstName("Test");
					emp.enterLastName("Demo");
					emp.selectJobtitle();
					emp.clickcreateEmployee();
					String Toast=emp.verifyEmployeeNotCreated();
					Assert.assertEquals(Toast, ToastMessage);
					System.out.println("*******************Step 1 Executed Successfully!!!**************************");
			
				}
				
				
				// To Verify Employee not added
				@Test(priority = 2, enabled = true)
				public void VerifyEmployeeDeleted() throws InterruptedException {
					System.out.println("*******************Step 2 Execution Start**************************");
					emp.clickOnPlusbutton();
					emp.enterFirstName(prop.getProperty("EmpFirstName"));
					emp.enterLastName(prop.getProperty("EmpLastName"));
					emp.selectJobtitle();
					emp.selectProject();
					emp.clickcreateEmployee();
					emp.DeletecreatedEmployee(prop.getProperty("EmpFirstName")+" "+prop.getProperty("EmpLastName"));
					
					System.out.println("*******************Step 2 Executed Successfully!!!**************************");
			
				}
				
			
				@Test(priority = 3, enabled = true)
				public void VerifyAD() throws InterruptedException {
					System.out.println("*******************Step 3 Execution Start**************************");
					emp.CreateEmployee();
					//emp.Create();
					emp.Checkad();

					System.out.println("*******************Step 3 Executed Successfully!!!**************************");
			
				}
				
				

				/*@Test(priority = 4, enabled = true)
				public void Adusers() throws InterruptedException {
					LOGGER.info("*******************Step 3 Execution Start**************************");
					System.out.println("*******************Step 3 Execution Start**************************");
					emp.CreateEmployee();
					emp.CreateEmployee();
					
					
					System.out.println("*******************Step 3 Executed Successfully!!!**************************");
					LOGGER.info("*******************Step 3 Executed Successfully!!!**************************");
			
				}*/
				
				
				
				
	@AfterMethod
	public void tearDown() throws InterruptedException {
		System.out.println("Closing App...........");
		driver.closeApp();
	}

	
}

package com.crm.qa.pages;

import java.util.List;
import org.openqa.selenium.support.CacheLookup;
import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class EmployeeAndroidPage extends TestBase {



	// Initializing the Page Objects:
	@AndroidFindBy(xpath = "//android.widget.ImageButton[@index='1']")
	@CacheLookup
	MobileElement CreateEmployee;

	@AndroidFindBy(id = "com.aaks.qaautomation:id/firstNameEditText")
	MobileElement FirstName;

	@AndroidFindBy(id = "com.aaks.qaautomation:id/lastNameEditText")
	MobileElement LastName;	

	@AndroidFindBy(id = "com.aaks.qaautomation:id/titleSpinner")
	@CacheLookup
	MobileElement jobtitle;

	@AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.ListView/android.widget.TextView[7]")
	@CacheLookup
	MobileElement jobtitlevalue;


	@AndroidFindBy(id = "com.aaks.qaautomation:id/projectSpinner")
	@CacheLookup
	MobileElement Project;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Professional']")
	@CacheLookup
	MobileElement Projecttext;


	@AndroidFindBy(id = "com.aaks.qaautomation:id/createButton")
	@CacheLookup
	MobileElement CreateButton;

	@AndroidFindBy(xpath = "//android.widget.Toast[1]")
	@CacheLookup
	MobileElement Toastmess;


	@AndroidFindBy(xpath = "//android.widget.LinearLayout[@index='3']")
	@CacheLookup
	MobileElement Employees;


	@AndroidFindBy(id = "com.aaks.qaautomation:id/deleteEmployeeButton")
	@CacheLookup
	MobileElement Delete;

	@AndroidFindBy(id = "com.aaks.qaautomation:id/fullNameTextView")
	@CacheLookup
	List<MobileElement> name;


	@AndroidFindBy(id = "com.aaks.qaautomation:id/adView")
	@CacheLookup
	MobileElement Adview;

	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
	@CacheLookup
	MobileElement Back;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='First Name']")
	@CacheLookup
	MobileElement FirstNam;
	
	
	
	
	public void clickOnPlusbutton() throws InterruptedException{
		//TestUtil.WaitforMobileElement(CreateEmployee);
		Thread.sleep(3000);
		CreateEmployee.click();
		
		
		
	}


	public void enterFirstName(String First) throws InterruptedException {
		//TestUtil.WaitforMobileElement(FirstName);	
		Thread.sleep(1000);
		FirstName.sendKeys(First);

	}


	public void enterLastName(String Last) throws InterruptedException {
		TestUtil.WaitforMobileElement(LastName);
		Thread.sleep(1000);
		LastName.sendKeys(Last);
	}

	public void selectJobtitle() throws InterruptedException {
		TestUtil.WaitforMobileElement(jobtitle);	
		jobtitle.click();
		TestUtil.WaitforMobileElement(jobtitlevalue);	
		jobtitlevalue.click();
	}

	public void selectProject() throws InterruptedException {
		TestUtil.WaitforMobileElement(Project);	
		Project.click();
		TestUtil.WaitforMobileElement(Projecttext);	
		Projecttext.click();
	}

	public void clickcreateEmployee() throws InterruptedException{
		TestUtil.WaitforMobileElement(CreateButton);	
		Thread.sleep(1000);
		CreateButton.click();
	}


	public String verifyEmployeeNotCreated(){
		String text = Toastmess.getAttribute("name");
		System.out.println("Toast Message:- "+text);
		return text;
	}



	public void DeletecreatedEmployee(String namee){
		TestUtil.WaitforMobileElement(Employees);	
		Employees.click();
		TestUtil.WaitforMobileElement(Delete);	
		Delete.click();

		if(name.size()>0) {

			for(MobileElement ele:name) {

				if(ele.getText().equals(namee)){
					System.out.println(namee + " is still visible");

				}else {

					System.out.println(namee +" Employee is deleted sucessfully");

				}

			}

		}

	}



	public void CreateEmployee() throws InterruptedException {		
		
		clickOnPlusbutton();
		enterFirstName("Mohit");
		enterLastName("Demo");
		selectJobtitle();
		selectProject();
		clickcreateEmployee();
	}


	public void Checkad() {


			if(name.get(0).getText().contains("Greg") || name.get(1).getText().contains("Carl")) {            	
				System.out.println("Employees are displaying in 1st and 2nd");	
			if (Adview.isDisplayed()) {
				System.out.println("Advertisement appears after every two employees are added");
			} 	
			else {
				System.out.println("advertisement appears at random place");				

			}
			}

	}


}









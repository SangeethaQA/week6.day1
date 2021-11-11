package steps;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class StepDefinition extends BaseClass{
	
@When("Click Leads link")
public void click_leads_link() {
	driver.findElement(By.linkText("Leads")).click();
}
@Then("Verify Leads Page")
public void verify_leads_page() {
  if (driver.getTitle().contains("My Leads"))
  System.out.println("Verified My Leads Page");
  else 
	  System.out.println("My Leads Page is not displayed");
  
}
@When("Click Create Lead link")
public void click_create_lead_link() {
	driver.findElement(By.linkText("Create Lead")).click();
}
@Then("Verify CreateLead Page")
public void verify_create_lead_page() {
	  if (driver.getTitle().contains("Create Lead"))
		  System.out.println("Verified Create Lead Page");
		  else 
			  System.out.println("Create Lead is not displayed");
		  
}
@Given("Enter the company name as {string} and first name as {string} and last name as {string}")
public void leaddetails(String company,String firstName, String lastName) {
	driver.findElement(By.id("createLeadForm_companyName")).sendKeys(company);
	driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstName);
	driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastName);

}

@Given("Enter the phone number as {string}")
public void phoneNumber(String phno) {

	driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(phno);
}


@When("Click Submit button")
public void click_submit_button() {
	driver.findElement(By.name("submitButton")).click();
}

@Then("Verify View Lead Page")
public void verify_view_lead_page() {

	if (driver.getTitle().contains("View Lead"))
		System.out.println("View Lead Page is displayed");
	else
		System.out.println("View Lead is not displayed");

}

@When("Click Find Lead link")
public void findLeadLink()
{
	driver.findElement(By.linkText("Find Leads")).click();
	
}
@Then("Verify Find Lead Page")
public void verify_find_lead_page() {
 if(driver.getTitle().contains("Find Leads"))
	 System.out.println("Find Lead Page is displayed");
 else 
	 System.out.println("Find Lead Page is not displayed");
}
@When("Click Phone tab and Phone details as {string}")
public void click_phone_tab_and_phone_details(String phno) {
	driver.findElement(By.xpath("//span[text()='Phone']")).click();
	driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(phno);
}
@When("Click Find button and select the first link")
public void click_find_button_and_select_the_first_link() throws InterruptedException {
  
	driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	Thread.sleep(2000);
	leadID = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
	driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
}
@When("Click Edit button")
public void click_edit_button() {
	driver.findElement(By.linkText("Edit")).click();
}
@Then("Verify Edit Lead Page")
public void verify_edit_lead_page() {

	 if(driver.getTitle().contains("opentaps CRM"))
		 System.out.println("Edit Lead Page is displayed");
	 else 
		 System.out.println("Edit Lead Page is not displayed");

}
@When("Enter the company name as {string}")
public void enter_the_company_name_as(String companyName) {
	driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(companyName);
}

@When("Click Merge Leads link")
public void click_merge_leads_link() {
	driver.findElement(By.linkText("Merge Leads")).click();
}
@Then("Verify Merge Leads Page")
public void verify_merge_leads_page() {
	 if(driver.getTitle().contains("Merge Leads"))
		 System.out.println("Merge Leads Page is displayed");
	 else 
		 System.out.println("Merge Leads Page is not displayed");

}
@When("From Lead as {string} and To Lead as {string}")
public void fromAndToLead(String fname1, String fname2) throws InterruptedException {
	driver.findElement(By.xpath("//img[@alt='Lookup']")).click();
	Set<String> allWindows = driver.getWindowHandles();
	List<String> allhandles = new ArrayList<String>(allWindows);
	driver.switchTo().window(allhandles.get(1));
	driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(fname1);
	driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	Thread.sleep(1000);
	leadID = driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).getText();
	System.out.println("leadId is "+leadID);
	driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
	driver.switchTo().window(allhandles.get(0));
	
	driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
	Set<String> allWindows2 = driver.getWindowHandles();
	List<String> allhandles2 = new ArrayList<String>(allWindows2);
	driver.switchTo().window(allhandles2.get(1));
	driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys(fname2);
	driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
	driver.switchTo().window(allhandles2.get(0));

	

}
@When("click Merge button and Click Alert message")
public void click_merge_button_and_click_alert_message() {
	driver.findElement(By.xpath("//a[text()='Merge']")).click();
	driver.switchTo().alert().accept();

 
}
@Then("Check the LeadId in find Leads Page and verify no records")
public void checkLead_and_verifyNorecords() throws InterruptedException {
	driver.findElement(By.linkText("Find Leads")).click();
	System.out.println("leadid is"+leadID);

	driver.findElement(By.xpath("//input[@name='id']")).sendKeys(leadID);
	driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
	Thread.sleep(2000);
	String text = driver.findElement(By.className("x-paging-info")).getText();
	System.out.println(text);
	if (text.equals("No records to display")) {
		System.out.println("Text matched");
	} else {
		System.out.println("Text not matched");
	}
}
	
	@When ("Click the DuplicateLead")
	public void duplicateLead()
	{
		driver.findElement(By.linkText("Duplicate Lead")).click();
		
	}
	
	@When("Click the DeleteLead")
	public void deleteLead()
	{
		driver.findElement(By.linkText("Delete")).click();
		
	}
 
}


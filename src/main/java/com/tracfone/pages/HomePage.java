package com.tracfone.pages;

import com.incessant.bon34.controls.Button;
import com.incessant.bon34.controls.Control;
import com.incessant.bon34.controls.Link;
import com.incessant.bon34.controls.TextField;
import com.tracfone.reusablemethods.BPATest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HomePage extends Control {

    //Object
    private HomePage homePage;
    private BPATest BPATest;



	// Variables

	private Link newLink;
	private Link dashboardLink;
	private Link agentTrainingRequestLink;
	private Link currentlyOpenItemsLink;
	private Link closeAllLink;
	private Link AgentTRWorkQueuesLink;
	private Link AssignedTRWorkQueuesLink;

	private Link caseFilterLink;
	private TextField searchTextField;
	private Button applyButton;
	private Link searchResultLink;
	private Link onPORLink;
	private Link clearRecents;
	private Link clickArrow;

	// Getters

	public Link getNewLink() {
		return newLink;
	}

	public Link getClearArrow(){
		return clickArrow;
	}

	public Link getAgentTrainingRequestLink() {
		return agentTrainingRequestLink;
	}

	public Link getOnPORLink(){ return onPORLink; }

	public Link getClearRecents(){return clearRecents; }

	public Link getDashboardLink() {
		return dashboardLink;
	}

	public Link getAgentTRWorkQueuesLink() {
		return AgentTRWorkQueuesLink;
	}

	public Link getAssignedTRWorkQueuesLink() {
		return AssignedTRWorkQueuesLink;
	}

	public Link getCurrentlyOpenItemsLink() {
		return currentlyOpenItemsLink;
	}

	public Link getCloseAllLink() {
		return closeAllLink;
	}

	public Link getCaseFilterLink() {
		return caseFilterLink;
	}

	public Link getclearRecents(){return clearRecents; }

	public TextField getSearchTextField() {
		return searchTextField;
	}

	public Button getApplyButton() {
		return applyButton;
	}


	public Link getSearchResultLink() {
		return searchResultLink;
	}

	// Screen Objects
	public HomePage() {

	   //	newLink = new Link(By.xpath("//div[@data-tour-id='cm-create-case-menu']"));
			newLink = new Link(By.xpath("//a[@data-test-id=\"20140927131516034450756\"]"));
	   	agentTrainingRequestLink = new Link(By.xpath("//span[contains(text(),'Agent Training Request')]"));
		dashboardLink = new Link(By.xpath("//li[@data-test-id='201711140151500071605']/a"));

		currentlyOpenItemsLink = new Link(By.xpath("//a[@id= 'TABANCHOR']"));
		closeAllLink = new Link(By.xpath("//tr[@id='/contextMenu/CloseAll']"));

		AgentTRWorkQueuesLink = new Link(By.xpath("//span[@id= 'BPA_TrainingRequest']"));
		AssignedTRWorkQueuesLink =  new Link(By.xpath("//span[@id= 'BPA_TrainingDocumentation']"));

		caseFilterLink = new Link(By.xpath("//table[@data-test-id= '201704060124420325674-layout']//th[@sortfield= '.pxRefObjectInsName']//a"));
		searchTextField = new TextField(By.xpath("//input[@id= 'bb4272d5']"));
		applyButton = new Button(By.xpath("//button[text() = 'Apply']"));
		searchResultLink = new Link(By.xpath("//a[@data-test-id= '20190720022707070737981']"));
		clearRecents = new Link(By.xpath("//span[contains(text(),'Clear recents')]"));
		clickArrow = new Link(By.xpath("//button[@data-test-id=\"2014091903171702718563\"]"));

		//New Amend or POR
		onPORLink = new Link(By.xpath("//span[contains(text(),'POR')]"));



	}




	// Test Methods
	public void closeAllOpenCases() throws InterruptedException {

		Thread.sleep(1000);
		getDriver().switchTo().defaultContent();
			//currentlyOpenItemsLink.isElementPresent(By.id("TABANCHOR")) == true
if(this.getDriver().findElement(By.id("TABANCHOR")).isDisplayed()){
	currentlyOpenItemsLink.click();
	getBrowser().sleep(2000);
	closeAllLink.click();
	getBrowser().sleep(1000);
//	clickArrow.click();
//	clearRecents.click();

}
			}
	public void clearAllRecentCase() throws InterruptedException {
		clickArrow.click();
		clearRecents.click();
	}


	// Test Methods

	public void clickOnNewSubTaskLink(String subTask){
		getBrowser().sleep(2700);
		Actions actions=new Actions(getDriver());
		actions.moveToElement(onPORLink.getElement()).click(onPORLink.getElement()).build().perform();

	}
	public void clickOnNewLink() throws InterruptedException {

		Thread.sleep(1000);
		getDriver().switchTo().defaultContent();
		newLink.click();
		getBrowser().sleep(2700);
		WebElement ne=getDriver().findElement(By.xpath("//span[@class=\"menu-item-title\"][contains(text(),'New')]"));
		Actions actions=new Actions(getDriver());
		actions.moveToElement(ne).build().perform();

	}



	// Test Methods
	public void clickOnAgentTrainingRequestLink() throws InterruptedException {
		Thread.sleep(3000);
		agentTrainingRequestLink.click();
	}
//	public void clickOnPORLink() throws InterruptedException {
//		Thread.sleep(3000);
//		onPORLink.click();
//
//	}

	public void clickOnCaseFilterIcon(){

        getBrowser().sleep(2000);
		BPATest = new BPATest();
		BPATest.switchToActiveIFrame();
		caseFilterLink.click();
	}

	public void clickSearchResult(){
		BPATest = new BPATest();
		BPATest.switchToActiveIFrame();
		getBrowser().sleep(500);
		searchResultLink.click();
	}
	public void navigateToAgentTRWorkQueues(){
		BPATest = new BPATest();
		getDriver().switchTo().defaultContent();
//		BPATest.switchToActiveIFrame();
		dashboardLink.click();
		getBrowser().sleep(3000);
		BPATest.switchToActiveIFrame();
			AgentTRWorkQueuesLink.click();
	 	}


	public void navigateToAssignedTRWorkQueues(){
		BPATest = new BPATest();
		BPATest.switchToActiveIFrame();
		dashboardLink.click();
		getBrowser().sleep(3000);
			AssignedTRWorkQueuesLink.click();
	}





}
                         
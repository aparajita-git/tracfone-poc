package com.tracfone.reusablemethods;

import com.incessant.bon34.core.Browser;
import com.incessant.bon34.core.GenericMethods;
import com.incessant.bon34.tests.CucumberGenericTest;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.*;

import java.util.logging.Level;

public class BPATest extends CucumberGenericTest {

    private GenericMethods genericMethods;
    private Browser browser;
    protected String userID;

    /**
     * Logs in to PEGA Application
     *
     * @param userID   The PID to log in with
     * @param password The password
     */

    public void login(String userID, String password) {
        WebElement userIDField = getBrowser().getElementWhenReady(By.id("txtUserID"));
        userIDField.sendKeys(userID);
        WebElement passwordField = getBrowser().getElementWhenReady(By.id("txtPassword"));
        passwordField.sendKeys(password);
        WebElement submitButton = getBrowser().getElementWhenReady(By.id("sub"));
        submitButton.click();
        getBrowser().getLogWriter().log(" Logging in as user  " + userID, Level.INFO);
        this.userID = userID;
    }

    /**
     * This mehod is to handle Stale Element Exception and to click on the Webelement provided
     *
     * @param by Selector
     */
    public void handleStaleElementAndClick(By by) {
        boolean result = false;
        int attempts = 0;
        while (attempts < 5) {
            try {
                getDriver().findElement(by).click();
                result = true;
                break;
            } catch (Exception e) {
            }
            attempts++;
        }
        // return result;
    }


    /**
     * This method is to perform click on Any item from the Actions Menu
     *
     * @param menuItem
     */
    public void clickActionsMenu(String menuItem) {
        //	this.waitIfInterneExplorer();
        getBrowser().sleep(1000);
        this.clickActionsMenu();
        getBrowser().sleep(1000);
        this.getBrowser().waitForElementToBeClickable(By.cssSelector("li[class= 'menu-item menu-item-enabled']"));
        boolean found = false;
        List<WebElement> actionList = this.getDriver().findElements(By.cssSelector("span[class= 'menu-item-title']"));
        Iterator var4 = actionList.iterator();

        while (var4.hasNext()) {
            WebElement action = (WebElement) var4.next();
            if (action.getText().contains(menuItem)) {
                action.click();
                found = true;
                break;
            }

        }
        if (!found) {
            throw new RuntimeException("Menu item \"" + menuItem + "\" not found");
        }

    }

    /**
     * This method is to click on Actions Mentui
     */
    public void clickActionsMenu() {
        //	this.waitIfInterneExplorer();
        getBrowser().sleep(1000);
        List actionButtonList;
        ListIterator actionButtonListIterator;
        WebElement button;
        if (getBrowser().isElementPresent(By.xpath("//button[@title='Actions']"))) {
            actionButtonList = this.getDriver().findElements(By.xpath("//button[@title='Actions']"));
            actionButtonListIterator = actionButtonList.listIterator();

            while (actionButtonListIterator.hasNext()) {
                button = (WebElement) actionButtonListIterator.next();
                if (button != null && button.isDisplayed() && button.isEnabled()) {
                    button.click();
                    this.log("Clicked Action Menu");
                    break;
                }
            }
        } else if (getBrowser().isElementPresent(By.xpath("//button[@data-click[contains(.,'pyWorkActionsPerform')]]"))) {
            actionButtonList = this.getDriver().findElements(By.xpath("//button[@data-click[contains(.,'pyWorkActionsPerform')]]"));
            actionButtonListIterator = actionButtonList.listIterator();

            while (actionButtonListIterator.hasNext()) {
                button = (WebElement) actionButtonListIterator.next();
                if (button != null && button.isDisplayed() && button.isEnabled()) {
                    button.click();
                    this.log("Clicked Action Menu");
                    break;
                }
            }

        }

    }

    /**
     * This method is to switch  the focus to active Iframe
     */
    public void switchToActiveIFrame() {
        this.getBrowser().sleep(this.getTimeout() / 5);
        getDriver().switchTo().defaultContent();
        int iterationCounter = 0;

        while (iterationCounter < 3) {
            try {
                WebElement webGadget = this.getBrowser().getElementWhenReady(By.cssSelector("div[class*='iframe-wrapper'][style= 'display: block;']"));
                WebElement iFrame = webGadget.findElement(By.cssSelector("iframe[id*='PegaGadget']"));
                String iFrameID = iFrame.getAttribute("id");
                (new WebDriverWait(this.getDriver(), 3L)).until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(iFrameID));
                // this.logWriter.log(iFrameID, Level.FINE);
                return;
            } catch (NoSuchElementException var4) {
                this.getBrowser().sleep(this.getTimeout() / 10);
                //  this.logWriter.log("Switch to active iFrame" + var4.getMessage());

            }
            ++iterationCounter;
        }

        throw new RuntimeException("Failed to switch to active iFrame");
    }

    /**
     * This method is to logoff from the application
     */
    public void logout() {
        this.getBrowser().leaveIFrame();

        while (true) {
            try {
                this.getBrowser().waitForElementToBeClickable(By.cssSelector("div[data-click*= 'className\":\"Data-Portal']"));
                this.getBrowser().getElementWhenReady(By.cssSelector("div[data-click*= 'className\":\"Data-Portal']")).click();
                this.getBrowser().sleep(2000);
                this.getBrowser().getDriver().findElement(By.cssSelector("a[data-click*='logOff'")).click();
                this.getBrowser().sleep(this.getBrowser().getTimeout() / 5);
                this.getBrowser().getLogWriter().log(" User '" + this.userID + "' Log Off successfully", Level.INFO);
                break;
            } catch (Exception var3) {
                var3.printStackTrace();
            }
        }

        while (true) {
            try {
                do {
                    this.loadEnvironment();
                    this.getBrowser().sleep(this.getBrowser().getTimeout() / 10);
                } while (this.getBrowser().getDriver().findElements(By.id("txtUserID")).isEmpty());

                return;
            } catch (Exception var2) {
                var2.printStackTrace();
            }
        }
    }


}

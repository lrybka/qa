package com.jsystems.qa.qagui;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

import static java.lang.Thread.sleep;

public class WindowsTest extends ConfigFrontend {
    @Test
    public void testWindows() throws InterruptedException {
        String firstPageWindowHandle;
        String secondTestWindowHandle = null;

        String contactUrl = "http://www.testdiary.com/training/selenium/selenium-test-page/";

        driver.get(contactUrl);

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Open page in a new window")));

        firstPageWindowHandle = driver.getWindowHandle();


        WebElement hyperLinkElement = driver.findElement(By.linkText("Open page in a new window"));

        int hyperlinkXCoordinate = hyperLinkElement.getLocation().getX();
        int hyperlinkYCoordinate = hyperLinkElement.getLocation().getY();

        JavascriptExecutor jsexecutor = (JavascriptExecutor) driver;
        jsexecutor.executeScript("window.scrollBy(" + hyperlinkXCoordinate + "," + hyperlinkYCoordinate + ")", "");

        new WebDriverWait(driver, 100)
                .until(ExpectedConditions.elementToBeClickable(By.linkText("Open page in a new window")));

        hyperLinkElement.click();

        Set<String> testPageWindowHandle = driver.getWindowHandles();


        for (String windowHandle : testPageWindowHandle) {
            if (!firstPageWindowHandle.equals(windowHandle)) {
                secondTestWindowHandle = windowHandle;
            }
        }


        driver.switchTo().window(secondTestWindowHandle);

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("testpagelink")));

        driver.switchTo().window(secondTestWindowHandle).close();

        driver.switchTo().window(firstPageWindowHandle);

        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Open page in a new window")));

    }

    @Test
    public void frameTest(){
        String contactUrl = "http://www.testdiary.com/training/selenium/selenium-test-page/";

        driver.get(contactUrl);

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.name("testframe")));

        WebElement testframe = driver.findElement(By.name("testframe"));

        driver.switchTo().frame(testframe);

        String expectedFrameText =driver.findElement(By.id("testpagelink")).getText();
        String actualFrameText = "My frame text";

        if(actualFrameText.equals(expectedFrameText)){
            System.out.println("Found my frame text");
        }
        else {
            System.out.println("Did not find my frame text");
        }

        driver.switchTo().parentFrame();
    }

    @Test
    public void pageScroll() {
        String contactUrl = "http://www.testdiary.com/training/selenium/selenium-test-page/";

        driver.get(contactUrl);

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Open page in the same window")));

        WebElement hyperLinkElement = driver.findElement(By.linkText("Open page in the same window"));

        int hyperlinkYCoordinate = hyperLinkElement.getLocation().getY();
        int hyperlinkXCoordinate = hyperLinkElement.getLocation().getX();

        JavascriptExecutor jsexecutor = (JavascriptExecutor) driver;
        jsexecutor.executeScript("window.scrollBy(" + hyperlinkXCoordinate + "," + hyperlinkYCoordinate + ")", "");

        new WebDriverWait(driver, 100)
                .until(ExpectedConditions.elementToBeClickable(By.linkText("Open page in the same window")));

        hyperLinkElement.click();
    }

    @Test
    void scrollIntoView(){
        driver.get("http://manos.malihu.gr/repository/custom-scrollbar/demo/examples/complete_examples.html");

        JavascriptExecutor je = (JavascriptExecutor) driver;

        WebElement element = driver.findElement(By.xpath("//*[@id=\"mCSB_9_container\"]/ul/li[4]/img"));

        je.executeScript("arguments[0].scrollIntoView(true);",element);
    }

    @Test
    public void popupHandler(){
        driver.switchTo().alert();
        driver.findElement(By.id("userID")).sendKeys("userName");
        driver.findElement(By.id("password")).sendKeys("myPassword");
        driver.switchTo().alert().accept();
        driver.switchTo().defaultContent();
    }

    @Test
    public void alert(){
        String firstWIndow;
        firstWIndow = driver.getWindowHandle();

        Alert alert = driver.switchTo().alert();
        alert.accept();
        alert.dismiss();

        driver.switchTo().window(firstWIndow);
    }

    void waitForExecute(Executable condition, long maxWaitTime) {
        new WebDriverWait(driver, maxWaitTime).until(driver -> {
            try {
                condition.execute();
                return true;
            } catch (org.openqa.selenium.StaleElementReferenceException e) {
            } catch (org.openqa.selenium.WebDriverException e) {
            } catch (Throwable throwable) {
            }
            return false;
        });
    }

    void waitForInVisibilityElement(WebElement webElement, long maxWaitTime) {
        new WebDriverWait(driver, maxWaitTime).until(driver -> {
            try {
                if(webElement.isDisplayed()) return false;
                else return true;
            } catch (org.openqa.selenium.NoSuchElementException e){
                return true;
            } catch (org.openqa.selenium.StaleElementReferenceException e) {
                return true;
            }
        });
    }
}

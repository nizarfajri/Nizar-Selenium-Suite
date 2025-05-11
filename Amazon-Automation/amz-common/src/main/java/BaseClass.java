import io.qameta.allure.Attachment;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration; import java.util.List;

public class BaseClass {

private static WebDriver getDriver() {
    return DriverInstance.getDriver();
}

private static WebElement waitForClickable(By locator, int timeoutSeconds) {
    return new WebDriverWait(getDriver(), Duration.ofSeconds(timeoutSeconds))
            .until(ExpectedConditions.elementToBeClickable(locator));
}

private static WebElement waitForVisible(By locator, int timeoutSeconds) {
    return new WebDriverWait(getDriver(), Duration.ofSeconds(timeoutSeconds))
            .until(ExpectedConditions.visibilityOfElementLocated(locator));
}

public static void click(By locator) {
    waitForClickable(locator, 15).click();
}

public static void enterText(By locator, String value) {
    WebElement element = waitForClickable(locator, 10);
    element.clear();
    element.sendKeys(value);
}

public static void selectDropdownByValue(By locator, String value) {
    new Select(waitForVisible(locator, 10)).selectByValue(value);
}

public static void selectDropdownByText(By locator, String text) {
    new Select(waitForVisible(locator, 10)).selectByVisibleText(text);
}

public static void scrollToElement(By locator) {
    WebElement element = waitForVisible(locator, 10);
    ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
}

public static boolean isElementPresent(By locator, int timeoutSeconds) {
    try {
        new WebDriverWait(getDriver(), Duration.ofSeconds(timeoutSeconds))
                .until(ExpectedConditions.presenceOfElementLocated(locator));
        return true;
    } catch (TimeoutException e) {
        return false;
    }
}

public static boolean isElementVisible(By locator, int timeoutSeconds) {
    try {
        return waitForVisible(locator, timeoutSeconds).isDisplayed();
    } catch (Exception e) {
        return false;
    }
}

public static void mouseHover(By locator) {
    WebElement element = waitForVisible(locator, 10);
    new Actions(getDriver()).moveToElement(element).perform();
}

public static void doubleClick(By locator) {
    WebElement element = waitForClickable(locator, 10);
    new Actions(getDriver()).doubleClick(element).perform();
}

public static void rightClick(By locator) {
    WebElement element = waitForClickable(locator, 10);
    new Actions(getDriver()).contextClick(element).perform();
}

public static String getText(By locator) {
    return waitForVisible(locator, 10).getText();
}

public static String getAttribute(By locator, String attribute) {
    return waitForVisible(locator, 10).getAttribute(attribute);
}

public static void assertTextEquals(By locator, String expectedText) {
    String actualText = getText(locator);
    if (!actualText.equals(expectedText)) {
        throw new AssertionError("Expected: " + expectedText + ", but found: " + actualText);
    }
}

public static void assertTextNotEquals(By locator, String expectedSubstring) {
    String actualText = getText(locator);
    if (!actualText.contains(expectedSubstring)) {
        throw new AssertionError("Expected substring: " + expectedSubstring + ", but was: " + actualText);
    }
}

public static void waitForInvisibility(By locator, int timeoutSeconds) {
    new WebDriverWait(getDriver(), Duration.ofSeconds(timeoutSeconds))
            .until(ExpectedConditions.invisibilityOfElementLocated(locator));
}

public static void waitForPageLoad() {
    new WebDriverWait(getDriver(), Duration.ofSeconds(30)).until(
            webDriver -> ((JavascriptExecutor) webDriver)
                    .executeScript("return document.readyState").equals("complete")
    );
}

@Attachment(value = "Screenshot", type = "image/png")
public static byte[] captureScreenshot() {
    return ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
}

}
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.junit.Assert.assertEquals;

public class CurrencyConverterTest {
  public static void main(String[] args) {
    System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
    WebDriver driver = new ChromeDriver();

    driver.get("https://currencyconverter.com");

    WebElement sourceCurrency = driver.findElement(By.id("sourceCurrency"));
    sourceCurrency.sendKeys("USD");

    WebElement targetCurrency = driver.findElement(By.id("targetCurrency"));
    targetCurrency.sendKeys("EUR");

    WebElement amount = driver.findElement(By.id("amount"));
    amount.sendKeys("100");

    WebElement convertButton = driver.findElement(By.id("convertButton"));
    convertButton.click();

    WebDriverWait wait = new WebDriverWait(driver, 10);
    WebElement convertedAmount = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("convertedAmount")));

    String actualConvertedAmount = convertedAmount.getText();
    String expectedConvertedAmount = "86.52"; // or whatever the expected amount is
    assertEquals(expectedConvertedAmount, actualConvertedAmount);

    driver.quit();
  }
}
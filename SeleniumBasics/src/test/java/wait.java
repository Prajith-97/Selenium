import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.io.IOException;
import java.time.Duration;
import java.util.function.Function;

public class wait {
    public static void main(String[] args) throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //explicit wait
        WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = w.until(ExpectedConditions.elementToBeClickable(By.xpath("")));
        w.until(ExpectedConditions.elementToBeClickable(element)).click();





        //fluent wait: //declaration part
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);
//        WebElement ele = wait.until(ExpectedConditions.)


        //usage part
        WebElement ele = wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.xpath(""));

            }
        });
        ele.click();  //above function will return element, and we can use it to perform actions
    }
}

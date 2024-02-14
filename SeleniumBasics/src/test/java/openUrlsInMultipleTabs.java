import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.time.Duration;

public class openUrlsInMultipleTabs {
    public static void main(String[] args) throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.switchTo().newWindow(WindowType.TAB);//to open link in new tab
        driver.switchTo().newWindow(WindowType.WINDOW);// to open link in new window
        driver.get("https://opencart.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }
}

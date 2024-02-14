import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class screenshot {
    public static void main(String[] args) throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.redbus.com/");
        driver.manage().window().maximize();
        //full page screenshot
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        File target = new File(".\\screenshot.s.png");
        FileUtils.copyFile(src, target);

        //specific section
        WebElement element = driver.findElement(By.xpath(""));
        File src1 = element.getScreenshotAs(OutputType.FILE);
        File target1 = new File(".\\screenshot.s.png");
        FileUtils.copyFile(src1, target1);
    }
}
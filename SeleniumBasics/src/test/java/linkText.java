import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class linkText {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");
//        driver.findElement(By.linkText("New Releases")).click();

        List<WebElement> links = driver.findElements(By.tagName("a"));
        for(WebElement link:links){
            String linkUrl = link.getAttribute("href");
            String text = link.getText();
            System.out.println(linkUrl);
            System.out.println(text);
            }
        }

    }

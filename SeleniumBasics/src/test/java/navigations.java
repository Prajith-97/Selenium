import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class navigations {
    public static void main (String[] args){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https:www.snapdeal.com");
        driver.get("https:www.amazon.in");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
    }
}


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;

public class javascriptExecutor {
    public static void main(String[] args) throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript();

        //flashing: keep on highlighting an element


        //Draw boarder while screenshot

        //get title

        //click

        //refresh

        //scroll down

        // Scroll up

        //zoom

    }
}
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.io.IOException;

public class slider {
    public static void main(String[] args) throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
        WebElement minSlider = driver.findElement(By.xpath("//span[@class='ui-slider-handle ui-corner-all ui-state-default'][1]"));
        System.out.println("location of minimum slider" +minSlider.getLocation());
        System.out.println("height and width of minimum slider" +minSlider.getSize());

        Actions act = new Actions(driver);
        act.dragAndDropBy(minSlider, 100, 30).perform();

    }
}

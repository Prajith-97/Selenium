import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class utils {

    //draw boarder
    public static void drawBoarder(WebElement element, WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("argument[0].style.boarder='3px solid red", element);
    }

    //getTitle
    public static String getTile(WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        String title = js.executeScript("return document.title").toString();
        return title;
    }

    //click
    public static void clickElement(WebElement element, WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("argument[0].click", element);
    }

    //generate Alert
    public static void generateAlert(WebDriver driver, String message){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("alert('"+message+"')");
    }

    //refresh
    public static void refresh(WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("history.go(0)");
    }

    //scroll down
    public static void scrollPageDown(WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    //scroll up
    public static void scrollup(WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollTo(0,-document.body.scrollHeight)");
        js.executeScript("window.scrollBy(0,600)");
//        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    //zoom
    public static void zoom(WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("document.body.style.zoom='50%'");
    }

}

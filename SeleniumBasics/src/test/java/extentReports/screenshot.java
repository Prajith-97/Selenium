package extentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.jsoup.Connection;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class screenshot {
    static WebDriver driver;

    public static void launchDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.redbus.com/");
    }

    public static String captureScreenshot() throws IOException {
        TakesScreenshot ts = (TakesScreenshot)driver;
        String base64 = ts.getScreenshotAs(OutputType.BASE64);
        return base64;
    }
    public static String captureScreenshot(String imageName) throws IOException {
        TakesScreenshot ts = (TakesScreenshot)driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File target = new File("/screenshot/"+imageName);
        FileUtils.copyFile(source, target);
        System.out.println(target.getAbsolutePath());
        return target.getAbsolutePath();
    }
    public static void main(String[] args) throws IOException {
        launchDriver();
        ExtentReports extentReports = new ExtentReports();
        File file = new File("C:\\JavaIntellij\\SeleniumBasics\\report.html");
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
        extentReports.attachReporter(sparkReporter);
        String Base64 = captureScreenshot();
        String path = captureScreenshot("redbus.png");

        //BASE64
        extentReports.createTest("Screenshot Base 64", "Attach screenshot")
                .pass("Test Passed")
                        .addScreenCaptureFromPath(Base64);
        extentReports.createTest("Screenshot Base 64 with title", "Attach screenshot")
                .pass("Test Passed")
                .addScreenCaptureFromBase64String(Base64,"Base64 Image");
        //IMAGE CAPTURED USING PATH
        extentReports.createTest("Screenshot path", "Attach screenshot")
                .log(Status.INFO,"Test Passed")
                        .addScreenCaptureFromPath(path);
        extentReports.createTest("Screenshot path with title", "Attach screenshot")
                .pass("Test Passed")
                .addScreenCaptureFromPath(path,"Image");

        //Attach Screenshot in log level
        extentReports.createTest("Screenshot ", "Attach screenshot")
                .pass("Test Passed")
                .pass("Test passed", MediaEntityBuilder.createScreenCaptureFromBase64String(path).build());

        extentReports.flush();
    }
}

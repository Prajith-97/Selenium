package extentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;

public class basic {
    public static void main(String[] args){
        ExtentReports extentReports=new ExtentReports();
        File file = new File("C:\\JavaIntellij\\SeleniumBasics\\report.html");
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);

        extentReports.attachReporter(sparkReporter);

        ExtentTest test1 = extentReports.createTest("Test1");
        test1.pass("Test 1 passed");

        ExtentTest test2 = extentReports.createTest("Test2");
        test2.log(Status.PASS, "Test 2 passed");
        extentReports.flush();
    }



}

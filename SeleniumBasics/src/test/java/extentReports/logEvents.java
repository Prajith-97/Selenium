package extentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;

public class logEvents {
    public static void main(String[] args){
        ExtentReports extentReports=new ExtentReports();
        File file = new File("C:\\JavaIntellij\\SeleniumBasics\\report.html");
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(file);
        extentReports.attachReporter(sparkReporter);

        ExtentTest test1 = extentReports.createTest("Test1")
                .log(Status.PASS, "passed")
                .log(Status.SKIP, "skipped")
                .log(Status.FAIL, "failed")
                .log(Status.INFO, "info");


        ExtentTest test2 = extentReports.createTest("Test2");
        test2.log(Status.SKIP, "Test 2 skipped");

        ExtentTest test3 = extentReports.createTest("Test3");
        test3.log(Status.FAIL, "Test 3 failed");

        ExtentTest test4 = extentReports.createTest("Test4");
        test4.log(Status.INFO, "Info Message");

        extentReports.flush();
    }



}



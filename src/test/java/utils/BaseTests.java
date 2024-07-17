package utils;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import java.io.File;

public class BaseTests {

    public WebDriver driver;
    private ScreenshotUtils screenshotUtils;
    private ExtentTest extentTest;
    private ConfigLoader configLoader = new ConfigLoader("src/test/resources/properties/ApplicationURLs.properties");

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        screenshotUtils = new ScreenshotUtils(driver);
        String testSiteURL = configLoader.getProperty("applicationURL");
        driver.get(testSiteURL);
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown(){
        if(driver != null){
            driver.quit();
        }

        ReportManager.getInstance().flush();
    }

    /**
     * Aceasta metoda creaza rezultatul testului
     * @param result
     */
    @AfterMethod
    public void afterMethod(ITestResult result){
        if(result.getStatus() == ITestResult.FAILURE){
            captureAndSaveFailureScreenshot(result.getMethod().getMethodName());
        }

        if (result.getStatus() == ITestResult.FAILURE) {
            extentTest.log(Status.FAIL, MarkupHelper .createLabel("Test case Failed: " + result.getName(), ExtentColor.RED));
            extentTest.fail(result.getThrowable());
        }else if(result.getStatus() == ITestResult.SUCCESS){
            extentTest.log(Status.PASS, MarkupHelper .createLabel("Test case Passed: " + result.getName(), ExtentColor.GREEN));
            extentTest.fail(result.getThrowable());
        }else{
            extentTest.log(Status.SKIP, MarkupHelper .createLabel("Test case Skipped: " + result.getName(), ExtentColor.YELLOW));
        }
    }

    public void initTest(String testName){
        extentTest = ReportManager.createTest(testName);
    }

    private void captureAndSaveFailureScreenshot(String testName){
        //Facem un folder nou, daca nu exista
        File screenshotDirectory = new File("Screenshots");
        if(!screenshotDirectory.exists()){
            screenshotDirectory.mkdir();
        }

        //capture and save screenshot
        screenshotUtils.captureAndSaveScreenshots(testName);
    }

}

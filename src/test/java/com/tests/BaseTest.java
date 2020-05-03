package com.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {
    protected WebDriver driver;
    @BeforeTest
    public void setupDriver(ITestContext ctx) throws MalformedURLException {

        //BROWSER =>chrome /firefox
        //HUB_HOST => localhost /10.0.1.3 /hostname

        String host = "localhost";
        DesiredCapabilities dc ;

        if(System.getProperty("BROWSER") != null && System.getProperty("BROWSER").equalsIgnoreCase("firefox")){
            dc = DesiredCapabilities.firefox();
        } else {
            dc = DesiredCapabilities.chrome();
        }


        if(System.getProperty("HUB_HOST") != null){
            host = System.getProperty("HUB_HOST");
        }

        String testName = ctx.getCurrentXmlTest().getName();

        String completeUrl = "http://" + host + ":4444/wd/hub";
        this.driver = new RemoteWebDriver(new URL(completeUrl),dc);
        System.out.println("TestName :" + testName);
        dc.setCapability("name",testName);
       // System.setProperty("webdriver.chrome.driver","C:\\Users\\vijayendra.kumar\\Downloads\\chromedriver_win32\\chromedriver.exe");
        //this.driver = new ChromeDriver() ;
    }

    @AfterTest
    public void quitDriver(){
        this.driver.quit();
    }
}

package com.jsystems.qa.qagui;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class ConfigFrontend {
    protected WebDriver driver;
    
    //    String chromePath;
    String fireFoxPath;
    {
        try {
//            chromePath = Paths.get(getClass().getClassLoader().getResource("drivers/chromedriver.exe")
//                    .toURI()).toFile().getAbsolutePath();
            fireFoxPath = Paths.get(getClass().getClassLoader().getResource("drivers/geckodriver.exe")
                    .toURI()).toFile().getAbsolutePath();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @BeforeAll
    public static void setUpAll() {
        WebDriverManager.chromedriver().setup();
//        WebDriverManager.firefoxdriver().setup();
    }

    @BeforeEach
    public void setUpEach() throws MalformedURLException {
        setupSystemProperties();

        //driver = new ChromeDriver();
        //driver = new FirefoxDriver();



        if (Configuration.BROWSER.equals("chrome")) {
            driver = new ChromeDriver();
        } else {
            driver = new FirefoxDriver();
        }

        setupDriver();
    }


    private void setupSystemProperties() {
//        System.setProperty("webdriver.chrome.driver", chromePath);
        System.setProperty("webdriver.gecko.driver", fireFoxPath);  // ustawienie zminnej dla drivera firefox
    }

    private void setupDriver() {
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
    }


    @AfterEach
    public void tearDownEach() {   // to co w nawiasach {} dotyczy sie @AfterEach
        driver.quit();
    }


    private void setUpRemote() {

        //        DesiredCapabilities cap = DesiredCapabilities.chrome();
//        cap.setPlatform(Platform.LINUX);
//        cap.setVersion("");
//
//
//        ChromeOptions options = new ChromeOptions();
//        options.setCapability("platform", "LINUX");
//        options.setCapability("browserName", "chrome");
//        driver = null;
//        try {
//            driver = new RemoteWebDriver(new URL("http://10.0.75.1:4444/wd/hub"), cap);
//        setupDriver();
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
    }
}
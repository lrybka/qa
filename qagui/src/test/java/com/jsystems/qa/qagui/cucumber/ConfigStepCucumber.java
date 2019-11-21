package com.jsystems.qa.qagui.cucumber;

import org.openqa.selenium.WebDriver;

import java.net.URISyntaxException;
import java.nio.file.Paths;

public class ConfigStepCucumber {

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




}

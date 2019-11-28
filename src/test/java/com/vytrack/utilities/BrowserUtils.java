package com.vytrack.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.*;
import java.util.function.*;

public class BrowserUtils {

    public static void waitUntilLoaderScreenDisappear(){
        String loaderMaskLocator = "div[class='loader-mask shown']";
        try{
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Long.valueOf(10));
            wait.until(ExpectedConditions.invisibilityOf(Driver.getDriver().findElement(By.cssSelector(loaderMaskLocator))));
        } catch(Exception e){
            System.out.println(e + " : : Loader Mask doesn't present");
        }
    }

    public static void waitPlease(int seconds){
        try {
            Thread.sleep(seconds * 1000 );
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

}

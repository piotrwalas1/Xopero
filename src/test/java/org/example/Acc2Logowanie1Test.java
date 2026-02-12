package XOPERO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class Acc2Logowanie1Test {
    @Test
    public void account1() throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        driver.get("https://xopero.com/pl/");
        String currentWindow = driver.getWindowHandle();
        Set<String> windowsNames = driver.getWindowHandles();
        for(String window : windowsNames){
            if(!window.equals(currentWindow)){
                driver.switchTo().window(window);
            }
        }
        driver.findElement(By.xpath("//*[@id='CybotCookiebotDialogBodyLevelButtonAccept']")).click();
        driver.switchTo().window(currentWindow);
        driver.findElement(By.xpath("/html/body/header/div[2]/nav/ul/li[2]/label/div/img")).click();
        driver.findElement(By.xpath("/html/body/header/div[2]/nav/ul/li[2]/div/ul/li[1]/a")).click();
        Set<String> windowsNames1 = driver.getWindowHandles();
        for(String window : windowsNames1){
            if(!window.equals(currentWindow)){
                driver.switchTo().window(window);
            }
        }
        driver.findElement(By.xpath("//*[@id='loginProtect']")).sendKeys("piotr@interia.pl");
driver.findElement(By.xpath("//*[@id='password']")).sendKeys("Ladnedlugiehaslo1!");
        Actions actions = new Actions(driver);
        WebElement heading = driver.findElement(By.id("submitBtn"));
        actions.moveToElement(heading).perform();
        Thread.sleep(1500);
        driver.quit();

}}

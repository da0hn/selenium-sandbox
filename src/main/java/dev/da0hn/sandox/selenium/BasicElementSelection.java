package dev.da0hn.sandox.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BasicElementSelection {

  public static void main(String[] args) throws InterruptedException {

    /**
     * Css Selector:
     *  Class Name: tagName.classname -> button.signInBtn
     *  Id: tagName#id -> input#inputUsername
     *  Attribute: tagName[attribute='value'] -> input[placeholder='Password']
     */

    final var driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

    driver.get("https://rahulshettyacademy.com/locatorspractice/");
    driver.findElement(By.id("inputUsername")).sendKeys("da0hn");
    driver.findElement(By.name("inputPassword")).sendKeys("123456");
    driver.findElement(By.cssSelector("button.signInBtn")).click();

    final var text = driver.findElement(By.cssSelector("p.error")).getText();
    System.out.println(text);
  }

}

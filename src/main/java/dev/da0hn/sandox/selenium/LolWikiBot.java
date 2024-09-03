package dev.da0hn.sandox.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class LolWikiBot {

  public static void main(String[] args) {
    ChromeDriver driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    driver.get("https://leagueoflegends.fandom.com/wiki/Champion");
    driver.findElement(By.cssSelector("div[data-tracking-opt-in-accept='true']")).click();

    final var element = driver.findElement(By.cssSelector("a[title='List of champions']"));
    final var actions = new Actions(driver);
    actions.moveToElement(element).click().perform();

    final var tableElement = driver.findElement(By.xpath("//table[@data-index-number='0']"));
    tableElement.findElements(By.tagName("tr")).forEach(row -> {
      final var columns = row.findElements(By.tagName("td"));
      if (!columns.isEmpty()) {
        final var championName = columns.get(0).getText();
        final var classType = columns.get(1).getText();
        final var releaseDate = columns.get(2).getText();
        final var lastChanged = columns.get(3).getText();
        final var blueEssencePrice = columns.get(4).getText();
        final var rpPrice = columns.get(5).getText();
        System.out.println("Champion: " + championName + " | Class: " + classType + " | Release Date: " + releaseDate + " | Last " +
                           "Changed: " + lastChanged + " | Blue Essence Price: " + blueEssencePrice + " | RP Price: " + rpPrice);
      }
    });

  }

}

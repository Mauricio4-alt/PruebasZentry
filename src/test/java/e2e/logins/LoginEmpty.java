package e2e.logins;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginEmpty {
    private WebDriver driver;

    @BeforeEach
    public void init(){
        this.driver =new ChromeDriver();
        this.driver.get("https://app.zentryplatform.camdvr.org/");
        String title = this.driver.getTitle();

        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @org.junit.jupiter.api.Test
    public void login(){
        WebElement botonLogin= this.driver.findElement(By.className("btn-info"));
        botonLogin.click();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        WebElement botonSubmit = this.driver.findElement(By.xpath("//*[@id=\"login-page\"]/div/form/div[3]/button[2]"));

        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        botonSubmit.submit();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement alert = this.driver.findElement(By.cssSelector(".invalid-feedback"));
        Assertions.assertEquals("Username cannot be empty!",alert.getAttribute("textContent"));

    }
    @AfterEach
    public void close(){
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        this.driver.quit();
    }
}

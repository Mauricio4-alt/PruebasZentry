package e2e.logins.logins;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class RemenberPasswordFailedTest {
    private WebDriver driver;

    @BeforeEach
    public void init(){
        this.driver =new ChromeDriver();
        this.driver.get("https://app.zentryplatform.camdvr.org/");
        String title = this.driver.getTitle();
        System.out.println(title);
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @Test
    public void login(){
        WebElement botonLogin= this.driver.findElement(By.className("btn-info"));
        botonLogin.click();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement savePassword = this.driver.findElement(By.name("#login-page > div > form > div.modal-body > div.d-flex.flex-column.gap-2.mb-3.px-1 > a"));
        savePassword.click();
        WebElement h1Element = this.driver.findElement(By.tagName("h1"));
        String textH1 = h1Element.getAttribute("textContent");
        Assertions.assertEquals("Restablecer su contraseña",textH1);

    }
    /*@AfterEach
    public void close(){

        this.driver.quit();
    }*/
}

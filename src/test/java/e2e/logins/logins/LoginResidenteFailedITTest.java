package e2e.logins.logins;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginResidenteFailedITTest {
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
        WebElement inputUsername = this.driver.findElement(By.id("username"));
        WebElement inputPassword = this.driver.findElement(By.id("password"));
        WebElement botonSubmit = this.driver.findElement(By.xpath("//*[@id=\"login-page\"]/div/form/div[3]/button[2]"));

        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        inputUsername.sendKeys("mauricio");
        inputPassword.sendKeys("criente2");

        botonSubmit.submit();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement alert = this.driver.findElement(By.cssSelector("#login-page > div > form > div.modal-body > div.row > div:nth-child(1) > div"));
        Assertions.assertEquals("¡El inicio de sesión ha fallado! Por favor, revise las credenciales e intente de nuevo.",alert.getAttribute("textContent"));
        ;
    }
    /*@AfterEach
    public void close(){
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        this.driver.quit();
    }*/
}

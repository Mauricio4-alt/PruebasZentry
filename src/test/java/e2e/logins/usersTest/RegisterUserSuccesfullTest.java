package e2e.logins.usersTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class RegisterUserSuccesfullTest {
    private WebDriver driver;

    @BeforeEach
    public void init() {
        this.driver = new ChromeDriver();
        this.driver.get("https://app.zentryplatform.camdvr.org/");
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void login() {


        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        var botonLogin = this.driver.findElement(By.className("btn-info"));
        botonLogin.click();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebElement inputUsername = this.driver.findElement(By.id("username"));
        WebElement inputPassword = this.driver.findElement(By.id("password"));
        WebElement botonSubmit = this.driver.findElement(By.xpath("//*[@id=\"login-page\"]/div/form/div[3]/button[2]"));

        inputUsername.sendKeys("admin");
        inputPassword.sendKeys("admin");

        botonSubmit.click();

        List <WebElement> botones = this.driver.findElements(By.cssSelector())
    }







    /*@AfterEach
    public void close(){
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        this.driver.quit();
    }*/
}

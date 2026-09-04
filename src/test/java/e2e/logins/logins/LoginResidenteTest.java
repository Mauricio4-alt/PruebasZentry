package e2e.logins.logins;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginResidenteTest {
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
        WebElement inputUsername = this.driver.findElement(By.id("username"));
        WebElement inputPassword = this.driver.findElement(By.id("password"));
        WebElement botonSubmit = this.driver.findElement(By.xpath("//*[@id=\"login-page\"]/div/form/div[3]/button[2]"));

        inputUsername.sendKeys("mauricio");
        inputPassword.sendKeys("cliente2");

        botonSubmit.submit();

    }
    /*@AfterEach
    public void close(){

        this.driver.quit();
    }*/
}

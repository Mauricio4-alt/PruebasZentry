package e2e.logins;


import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class LoginResidenteIT {
    private WebDriver driver;

    @BeforeEach
    public void init(){
        this.driver =new ChromeDriver();
        this.driver.get("https://app.zentryplatform.camdvr.org/");
        var title = this.driver.getTitle();
        System.out.println(title);
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @Test
    public void login(){
        var botonLogin= this.driver.findElement(By.className("btn-info"));
        botonLogin.click();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        var inputUsername = this.driver.findElement(By.id("username"));
        var inputPassword = this.driver.findElement(By.id("password"));
        var botonSubmit = this.driver.findElement(By.xpath("//*[@id=\"login-page\"]/div/form/div[3]/button[2]"));

        inputUsername.sendKeys("mauricio");
        inputPassword.sendKeys("cliente2");

        botonSubmit.submit();

    }
    @AfterEach
    public void close(){

        this.driver.quit();
    }
}

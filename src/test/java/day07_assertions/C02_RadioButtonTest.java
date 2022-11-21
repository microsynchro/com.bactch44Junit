package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

//        1. Bir class oluşturun : RadioButtonTest
//        2. Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
//        - https://www.facebook.com adresine gidin
//        - Cookies’i kabul edin
//        - “Create an Account” button’una basin
//        - “radio buttons” elementlerini locate edin
//        - Secili degilse cinsiyet butonundan size uygun olani secin

public class C02_RadioButtonTest {
    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test
    public void test01(){
        driver.get("https://facebook.com");
        driver.findElement(By.xpath("//button[@data-cookiebanner='accept_button']")).click();
        driver.findElement(By.xpath("(//div[@class='_6ltg'])[2]")).click();
        driver.findElement(By.xpath("//input[@value=1]")).click();
    }

    @After
    public void teardown(){
        driver.close();
    }






}

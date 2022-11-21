package Day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_TekSayfadaFarkiTestler {

    WebDriver driver;
    WebElement searchBox;

    @Test
    public void test01(){
//        amazon sayfasinda nutella icin arama yapap sonuc yazisinin nutella icerdigini test edelim
        driver.get("httpsB//www.amazon.com/");
    }

    @Test
    public void test02(){
//        amazon sayfasinda java icin arama yapip sonuc yazisinin java icerdigini test edelim.
    }
    @Test
    public void test03(){
//        amazon sayfasinda ali icin arama yapip sonuc yazisinin ali icerdigini test edelim.
    }

    @BeforeClass
    public void settings(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.findElement(By.id("twotabsearchtextbox")); 
    }

    @AfterClass
    public void teardown(){

        driver.close();
    }
}

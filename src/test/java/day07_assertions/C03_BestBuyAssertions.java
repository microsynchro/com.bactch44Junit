package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BestBuyAssertions {


//    1) Bir class oluşturun: BestBuyAssertions
//    2) https://www.bestbuy.com/ Adresine gidin farkli test method’lari olusturarak asagidaki testleri yapin
//      ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin

    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://www.bestbuy.com");

    }

    @Test
    public void pageUrl(){
//              ○ Sayfa URL’inin https://www.bestbuy.com/ ‘a esit oldugunu test edin

        String pageUrl = "https://www.bestbuy.com/";
        Assert.assertEquals(pageUrl,driver.getCurrentUrl());
    }

    @Test
    public void titleTest(){

//              ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin.
        Assert.assertFalse(driver.getTitle().contains("Rest"));
    }

    @Test
    public void logoTest(){
        //      ○ logoTest => BestBuy logosunun görüntülendigini test edin
        Assert.assertTrue(driver.findElement(By.xpath("(//img[@class='logo'])[1]")).isDisplayed());
    }

    @Test
    public void FrancaisLinkTest(){
        //      ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin.
        Assert.assertTrue(driver.findElement(By.xpath("//button[text()='Français']")).isDisplayed());
    }

    @AfterClass
    public static void teardown(){
        driver.close();

    }




}

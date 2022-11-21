package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_YoutubeAssertions {


//    1) Bir class oluşturun: YoutubeAssertions
//    2) https://www.youtube.com adresine gidin
//    3) Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
//○ titleTest => Sayfa başlığının “YouTube” oldugunu test edin
//○ imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
//○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
//○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin

    static WebDriver driver;

    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://www.youtube.com");
    }
    @Test
    public void titleTest(){
        Assert.assertTrue(driver.getTitle().contains("YouTube"));

    }
    @Test
    public static void imageTest(){
        driver.findElement(By.xpath("(//button[@class='yt-spec-button-shape-next yt-spec-button-shape-next--filled yt-spec-button-shape-next--call-to-action yt-spec-button-shape-next--size-m '])[2]")).click();
        Assert.assertTrue(driver.findElement(By.xpath("(//yt-icon[@class='style-scope ytd-logo'])[1]")).isDisplayed());
//        WebElement youtubeLogo = driver.findElement(By.xpath("(//yt-icon[@class='style-scope ytd-logo'])[1]"));
//        youtubeLogo.isEnabled();

    }
    @Test
    public void searchBoxTest(){
        Assert.assertTrue(driver.findElement(By.xpath("//input[@id='search']")).isEnabled());

    }
    @Test
    public void wrongTitleTest(){
        String expectedTitle = "youtube";
        Assert.assertFalse(expectedTitle,driver.getTitle().equals(expectedTitle));

    }

    @AfterClass
    public static void teardown(){

    }
}

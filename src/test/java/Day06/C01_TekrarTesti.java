package Day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Arrays;

public class C01_TekrarTesti {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


//        1-C01_TekrarTesti isimli bir class olusturun
//        2- https://www.google.com/ adresine gidin
        driver.get("http://www.google.com");
//        3- cookies uyarisini kabul ederek kapatin
        driver.findElement(By.xpath("//div[text()='Sprejmi vse']")).click();
//        4-Sayfa basliginin “Google” ifadesi icerdigini test edin
        String actualPageTitle = driver.getTitle();
        if (actualPageTitle.contains("Google")){
            System.out.println("Page title test PASSED");
        } else {
            System.out.println("Page title test FAILED. Actual page title is: "+actualPageTitle);
        }
//        5- Arama cubuguna “Nutella” yazip aratin
        driver.findElement(By.xpath("//input[@class='gLFyf']")).sendKeys("Nutella"+Keys.ENTER);
//        6-Bulunan sonuc sayisini yazdirin
        WebElement resultElement = driver.findElement(By.xpath("(//div[@id='result-stats'])[1]"));
        System.out.println(resultElement.getText());
//        7- sonuc sayisinin 10 milyon’dan fazla oldugunu test edin
        String resultString = resultElement.getText();
        String[] resultStringWords = resultString.split(" ");
        System.out.println(Arrays.toString(resultStringWords));
        String resultNutella = resultStringWords[1];
        resultNutella = resultNutella.replace(".","");
        int numberOfNutella = Integer.parseInt(resultNutella);
        System.out.println(resultNutella);

        if (numberOfNutella>10000000){
            System.out.println("Nutella result no greater then 10000000 test PASSED");
        } else{
            System.out.println("Nutella result no greater then 10000000 test FAILED");
        }
//        8-Sayfayi kapatin
        driver.close();


    }
}

package Day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Practice {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


//        1. “https://www.saucedemo.com” Adresine gidin
        driver.get("https://www.saucedemo.com");

//        2. Username kutusuna “standard_user” yazdirin
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

//        3. Password kutusuna “secret_sauce” yazdirin
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");

//        4. Login tusuna basin
        driver.findElement(By.id("login-button")).click();

//        5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        WebElement firstProductName = driver.findElement(By.xpath("(//div[@class='inventory_item_name'])[1]"));
        String firstProductNameString = firstProductName.getText();
        firstProductName.click();

//        6. Add to Cart butonuna basin
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();

//        7. Alisveris sepetine tiklayin
        driver.findElement(By.id("shopping_cart_container")).click();

//        8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        WebElement productNameInCardPage = driver.findElement(By.id("item_4_title_link"));
//        String productnameInCardPage = productNameInCardPage.getText();
        if (firstProductNameString.equals(firstProductNameString)){
            System.out.println("To choose rigth product test PASSED");
        } else {
            System.out.println("To choose rigth product test FAILED");
        }

//        9. Sayfayi kapatin
        driver.close();

    }
}

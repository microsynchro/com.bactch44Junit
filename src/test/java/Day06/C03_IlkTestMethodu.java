package Day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class C03_IlkTestMethodu {

    WebDriver driver;

    @Test
    public void test01(){
//        amazon.com'a gidelim ve Title'in "amazon" icerdigini test edelim.
        driver.get("https://amazon.com");
        String actualTitle = driver.getTitle();
        String expectedTitle = "amazon";

        if (actualTitle.contains(expectedTitle)){
            System.out.println("Amazon sayfasi testi PASSED");
        }else {
            System.out.println(("Amazon sayfasi testi FAILED"));
        }
    }

    @Test
    public void test02(){
//        google'a gidelim ve basligin "google" icerdigini test edelim.
        driver.get("https://www.google.com");
        String actualTitle = driver.getTitle();
        String expectedTitle = "google";

        if (actualTitle.contains(expectedTitle)){
            System.out.println("Google sayfasi testi PASSED");
        }else {
            System.out.println(("Google sayfasi testi FAILED"));
        }

            }

    @Before
    public void settings(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void exit (){
        driver.close();

    }

}

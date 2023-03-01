package Test;

import com.Wavecart.pages.WaveCartPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;


public class WaveKartTest{
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        System.setProperty("Webdriver.chrome.driver", "G:\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.wavemakeronline.com/run-0dnqs4vt0q/WaveKart_master/#/Main");
        driver.manage().window().maximize();
    }
    @Test(dataProvider = "products", dataProviderClass = WaveKartDataProvider.class)
    public void verIfyProducts(String productName,Integer noOfItems, Integer price, String Quantity) {
        WaveCartPage wave = new WaveCartPage(driver);
        wave.addToCart(productName, noOfItems);
        wave.placeOrder(productName, noOfItems, price,Quantity);
        wave.canCelOrder();
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}





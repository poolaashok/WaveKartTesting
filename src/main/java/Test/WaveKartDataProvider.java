package Test;

import org.testng.annotations.DataProvider;

public class WaveKartDataProvider {
    @DataProvider(name = "products")
    public static Object[][] products() {
        return new Object[][]{{"Moto G (Black, with 8 GB)",1, 195,"1"},
                {"HP Pavilion 15-n039TX Laptop", 1,562,"1"},
                {"Canon PowerShot SX160 IS Point & Shoot",1, 143,"1"}};
        //remove the extra parameter.
    }
}

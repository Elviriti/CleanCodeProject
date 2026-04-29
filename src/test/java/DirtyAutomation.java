import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DirtyAutomation {
    // SMELL: Large Class y Feature Envy
    @Test
    public void test() {
        // SMELL: Shotgun Surgery (URL y credenciales hardcodeadas)
        WebDriver d = new ChromeDriver();
        d.get("https://www.saucedemo.com/");

        // SMELL: Nombres crípticos (d, u, p)
        d.findElement(By.id("user-name")).sendKeys("standard_user");
        d.findElement(By.id("password")).sendKeys("secret_sauce");
        d.findElement(By.id("login-button")).click();

        // SMELL: Long Method (Login y compra en un solo bloque)
        d.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        d.findElement(By.className("shopping_cart_link")).click();
        d.findElement(By.id("checkout")).click();

        // SMELL: Duplicate Code (Se repetiría en cada test nuevo)
        d.findElement(By.id("first-name")).sendKeys("Nombre");
        d.findElement(By.id("last-name")).sendKeys("Apellido");
        d.findElement(By.id("postal-code")).sendKeys("12345");
        d.findElement(By.id("continue")).click();
        d.findElement(By.id("finish")).click();

        if(d.getCurrentUrl().contains("checkout-complete")) {
            System.out.println("Ok");
        }
        d.quit(); // SMELL: Dead Code si el test falla antes
    }
    it commit -m "feat: functional dirty code with 10 identified smells"

}
it commit -m "feat: functional dirty code with 10 identified smells"


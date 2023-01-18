package domaci20;

import com.sun.xml.internal.ws.model.WrapperBeanGenerator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/*
Uporediti da li u rezultatu (ispod submit), full name i email su isti kao uneseni pre
submita, da nije doslo do izmene.
Upisati odgovarajucu poruku ako su isti ili ako se razlikuju podaci.
*/
public class Domaci20 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\colic\\OneDrive\\Radna površina\\QA\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/text-box");
        driver.manage().window().maximize();

        WebElement username = driver.findElement(By.id("userName"));
        username.sendKeys("Andjela Colic");


        WebElement useremail = driver.findElement(By.id("userEmail"));
        useremail.sendKeys("andjela.colic.cola@gmail.com");

        WebElement currentaddress = driver.findElement(By.id("currentAddress"));
        currentaddress.sendKeys("Novi Sad");

        WebElement permanentaddress = driver.findElement(By.id("permanentAddress"));
        permanentaddress.sendKeys("Novi Sad");

        WebElement submit = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[2]/div[2]/div[2]/form/div[5]/div/button"));
        // submit.submit(); ovom linijom mi se brišu uneti podaci, ne pojavljuje se textbox ispod
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollBy(0,350);", "");

        submit.click();


        WebElement actualname = driver.findElement(By.id("name"));
        String actualName = actualname.getText();
        WebElement actualemail = driver.findElement(By.id("email"));
        String actualEmail = actualemail.getText();
        WebElement actualCurrrentAddress = driver.findElement(By.xpath("//*[@id=\"currentAddress\"]"));
        WebElement actualPermanentAddress = driver.findElement(By.xpath("//*[@id=\"permanentAddress\"]"));


        try {
            if (actualName.substring(5).equals("Andjela Colic") && actualEmail.substring(6).equals("andjela.colic.cola@gmail.com")) {
                System.out.println("Uneti i ispisani podaci su isti");
            } else {
                System.out.println("Uneti i ispisani podaci se razlikuju");
            }
        } catch (NullPointerException e) {
            System.out.println("Greska");
        }


    }


}

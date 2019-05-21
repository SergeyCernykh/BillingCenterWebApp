import com.BillingCenter.services.Services;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.util.logging.Level;

public class Tests extends Assert {

    private String base_path = "http://localhost:8080/BillingCenter_war_exploded/";

    @Test
    public void Service(){
        System.setProperty("webdriver.chrome.driver", "C:/Users/Sergey/Downloads/chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(base_path + "services");
        WebElement element = driver.findElement(By.id("createService"));
        element.click();
        assertEquals(driver.getCurrentUrl(),base_path+"createServiceForm");
        element = driver.findElement(By.id("name"));
        element.sendKeys("Service1");
        element = driver.findElement(By.id("internet"));
        element.sendKeys("10");
        element = driver.findElement(By.id("minutes"));
        element.sendKeys("10");
        element = driver.findElement(By.id("sms"));
        element.sendKeys("10");
        element = driver.findElement(By.id("specialoffer"));
        element.sendKeys("0");
        element = driver.findElement(By.id("cost"));
        element.sendKeys("10");
        element = driver.findElement(By.id("save"));
        element.submit();
        assertEquals(driver.getCurrentUrl(), base_path + "services");

        String name = driver.findElement(By.id("table"))
                .findElement(By.xpath("//td[1]")).getText();
        assertEquals(name,"Service1");

        element = driver.findElement(By.id("table"))
                .findElement(By.xpath("//td[7]/span/a"));
        element.click();

        element = driver.findElement(By.id("name"));
        element.sendKeys("Service2");
        element = driver.findElement(By.id("save"));
        element.submit();
        name = driver.findElement(By.id("table"))
                .findElement(By.xpath("//td[1]")).getText();
        assertEquals(name,"Service1Service2");

        element = driver.findElement(By.id("createService"));
        element.click();
        element = driver.findElement(By.id("cancelCreateButton"));
        element.click();

        element = driver.findElement(By.id("table"))
                .findElement(By.xpath("//td[7]/span/a"));
        element.click();
        element = driver.findElement(By.id("cancelCreateButton"));
        element.click();

        element = driver.findElement(By.id("table"))
                .findElement(By.xpath("//td[8]/span/a"));
        element.click();

        driver.close();
    }

    @Test
    public void Customer(){
        System.setProperty("webdriver.chrome.driver", "C:/Users/Sergey/Downloads/chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get(base_path + "services");
        driver.findElement(By.id("createService")).click();
        driver.findElement(By.id("name")).sendKeys("Service1");
        driver.findElement(By.id("save")).click();
        String name = driver.findElement(By.id("table"))
           .findElement(By.xpath("//td[1]")).getText();
        assertEquals(name,"Service1");

        driver.get(base_path + "customers");
        driver.findElement(By.id("createCustomer")).click();
        assertEquals(driver.getCurrentUrl(), base_path+"createCustomerForm");
        driver.findElement(By.id("name")).sendKeys("Sergey");
        driver.findElement(By.id("serviceid")).sendKeys("Service1");
        driver.findElement(By.id("save")).click();
        assertEquals(driver.getCurrentUrl(), base_path+"customers");
        name = driver.findElement(By.id("table"))
                .findElement(By.xpath("//td[1]")).getText();
        assertEquals(name, "Sergey");
        name = driver.findElement(By.id("table"))
                .findElement(By.xpath("//td[2]")).getText();
        assertEquals(name, "Service1");

        driver.findElement(By.xpath("//td[8]")).click();
        driver.findElement(By.id("name"))
                .sendKeys("Chernykh");
        driver.findElement(By.id("save")).click();
        assertEquals(driver.getCurrentUrl(), base_path+"customers");
        name = driver.findElement(By.id("table"))
                .findElement(By.xpath("//td[1]")).getText();
        assertEquals(name,"SergeyChernykh");

        driver.findElement(By.xpath("//td[8]")).click();
        driver.findElement(By.id("numbers"))
                .findElement(By.xpath("//td[1]/span/a")).click();
        name = driver.findElement(By.xpath("//tr[2]/td/table/tbody/tr/td[1]"))
                .getText();
        assertEquals(name, "+7(999) 10000");


        driver.findElement(By.id("act")).clear();
        driver.findElement(By.id("act")).sendKeys("1000");
        driver.findElement(By.id("reg")).click();
        String value = driver.findElement(By.xpath("//table[2]/tbody/tr/td")).getText();
        assertEquals(value, "1000.0");

        driver.findElement(By.id("act")).clear();
        driver.findElement(By.id("act")).sendKeys("-1000");
        driver.findElement(By.id("reg")).click();
        value = driver.findElement(By.xpath("//table[2]/tbody/tr/td")).getText();
        assertEquals(value, "0.0");

        driver.findElement(By.xpath("//tr[3]/td/span/a")).click();
        driver.findElement(By.id("fullname")).sendKeys("Sergey");
        driver.findElement(By.id("save")).click();
        value = driver.findElement(By.xpath("//tr[3]/td/table/tbody/tr[2]/td[2]"))
                .getText();
        assertEquals(value, "Sergey");
        driver.findElement(By.xpath("//td[7]/span/a")).click();


        driver.get(base_path + "customers");
        driver.findElement(By.id("table"))
                .findElement(By.xpath("//td[9]/span/a"))
                .click();

        driver.get(base_path + "services");
        driver.findElement(By.id("table"))
            .findElement(By.xpath("//td[8]/span/a"))
            .click();

        driver.close();
    }
}

package daily_tasks.tests;

import daily_tasks.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Sept6_Amazon extends TestBase {
    /*
    1) visit Amazon.com
    2) click the menu on the upper left
    3) select "Software"
    4) select "Programming & Web Development"
    5) in the opened page, put price limit as >> min. 10, max.20
    6) then click "Go"
    7) lastly, get the URL of the page and print it
     */

    @Test
    public void test1(){
        driver.get("http://amazon.com");

        //menu web elemani
        WebElement dropDown = driver.findElement(By.id("nav-hamburger-menu"));

        dropDown.click();//menu ye tikla

        //menu deki "software" ksimi
        WebElement software = driver.findElement(By.xpath("//a[@data-menu-id='22']"));
        //bunun id si, name i falan yoktu. o yuzden xpath le boyle bulabildim

        software.click();//"software" secenegine tikla

        //"software" icindeki "programming..." kismi
        WebElement programmingLink = driver.findElement(By.partialLinkText("Programming"));
        //bu bir link olarak kod lanmis, o yuzden partialLinkText() iyidir

        programmingLink.click();//tikla

        //yeni sayfa acildi su an

        //minimum price kutusu
        WebElement minBox = driver.findElement(By.id("low-price"));
        minBox.sendKeys("10");//10 sayisini yazdirmak icin

        //maximum price kutusu
        WebElement maxBox = driver.findElement(By.id("high-price"));
        maxBox.sendKeys("20");//20 sayisini yazdirmak icin

        //"Go" butonunu bulup tiklamak yerine direkt .submit() yapsak da olur
        //bu bize kalmis
        maxBox.submit();//submit() >> enter tusuna basmak gibi

        //bu da bulundugumuz sayfanin URL i
        System.out.println(driver.getCurrentUrl());
    }
}

package seleniumStudyQuestions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import unitilities.Main;


public class C13_Sahibinden extends Main {

    @Test
    public void test01() throws InterruptedException {

//sahibinden.com a gidin
        driver.get("https://www.sahibinden.com");

//anasayfada oldugunuzu dogrulayin
        WebElement anaSayfa = driver.findElement(By.xpath("(//*[@lang='tr'])[1]"));
        Assert.assertTrue(anaSayfa.isDisplayed());


//detayli arama tiklayin
        driver.findElement(By.xpath("//*[@href='https://www.sahibinden.com/arama/detayli']")).click();

//detayli arama sayfasina geldiginizi dogrulatin
        WebElement detayliAramaSayfasi = driver.findElement(By.xpath("//h2[.='Detaylı Arama']"));
        Assert.assertTrue(detayliAramaSayfasi.isDisplayed());



//emlak-konut-satilik seceneklerini secip
        WebElement emlak = driver.findElement(By.xpath("//*[@href='/arama/detayli?category=3518']"));
        emlak.click();

        WebElement konut = driver.findElement(By.xpath("//*[@href='/arama/detayli?category=3613']"));
        konut.click();

        WebElement satilik = driver.findElement(By.xpath("//*[@href='/arama/detayli?category=16623']"));
        satilik.click();



//altta cikan butun filtre seceneklerine en az bir filtre degeri girip en sonundaki arama yap tusuna tiklayin
        detayliArama("Ankara","Yenimahalle","Batıkent");




//filtreler için sağıdakilere benzer methodlar oluşturun
//        detayli_Arama_Adres("izmir", "bayrakli", "adalet mah.");
//        detayli_Arama_Fiyat("4.000","4.000.000","USD");
//        detayli_Arama_Brut("180","400");
//        detayli_Arama_Oda_Sayisi("10 Üzeri");//0-43 arasi




//cikan sonuc sayisini veya sonuc yoksa bunu bildiren yaziyi konsolda yazdirin



    }

    public void detayliArama(String il, String ilce, String mah) throws InterruptedException {
        WebElement Adres1 = driver.findElement(By.xpath("(//[@class='faceted-select'])[1]"));
        Adres1.click();
        WebElement ilyaz = driver.findElement(By.xpath("//input[@placeholder='İl']"));
        ilyaz.sendKeys(il);
        Thread.sleep(2000);

        driver.findElement(By.xpath("//a[contains(text(),'" + il + "')]")).click();
        WebElement Adres2 = driver.findElement(By.xpath("(//[@class='faceted-select'])[2]"));
        Adres2.click();
        Thread.sleep(2000);

        WebElement semtyaz = driver.findElement(By.xpath("//input[@placeholder='İlçe']"));
        semtyaz.sendKeys(ilce);
        driver.findElement(By.xpath("//a[contains(text(),'" + ilce + "')]")).click();
        driver.findElement(By.xpath("//a[@class='collapse-pane']")).click();
        WebElement Adres3 = driver.findElement(By.xpath("(//*[@class='faceted-select'])[3]"));
        Adres3.click();
        WebElement mahlyaz = driver.findElement(By.xpath("//input[@placeholder='Semt / Mahalle']"));
        mahlyaz.sendKeys(mah);
        driver.findElement(By.xpath("//a[normalize-space()='" + mah + "']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//a[@class='collapse-pane']")).click();
    }


}

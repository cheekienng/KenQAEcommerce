package homepage;

import core.BasePage;
import modelclass.ProductModelClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProductListingPage extends BasePage {
    static WebDriver driver;
    static ProductModelClass productModel = new ProductModelClass();
    static List<ProductModelClass> productModelList = new ArrayList<>();
    static List<ProductModelClass> productModelSortedList = new ArrayList<>();

    public ProductListingPage(WebDriver driver) {
        super(driver);
    }

    public static void main(String[] arg) throws InterruptedException, IOException {
        driver = new ChromeDriver();
        ProductListingPage productPage = new ProductListingPage(driver);

        searchProductEbay("iphone11", "Cell Phones & Accessories");
        searchProductLazada("iphone11");
        report.GenerateReport.printProductReport(driver, productModelSortedList);
        String basePath = new File("").getAbsolutePath();
    }

    public static void searchProductEbay(String product, String category) throws InterruptedException {
        driver.get("https://www.ebay.com.my");
        driver.findElement(By.id("gh-ac")).sendKeys(product);

        WebElement dropdown = driver.findElement(By.id("gh-cat"));
        Select selectCategory = new Select(dropdown);
        selectCategory.selectByVisibleText(category);
        driver.findElement(By.id("gh-btn")).click();
        Thread.sleep(2000);

        List<WebElement> products = driver.findElements(By.cssSelector("li[class='s-item    ']"));
        for (int i = 0; i < products.size(); i++) {
            WebElement link1 = products.get(i).findElement(By.className("s-item__image")).findElement(By.tagName("a"));

            productModel = new ProductModelClass();
            productModel.webSite = "eBay";
            productModel.productName = products.get(i).findElement(By.className("s-item__title")).getText();
            productModel.productOriPrice = products.get(i).findElements(By.className("s-item__price")).get(0).getText();
            BigDecimal bdPrice = new BigDecimal(products.get(i).findElements(By.className("s-item__price")).get(0).getText().replaceAll("[\\\\.$|,|;|'|RM ]", ""));
            productModel.productPrice = bdPrice;
            productModel.productUrl = link1.getAttribute("href");
            productModelList.add(productModel);
        }
    }

    public static void searchProductLazada(String product) throws InterruptedException {
        driver.get("https://lazada.com.my");
        driver.findElement(By.id("q")).sendKeys(product);
        driver.findElement(By.id("q")).sendKeys(Keys.ENTER);
        Thread.sleep(2000);

        List<WebElement> products = driver.findElements(By.className("c2prKC"));
        for (int i = 0; i < products.size(); i++) {
            WebElement link1 = products.get(i).findElement(By.className("c16H9d")).findElement(By.tagName("a"));

            productModel = new ProductModelClass();
            productModel.webSite = "Lazada";
            productModel.productName = products.get(i).findElement(By.className("c16H9d")).getText();
            productModel.productOriPrice = products.get(i).findElement(By.className("c13VH6")).getText();
            BigDecimal bdPrice = new BigDecimal(products.get(i).findElement(By.className("c13VH6")).getText().replaceAll("[\\\\.$|,|;|'|RM ]", ""));
            productModel.productPrice = bdPrice;
            productModel.productUrl = link1.getAttribute("href");
            productModelList.add(productModel);
        }

        productModelList
                .stream()
                .sorted(
                        (product1, product2) -> product1.productPrice.compareTo(product2.productPrice)
                )
                .forEach(
                        productItem -> productModelSortedList.add(productItem)
                );
    }
}

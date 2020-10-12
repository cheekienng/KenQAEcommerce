package report;

import modelclass.ProductModelClass;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class GenerateReport {
    static WebDriver driver;
    static String basePath = new File("").getAbsolutePath();

    public static void printProductReport(WebDriver driver, List<ProductModelClass> productModelSortedList) throws IOException {
        PrintWriter pw = new PrintWriter(new FileWriter("product.html"));
        pw.println(
                "<TABLE " +
                        "BORDER cellspacing=\"0\" cellpadding=\"5\" style='font-family:\"Arial\", Arial, monospace; font-size:80%'>" +
                        "<TR>" +
                        "<TH>No." +
                        "<TH>Website" +
                        "<TH>Product Name" +
                        "<TH style=\"width:15%\" padding: 5px>Price" +
                        "<TH style=\"width:5%\">URL" +
                        "</TR>");

        for (int i = 0; i < productModelSortedList.size(); i++) {
            pw.format("<TR ALIGN=LEFT>" +
                            "<TD>%1$s" +
                            "<TD>%2$s" +
                            "<TD>%3$s" +
                            "<TD style=\"text-align:right\">%4$s  " +
                            "<TD><a href=\"%5$s\">Link</a>",
                    i + 1,
                    productModelSortedList.get(i).webSite,
                    productModelSortedList.get(i).productName,
                    productModelSortedList.get(i).productOriPrice,
                    productModelSortedList.get(i).productUrl);
        }

        pw.println("</TABLE>");
        pw.close();
        System.setProperty("webdriver.chrome.driver", "\\chromedriver.exe");
        driver.get(basePath + "\\product.html");
    }
}

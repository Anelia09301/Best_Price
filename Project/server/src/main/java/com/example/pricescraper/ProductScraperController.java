
package com.example.pricescraper;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductScraperController {
    @GetMapping("/api/products")
    public List<Product> getProducts() throws IOException {
        List<Product> products = new ArrayList<>();
        
        // Пример за Lidl
        String url = "https://www.lidl.bg/bg/c/weekly-brochure/c10007637";
        Document doc = Jsoup.connect(url).get();
        Elements productElements = doc.select(".product-card"); // Път към елементите с продукти
        
        for (org.jsoup.nodes.Element element : productElements) {
            String name = element.select(".product-title").text();
            String price = element.select(".price").text();
            products.add(new Product(name, price));
        }
        
        return products;
    }
}
    
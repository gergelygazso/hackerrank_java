package org.gergelygazso.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TotalPriceByCategory {

    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();
        products.add(new Product("Laptop", "Electronics", 999.99));
        products.add(new Product("Smartphone", "Electronics", 699.99));
        products.add(new Product("Tablet", "Electronics", 399.99));
        products.add(new Product("Headphones", "Accessories", 199.99));
        products.add(new Product("Mouse", "Accessories", 49.99));
        products.add(new Product("Keyboard", "Accessories", 89.99));
        products.add(new Product("Desk", "Furniture", 299.99));
        products.add(new Product("Chair", "Furniture", 149.99));

        // Task: Group products by category and calculate the total price for each category
        Map<String, Double> totalPricePerCategory = products.stream().collect(Collectors.groupingBy(
                Product::getCategory,
                Collectors.summingDouble(Product::getPrice)
        ));
        System.out.println(totalPricePerCategory);

    }

    private static class Product {
        private String name;
        private String category;
        private double price;

        public Product(String name, String category, double price) {
            this.name = name;
            this.category = category;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public String getCategory() {
            return category;
        }

        public double getPrice() {
            return price;
        }
    }

}

package com.example.activte2;

import com.example.activte2.entities.Product;
import com.example.activte2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Activte2Application implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;
    public static void main(String[] args) {

        SpringApplication.run(Activte2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
            /*productRepository.save(new Product(null,"Computer",4300,3));
            productRepository.save(new Product(null,"Printer",1200,4));
            productRepository.save(new Product(null,"Smartphone",3200,32 ));*/
            List<Product> products = productRepository.findAll();
            products.forEach(p->System.out.println(p.toString()));
            Product product=productRepository.findById(Long.valueOf(1)).get();
            System.out.println("**************");
            System.out.println(product.getId());
            System.out.println(product.getName());
            System.out.println(product.getPrice());
            System.out.println(product.getQuantity());
            System.out.println("**************");
            System.out.println("--------------");
            List<Product> ProductsList=productRepository.findByNameContains("C");
            ProductsList.forEach(p->
                    System.out.println(p.toString()
                     ));
            System.out.println("_______________");
            List<Product> ProductsList2=productRepository.search("%C%");
            System.out.println("_______________");
            List<Product> ProductsList3=productRepository.searchByPrice(3000);
            ProductsList3.forEach(p->
                System.out.println(p.toString()
                ));
    }
}

package com.sid.sid;

import com.sid.sid.entities.Category;
import com.sid.sid.entities.Product;
import com.sid.sid.repository.CategoryRepository;
import com.sid.sid.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Stream;

@SpringBootApplication
public class SidApplication {

    public static void main(String[] args) {
        SpringApplication.run(SidApplication.class, args);
    }

    @Bean
    CommandLineRunner start(CategoryRepository categoryRepository, ProductRepository productRepository ) {
        return args -> {
            categoryRepository.deleteAll();
            Stream.of("c1 Ordinateur", "c2 Imprimante", "c3 Televiseur").forEach( c -> {
                categoryRepository.save(new Category(c.split(" ")[0], c.split(" ")[1], new ArrayList<Product>()));
            });
            categoryRepository.findAll().forEach(System.out::println);

            productRepository.deleteAll();
            Stream.of("p1 Toshiba", "p1 Lenovo", "p3 Dell", "p4 Asus").forEach(
                    p -> {
                        Category c1 = categoryRepository.findById("c1").get();
                       productRepository.save(new Product(p.split(" ")[0], p.split(" ")[1],Math.random()*1200,c1));
                    }
            );
            productRepository.findAll().forEach(System.out::println);
        };

    }

}

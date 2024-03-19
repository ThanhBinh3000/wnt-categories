package vn.com.gsoft.categories;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class CategoriesApplication {

    public static void main(String[] args) {
        SpringApplication.run(CategoriesApplication.class, args);
    }

}

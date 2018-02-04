package com.example;

import com.dao.IProductDAO;
import com.entities.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BasicApplication {

	public static void main(String[] args) {
            ApplicationContext ctx = SpringApplication.run(BasicApplication.class, args);
            IProductDAO prod = ctx.getBean(IProductDAO.class);
            prod.save(new Product("PC", 125D, 25D));
	}
}

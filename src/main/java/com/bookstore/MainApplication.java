package com.bookstore;

import com.bookstore.service.BookstoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MainApplication {

    @Autowired
    private BookstoreService bookstoreService;

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Bean
    public ApplicationRunner init() {
        return args -> {
            System.out.println("\n\n Fetch all:");
            System.out.println("---------------------------------");
            bookstoreService.fetchAll();
            
            System.out.println("\n\n Fetch age, name and genre:");
            System.out.println("---------------------------------");
            bookstoreService.fetchAgeNameGenre();

            System.out.println("\n\n Fetch name and email:");
            System.out.println("---------------------------------");
            bookstoreService.fetchNameEmail();
        };
    }
}

/*
 * 
 * Reusing Spring projection

Description: This application is a sample of reusing an interface-based Spring projection. This is useful to avoid defining multiple interface-based Spring projections in order to cover a range of queries that fetches different subsets of fields.

Key points:

define an interface-based Spring projection containing getters for the wider case
rely on class-level @JsonInclude(JsonInclude.Include.NON_DEFAULT) annotation to avoid serialization of default fields (e.g., fields that are not available in the current projection and are null - these fields haven't been fetched in the current query)
this is useful to Jackson that will not serialize in the resulted JSON the missing fields (e.g., null fields)
 * 
 * 
 */

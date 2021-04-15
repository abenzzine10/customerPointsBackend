package com.charter.store;

import com.charter.store.entities.Customer;
import com.charter.store.entities.Purchase;
import com.charter.store.repositories.CustomerRepository;
import com.charter.store.repositories.PurchaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@SpringBootApplication
public class StoreApplication {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PurchaseRepository purchaseRepository;

    public static void main(String[] args) {
        SpringApplication.run(StoreApplication.class, args);
    }

    // Adding customers and their purchases to an h2 database
    @Bean
    CommandLineRunner runner() {
        return args -> {
            String[] firstNames = {"Ayoub", "Leo", "Cristiano", "Ricardo", "Kylian", "Luka", "Roger",
                    "Juan", "Rafael", "Hakim", "Youssef", "Christian", "Walter", "Ben", "Gasper", "Yaya",
                    "Jonathan", "Erling", "Luis", "Andres", "Carlos", "Paolo"};

            String[] lasttNames = {"Benzzine", "Messi", "Ronaldo", "Kaka", "Mbappe", "Modric", "Federer",
                    "Bernat", "Nadal", "Ziyech", "Elarabi", "Pulisic", "Samuel", "Chilwell", "Schmeichl", "Toure",
                    "Davies", "Haaland", "Figo", "Iniesta", "Puyol", "Dybala"};

            // Saving 22 customers to the database
            List<Customer> customers = new ArrayList<>();
            for(int i = 0; i < firstNames.length; i++){
                Customer customer = new Customer(firstNames[i], lasttNames[i]);
                customers.add(customer);
                customerRepository.save(customer);
            }

            // Generating an array of 100 random dates between January 1st, 2021 nad March 31st, 2021
            LocalDate start = LocalDate.of(2021, Month.JANUARY, 1);
            LocalDate end = LocalDate.of(2021, Month.MARCH, 31);
            LocalDate[] dates = new LocalDate[100];
            for(int i = 0; i < dates.length; i++) {
                dates[i] = between(start, end);
            }

            // Generating an array of 100 random prices between $5 and $200
            Random rd = new Random();
            double[] amounts = new double[100];
            double min = 5;
            double max = 200;
            for(int i = 0; i < amounts.length; i++) {
                amounts[i] = Math.floor(((rd.nextDouble() * (max - min)) + min) * 100) / 100;
            }

            // Saving 100 purchases to the database
            for(int i = 0; i < amounts.length; i++){
                int customerIndex = (int) (Math.random() * customers.size());
                Purchase purchase = new Purchase(customers.get(customerIndex), dates[i], amounts[i]);
                purchaseRepository.save(purchase);
            }
        };
    }

    /*
     * Generate a random date between a start date and an end date
     * @param startInclusive is the start date
     * @param endInclusive is the end date
     * @return the generated date
     */
    public LocalDate between(LocalDate startInclusive, LocalDate endExclusive) {
        long startEpochDay = startInclusive.toEpochDay();
        long endEpochDay = endExclusive.toEpochDay();
        long randomDay = ThreadLocalRandom
                .current()
                .nextLong(startEpochDay, endEpochDay);

        return LocalDate.ofEpochDay(randomDay);
    }
}

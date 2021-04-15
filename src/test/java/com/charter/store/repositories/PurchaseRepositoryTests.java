package com.charter.store.repositories;

import com.charter.store.entities.Customer;
import com.charter.store.entities.Purchase;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class PurchaseRepositoryTests {

    @Autowired
    private PurchaseRepository repository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    void savePurchase() {
        Customer customer = new Customer("Ayoub", "Benzzine");
        Purchase purchase = new Purchase(customer, LocalDate.of(2021, Month.MARCH, 30),150);
        testEntityManager.persistAndFlush(customer);
        testEntityManager.persistAndFlush(purchase);
        assertThat(purchase.getId()).isNotNull();
    }

    @Test
    void deleteAll() {
        Customer customer = new Customer("Ayoub", "Benzzine");
        Purchase purchase1 = new Purchase(customer, LocalDate.of(2021, Month.MARCH, 30), 150);
        Purchase purchase2 = new Purchase(customer, LocalDate.of(2021, Month.MARCH, 30), 40);
        testEntityManager.persistAndFlush(customer);
        testEntityManager.persistAndFlush(purchase1);
        testEntityManager.persistAndFlush(purchase2);
        repository.deleteAll();
        assertThat(repository.findAll()).isEmpty();
    }

    @Test
    void findById() {
        Customer customer = new Customer("Ayoub", "Benzzine");
        Purchase purchase = new Purchase(customer, LocalDate.of(2021, Month.MARCH, 30), 150);
        repository.deleteAll();
        testEntityManager.persistAndFlush(customer);
        testEntityManager.persistAndFlush(purchase);
        assertEquals(customer.getLastName(), repository.findById(purchase.getId()).get().getCustomer().getLastName());
    }

    @Test
    void findAll() {
        Customer customer1 = new Customer("Ayoub", "Benzzine");
        Customer customer2 = new Customer("Mariam", "Makhtari");
        Purchase purchase1 = new Purchase(customer1, LocalDate.of(2021, Month.MARCH, 30), 150);
        Purchase purchase2 = new Purchase(customer2, LocalDate.of(2021, Month.MARCH, 30), 40);
        Purchase purchase3 = new Purchase(customer2, LocalDate.of(2021, Month.MARCH, 30), 200);
        List<Purchase> expectedPurchases = new ArrayList<>();
        expectedPurchases.add(purchase1);
        expectedPurchases.add(purchase2);
        expectedPurchases.add(purchase3);
        repository.deleteAll();
        testEntityManager.persistAndFlush(customer1);
        testEntityManager.persistAndFlush(customer2);
        for(int i = 0; i < 3; i++)
            testEntityManager.persistAndFlush(expectedPurchases.get(i));
        Iterable<Purchase> iterable = repository.findAll();
        List<Purchase> actualPurchases = new ArrayList<>();
        iterable.forEach(actualPurchases::add);
        for(int i = 0; i < 3; i++)
            assertEquals(expectedPurchases.get(i).getCustomer().getFirstName(), actualPurchases.get(i).getCustomer().getFirstName());
    }

    @Test
    void count() {
        Customer customer1 = new Customer("Ayoub", "Benzzine");
        Customer customer2 = new Customer("Mariam", "Makhtari");
        Purchase purchase1 = new Purchase(customer1, LocalDate.of(2021, Month.MARCH, 30), 150);
        Purchase purchase2 = new Purchase(customer2, LocalDate.of(2021, Month.MARCH, 30), 40);
        Purchase purchase3 = new Purchase(customer2, LocalDate.of(2021, Month.MARCH, 30), 200);
        repository.deleteAll();
        testEntityManager.persistAndFlush(customer1);
        testEntityManager.persistAndFlush(customer2);
        testEntityManager.persistAndFlush(purchase1);
        testEntityManager.persistAndFlush(purchase2);
        testEntityManager.persistAndFlush(purchase3);
        assertEquals(3, repository.count());
    }
}

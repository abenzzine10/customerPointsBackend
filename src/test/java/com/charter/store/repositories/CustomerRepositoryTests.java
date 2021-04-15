package com.charter.store.repositories;

import com.charter.store.entities.Customer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DataJpaTest
public class CustomerRepositoryTests {

    @Autowired
    private CustomerRepository repository;

    @Autowired
    private TestEntityManager testEntityManager;

    @Test
    void saveCustomer() {
        Customer customer = new Customer("Ayoub", "Benzzine");
        testEntityManager.persistAndFlush(customer);
        assertThat(customer.getId()).isNotNull();
    }

    @Test
    void deleteAll() {
        Customer customer1 = new Customer("Ayoub", "Benzzine");
        Customer customer2 = new Customer("Mariam", "Makhtari");
        testEntityManager.persistAndFlush(customer1);
        testEntityManager.persistAndFlush(customer2);
        repository.deleteAll();
        assertThat(repository.findAll()).isEmpty();
    }

    @Test
    void findById() {
        Customer customer = new Customer("Ayoub", "Benzzine");
        repository.deleteAll();
        testEntityManager.persistAndFlush(customer);
        assertEquals(customer.getLastName(), repository.findById(customer.getId()).get().getLastName());
    }

    @Test
    void findAll() {
        Customer customer1 = new Customer("Ayoub", "Benzzine");
        Customer customer2 = new Customer("Mariam", "Makhtari");
        List<Customer> expectedCustomers = new ArrayList<>();
        expectedCustomers.add(customer1);
        expectedCustomers.add(customer2);
        repository.deleteAll();
        testEntityManager.persistAndFlush(customer1);
        testEntityManager.persistAndFlush(customer2);
        Iterable<Customer> iterable = repository.findAll();
        List<Customer> actualCustomers = new ArrayList<>();
        iterable.forEach(actualCustomers::add);
        assertEquals(expectedCustomers.get(0).getFirstName(), actualCustomers.get(0).getFirstName());
        assertEquals(expectedCustomers.get(1).getFirstName(), actualCustomers.get(1).getFirstName());
    }

    @Test
    void count() {
        Customer customer1 = new Customer("Ayoub", "Benzzine");
        Customer customer2 = new Customer("Mariam", "Makhtari");
        repository.deleteAll();
        testEntityManager.persistAndFlush(customer1);
        testEntityManager.persistAndFlush(customer2);
        assertEquals(2, repository.count());
    }
}

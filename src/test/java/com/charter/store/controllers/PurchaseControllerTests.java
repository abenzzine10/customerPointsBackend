package com.charter.store.controllers;

import com.charter.store.entities.Customer;
import com.charter.store.entities.Purchase;
import com.charter.store.repositories.CustomerRepository;
import com.charter.store.repositories.PurchaseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.time.Month;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class PurchaseControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    public void getPurchases() throws Exception {
        Customer customer1 = new Customer("Ayoub", "Benzzine");
        Customer customer2 = new Customer("Mariam", "Makhtari");
        Purchase purchase1 = new Purchase(customer1, LocalDate.of(2021, Month.MARCH, 30), 150);
        Purchase purchase2 = new Purchase(customer2, LocalDate.of(2021, Month.MARCH, 30), 40);
        Purchase purchase3 = new Purchase(customer2, LocalDate.of(2021, Month.MARCH, 30), 200);
        customerRepository.deleteAll();
        customerRepository.save(customer1);
        customerRepository.save(customer2);
        purchaseRepository.deleteAll();
        purchaseRepository.save(purchase1);
        purchaseRepository.save(purchase2);
        purchaseRepository.save(purchase3);
        this.mockMvc.perform(get("/purchases")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("150")))
                .andExpect(content().string(containsString("40")))
                .andExpect(content().string(containsString("200")));
    }
}

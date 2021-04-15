package com.charter.store.controllers;

import com.charter.store.dto.CustomerDto;
import com.charter.store.entities.Customer;
import com.charter.store.entities.Purchase;
import com.charter.store.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "https://customer-points-frontend.herokuapp.com")
@RestController
public class CustomerController {

    @Autowired
    private CustomerRepository repository;

    @RequestMapping(value = "/customers", method = RequestMethod.GET)
    public List<CustomerDto> getCustomers() {

        Iterable<Customer> customersIterable = repository.findAll();
        List<Customer> customers = new ArrayList<>();
        customersIterable.forEach(customers::add);
        List<CustomerDto> customersDto = new ArrayList<>();
        for(int i = 0; i < customers.size(); i++) {
            int numberPurchases = customers.get(i).getPurchases().size();
            int januaryPoints = calculatePoints(customers.get(i), Month.JANUARY);
            int februaryPoints = calculatePoints(customers.get(i), Month.FEBRUARY);
            int marchPoints = calculatePoints(customers.get(i), Month.MARCH);
            CustomerDto customerDto = new CustomerDto(
                    customers.get(i).getFirstName(),
                    customers.get(i).getLastName(),
                    numberPurchases,
                    januaryPoints,
                    februaryPoints,
                    marchPoints
                    );
            customersDto.add(customerDto);
        }
        return customersDto;
    }

    private int calculatePoints(Customer customer, Month month) {
        int totalPoints = 0;
        for(Purchase purchase : customer.getPurchases()) {
            int points = 0;
            if(purchase.getDate().getMonth().equals(month)) {
                if (purchase.getAmount() > 50) {
                    points += Math.floor(purchase.getAmount() - 50);
                }
                if (purchase.getAmount() > 100) {
                    points += Math.floor(purchase.getAmount() - 100);
                }
            }
            totalPoints += points;
        }
        return totalPoints;
    }
}

package tu.comsci.laptopcustomer.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tu.comsci.laptopcustomer.model.Customer;
import tu.comsci.laptopcustomer.repository.CustomerRepository;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Transactional
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }
}

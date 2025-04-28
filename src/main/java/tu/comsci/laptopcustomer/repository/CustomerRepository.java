package tu.comsci.laptopcustomer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tu.comsci.laptopcustomer.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
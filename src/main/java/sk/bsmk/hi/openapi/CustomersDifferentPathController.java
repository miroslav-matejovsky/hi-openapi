package sk.bsmk.hi.openapi;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sk.bsmk.hi.openapi.model.Customer;

import javax.validation.Valid;

// It is important that this controller has the same package as CustomersApi interface
@RestController
public class CustomersDifferentPathController implements CustomersApi {

  @RequestMapping(value = "/customers-alt",
    produces = { "application/json" },
    method = RequestMethod.GET)
  @Override
  public ResponseEntity<Customer> listCustomers(@Valid Integer limit) {
    final Customer customer = new Customer();
    customer.setId(2L);
    customer.setName("Bob");
    customer.setPoints(24L);
    customer.setTag("Par");
    return ResponseEntity.ok(customer);
  }

}

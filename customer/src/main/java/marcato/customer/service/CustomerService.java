package marcato.customer.service;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import marcato.customer.dto.CustomerDTO;
import marcato.customer.entity.CustomerEntity;
import marcato.customer.repository.CustomerRepository;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class CustomerService {

    @Inject
    CustomerRepository customerRepository;

    public List<CustomerDTO> findAllCustomers(){
        List<CustomerDTO> customers = new ArrayList<>();

        customerRepository
                .findAll()
                .stream()
                .forEach(
                        item->{
                            customers.add(mapCustomerEntityToDTO(item));
                        }
                );

        return customers;
    }

    public CustomerDTO findCustomerById(Long id) {
        return mapCustomerEntityToDTO(customerRepository.findById(id));
    }


    public void createNewCustomer(CustomerDTO customerDTO){
        customerRepository
                .persist(mapCustomerDtoToEntity(customerDTO));
    }

    public void changeCustomer(Long id, CustomerDTO customerDTO){
        CustomerEntity customer = customerRepository.findById(id);

        if (customer == null) {
            throw new IllegalArgumentException("Customer with id " + id + " not found");
        }

        customer.setName(customerDTO.getName());
        customer.setEmail(customerDTO.getEmail());
        customer.setPhone(customerDTO.getPhone());

        customerRepository.persist(customer);
    }

    public void deleteCustomer(Long id){

        customerRepository.deleteById(id);
    }

    private CustomerDTO mapCustomerEntityToDTO(CustomerEntity customer){

        CustomerDTO customerDTO = new CustomerDTO();

        customerDTO.setName(customer.getName());
        customerDTO.setEmail(customer.getEmail());
        customerDTO.setPhone(customer.getPhone());

        return customerDTO;

    }

    private CustomerEntity mapCustomerDtoToEntity(CustomerDTO customer){

        CustomerEntity customerEntity = new CustomerEntity();

        customerEntity.setName(customer.getName());
        customerEntity.setEmail(customer.getEmail());
        customerEntity.setPhone(customer.getPhone());

        return customerEntity;

    }
}

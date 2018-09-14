package pl.mczarnik.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.mczarnik.springmvc.dao.CustomerDAO;
import pl.mczarnik.springmvc.entity.CustomerEntity;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    // Simply delegate call to customerDAO
    @Transactional
    public CustomerEntity getCustomer(int id) {
        return customerDAO.getCustomer(id);
    }

    @Transactional
    public List<CustomerEntity> getCustomers() {
        return customerDAO.getCustomers();
    }

    @Transactional
    public void saveOrUpdateCustomer(CustomerEntity customer) {
        customerDAO.saveOrUpdateCustomer(customer);
    }

    @Transactional
    public void deleteCustomer(int id) {
        customerDAO.deleteCustomer(id);
    }

    @Transactional
    public List<CustomerEntity> searchCustomers(String name) {

        return customerDAO.searchCustomers(name);
    }
}

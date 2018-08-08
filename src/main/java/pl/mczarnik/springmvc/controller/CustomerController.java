package pl.mczarnik.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.mczarnik.springmvc.entity.Customer;
import pl.mczarnik.springmvc.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/list")
    public String listCustomers(Model model) {
        model.addAttribute("customers", customerService.getCustomers());

        return "list-customers";
    }

    @GetMapping("/add")
    public String addCustomer(Model model) {
        // Create model attribute to bind form data
        Customer customer = new Customer();

        model.addAttribute("customer", customer);

        return "customer-form";
    }

    @GetMapping("/update")
    public String updateCustomer(@RequestParam("id") int id, Model model) {
        Customer customer = customerService.getCustomer(id);

        model.addAttribute("customer", customer);

        return "customer-form";
    }

    @PostMapping("/process-form")
    public String processForm(@ModelAttribute("customer") Customer customer) {
        customerService.saveOrUpdateCustomer(customer);

        return "redirect:/customer/list";
    }
}

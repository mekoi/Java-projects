package com.spring.boot.micro;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomerController {

	@Autowired 
	private CustomerRepository customerRepository;
	
	@RequestMapping("/")
    public String show(Model model)
    {
        model.addAttribute("customers", customerRepository.findAll());
        return "show";
    }			
			
	//To get the add-customer
	@GetMapping("/add")
	public String add(Customer customer)
	{
		return "add-customer";
	}			
	
	@PostMapping("/add")
    public String add(@Valid Customer customer, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-customer";
        }

        customerRepository.save(customer);
        model.addAttribute("customers", customerRepository.findAll());
        return "show";
    }
	
	//Get the edit request
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") int no, Model model) {
		Customer cus = customerRepository.findById(no)
	      .orElseThrow(() -> new IllegalArgumentException("Invalid customer number:" + no));

	    model.addAttribute("customer", cus);
	    return "update-customer";
	}
	
	//update the existing customer info
	@PostMapping("/update/{id}")
	public String update(@PathVariable("id") int no, @Valid Customer customer,
	  BindingResult result, Model model) {
	    if (result.hasErrors()) {
	    	customer.setCustomerId(no);
	        return "update-customer";
	    }
	    customerRepository.save(customer);
	    model.addAttribute("customers", customerRepository.findAll());
	    return "show";
	}	
	
	//delete a customer info
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") int no, Model model) {
		Customer cus= customerRepository.findById(no)
	      .orElseThrow(() -> new IllegalArgumentException("Invalid customer Number:" + no));
	    customerRepository.delete(cus);
	    model.addAttribute("customers", customerRepository.findAll());
	    return "show";
	}    
}
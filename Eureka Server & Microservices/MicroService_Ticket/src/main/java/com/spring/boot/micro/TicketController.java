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
public class TicketController {

	@Autowired 
	private TicketRepository ticketRepository;
	
	@RequestMapping("/")
    public String show(Model model)
    {
        model.addAttribute("tickets", ticketRepository.findAll());
        return "show";
    }			
			
	//To get the add-ticket
	@GetMapping("/add")
	public String add(Ticket ticket)
	{
		return "add-ticket";
	}			
	
	@PostMapping("/add")
    public String add(@Valid Ticket ticket, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-ticket";
        }

        ticketRepository.save(ticket);
        model.addAttribute("tickets", ticketRepository.findAll());
        return "show";
    }
	
	//Get the edit request
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable("id") int no, Model model) {
		Ticket tic = ticketRepository.findById(no)
	      .orElseThrow(() -> new IllegalArgumentException("Invalid ticket number:" + no));

	    model.addAttribute("ticket", tic);
	    return "update-ticket";
	}
	
	//update the existing ticket info
	@PostMapping("/update/{id}")
	public String update(@PathVariable("id") int no, @Valid Ticket ticket,
	  BindingResult result, Model model) {
	    if (result.hasErrors()) {
	    	ticket.setTicketId(no);
	        return "update-ticket";
	    }
	    ticketRepository.save(ticket);
	    model.addAttribute("tickets", ticketRepository.findAll());
	    return "show";
	}	
	
	//delete a ticket info
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") int no, Model model) {
		Ticket tic= ticketRepository.findById(no)
	      .orElseThrow(() -> new IllegalArgumentException("Invalid ticket Number:" + no));
	    ticketRepository.delete(tic);
	    model.addAttribute("tickets", ticketRepository.findAll());
	    return "show";
	}    
}
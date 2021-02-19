package com.spring.mvc.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import com.spring.mvc.jpa.Customer;
@SuppressWarnings("unused")

@Controller
public class CustomerController {
	
	private static EntityManagerFactory factory;
	private static EntityManager em;
	public static Customer currentCustomer;
	
	@RequestMapping(value="registration", method=RequestMethod.GET)  
	public ModelAndView registration() 
	{
		return new ModelAndView("registration");
	}
		
	@RequestMapping(value="registration", method=RequestMethod.POST)  
	public ModelAndView registration(HttpServletRequest request,HttpServletResponse response)
	{		    
	    //Getting input values from index.jsp form			
	    String userName=request.getParameter("userName");
	    String userPassword=request.getParameter("userPassword");
	    String firstName=request.getParameter("firstName");
	    String lastName=request.getParameter("lastName");
	    String address=request.getParameter("address");
	    String city=request.getParameter("city");
	    String postalCode=request.getParameter("postalCode");
	    String country=request.getParameter("country");
	    
		//JPA persistent
		factory = Persistence.createEntityManagerFactory("Bruno-Irisi_COMP303_Assignment2");
	    em = factory.createEntityManager();
	    
	    em.getTransaction().begin();
	    Customer customer = new Customer();   
	    customer.setUserName(userName);
	    customer.setUserPassword(userPassword);
	    customer.setFirstName(firstName);
	    customer.setLastName(lastName);
	    customer.setAddress(address);
	    customer.setCity(city);
	    customer.setPostalCode(postalCode);
	    customer.setCountry(country);
	    em.persist(customer); 
	    em.getTransaction().commit();	    
	    	
	    Query query = em.createQuery ("select MAX(c.customerId) from Customer c");
	    int lastCustomerId = (Integer)query.getSingleResult();	
	    customer.setCustomerId(lastCustomerId);
	    
	    em.close();
	    
		currentCustomer=customer;
	
	return new ModelAndView("order","customer",customer); 	
   	}
		
	@RequestMapping(value="login", method=RequestMethod.GET)  
	public ModelAndView login() 
	{
		return new ModelAndView("login");
	}	
	
	@RequestMapping(value="login", method=RequestMethod.POST)  
	public ModelAndView login(HttpServletRequest request,HttpServletResponse response)
	{			
	    String userName=request.getParameter("userName");
	    String userPassword=request.getParameter("userPassword");
	    Customer customer;
	    
		//JPA persistent
		factory = Persistence.createEntityManagerFactory("Bruno-Irisi_COMP303_Assignment2");
		em = factory.createEntityManager();
	    
		try {
	    Query query = em.createQuery ("select e from Customer e where e.userName = '" + userName + "'");
	    customer = (Customer)query.getSingleResult();
	    em.close();
		} catch (Exception e) {
			return new ModelAndView("user-mismatch");
		}

	    if (userPassword.equals(customer.getUserPassword())) {	    	
		    currentCustomer=customer;
	    	return new ModelAndView("order", "customer", customer);
	    }
	    else {
	    	return new ModelAndView("user-mismatch");
	    }	    
	}
		
	@RequestMapping(value="profile", method=RequestMethod.GET)  
	public ModelAndView profile() 
	{
		Customer customer = new Customer();	
		customer=currentCustomer;
		
		return new ModelAndView("profile","customer",customer);
	}	
	
	@RequestMapping(value="profile", method=RequestMethod.POST)  
	public ModelAndView profile(HttpServletRequest request,HttpServletResponse response)
	{							
		int customerId=Integer.parseInt(request.getParameter("customerId"));	
		String userName=request.getParameter("userName");
	    String userPassword=request.getParameter("userPassword");
	    String firstName=request.getParameter("firstName");
	    String lastName=request.getParameter("lastName");
	    String address=request.getParameter("address");
	    String city=request.getParameter("city");
	    String postalCode=request.getParameter("postalCode");
	    String country=request.getParameter("country");   
	    
	    //JPA persistent
		factory = Persistence.createEntityManagerFactory("Bruno-Irisi_COMP303_Assignment2");
	    em = factory.createEntityManager();
	    Customer customer = new Customer();
	    em.getTransaction().begin();
	    customer=em.find(Customer.class,customerId);
			    
		//update into customer table	    	    
	    customer.setUserName(userName);
	    customer.setUserPassword(userPassword);
	    customer.setFirstName(firstName);
	    customer.setLastName(lastName);
	    customer.setAddress(address);
	    customer.setCity(city);
	    customer.setPostalCode(postalCode);
	    customer.setCountry(country);
	   
		em.persist(customer);
		em.getTransaction().commit();		    
		em.close();
		
		return new ModelAndView("updateprofile","customer",customer);	      		
	}	

	@RequestMapping("logout")
	public ModelAndView logout() 
	{
		currentCustomer=null;
		return new ModelAndView("index");
	}	       
}


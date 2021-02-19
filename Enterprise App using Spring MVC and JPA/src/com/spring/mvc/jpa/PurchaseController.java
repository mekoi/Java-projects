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

@Controller
public class PurchaseController {
	
	private static EntityManagerFactory factory;
	private static EntityManager em;
	//public static Customer currentCustomer;
	
	//map to the Order view
	@RequestMapping(value="order", method=RequestMethod.GET)  
	public ModelAndView order() 
	{
		return new ModelAndView("order");
	}
	
	//this is the action method called when adding new purchase
	@RequestMapping(value="order", method=RequestMethod.POST)  
	public ModelAndView order(HttpServletRequest request,HttpServletResponse response)
	{			    										
		int customerId=0;
		
		if (request.getParameter("customerId") == "")		
			customerId=CustomerController.currentCustomer.getCustomerId();									
		else
			customerId=Integer.parseInt(request.getParameter("customerId"));
				
		String brandName=request.getParameter("brandName");	
		String modelName=request.getParameter("modelName");	
		int productId=0;
				
		switch(brandName)
		{
		 	case "Apple":
		 		{
		 			switch(modelName)
		 			{
					 	case "iPhone XR":
					 		productId=1;
					 		break;
						case "iPhone 12 Pro":
							productId=2;
							break;	
		 			}
		 		}
			break;
			
			case "Motorola":
				{
					switch(modelName)
					{
						case "Motorola G8 Plus":
							productId=3;
							break;
						case "Motorola One Vision":
							productId=4;
							break;	
					}
				}
		}				 		
		
		int quantity=Integer.parseInt(request.getParameter("quantity"));
					
		java.util.Date dt = new java.util.Date();
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
	
		String currentDateTime = sdf.format(dt);
		
		String orderStatus="Submitted";
	    
		//JPA persistent
		factory = Persistence.createEntityManagerFactory("Bruno-Irisi_COMP303_Assignment2");
	    em = factory.createEntityManager();
	    Purchase newPurchase = new Purchase();	    	   		
			    
		//insert into purchase table
	    em.getTransaction().begin();
	    newPurchase.setCustomerId(customerId);
	    newPurchase.setProductId(productId);
	    newPurchase.setQuantity(quantity);
	    newPurchase.setOrderDate(currentDateTime);
	    newPurchase.setDeliveryDate(currentDateTime);
	    newPurchase.setOrderStatus(orderStatus);	    
	   	    
		em.persist(newPurchase);
		em.getTransaction().commit();
	    
		Query query1 = em.createQuery ("select MAX(p.orderId) from Purchase p");
	    int lastOrderId = (Integer)query1.getSingleResult();	    
	    
	    Query query2 = em.createQuery ("select c.firstName from Customer c where c.customerId = '" + newPurchase.getCustomerId() + "'");
	    String lastOrderCustomerName = (String)query2.getSingleResult();
	    
	    Query query3 = em.createQuery ("select p.brandName from Product p where p.productId = '" + newPurchase.getProductId() + "'");
	    String lastOrderBrand = (String)query3.getSingleResult();
	    
	    Query query4 = em.createQuery ("select p.modelName from Product p where p.productId = '" + newPurchase.getProductId() + "'");
	    String lastOrderModel = (String)query4.getSingleResult();
	    
	    Query query5 = em.createQuery ("select p.price from Product p where p.productId = '" + newPurchase.getProductId() + "'");
	    double lastOrderPrice = (Double)query5.getSingleResult();	    
	   		
		FinishedOrder finishedOrder = new FinishedOrder();		
		finishedOrder.setOrderId(lastOrderId);
		finishedOrder.setCustomerName(lastOrderCustomerName);
		finishedOrder.setBrandName(lastOrderBrand);
		finishedOrder.setModelName(lastOrderModel);
		finishedOrder.setPrice(lastOrderPrice);
		finishedOrder.setQuantity(quantity);
		finishedOrder.setDeliveryDate(newPurchase.getDeliveryDate());
		
		em.close();
			 
		return new ModelAndView("order-confirmation","finishedOrder",finishedOrder); 			

    }
	
	@RequestMapping(value="payment", method=RequestMethod.GET)  
	public ModelAndView payment() 
	{
		return new ModelAndView("payment");
	}
	
	@RequestMapping(value="payment", method=RequestMethod.POST)  
   public ModelAndView payment(HttpServletRequest request,HttpServletResponse response)
   {		
		return new ModelAndView("payment");
   }
	
	@RequestMapping(value="thanks", method=RequestMethod.GET)  
	public ModelAndView thanks() 
	{
		return new ModelAndView("thanks");
	}
	
	@RequestMapping(value="thanks", method=RequestMethod.POST)  
   public ModelAndView thanks(HttpServletRequest request,HttpServletResponse response)
   {		
		return new ModelAndView("thanks");
   }
	
	@RequestMapping(value="manage", method=RequestMethod.GET)  
	public ModelAndView manage() 
	{
		factory = Persistence.createEntityManagerFactory("Bruno-Irisi_COMP303_Assignment2");
		em = factory.createEntityManager();
		
		Query queryOrders = em.createQuery("SELECT p from Purchase p where p.customerId = " + CustomerController.currentCustomer.getCustomerId());
		
		List<Purchase> allPurchasesOfCustomer = queryOrders.getResultList();
		
		return new ModelAndView("manage","allPurchasesOfCustomer",allPurchasesOfCustomer);				
	}
}

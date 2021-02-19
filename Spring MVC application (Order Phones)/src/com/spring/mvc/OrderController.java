package com.spring.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class OrderController {
	
	@RequestMapping("/order")
	public ModelAndView order(HttpServletRequest request, HttpServletResponse response) {
			
		 String firstName=request.getParameter("firstName");
		 String email=request.getParameter("email");	
		 String areaCode=request.getParameter("areaCode");
		 String phoneNumber=request.getParameter("phoneNumber");
		 String streetAddress=request.getParameter("streetAddress");
		 String city=request.getParameter("city");
		 String stateProvince=request.getParameter("stateProvince");
		 String phoneBrand=request.getParameter("phoneBrand");
		 String phoneModel=request.getParameter("phoneModel");
		 int quantity=Integer.parseInt(request.getParameter("quantity")); 
		 
		 double price=0;		 		 		
		 
		 switch(phoneModel){
		 	case "iPhoneXR":
				 price=800;
				 break;
			case "iPhone11Pro":
				 price=900;
				 break;
			case "Galaxy20Plus":
				 price=700;
				 break;
			case "GalaxyS2":
				 price=600;
				 break;
		 }
	 
		 Order order = new Order();
		 
		 order.setFirstName(firstName);  
		 order.setEmail(email);
		 order.setPhoneNumber(phoneNumber);
		 order.setAreaCode(areaCode);
		 order.setStreetAddress(streetAddress);
		 order.setCity(city);
		 order.setStateProvince(stateProvince);
		 order.setPhoneBrand(phoneBrand);
		 order.setPhoneModel(phoneModel);
		 order.setPrice(price);
		 order.setQuantity(quantity);			 
		 		 
		 return new ModelAndView("show-order","model", order);		
	}
}
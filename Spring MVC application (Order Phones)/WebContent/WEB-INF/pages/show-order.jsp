<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"> 
<!-- <link rel="stylesheet" type="text/css" href="css/style.css"> -->
<style>
	ul{
	color:red;
	}
	.info{
		font-size:16px;
		color:#002db3;
	}
	.info-title{
		color:red;
		weight:bold;	
		font-size:18px;
	}
	.order-greeting{
		weight:bold;	
		font-size:22px;
		color:#002db3;
	}
	.info-name{
		font-size:25px;
		color:black;
	}
	span{
		margin-left:60px;
	}
	.tabbed {
      padding-left:8.00em;
     }     
</style>

<title>Order confirmation</title>

</head>
<body>
	<h3 class="order-greeting">Welcome ${model.getFirstName()}.</h3>
	
    <h5 class="info-title">Your Order details are as follows:</h5>
    
      <ul class="details">
        <li>Email Address: ${model.getEmail()} </li>
        <li>Phone Number: ${model.getAreaCode()} - ${model.getPhoneNumber()} </li>
        <li>Address: ${model.getStreetAddress()},<br/> ${model.getCity()}, ${model.getStateProvince()} </li>
      </ul>      
  	<h5 class="info tabbed">Phone Details:<br/></h5>
  	<h5 class="info tabbed">Phone Brand: ${model.getPhoneBrand()}</h5>
  	<h5 class="info tabbed">Phone Model: ${model.getPhoneModel()}</h5>
  	<h5 class="info tabbed">Phone Price: CAD ${model.getPrice()} </h5>
  	<h5 class="info tabbed">Quantity: ${model.getQuantity()}<br/></h5>
    <h5 class="info tabbed">Total: CAD ${model.getPrice()*model.getQuantity()}</h5>       	
</body>
</html>
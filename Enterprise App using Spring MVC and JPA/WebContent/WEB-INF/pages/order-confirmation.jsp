<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css">
<title>Order Confirmation</title>
</head>

<body class="bg-dark">

    <header>
        <nav class="navbar navbar-expand-sm navbar-toggleable-sm navbar-light bg-white border-bottom box-shadow mb-3">
            <div class="container">

                <a class="navbar-brand">
                     <img src="https://imagesforjava.s3.amazonaws.com/digitel-logo.jpg" width="200" height="82">
                </a>
                
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target=".navbar-collapse" aria-controls="navbarSupportedContent"
                        aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
	       			<form class="form-inline">
	       				<a class="btn btn-lg btn-info mx-3 my-sm-0" href="manage" role="button">ORDERS</a>
	                    <a class="btn btn-lg btn-primary mx-3 my-sm-0" href="profile" role="button">PROFILE</a>
	                    <a class="btn btn-lg btn-secondary mx-2 my-sm-0" href="index.jsp" role="button">LOGOUT</a>
	                </form>
            </div>
        </nav>
    </header>

<div class="container">
    <div class="row">

        <div class="col">
        </div>

        <div class="col-6 border spacer bg-white border-dark rounded">
        
            <form action="payment" method="post">
                <div class="col-12" style="height:30px;"></div>
                <div class="top-spacer bottom-spacer grey text-center">
                    <h1>Order Confirmation</h1>
                    <h5>Order Number: ${finishedOrder.getOrderId()}</h5>              
                </div>
                <hr/>
                <div class="form-group">
                    <h4>Customer Details</h4>
                </div>
                 <hr/>
                <div class="row">
                    <div class="col-12" style="height:15px;"></div>
	                <div class="col text-left">
		                  <h5><b>Name:</b> ${finishedOrder.getCustomerName()}</h5>   
	                </div>
	                <div class="col-12" style="height:15px;"></div>
                </div>
                <hr/>
                <div class="form-group">
                    <h4>Product Details</h4>
                </div>
                <hr/>
                <div class="row">
                	<div class="col-12" style="height:15px;"></div>
	                <div class="col text-left">
		                  <h5><b>Phone Brand:</b> ${finishedOrder.getBrandName()}</h5>   
	                </div>
	                <div class="col-12" style="height:15px;"></div>
	                
	                <div class="col text-left">
		                  <h5><b>Phone Model:</b> ${finishedOrder.getModelName()}</h5>   
	                </div>
	                <div class="col-12" style="height:15px;"></div>
                </div>
                <hr/>
                <div class="form-group">
                    <h4>Order Details</h4>
                </div>
                 <hr/>
                <div class="row">
                	<div class="col-12" style="height:15px;"></div>
	                <div class="col text-left">	                 
		                  <h5><b>Item Price:</b> CAD ${finishedOrder.getPrice()}</h5>    
	                </div>
	                <div class="col-12" style="height:15px;"></div>
	                <div class="col text-left">
		                  <h5><b>Quantity:</b> ${finishedOrder.getQuantity()} </h5>  
	                </div>
	                <div class="col-12" style="height:15px;"></div>
	                <div class="col text-left">
		                  <h5><b>Total:</b> CAD ${finishedOrder.getPrice()*finishedOrder.getQuantity()}</h5>   
	                </div>
	                <div class="col-12" style="height:15px;"></div>
	                <div class="col text-left">
		                  <h5><b>Delivery Date:</b> ${finishedOrder.getDeliveryDate()}</h5>   
	                </div>
	                
	                <div class="col-12" style="height:15px;"></div>
                </div>
                <hr/>
                
                <button type="submit" class="btn btn-lg btn-success btn-block bottom-spacer" value="ADD CUSTOMER">Payment</button>
            </form>
            
            <div class="col-12" style="height:30px;"></div>
            
        </div>

        <div class="col">
        </div>

    </div>
</div>

</body>
</html>
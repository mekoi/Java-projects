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
<title>Order Page</title>
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
        
            <form action="order" method="post">
            <input type="text" name="customerId" id="customerId" value="${customer.getCustomerId()}" hidden>
            
                <div class="col-12" style="height:30px;"></div>
                <div class="top-spacer bottom-spacer grey">
                    <h1>Order Page</h1>                      
                </div>
                 <hr/>
                <div class="form-group">
                    <h4>Choose a Cell Phone</h4>
                </div>
	                <div class="form-group">
	                    Phone Brand
	                    <select class="form-control form-control-lg" name="brandName" id="brandName" >
						   <option value="Apple">Apple</option>
						   <option value="Motorola">Motorola</option>
						</select>
	                </div>
	                <div class="form-group">
	                    Phone Model
	                    <select class="form-control form-control-lg" name="modelName" id="modelName" >
						   <option value="iPhone XR">iPhone XR           - Price: CAD 1000</option>
						   <option value="iPhone 12 Pro">iPhone 12 Pro       - Price: CAD 1350</option>
						   <option value="Motorola G8 Plus">Motorola G8 Plus    - Price: CAD 500</option>
						   <option value="Motorola One Vision">Motorola One Vision - Price: CAD 900</option>
						</select>
	                </div>	                
	                <div class="form-group">
	                    Purchase Quantity
	                    <input type="text" class="form-control form-control-lg" name="quantity" id="quantity">
	                </div>
	              
                <hr/>

                <button type="submit" class="btn btn-lg btn-success btn-block bottom-spacer" value="ADD CUSTOMER">Proceed to Payment</button>
            </form>
	            
            <div class="col-12" style="height:30px;"></div>
            
        </div>

        <div class="col">
        </div>

    </div>
</div>

</body>
</html>
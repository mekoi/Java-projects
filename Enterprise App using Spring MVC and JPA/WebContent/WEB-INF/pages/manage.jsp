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
<title>Manage Order</title>
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
	       				<a class="btn btn-lg btn-success mx-2 my-sm-0" href="order" role="button">BUY NOW</a>
	       				<a class="btn btn-lg btn-info mx-2 my-sm-0" href="manage" role="button">ORDERS</a>
	                    <a class="btn btn-lg btn-primary mx-2 my-sm-0" href="profile" role="button">PROFILE</a>
	                    <a class="btn btn-lg btn-secondary mx-2 my-sm-0" href="index.jsp" role="button">LOGOUT</a>
	                </form>
            </div>
        </nav>
    </header>
    
<div class="container">
    <div class="row">
        <div class="col-12 border spacer bg-white border-dark rounded text-center">
            	<h2> Manage Orders </h2>
        </div>
    </div>
</div>

<div class="container">
    <div class="row">
    
		<div class="col-12" style="height:30px;"></div>
        <div class="col-12 border spacer bg-white border-dark rounded">
        <div class="col-12" style="height:30px;"></div>
        
			<table class="table">
			  <thead>
			    <tr>
			      <th scope="col">ID</th>
			      <th scope="col">Order Date</th>
			      <th scope="col">Status</th>
			    </tr>
			  </thead>
			  <tbody>			  
				  <c:forEach var="purchase" items="${allPurchasesOfCustomer}">
				  <form action="updatePurchase" method="post">
				  <input type="text" name="orderId" value="${purchase.orderId}" hidden>
				      <tr>
					      <th scope="row">${purchase.getOrderId()}</th>
					      <td>${purchase.getOrderDate()}</td>
					      <td>${purchase.getOrderStatus()}</td>				      
				      </tr>
				   </form>
				   </c:forEach>			    
			  </tbody>
			</table>   
			         
        </div>
    </div>
</div>

</body>
</html>
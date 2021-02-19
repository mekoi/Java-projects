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
<title>Thank You</title>
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
        
            <form action="updateCustomer" method="post">
                <div class="col-12" style="height:15px;"></div>
                
                <div class="alert alert-success text-center" role="alert">
				  <b>The payment has been successfully processed!</b>
				</div>
				
				<div class="col-12" style="height:15px;"></div>
				
                <div class="top-spacer bottom-spacer grey text-center">
                    <h1>Thank You for Ordering!</h1>
                </div>
                 <hr/>
                <div class="form-group text-center">
                    <h4>We're now processing your order</h4>
                </div>

                <a class="btn btn-lg btn-primary btn-block" href="manage" role="button">Click Here to Manage Orders</a>
            </form>
            
            <div class="col-12" style="height:30px;"></div>
            
        </div>

        <div class="col">
        </div>

    </div>
</div>

</body>
</html>
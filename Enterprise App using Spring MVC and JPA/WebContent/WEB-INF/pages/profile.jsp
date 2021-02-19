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
<title>Profile</title>
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
        
            <form action="profile" method="post">
                <div class="col-12" style="height:30px;"></div>
                <div class="top-spacer bottom-spacer grey">
                    <h1>Profile Page</h1>
                </div>
                 <hr/>
                <div class="form-group">
                    <h4>Login Details</h4>
                </div> 
                <div class="form-group">
                    Username
                    <input type="text" class="form-control" name="userName" id="userName" value="${customer.userName}" required="required">
                </div>
                <div class="form-group">
                    Password
                    <input type="password" class="form-control" name="userPassword" id="userPassword" value="${customer.userPassword}" required="required">
                </div>
                <hr/>
                <div class="form-group">
                    <h4>Personal Information</h4>
                </div>
                <div class="form-group">
                    First Name
                    <input type="text" class="form-control" name="firstName" id="firstName" value="${customer.firstName}" required="required">
                </div>
                <div class="form-group">
                    Last Name
                    <input type="text" class="form-control" name="lastName" id="lastName" value="${customer.lastName}" required="required">
                </div>
                <div class="form-group">
                    Address
                    <input type="text" class="form-control" name="address" id="address" value="${customer.address}" required="required">
                </div>
                <div class="form-group">
                    City
                    <input type="text" class="form-control" name="city" id="city" value="${customer.city}" required="required">
                </div>
                <div class="form-group">
                    Postal Code
                    <input type="text" class="form-control" name="postalCode" id="postalCode" value="${customer.postalCode}" required="required">
                </div>
                <div class="form-group">
                    Country
                    <input type="text" class="form-control" name="country" id="country" value="${customer.country}" required="required">
                </div>
                <input type="text" name="customerId" id="customerId" value="${customer.customerId}" hidden >

                <button type="submit" class="btn btn-lg btn-success btn-block bottom-spacer">UPDATE</button>
            </form>
            
            
            
            
            <div class="col-12" style="height:30px;"></div>
            
        </div>

        <div class="col">
        </div>

    </div>
</div>

</body>
</html>
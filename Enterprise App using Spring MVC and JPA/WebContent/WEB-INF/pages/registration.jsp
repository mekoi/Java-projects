<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css">
<title>Welcome to DigiTel</title>
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
                    <a class="btn btn-lg btn-primary mx-3 my-sm-0" href="index.jsp" role="button">LOGIN</a>
                    <a class="btn btn-lg btn-success mx-2 my-sm-0" href="registration" role="button">REGISTER</a>
                </form>

            </div>
        </nav>
    </header>

<div class="container">
    <div class="row">


        <div class="col-12 border spacer bg-white border-dark rounded">
        
            <form action="registration" method="post">
                <div class="col-12" style="height:30px;"></div>
                <div class="top-spacer bottom-spacer grey">
                    <h1>Registration</h1>
                </div>
                 <hr/>
                <div class="form-group">
                    <h4>Login Details</h4>
                </div>
                <div class="form-group">
                    Username
                    <input type="text" class="form-control form-control-lg" name="userName">
                </div>
                <div class="form-group">
                    Password
                    <input type="password" class="form-control form-control-lg" name="userPassword">
                </div>
                <hr/>
                <div class="form-group">
                    <h4>Personal Information</h4>
                </div>
                <div class="row">
	                <div class="col">
		                <div class="form-group">
		                    First Name
		                    <input type="text" class="form-control form-control-lg" name="firstName">
		                </div>
		             </div>
	                <div class="col">
		                <div class="form-group">
		                    Last Name
		                    <input type="text" class="form-control form-control-lg" name="lastName">
		                </div>
		             </div>
                </div>
                <div class="row">
	                <div class="col">
		                <div class="form-group">
		                    Address
		                    <input type="text" class="form-control form-control-lg" name="address">
		                </div>
		             </div>
	                <div class="col">
		                <div class="form-group">
		                    City
		                    <input type="text" class="form-control form-control-lg" name="city">
		                </div>
		             </div>
                </div>
                <div class="row">
	                <div class="col">
	                    Country
	                    <select class="form-control form-control-lg" name="country">
						   <option>Australia</option>
						   <option>Canada</option>
						   <option>United Kingdom</option>
						   <option>United States</option>
						</select>
		             </div>
	                <div class="col">
		                <div class="form-group">
		                    Postal Code
		                    <input type="text" class="form-control form-control-lg" name="postalCode">
		                </div>
		             </div>
                </div>


                <button type="submit" class="btn btn-lg btn-success btn-block bottom-spacer" value="ADD CUSTOMER">REGISTER</button>
            </form>
            
            <div class="col-12" style="height:30px;"></div>
            
	            <div class="col text-right">
	                Already have an account? <b><a href="index.jsp" >LOGIN</a></b>
	            </div>
	            
            <div class="col-12" style="height:30px;"></div>
            
        </div>

        
        <div class="col-12" style="height:30px;"></div>

    </div>
</div>

</body>
</html>
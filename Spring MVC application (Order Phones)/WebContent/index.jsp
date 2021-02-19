<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"> 
<title>DigiTel Order Form</title>
<!-- Note: Styling links are not working. Paths are configured, yet not loading, so I have done internal styling. -->   
<!--<link href="css/style.css" type="text/css"  rel="stylesheet" > -->
<style>
      * {
        box-sizing: border-box;
        padding: 0;
        margin: 0;
        font-family: "Trebuchet MS", "Lucida Sans Unicode", "Lucida Grande",
          "Lucida Sans", Arial, sans-serif;
      }
      body {
        padding: 20px;
      }
      form {
        width: 700px;
        margin: 0 auto;
      } 
      h1 {
        font-size: 40px;
        color: gray;
      }      
      .heading {
        padding: 5px;
        background: rgb(187, 187, 187);
        width: 100%;
        margin: 10px 0;
        font-size: 14px;
        color: rgb(255, 255, 255);
      }
      .group-wrapper {
        display: flex;
        align-items: center;
      }
      .group-wrapper.col {
        flex-direction: column;
        align-items: flex-start;
      }
      .form-group {
        display: flex;
        flex-direction: column;
      }
      .group {
        display: flex;
        flex-direction: column;
        justify-content: center;
        padding-right: 20px;
      }
      .group.row {
        flex-direction: row-reverse;
        align-items: center;
      }
      label {
        opacity: 0.6;
        margin-right: 20px;
      }
      input {
        width: 150px;
        height: 30px;
        border-radius: 3px;
        border: 1px solid rgba(0, 0, 0, 0.288);
        padding-left: 5px;
        margin: 5px 0;
      }
      input[type="number"] {
        height: 20px;
        text-align: end;
      }
      input.s {
        width: 75px;
      }
      input.xl {
        width: 300px;
      }
       input.invalid {
       	border:1px solid red;
      }
      select {
        width: 150px;
        height: 30px;
        border-radius: 3px;
        border: 1px solid rgba(0, 0, 0, 0.288);
        padding-left: 5px;
        margin: 5px 0;
        color: rgba(0, 0, 0, 0.5);
      }
      button {
        padding: 10px 20px;
        width: 200px;
        margin-top: 10px;
        border-radius: 5px;
        color: white;
        border: none;
        background: dodgerblue;
      } 
    </style> 

</head>
<body>
	<form action="order" method="post" class="">
	      <h1>Smart Phone Order Form</h1>
	      <div class="form-group">
	        <div class="heading">
	          <label for="">Full Name</label>
	        </div>
	        <div class="group-wrapper">
	          <div class="group">
	            <input type="text" name="firstName"/>	            
	            <label for="">First Name</label>
	          </div> 	          
	          <div class="group">
	            <input type="text" name="middleName"/>
	            <label for="">Middle Name</label>
	          </div>
	          <div class="group">
	            <input type="text" name="lastName"/>
	            <label for="">Last Name</label>
	          </div>
	        </div>
	      </div>
	      <div class="form-group">
	        <div class="heading">
	          <label for="">E-mail</label>
	        </div>
	        <div class="group-wrapper">
	          <div class="group">
	            <input class="xl email-input" type="text" name="email" placeholder="ex: myname@example.com"/>
	            <label class="email-validation" data-text="example@example.com" for="">example@example.com</label>
	          </div>
	        </div>
	      </div>
	      <div class="form-group">
	        <div class="heading">
	          <label for="">Contact Number</label>
	        </div>
	        <div class="group-wrapper">
	          <div class="group">
	            <input class="s phone-area-input" type="text" name="areaCode"/>
	            <label for="">Area Code</label>
	          </div>	          
	          <div class="group">
   				<label for="">-</label>
	          </div>
	          <div class="group">
	            <input class="i-xl phone-number-input" type="text" name="phoneNumber"/>
	            <label for="">Phone Number</label>
	          </div>
	        </div>
	      </div>
	      <div class="form-group">
	        <div class="heading">
	          <label for="">Billing Address</label>
	        </div>
	        <div class="group-wrapper col">
	          <div class="group">
	            <input type="text" name="streetAddress"/>
	            <label for="">Street Address</label>
	          </div>
	          <div class="group">
	            <input type="text" name="streetAddressLine2"/>
	            <label for="">Street Address Line 2</label>
	          </div>
	          <div class="group-wrapper">
	            <div class="group">
	              <input type="text" name="city"/>
	              <label for="">City</label>
	            </div>
	            <div class="group">
	              <input type="text" name="stateProvince"/>
	              <label for="">State/Province</label>
	            </div>
	          </div>
	          <div class="group-wrapper">
	            <div class="group">
	              <input type="text" name="zipCode"/>
	              <label for="">Postal Code</label>
	            </div>
	            <div class="group">           	            	              
           			<select name="country" id="country"> 
				      <option value="Please Select" selected>Please Select</option>        		 
				      <option value="ALBANIA">ALBANIA</option>
				      <option value="BRASIL">BRASIL</option>   
				      <option value="CANADA">CANADA</option>
				      <option value="CHINA">CHINA</option>   
				      <option value="GERMANY">GERMANY</option>    	
				       <option value="GHANA">GHANA</option>  			        
				      <option value="FRANCE">FRANCE</option>    				     
				      <option value="INDIA">INDIA</option>  
				      <option value="ITALY">ITALY</option>  
				      <option value="JAPAN">JAPAN</option>  
				      <option value="SPAIN">SPAIN</option>  
				      <option value="UK">UK</option>    
				      <option value="USA">USA</option>  				     				          
  					</select>    			    			     					           	              
	              	<label for="">Country</label>
	            </div>
	          </div>
	        </div>
	      </div>
	      <div class="form-group">
	        <div class="heading">
	          <label for="">Product Details</label>
	        </div>
	        <div class="group-wrapper col">
	          <div class="group row">
                 <input type="number" name="prodNumber" class="productInput only-numbers" step="1" />
	            <label for="">Product #</label>	        
	          </div>
	          <div class="group row">
	            <select name="phoneBrand" id="phoneBrand"> 
	            	<option value="Please Select">Please Select</option>
	            	<option value="iPHONE">iPHONE</option>
				     <option value="Samsung">Samsung</option>   
				     <option value="Google">Google</option>
				     <option value="BlackBerry">BlackBerry</option>                            
	            </select>
	            <label for="">Phone Brand</label>
	          </div>	       
	          <div class="group row">	            
	            	<select name="phoneModel" id="phoneModel">    
	            	 <option value="Please Select">Please Select</option>    
	            	<option value="iPhoneXR">iPhoneXR</option>
				      <option value="iPhone11Pro">iPhone11Pro</option>   
				      <option value="Galaxy20Plus">Galaxy20Plus</option>
				      <option value="GalaxyS2">GalaxyS2</option>    				      
				 </select>    	            	        	            
	            <label for="">Phone Model</label>
	          </div>
	          <div class="group row">
	            <input type="number" 	name="quantity" class="numberInput only-numbers" step="1" />
	            <label for="">Quantity</label>
	          </div>
	        </div>
	      </div>	
	      <button type="submit" class="submit-btn">Submit Order</button>
	      <button type="reset" value="Reset">Reset</button>
	</form>
	
	<script>
 		// Get all inputs that contain the class 'only-numbers'
		var iputs = document.querySelectorAll(".only-numbers"); 
		
 		// Loops through all inputs and adds a listener for focus and focus out, this checks various conditions
		for(var i = 0; i < iputs.length; i++)
		{
			iputs[i].addEventListener("focusout", function(e){
			  console.log("not focused");
			  if(e.target.value <= 0 || isNaN(e.target.value))
			  {
			    e.target.value = "";
			  }
			})
			iputs[i].addEventListener("focus", function(e){
			  if(e.target.value <= 0 || isNaN(e.target.value))
			  {
			    e.target.value = "";
			  }
			})
		} 
		

 		// adds a listener to the email input for a keydown pressed, this checks various conditions
		var eMail = document.querySelector(".email-input");
		var email_validation = document.querySelector(".email-validation");  
		eMail.addEventListener("keydown", function(e){
			var filter = /^([a-z\d\.-]+)@([a-z\d-])\.([a-z]{2,8})(\.([a-z]{2,8}))?$/;
			if (!filter.test(e.target.value)) {
			      e.target.classList.add("invalid");
		    } else {					
			      e.target.classList.remove("invalid");  
		    }
		})
		
		
 		// adds a listener to the both phone number inputs for a keydown pressed, this checks various conditions		 
		var phoneNumberArea = document.querySelector(".phone-area-input");
		var phoneNumberOther = document.querySelector(".phone-number-input"); 
		
		phoneNumberArea.addEventListener("keydown", function(e){ 
			
			if(e.target.value.length >= 3 || isNaN(e.target.value))
			{
				if(!this.classList.contains("invalid"))
				{
					this.classList.add("invalid");
				}
			}else{
				if(this.classList.contains("invalid"))
				{
					this.classList.remove("invalid");
				} 
			}  
		})    
		phoneNumberOther.addEventListener("keydown", function(e){ 
			  
			if(e.target.value.length >= 7 || isNaN(e.target.value))
			{
				if(!this.classList.contains("invalid"))
				{
					this.classList.add("invalid");
				}
			}else{
				if(this.classList.contains("invalid"))
				{
					this.classList.remove("invalid");
				} 
			} 
		})    
		  
	</script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Loan Application Form</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
</head>
<body onload="myFunction()">			
			
	<form action="user?action=placeloan" method="post">
		<table>
			<tr>
			<td><label for="Apply Loan">Apply for a new Loan</label></td>
			</tr>
			
			<tr>
				<td>Application Number</td>
				<td><input type="text" name="ApplicationNumber"></td>
			</tr>
			
			<tr>
				<td>Loan Name</td>
				<td><input type="text" name="LoanName"></td>
			</tr>
			
			<tr>
				<td>Loan Amount</td>
				<td><input type="text" name="LoanAmount"></td>
			</tr>
			<tr>
				<td>Application Date</td>
				<td><input type="text" name="ApplicationDate"></td>
			</tr>
			<tr>
			</table>
				<label for="BusinessStructure">Business Structure</label>				
				<select name="BusinessStructure" id="BusinessStructure">
			  	<option value="Individual">Individual</option>		
			 	 <option value="Organization">Organization</option>
			  	</select>
			  
			  	<br>
			  	<label for="BillingIndicator">Billing Indicator</label>				
				<select name="BillingIndicator" id="BillingIndicator">
			  	<option value="Salaried">Salaried</option>		
			 	 <option value="NotSalaried">Not Salaried</option>
			  	</select>
			  	<br/>
			  	<br>
			  	<label for="TaxPayer">Tax Payer</label>				
				<select name="TaxPayer" id="TaxPayer">
			  	<option value="Yes">Yes</option>		
			 	 <option value="No">No</option>
			  	</select>
			  	<br/>
			  	
			<table> 
			<tr>
			<td><label for="Contact Details">Contact Details</label></td>
			</tr>
			<tr>
				<td>Contact Address</td>
				<td><input type="text" name="ContactAddress"></td>
			</tr>
			<tr>
				<td>Contact Number</td>
				<td><input type="text" name="ContactNumber"></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><input type="text" name="Email"></td>
			</tr>
			 <tr>
				<td>Loan Number</td>
				<td><input type="text" name="LoanNumber"></td>
			</tr>	
			
			<tr>
				<td></td>
				<td><input type="submit" value="placeloan"></td>
			</tr>
			
			
			
		</table>
	</form>
</body>
</html>
			
			
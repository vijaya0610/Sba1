<%@page import="com.iiht.evaluation.eloan.model.LoanInfoDisplay"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display All Loans</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<h1>Welcome to Loan Details Mr. <%=request.getParameter("LoanNumber")%></h1>

	<%
		
	List<LoanInfoDisplay> loandetails = (List<LoanInfoDisplay>) request.getAttribute("loandetails");
	%>
	<table border="1" width="100%">
		<thead>
			<th>ApplicationNumber</th>
			<th>LoanName</th>
			<th>LoanAmount</th>
			<th>ApplicationDate</th>
			<th>BusinessStructure</th>
			<th>BillingIndicator</th>
			<th>TaxPayer</th>
			<th>ContactAddress</th>
			<th>ContactNumber</th>
			<th>Email</th>
			<th>LoanNumber</th>
		</thead>
		<tbody>
			<% for(LoanInfoDisplay loaninfo1 : loandetails) { %>
			
			<tr>
			
			<td><%=loaninfo1.getApplicationNumber() %></td>
			<td><%=loaninfo1.getLoanName() %></td>
			<td><%=loaninfo1.getLoanAmount() %></td>
			<td><%=loaninfo1.getApplicationDate() %></td>
			<td><%=loaninfo1.getBusinessStructure() %></td>
			<td><%=loaninfo1.getBillingIndicator() %></td>
			<td><%=loaninfo1.getContactAddress() %></td>
			<td><%=loaninfo1.getEmail() %></td>
			<td><%=loaninfo1.getContactNumber() %></td>
			<td><%=loaninfo1.getLoanNumber() %></td>
			
			
			
			<% } %>
		</tbody>
	</table>
	<form action="user?action=displaystatus" method="post">
	
	</form>
	<hr>
	<hr>
	




<table>




			
</table>
	

</body>
</html>
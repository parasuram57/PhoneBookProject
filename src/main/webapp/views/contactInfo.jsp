<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Phone book</title>
</head>
<body>
<h2>Save Contact</h2>
<p><font color="green">${sucMsg}</font></p>
<p><font color="red">${errMsg}</font></p>

<form:form action="/saveContact" modelAttribute="contact" method="POST">

<table>
<tr>
<form:hidden path="contactId" />
<td>Contact Name :</td>
<td><form:input path="contactName" /></td>
</tr>
<tr>
<td>Email id :</td>
<td><form:input path="contactEmail" /></td>
</tr>
<tr>
<td>Contact Number :</td>
<td><form:input path="contactNumber" /></td>
</tr>
<tr>
<td><form:button type="reset" value="reset" /></td>
<td><form:button type="submit" value="save Contact" /></td>
</tr>
</table>

</form:form>
<p><a href="/viewContacts">View All Contacts</a></p>
</body>
</html>
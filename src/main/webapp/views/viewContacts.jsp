<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<link href="https://cdn.datatables.net/1.10.22/css/jquery.dataTables.min.css" rel="stylesheet" type="css/text">

<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js"></script>

<script>
$(document).ready(function() {
    $('#contactTbl').DataTable( {
        "pagingType": "full_numbers"
    } );
} );
function deleteconform(){
	var txt;
	  
	  
	  if (confirm("Press a button!")) {
	    txt = "You pressed OK!";
	    alert("Hello");
	  } else {
	    txt = "You pressed Cancel!";
	    alert("wer");
	  }
	  document.getElementById("demo").innerHTML = txt;
}

</script>
</head>
<body>
<a href="addContact">+Add Contact</a>
<table border="1" id="contactTbl">
<thead>
<tr>
<th>S.NO</th>
<th>NAME</th>
<th>EMAIL</th>
<th>PHNO</th>
<th>ACTION</th>
</tr>
</thead>
<tbody>
<c:forEach items="${contacts}" var="c" varStatus="index">

<tr>
<td>${index.count}</td>
<td>${c.contactName}</td>
<td>${c.contactEmail}</td>
<td>${c.contactNumber}</td>
<td>
<a href="editContact?cid=${c.contactId}" >EDIT</a>
<a href="deleteContact?cid=${c.contactId}" onclick="deleteconform()" >DELIT</a>
</td>
</tr>
</c:forEach>

</tbody>
</table>
</body>
</html>
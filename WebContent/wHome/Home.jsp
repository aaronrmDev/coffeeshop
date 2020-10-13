<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
html {
	background: url('../img/Background.png') no-repeat center fixed;
	background-size: cover;
	overflow: hidden;
	background-position: center center;
}
</style>

<meta charset="ISO-8859-1">
<title>CoffeeShop Session</title>
<link href="../wHome/CSSHome.css" rel="stylesheet" type="text/css">

</head>
 <%
     int start = 0;
     int elementsLen = 10;
     int counter = 1;
     int noOfItemsInRow = 4; //set number of td you want in tr
     StringBuilder sb = new StringBuilder();
     noOfItemsInRow++;

     //start table
     out.println("<table>");
     while(start<=elementsLen){ 
        sb.append("<td>");
        sb.append(start);
        sb.append("</td>");

        //check if noOfElemntsInRow elements is reached keep it in a new row
        if(++counter==noOfItemsInRow){
            out.println("<tr>");
            out.println(sb.toString());
            out.println("</tr>");
            sb.setLength(0);
            counter = 1;
        }
        start++;
     }
    //print remaining td elements in a new row
     if(sb.length()>1){
         out.println("<tr>");
         out.println(sb.toString());
         out.println("</tr>");
     }
    //close table
     out.println("</table>");
    %>
    
    <h3>Order List</h3>
	<c:set var="total" value="0"></c:set>
	<table border="1" cellpadding="2" cellspacing="2">
		<tr>
			<th>createdAt</th>
			<th>user</th>
			<th>id</th>
			<th>updatedAt</th>
			<th>state</th>
		</tr>
		<c:forEach var="product" items="${products }">
			<c:set var="total" value="${total + product.price * product.quantity }"></c:set>
			<tr>
				<td>${product.id }</td>
				<td>${product.name }</td>
				<td><img
					src="${pageContext.request.contextPath }/assets/images/${product.photo }"
					width="120"></td>
				<td>${product.price }</td>
				<td>${product.quantity }</td>
				<td>${product.price * product.quantity }</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="5" align="right">Total</td>
			<td>${total }</td>
		</tr>
	</table>

<body>

</body>
</html>
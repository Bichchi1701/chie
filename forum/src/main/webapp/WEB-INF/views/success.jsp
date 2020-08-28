<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String contextPath=request.getContextPath();
%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title> 	
<style>
table, th, td {
  border: 1px solid black;
  border-collapse: collapse;
}
th, td {
  padding: 5px;
  text-align: left;    
}

</style>
  <!-- Site Icons -->
    <link rel="shortcut icon" href="<%=contextPath%>/resources/images/favicon.ico" type="image/x-icon">
    <link rel="apple-touch-icon" href="<%=contextPath%>/resources/images/apple-touch-icon.png">

	<!-- Site CSS -->
    <link rel="stylesheet" href="<%=contextPath%>/resources/css/style.css">    
    <!-- Custom CSS -->
    <link rel="stylesheet" href="<%=contextPath%>/resources/css/custom.css">

    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<!-- Start header -->
	
	<!-- End header -->

	<!-- Start All Pages -->
	
	<table style="width:70%; margin-left: 300px; margin-top: 50px ">
		 
		  <tr>
			<th>source name</th>
		    <th>date</th>
		    <th>Link down</th>
		    <th>Date and time</th>
		    <th>Number</th>
			<th>Booking</th>
		    <th>Memo</th>
		    <th></th>
		  </tr>	
		  	<c:forEach var="source" items="${listsource}">
		  <tr>
		  		
				<td>${source.sourcename}</td>
		   		<td>${source.date}</td>
		        <td>${source.size}</td>
		        <td>${source.contentdetails}</td>
		        <td>${source.title}</td>
		        <td>${source.price}</td>
		        <td>${source.avatar}</td>
		   </tr>
		  
		</c:forEach>
</table>

</body>
</html>
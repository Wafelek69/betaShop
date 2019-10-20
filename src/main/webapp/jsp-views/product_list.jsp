<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />
		<style type="text/css">
        #container {width:600px;}
        #left {width: 50%; display: inline-block; background}
        #right {width: 25%; display: inline-block; background}
        </style>
	</head>
	<body>
		<h3>Lista produktów</h3>
		<a href="/products/form/create">Dodaj nowy produkt</a>
        <c:choose>
        <c:when test = "${not empty naszaListaProduktow}">
            <c:forEach items="${naszaListaProduktow}" var="productElement">
            <div id="container">
                <div id="left">
                    <a href="/products/${productElement.id}">${productElement.title}</a>
                </div>
                <div id="right">
                    <img src="${productElement.mainPhoto}" alt="${productElement.title}"  width="100px" height="70px">
               </div>
            </div>
            </c:forEach>
        </c:when>
        <c:otherwise>
        <h3>Brak produktów w bazie</h3>
        </c:otherwise>
        </c:choose>
    </body>
</html>
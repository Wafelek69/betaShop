<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />
		<style type="text/css">
        #container {width:600px;}
        </style>
	</head>
	<body>
	 <a href="/products">Lista produktów</a>
		<h3>Szczegóły produktu</h3>

        <div id="container">
                Nazwa produktu: ${product.title} <br>
                Opis produktu: ${product.description} <br>
                Cena : ${product.price} / ${product.unit}
        </div>
        <a href="/products/form/${product.id}">Edytuj produkt</a>
        <a href="/products-delete/${product.id}">Usuń produkt</a>

        <c:choose>
        <c:when test = "${not empty product.commentaryList}">
                    <c:forEach items="${product.commentaryList}" var="commentaryElement">
                    <div id="container">
                    Tekst komentarza: ${commentaryElement.text}
                    Data publikacji: ${commentaryElement.publishDate}
                    </div>
                    </c:forEach>
        </c:when>
        <c:otherwise>
        <h3>Brak komentarzy</h3>
        </c:otherwise>
        </c:choose>
    </body>
</html>
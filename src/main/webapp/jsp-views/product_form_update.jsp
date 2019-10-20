<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv='Content-Type' content='text/html; charset=UTF-8' />
    	<style>
    		.error {
    		color: #ff0000;
    		font-style: italic;
    		font-weight: bold;
    		}
    	</style>
    </head>
    <body>
    	<a href="/products"> Powrót do liste produktów </a> <br>
        <h3>Dodaj produkt</h3>
        	<form:form method="POST" action="/products" modelAttribute="product">
             <table>
                <tr>
                    <td><form:label path="title">Nazwa produktu</form:label></td>
                    <td><form:input path="title"/></td>
                </tr>
                <tr>
                    <td><form:label path="description">Opis produktu</form:label></td>
                    <td><form:input path="description"/></td>
                </tr>
                <tr>
                    <td><form:label path="mainPhoto">Foto</form:label></td>
                    <td><form:input path="mainPhoto"/></td>
                </tr>
                <tr>
                    <td><form:label path="price">Cena</form:label></td>
                    <td><form:input path="price"/></td>
                </tr>
                <tr>
                    <td><form:label path="unit">Jednostka</form:label></td>
                     <td>
                     <form:select path="unit">
                        <option value="${product.unit}" selected>${product.unit}</option>
                            <c:forEach items="${unitEnums}" var="unitElement">
                                <option value="${unitElement}">${unitElement}</option>
                            </c:forEach>
                        </form:select>
                     </td>
                </tr>
                <tr>
                	<td><form:hidden path="id" /></td>
                    <td><input type="submit" value="OK"/></td>
                </tr>
            </table>
        </form:form>
    </body>
</html>
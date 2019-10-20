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
    <%@ include file="header.jsp" %>
    	<a href="/products"> Powrót do liste produktów </a> <br>
        <h3>Załóż konto</h3>
        	<form:form method="POST" action="/users" modelAttribute="userDto">
             <table>
                <tr>
                    <td><form:label path="email">Email</form:label></td>
                    <td><form:input path="email"/></td>
                    <td class='error'><form:errors path="email"/></td>
                </tr>
                <tr>
                    <td><form:label path="password">Hasło</form:label></td>
                    <td><form:input path="password"/></td>
                    <td class='error'><form:errors path="password"/></td>
                </tr>
                <tr>
                    <td><form:label path="repeatPassword">Hasło</form:label></td>
                    <td><form:input path="repeatPassword"/></td>
                </tr>
                 <tr>
                     <td><form:label path="telephone">Telephone</form:label></td>
                     <td><form:input path="telephone"/></td>
                     <td class='error'><form:errors path="telephone"/></td>
                 </tr>
                 <tr>
                     <td><form:label path="address">Address</form:label></td>
                     <td><form:input path="address"/></td>
                     <td class='error'><form:errors path="address"/></td>
                 </tr>
                <tr>
                	<td></td>
                    <td><input type="submit" value="OK"/></td>
                </tr>
            </table>
        </form:form>
    </body>
</html>
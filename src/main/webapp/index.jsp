<%@page import="com.weather.enums.Cities"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Weather app</title>
        <meta charset="utf-8" />
        <link rel="stylesheet" type="text/css" href="css/main.css">
    </head>
    <body>
        <div id="main">
        <h1>Weather app</h1>
        <form action="/app" method="get">
            <select name="selectedCity">
                <option selected disabled>Select city</option>
                <c:set var="enumValues" value="<%=Cities.values()%>"/>
                <c:forEach items="${enumValues}" var="enumValue">
                    <option value="${enumValue}">${enumValue.name}</option>
                </c:forEach>                
            </select> 

                <input type="submit" value="Check the weather">
        </form>
        <c:if test="${(cityWeather != null)}">
        <div id="table">
            <table>               
                <tr>
                    <td>City</td>
                    <td>${cityWeather.name}</td>
                </tr>
                <tr>
                    <td>Cloudiness [%]</td>
                    <td>${cityWeather.clouds.all}</td>
                </tr>
                <tr>
                    <td>Temperature [C]</td>
                    <td>${cityWeather.main.temp}</td>
                </tr>
                <tr>
                    <td>Pressure [hPa]</td>
                    <td>${cityWeather.main.pressure}</td>
                </tr>
                <tr>
                    <td>Wind speed[m/s]</td>
                    <td>${cityWeather.wind.speed}</td>
                </tr>
            </table>
        </div>
        </c:if>
        </div>
    </body>
    
</html>
